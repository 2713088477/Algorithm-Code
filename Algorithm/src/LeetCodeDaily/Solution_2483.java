package LeetCodeDaily;

public class Solution_2483 {
    public int bestClosingTime(String customers) {
        char[] s=customers.toCharArray();
        int len=s.length;
        int ans=len;
        int[] countY=new int[len+1];
        int[] countN=new int[len+1];
        for(int i=0;i<len;i++){
            if(s[i]=='Y'){
                countY[i+1]=countY[i]+1;
                countN[i+1]=countN[i];
            }else{
                countN[i+1]=countN[i]+1;
                countY[i+1]=countY[i];
            }
        }
        int minCost=countN[len]-countN[0]+1;
        int bestTime=len;
        for(int i=0;i<s.length;i++){
            if(s[i]=='N'){
                //此刻关门的代价
                int now= countN[i]-countN[0] + countY[len]-countY[i];
                if(minCost>now){
                    minCost=now;
                    bestTime=i;
            
                }
            }
        }
        return bestTime;
    }
}
