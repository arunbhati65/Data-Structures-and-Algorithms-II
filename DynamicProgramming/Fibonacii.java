public class Fibonacii{
	static int fibonacii(int n){
		if(n==0)return 0;
		if(n==1) return 1;
		return fibonacii(n-1)+fibonacii(n-2);
	}

	public static void main(String args[]){
		System.out.print("fibonacii of 8 is :  "+fibonacii(8));
	}
}