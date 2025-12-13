package dpDay2;
import java.util.HashMap;
import java.util.Map;
public class demo1 {
	public static void main(String[] args) {
//		initMap();
		System.out.println(numDecodings("27"));
	}
	public static Map<String,Character> map=new HashMap<>();
	public static void initMap() {
		for(int i=1;i<=26;i++) {
			map.put(String.valueOf(i), Character.valueOf((char)('A'+i-1)));
		}
	}
    public static int numDecodings(String s) {
        return getCurDecodings(s,0);
    }
    public static int getCurDecodings(String s,int cur) {
    	if(cur>=s.length()||s.charAt(cur)=='0') {
    		return 0;
    	}
    	if(cur==(s.length()-1)) return 1;
    	if(cur==(s.length()-2)&&s.charAt(cur+1)=='0') return 1;
    	if(cur==(s.length()-2)&&s.substring(cur).compareTo("26")>0) return 1;
    	if(cur==(s.length()-2)&&s.charAt(cur+1)!='0'&&s.substring(cur).compareTo("26")<=0) return 2;
    	return getCurDecodings(s,cur+1)+getCurDecodings(s,cur+2);
    }
    

}
