package VideoZuo38;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GetAllCombinationPlus {
    public List<List<Integer>> permuteUnique(int[] nums) {
    	List<List<Integer>> ans=new ArrayList<>();
    	f(nums,0,ans);
    	return ans;
    }
    public void f(int[] nums,int index,List<List<Integer>> ans) {
    	if(index == nums.length) {
    		List<Integer> list=new ArrayList<>();
    		for(int num:nums) {
    			list.add(num);
    		}
    		ans.add(list);
    	}
    	
    	Set<Integer> set= new HashSet<>();
    	for(int i=index;i<nums.length;i++) {
    		if(!set.contains(nums[i])) {
    			set.add(nums[i]);
    			swap(nums,index,i);
    			f(nums,index+1,ans);
    			swap(nums,index,i);
    		}
    	}
    	
    }
    public static void swap(int[] nums,int i,int j) {
    	if(i==j)return;
    	nums[i]=nums[i]^nums[j];
    	nums[j]=nums[i]^nums[j];
    	nums[i]=nums[i]^nums[j];
    }
}
