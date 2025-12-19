package VideoZuo38;

import java.util.ArrayList;
import java.util.List;

public class GetAllCombination {
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> ans=new ArrayList<>();
    	f(nums,0,ans);
    	return ans;
    }
    public void f(int[] nums,int index,List<List<Integer>> ans) {
    	if(index==nums.length) {
    		List<Integer> list=new ArrayList<>();
    		for(int num:nums) list.add(num);
    		ans.add(list);
    	}
    	//让所有人都来坐当前位置
    	for(int i=index;i<nums.length;i++) {
    		swap(nums,index,i);
    		f(nums,index+1,ans);
    		swap(nums,index,i);//恢复现场
    	}
    }
    public static void swap(int[] nums,int index1,int index2) {
    	if(index1==index2) return;
    	nums[index1]=nums[index1]^nums[index2];
    	nums[index2]=nums[index1]^nums[index2];
    	nums[index1]=nums[index1]^nums[index2];
    }
}
