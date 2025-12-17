package LeetCodeDaily;

import java.util.HashMap;
import java.util.Map;
//这道题主播目前已经燃尽了，但是还是超时，等待回来重做的那天
public class Solution_3573 {
    private int[] prices;
    private int k;
    private Map<String,Long> map=new HashMap<>();
    public long maximumProfit(int[] prices, int k) {
        this.prices=prices;
        this.k=k;
        return findMax(0,0);
    }
    public long findMax(int index,int lastBuy){
        if(k<=0) return 0;
        if(index==prices.length) return 0;

        StringBuilder sb= new StringBuilder();
        sb.append(index);sb.append(" ");sb.append(lastBuy);sb.append(" ");sb.append(k);
        String s=sb.toString();
        if(map.containsKey(s)){
            return map.get(s);
        }
        long ans1=Integer.MIN_VALUE,ans2=Integer.MIN_VALUE,ans3=Integer.MIN_VALUE,ans4=Integer.MIN_VALUE;
        if(lastBuy==0){
            ans1=findMax(index+1,0);
            ans2=findMax(index+1,prices[index]);
        }else{
            k--;
            ans3=findMax(index+1,0)+Math.abs(lastBuy-prices[index]);
            k++;
            ans4=findMax(index+1,lastBuy);
        }
        long ans=Math.max(Math.max(ans1,ans2),Math.max(ans3,ans4));
        map.put(s,ans);
        return ans;
    

    }
}
