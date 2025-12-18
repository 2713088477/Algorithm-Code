package VideoZuo38;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubAllNumber {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        int[] cop=new int[nums.length];
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        f(nums,0,cop,0,ans);
        return ans;
    }
    public void f(int[] nums,int index,int[] cop,int size, List<List<Integer>> ans) {
    	if(index==nums.length) {
    		List<Integer> list=new ArrayList<>();
    		for(int i=0;i<size;i++) {
    			list.add(cop[i]);
    		}
    		ans.add(list);
    		return;
    	}
    	int j=index+1;
    	while(j<nums.length && nums[index]==nums[j])j++;
    	f(nums,j,cop,size,ans);
    	for(int i=index;i<j;i++) {
    		cop[size++]=nums[i];
    		f(nums,j,cop,size,ans);
    	}
    }

}
