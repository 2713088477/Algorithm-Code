package LeetCodeDaily;

import java.util.HashSet;
import java.util.Set;

public class Solution_3562 {
    private int n;
    private int budget;
    private int[] present=null;
    private int[] future=null;
    private int[][] hierarchy=null;
    private Set<Integer> set=new HashSet<>();
    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        this.n=n;
        this.budget=budget;
        this.present=present;
        this.future=future;
        this.hierarchy=hierarchy;
        int ans=findMax(0,budget);
        return ans;
    }
    //id=index+1,利用剩余money能获得的最大利润
    public int findMax(int index,int money){
        if(index==n) return 0;
        int ans=findMax(index+1,money);
        if(money>=present[index]){
            for(int i=0;i<hierarchy.length;i++){
                if(hierarchy[i][0]==index+1){
                    set.add(hierarchy[i][1]-1);
                }
            }
            int buyMoeny=present[index];
            if(set.contains(index)) buyMoeny/=2;
            int tem=findMax(index+1,money-buyMoeny)+(future[index]-buyMoeny);
            ans=Math.max(ans,tem);
            for(int i=0;i<hierarchy.length;i++){
                if(hierarchy[i][0]==index+1){
                    set.remove(hierarchy[i][1]-1);
                }
            }
        }
        return ans;
    }
    public static void main(String[] args) {
    	Solution_3562 solution =new Solution_3562();
    }

}
