import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class ConcatenationProcess {
	String concatenationProcess(String[] a) {
	    List<String> b = new Vector<String>(Arrays.asList(a));
	    for (;b.size() > 1;) {
	    	b.sort((x,y)-> x.length()-y.length());
	        String d=b.remove(1),c;
	        b.add((c=b.remove(0)).equals("z") ? d+c : c+d);
	        
	    }
	    return b.get(0);
	}
	public static void main(String[] args) {
		System.out.println(new ConcatenationProcess().concatenationProcess(new String[]{"aaa","dd","bbbbb"}));
	}
}
