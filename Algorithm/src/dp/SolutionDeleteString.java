package dp;

import java.util.ArrayList;
import java.util.List;

public class SolutionDeleteString {
	public static int changeString(String s1,String s2) {
		char[] arr1=s1.toCharArray();
		char[] arr2=s2.toCharArray();
		int len1=arr1.length,len2=arr2.length;
		//dp[i][j]表示arr1[0,...,i-1]需要删除几个字符才能变成arr2必须以j-1为结尾的字串
		int[][] dp=new int[len1+1][len2+1];
		for(int i=1;i<=len1;i++) {
			dp[i][0]=i;
			for(int j=1;j<=len2;j++) {
				if(arr1[i-1]==arr2[j-1]) {
					dp[i][j]=dp[i-1][j-1];
				}else {
					dp[i][j]=dp[i-1][j]+1;
				}
			}
		}
		int ans=Integer.MAX_VALUE;
		for(int i=0;i<=len2;i++) {
			ans=Math.min(ans, dp[len1][i]);
		}
		return ans;
	}
	public static int deleteString(String s1,String s2) {
		//计算出s1的所有字串
		List<String> list=new ArrayList<String>();
		f1(s1.toCharArray(),0,"",list);
		list.sort((a,b)-> b.length()-a.length());
		for(String str:list) {
			if(s2.indexOf(str)!=-1) {
				return s1.length()-str.length();
			}
		}
		return s1.length();
		
	}
	//将s的所有字串加入到list中
	public static void f1(char[] s,int index,String path,List<String> list) {
		if(index==s.length) {
			list.add(path);
		}else {
			f1(s,index+1,path,list);
			f1(s,index+1,path+s[index],list);
		}
	}
	
	//生成长度为len,有k个不同的字符串
	public static String getRandom(int len,int k){
		char[] ans=new char[len];
		for(int i=0;i<len;i++) {
			ans[i]=(char)('a'+(int)(Math.random()*k));
		}
		return String.valueOf(ans);
	}
	public static void main(String[] args) {
		int len=13;
		int k=10;
		int test=2000;
		System.out.println("测试开始");
		for(int i=0;i<test;i++) {
			int len1=(int)(Math.random()*len)+1;
			int len2=(int)(Math.random()*len)+1;
			String s1=getRandom(len1,k);
			String s2=getRandom(len2,k);
			int ans1=changeString(s1,s2);
			int ans2=deleteString(s1,s2);
			if(ans1!=ans2) {
				System.out.println("测试失败"+s1+" "+s2);
				System.out.println(ans1+" "+ans2);
			}
			
		}
		System.out.println("测试结束");
		
	}

}
