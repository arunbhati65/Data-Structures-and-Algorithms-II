public class CombinationOfString {
    static void combination(String s){
        if(s.length()==0) return;
        System.out.println(" ");
        for(int i=0;i<s.length();++i){
            DFS(i,s.substring(i,i+1),s.toCharArray());
        }
   
    }
    
    private static void DFS(int index,String ans, char[] cs) {
        System.out.println(ans);
        if(index==cs.length-1) return;
        for (int i = index+1; i < cs.length; ++i) {
            DFS(i,ans +cs[i],cs);
        }
    }


    public static void main(String[] args) {
        combination("ABC");
    }
}
