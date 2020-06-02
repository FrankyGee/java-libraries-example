package au.com.franky.guildpresentation.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Some good resources:
 * https://blog.espenberntsen.net/2010/03/20/aspectj-cheat-sheet/
 * https://blog.espenberntsen.net/2010/03/18/aspectj-examples-with-pointcuts-based-on-annotations/
 */
@Aspect
@Component
public class LoggingAspect {

	private int index = 0;

//	@Pointcut("within(au.com.franky..*)")
	@Pointcut("execution(* au.com.franky..*(..))")
	public void allMethods() {
	}

	@Around("allMethods()")
	public Object addTraceLogs(ProceedingJoinPoint joinPoint) throws Throwable {
		Logger log = LoggerFactory.getLogger(joinPoint.getSignature().getDeclaringTypeName());

		log.debug("{}-> Entering method {}", calculateIndent(), joinPoint.getSignature().getName());
		index++;
		Object result = joinPoint.proceed();
		index--;
		log.debug("{}<- Exiting method {}", calculateIndent(), joinPoint.getSignature().getName());

		return result;
	}

	private String calculateIndent() {
		return "  ".repeat(index);
	}

	// Example adding a cache //
	Map<Object[], Object> cache = new HashMap<>();

	@Around("allMethods()")
	public Object cacheMethodReturn(ProceedingJoinPoint joinPoint) {
		cache.computeIfAbsent(joinPoint.getArgs(), objects -> {
			try {
				return joinPoint.proceed();
			} catch (Throwable throwable) {
				throwable.printStackTrace();
			}
			return null;
		});
		return cache.get(joinPoint.getArgs());
	}
}
