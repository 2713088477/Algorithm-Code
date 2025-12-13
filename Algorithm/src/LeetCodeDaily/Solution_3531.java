package LeetCodeDaily;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_3531 {
    public int countCoveredBuildings(int n, int[][] buildings) {
    	//记录每一行有哪些列的建筑物存在
    	Map<Integer,List<Integer>> rows=new HashMap<>();
    	//记录每一列有哪些行的建筑物存在
    	Map<Integer,List<Integer>> cols=new HashMap<>();
    	for(int i=0;i<buildings.length;i++) {
    		int x=buildings[i][0],y=buildings[i][1];
    		rows.computeIfAbsent(x, k ->new ArrayList<Integer>()).add(y);
    		cols.computeIfAbsent(y, k ->new ArrayList<Integer>()).add(x);
    	}
    	//将每个list排序
    	rows.forEach((k,v)->{
    		Collections.sort(v);
    	});
    	cols.forEach((k,v)->{
    		Collections.sort(v);
    	});
    	
    	int ans=0;
    	//遍历每一个格子，去看看上下左右有没有覆盖
    	for(int i=0;i<buildings.length;i++) {
    		int x =buildings[i][0];
    		int y =buildings[i][1];
    		if(rows.containsKey(x) && cols.containsKey(y)) {
				List<Integer> rowList= rows.get(x);
				List<Integer> colList= cols.get(y);
				if(rowList.get(0)<y && rowList.get(rowList.size()-1)>y && colList.get(0)<x && colList.get(colList.size()-1)>x) {
					ans++;
				}
			}
    	}

    	return ans;

    }

}
