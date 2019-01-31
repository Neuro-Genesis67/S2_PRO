package opgave_4;

import java.util.HashSet;
import java.util.Set;

public class SetOperations {

	public static <T> Set<T> union(Set<T> s1, Set<T> s2) {
		Set<T> set = new HashSet<>();
		set.addAll(s1);
		set.addAll(s2);
		return set;
	}

	public static <T> Set<T> differens(Set<T> s1, Set<T> s2) {
		Set<T> set = new HashSet<>();
		for (T t : s1) {
			if (!s2.contains(t)) {
				set.add(t);
			}
		}
		return set;

	}

	public static <T> Set<T> intesection(Set<T> s1, Set<T> s2) {
		Set<T> set = new HashSet<>();
		for (T t : s1) {
			if (s2.contains(t)) {
				set.add(t);
			}
		}
		return set;

	}

}
