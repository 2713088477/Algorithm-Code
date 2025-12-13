package VideoZuo31;

public class IsPower3 {
	public static void main(String[] args) {
		//找到int范围内最大的3的幂 1 3 9 27 27*3
		int ans=1;
		while(ans*3>0&&ans*3<=Integer.MAX_VALUE) {
			ans*=3;
		}
		System.out.println(ans);//1162261467
		
	}
    public boolean isPowerOfThree(int n) {
        return n>0 && 1162261467%n==0;
    }

}
