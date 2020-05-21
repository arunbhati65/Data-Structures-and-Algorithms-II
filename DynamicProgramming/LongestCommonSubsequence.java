import java.lang.Math;

public class LongestCommonSubsequence{
	
	static int LCS(String str1,int l1,String str2,int l2){
		if(l1==0||l2==0) return 0;
		if(str1.charAt(l1-1)==str2.charAt(l2-1)){
			return 1+LCS(str1,l1-1,str2,l2-1);
		}else{
			return Math.max(LCS(str1,l1,str2,l2-1),LCS(str1,l1-1,str2,l2));
		}
	}
	
	public static void main(String args[]){
		String str1="aabcsdbc";
		String str2="aaabbbcc";
		
		System.out.println("length of LCS is - "+LCS(str1,str1.length(),str2,str2.length()));

	}
}