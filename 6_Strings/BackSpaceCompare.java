class BackspaceCompare {

    public static boolean compare(String str1, String str2) {
      char[] s1=str1.toCharArray();
      char[] s2=str2.toCharArray();
      int l1=0;
      for(int h=0;h<s1.length;++h){
         if(s1[h]=='#'){
           --l1;
         }else{
           s1[l1]=s1[h];
           ++l1;
         }
      }
      int l2=0;
      for(int h=0;h<s2.length;++h){
         if(s2[h]=='#'){
           --l2;
         }else{
           s2[l2]=s2[h];
           ++l2;
         }
      }
      if(l1!=l2) return false; 
      for(int i=0;i<l2;++i){
        if(s1[i]!=s2[i]) return false;
      }
      return true;
    }
  }