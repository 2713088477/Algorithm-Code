package LeetCodeDaily;

import java.util.Arrays;

public class Solution_955 {
    public int minDeletionSize(String[] strs) {
    	int size=strs.length;
    	int sLen=strs[0].length();
        String[] ans = new String[size];
        Arrays.fill(ans, "");
        int kept=0;
        for(int i=0;i<sLen;i++) {
        	String[] newAns=new String[size];
        	newAns[0]=ans[0]+String.valueOf(strs[0].charAt(i));
        	int j=1;
        	for(;j<size;j++) {
        		newAns[j] =ans[j]+String.valueOf(strs[j].charAt(i));
        		if(newAns[j].compareTo(newAns[j-1])<0) break;
        	}
        	if(j==size) {
        		ans=newAns;
        		kept++;
        	}
        }
        return sLen-kept;
       
    }
    
}
