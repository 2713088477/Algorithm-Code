package VideoZuo38;

//TODO s="bbbba" p=".*a*a过不了
public class MyPract_LeetCode_10 {
    public boolean isMatch(String s, String p) {
        char[] sArr=s.toCharArray();
        char[] pArr=p.toCharArray();
        return myMatch(sArr,pArr,0,0);
    }
    public boolean myMatch(char[] sArr,char[] pArr,int sIndex,int pIndex) {
    	if(sIndex==sArr.length && pIndex==pArr.length) {
    		return true;
    	}
    	if(sIndex==sArr.length&&pIndex<pArr.length) {
    		if(pIndex+1<pArr.length && pArr[pIndex+1]=='*') {
    			return myMatch(sArr,pArr,sIndex,pIndex+2);
    		}
    	}
    	if(sIndex>=sArr.length || pIndex>=pArr.length) {
    		return false;
    	}
    	
    	//'.'可以匹配任意单个字符
    	if(pArr[pIndex]=='.') {
    		return myMatch(sArr,pArr,sIndex+1,pIndex+1);
    	}
    	//'*'可以匹配零个或多个前面的那一个元素
    	else if(pArr[pIndex]=='*') {
    		char pre=pArr[pIndex-1];
    		if(pre=='.') {
    			if(pIndex+1==pArr.length) return true;
    			for(int i=sIndex;i<sArr.length;i++) {
    				if(myMatch(sArr,pArr,i,pIndex+1)) {
    					return true;
    				}
    			}
    			return false;
    		}else {
    			int i=sIndex;
    			for(;i<sArr.length;i++) {
    				if(sArr[i]!=pre) break;
    				else {
    					if(myMatch(sArr,pArr,i,pIndex+1)) return true;
    				}
    			}
    			return myMatch(sArr,pArr,i,pIndex+1);
    		}
    	}else {
    		if(pIndex+1<pArr.length && pArr[pIndex+1]=='*') {
				return myMatch(sArr,pArr,sIndex,pIndex+2);
			}
    		
    		if(sArr[sIndex]==pArr[pIndex]) {
    			return myMatch(sArr,pArr,sIndex+1,pIndex+1);
    		}
    		return false;
    	}
    }

}
