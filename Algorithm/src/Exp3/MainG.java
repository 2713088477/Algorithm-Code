package Exp3;



import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainG {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNextInt()) {
			int m=sc.nextInt(),n=sc.nextInt();
			List<ArrayList<Integer>> nums=new ArrayList<>();
			for(int i=0;i<n;i++) {
				nums.add(new ArrayList<Integer>());
			}
			for(int i=0;i<=m;i++) {
				for(int j=0;j<n;j++) {
					nums.get(j).add(sc.nextInt());
				}
			}
			/*
			 * nums.forEach(item->{ item.forEach(ele->{ System.out.print(ele+" "); });
			 * System.out.println(); });
			 */
			//暴力递归:
			//System.out.println(f1(nums,0,m,n));
			
			//记忆化搜索
			//int[][] dp=new int[n+1][m+1];
			//for(int i=0;i<dp.length;i++) {
			//	Arrays.fill(dp[i], -1);
			//}
			//System.out.println(f2(nums,0,m,n,dp));
			
			//严格位置依赖的动态规划
			f3(nums,m,n);
		}
		sc.close();
	}
	//暴力递归:从当前curProject开始,用money可以获得的最大收益
	public static int f1(List<ArrayList<Integer>> nums,int curProject,int money,int n) {
		if(curProject==n) {
			return 0;
		}
		int ans=Integer.MIN_VALUE;
		for(int i=0;i<=money;i++) {
			ans=Math.max(ans, f1(nums,curProject+1,money-i,n)+nums.get(curProject).get(i));
		}
		return ans;
	}
	
	//记忆化搜索:从当前curProject开始,用money可以获得的最大收益
	public static int f2(List<ArrayList<Integer>> nums,int curProject,int money,int n,int[][] dp) {
		if(curProject==n) {
			return 0;
		}
		if(dp[curProject][money]!=-1) {
			return dp[curProject][money];
		}
		int ans=Integer.MIN_VALUE;
		for(int i=0;i<=money;i++) {
			ans=Math.max(ans, f2(nums,curProject+1,money-i,n,dp)+nums.get(curProject).get(i));
		}
		dp[curProject][money]=ans;
		
		return ans;
	}
	//严格位置依赖动态规划
	public static void f3(List<ArrayList<Integer>> nums,int m,int n) {
		//dp[x][y]表示从x项目开始,投资y元可以获得的最高收益
		int[][] dp=new int[n][m+1];
		int[][] path=new int[n][m+1];
		for(int i=0;i<=m;i++) {
			dp[n-1][i]=nums.get(n-1).get(i);
			path[n-1][i]=i;
		}
		for(int i=n-2;i>=0;i--) {
			for(int j=0;j<=m;j++) {
				for(int k=0;k<=j;k++) {
					if(dp[i+1][k]+nums.get(i).get(j-k)>dp[i][j]) {
						dp[i][j]=dp[i+1][k]+nums.get(i).get(j-k);
						path[i][j]=j-k;
					}
					//dp[i][j]=Math.max(dp[i][j], dp[i+1][k]+nums.get(i).get(j-k));
				}
			}
		}
		/*
		 * for(int i=0;i<dp.length;i++) { System.out.println(Arrays.toString(dp[i])); }
		 */
		int[] ansArr=new int[n];
		int remainMoney=m;
		for(int i=0;i<n;i++) {
			ansArr[i]=path[i][remainMoney];
			remainMoney-=ansArr[i];
		}
		System.out.println(dp[0][m]); 
		for(int i=0;i<ansArr.length;i++) {
			if(i==ansArr.length-1) {
				System.out.println(ansArr[i]);
			}else {
				System.out.print(ansArr[i]+",");
			}
		}
		
		
	}

}
