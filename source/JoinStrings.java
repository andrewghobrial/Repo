import com.google.common.base.Joiner;

public class JoinStrings {
	public String join(String A, String B, String C) {
	Joiner joiner = Joiner.on("; ").skipNulls();
	return joiner.join(A, null, B, C);
	}
}
