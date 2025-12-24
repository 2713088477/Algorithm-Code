package VideoZuo38;

public class HanNuo {
	public void HanNuo(int n,String from,String to,String other) {
		if(n==1) {
			System.out.println(n+from+"->"+to);
			return;
		}
		HanNuo(n-1,from,other,to);
		System.out.println(n+from+"->"+to);
		HanNuo(n-1,other,to,from);
	}
}
