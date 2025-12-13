package moveWindow;
import java.util.HashSet;
import java.util.Set;
public class demo1 {
    public static int maxVowels(String s, int k) {
        Set<Character> set=new HashSet<>(Set.of('a','e','i','o','u'));
        int ans =0;
        int curCount=0;//统计当前窗口的元音字母的数量
        for(int i=0;i<s.length();i++) {
        	//没有达到窗口的长度
        	if(i-k+1<0) {
        		if(set.contains(s.charAt(i))){
        			curCount++;
        		}
        		continue;
        	}
        	//进入窗口
        	//1.先将新加入的值进行处理
        	if(set.contains(s.charAt(i))){
    			curCount++;
    		}
        	//2.更新答案
        	ans=Math.max(ans, curCount);
        	//3.对移除的值进行处理
        	if(set.contains(s.charAt(i-k+1))){
    			curCount--;
    		}
        }
        return ans;
    }
}
