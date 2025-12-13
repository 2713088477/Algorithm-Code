package VideoZuo30;

public class GetSingleNumber {
	public static void main(String[] args) {
		
	}
    public int[] singleNumber(int[] nums) {
        int xorTotal=0;
        for(int num:nums) {
        	xorTotal ^= num;
        }
        //整体异或后,xorTotal肯定是两个出现奇数次的数贡献的
        //最右侧的1，说明在这个二进制位，两个出现奇数次的数一定不同
        int rightBit=xorTotal&(~xorTotal+1);
        //根据这个将两个数区分出来
        int xor1=0,xor2=0;
        for(int num:nums) {
        	if((num&rightBit)==0) {
        		xor1 ^= num;
        	}else {
        		xor2 ^= num;
        	}
        }
        return new int[] {xor1,xor2};
    }

}
