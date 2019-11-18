
public class WailingGhosts {
	static Object wailingGhosts(String s) {
		return s.replaceAll("(o+)u+\\1", "");
	}

	public static void main(String[] args) {
		System.out.println(wailingGhosts("oouuuuuooo"));
	}
}
