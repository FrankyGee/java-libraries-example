package au.com.franky.guildpresentation;

import lombok.SneakyThrows;
import lombok.experimental.Delegate;
import lombok.extern.slf4j.Slf4j;
import lombok.val;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Slf4j
public class LombokStuff {
	public static void main(String[] args) {
		new LombokStuff();
	}

	@Delegate
	private final List<String> listDelegate = new ArrayList<>();

	public LombokStuff() {
		this.add("A quick brown fox");

		try {
			throwsACheckedException();
		} catch (Exception e) {
			System.out.println("Totally threw an exception");
		}

		valAndVar();
		logging();
	}

	@SneakyThrows
	public void throwsACheckedException() {
		throw new IllegalAccessException();
	}

	public void valAndVar() {
		var mutable = new ArrayList<String>();   // Whoops, var was adopted by Java!
		val immutable = new HashMap<>();	// Magic

		mutable.add("look ma I can add something to this list");
		immutable.put("key", "value");

		mutable = new ArrayList<>();
//		immutable = new LinkedHashMap<>();	// IDE detection is kinda flaky?!
	}

	public void logging() {
		String importantWord = "log";
		log.debug("This is a {}, with built-in formatting!", importantWord);
	}


}
