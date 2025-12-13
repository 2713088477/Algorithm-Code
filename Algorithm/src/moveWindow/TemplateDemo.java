package moveWindow;

public class TemplateDemo {
	
	/**
	 * 定长滑动窗口的代码模板，用于解决以下问题：在一个数组 arr[]里，找到所有长度为 windowLength的连续子数组中，元素之和最大的那个值。
	 * @param arr
	 * @param windowLength 题目保证windowLength<=arr.length
	 * @return
	 */
	public int FixedLengthSlidingWindow(int[] arr,int windowLength) {
		//ans是返回的答案
		int ans=Integer.MIN_VALUE;
		//sum是子数组求和的结果
		int sum=0;
		//开始滑动窗口
		for(int i=0;i<arr.length;i++) {
			//当还没有到窗口的长度的时候
			if(i-windowLength+1<0) {
				sum+=arr[i];
				continue;//加上continue,因为后面的逻辑是处理窗口到达的时候
			}
			//当窗口到达的时候(三板斧操作)
			//1.先更新新加入到窗口的元素
			sum+=arr[i];
			//2.处理答案
			ans=Math.max(ans, sum);
			//3.移除掉左窗口
			sum-=arr[i-windowLength+1];
		}
		//循环结束,返回答案
		return ans;
	}

}
