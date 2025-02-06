class Solution {//Not Efficient
    char[] arr={'a','e','i','o','u'};
    public int countVowelStrings(int n) {
         return helper("",0,n);          
    }
    
    int helper(String str,int index,int n){
        if(str.length()==n) {
            System.out.println(str);
            return 1;
        }
        int count=0;
        for(int i=index;i<arr.length;++i){
            count=count+helper(str+arr[i],i,n);
        }
        return count;
    }
}

class Solution {//Not efficent
    char[] arr={'a','e','i','o','u'};
    HashSet<String> set=new HashSet<>();
    public int countVowelStrings(int n) {
        for(int i=0;i<arr.length;++i){
          helper(""+arr[i],i,n);          
        }
        return set.size();
    }
    
    void helper(String str,int index,int n){
        if(str.length()==n) {
            set.add(str);
            return ;
        }
        if(index==arr.length) return;
        helper(str+arr[index],index,n);
        helper(str,index+1,n);
        if(index+1>=arr.length) return;
        helper(str+arr[index+1],index+1,n);
    }
}