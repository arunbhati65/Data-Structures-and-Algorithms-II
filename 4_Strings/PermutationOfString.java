public class PermutationOfString {

    static void permutation(String s){
        if(s.length()==0) return;
        DFS(0,s.toCharArray());
    }
    
    private static void DFS(int index, char[] cs) {
        if (index == cs.length-1) {
            System.out.println(cs);
            return;
        }
        for (int i = index; i < cs.length; ++i) {
            swap(cs,index,i);
            DFS(index+1, cs);
            swap(cs,index,i);
        }
    }

    private static void swap(char[] cs, int index, int i) {
        char temp=cs[i];
        cs[i]=cs[index];
        cs[index]=temp;
    }

    public static void main(String[] args) {
        permutation("ABC");
    }
}
