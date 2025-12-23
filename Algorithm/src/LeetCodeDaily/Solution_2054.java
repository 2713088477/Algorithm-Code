package LeetCodeDaily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

//TODO 超时
public class Solution_2054 {
	class Obj {
		int index;
		int selectNum;
		int lastEnd;
		public Obj(int index,int selectNum,int lastEnd) {
			this.index=index;
			this.selectNum=selectNum;
			this.lastEnd=lastEnd;
		}
		@Override
		public boolean equals(Object other) {
			Obj o=(Obj) other;
			return this.index==o.index && this.selectNum==o.selectNum && this.lastEnd==o.lastEnd;
		}
		@Override
		public int hashCode() {
			return Objects.hash(index,selectNum,lastEnd);
		}
	}
    public int maxTwoEvents(int[][] events) {
    	Arrays.sort(events,(e1,e2)->{
    		if(e1[0]!=e2[0]) {
    			return Integer.compare(e1[0], e2[0]);
    		}else {
    			return Integer.compare(e1[1], e2[1]);
    		}
    		
    	});
    	
    	Map<Obj,Integer> map=new HashMap();
    	int ans=findMax(events,0,2,-1,map);
    	return ans;
    }
    //记忆化搜索版本
    public int findMax(int[][] events,int index,int selectNum,int lastEnd,Map<Obj,Integer> map) {
    	if(index==events.length) {
    		return 0;
    	}
    	if(selectNum==0) return 0;
    	Obj key=new Obj(index,selectNum,lastEnd);
    	if(map.containsKey(key)) {
    		return map.get(key);
    	}
    	int ans=findMax(events,index+1,selectNum,lastEnd,map);
    	if(lastEnd==-1 || events[index][0] >lastEnd) {
    		int another = findMax(events,index+1,selectNum-1,events[index][1],map)+events[index][2];
    		ans=Math.max(another,ans);
    	}
    	map.put(key, ans);
    	return ans;
    }
	
}
