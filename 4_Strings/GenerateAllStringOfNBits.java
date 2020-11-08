public class GenerateAllStringOfNBits {
    static void allStrings(int n){
        int[] ans=new int[n];
        DFS(0,ans);
    }
    
    private static void DFS(int index,int[] ans) {
        if(index==ans.length){
            for(int i=0;i<ans.length;++i){
                System.out.print(ans[i]);
            }
            System.out.println("");
            return;
        } 
        ans[index]=1;
        DFS(index+1, ans);
        ans[index]=0;
        DFS(index+1, ans);
    }


    public static void main(String[] args) {
        allStrings(3);
    }
}
