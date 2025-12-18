package VideoZuo38;

import java.util.HashSet;
import java.util.Set;

public class SubAllString {
    public String[] generatePermutation1 (String s) {
        char[] arr=s.toCharArray();
        StringBuilder sb=new StringBuilder();
        Set<String> set=new HashSet<>();
        getSubAllString(arr,0,sb,set);
        
        String[] ans=new String[set.size()];
        int index=0;
        for(String t:set) {
        	ans[index++]=t;
        }
        return ans;
        
    }
    public static void getSubAllString(char[] arr,int index,StringBuilder sb,Set<String> set) {
    	if(index==arr.length) {
    		set.add(sb.toString());
    		return;
    	}
    	getSubAllString(arr,index+1,sb,set);
    	sb.append(arr[index]);
    	getSubAllString(arr,index+1,sb,set);
    	sb.deleteCharAt(sb.length()-1);
    }
    
    public String[] generatePermutation2(String s) {
        char[] arr=s.toCharArray();
        char[] cop=new char[s.length()];
        Set<String> set=new HashSet<>();
        f2(arr,0,cop,0,set);
        
        String[] ans=new String[set.size()];
        int index=0;
        for(String t:set) {
        	ans[index++]=t;
        }
        return ans;
    }
    public static void f2(char[] arr,int index,char[] cop,int size,Set<String> set) {
    	if(index==arr.length) {
    		set.add(String.valueOf(cop, 0, size));
    		return;
    	}
    	f2(arr,index+1,cop,size,set);
    	cop[size]=arr[index];
    	f2(arr,index+1,cop,size+1,set);
    }
}
