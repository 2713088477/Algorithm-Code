package LeetCodeDaily;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution_2092 {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
    	//按照会议时间升序排序
    	Arrays.sort(meetings,(m1,m2)-> Integer.compare(m1[2], m2[2]));
    	//记录已经直到秘密的人
        boolean[] knownPerson=new boolean[n];
        knownPerson[0]=true;
        knownPerson[firstPerson]=true;
        
        int mLen=meetings.length;
        for(int i=0;i<mLen;) {
        	int time=meetings[i][2];
        	
        	Map<Integer,List<Integer>> graph=new HashMap<>();
        	Set<Integer> peopleInvolved = new HashSet<>(); 
        	
        	while(i<mLen && meetings[i][2]==time) {
        		int x=meetings[i][0],y=meetings[i][1];
        		graph.computeIfAbsent(x, k-> new ArrayList<Integer>()).add(y);
        		graph.computeIfAbsent(y, k-> new ArrayList<Integer>()).add(x);
        		peopleInvolved.add(x);
        		peopleInvolved.add(y);
        		i++;
        	}
        	
        	Deque<Integer> deque=new ArrayDeque();
        	Set<Integer> visited = new HashSet<>();
        	
        	for(int p:peopleInvolved) {
        		if(knownPerson[p] && !visited.contains(p)) {
        			deque.offerFirst(p);
        			visited.add(p);
        			
        		}
        	}
        	
        	while(!deque.isEmpty()) {
        		int cur=deque.pollFirst();
        		for(int nei:graph.getOrDefault(cur,new ArrayList<>())) {
        			if(!visited.contains(nei)) {
        				visited.add(nei);
        				knownPerson[nei]=true;
        				deque.offerFirst(nei);
        			}
        			
        		}
        	}
        	
        }
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++) {
        	if(knownPerson[i]) {
        		ans.add(i);
        	}
        }
        return ans;
        
    }

}
