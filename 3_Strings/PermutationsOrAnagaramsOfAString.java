//All possible anagrams or permutation of a string    
void helper(String txt,String str,int l,int h){
        if(l==h){
            if(txt.indexOf(str)>=0){
                System.out.println(str);
            }
        }else{
            for(int i=l;i<=h;++i){
                str=swap(str,l,i);
                helper(txt,str,l+1,h);
                str=swap(str,l,i);
            }
        }
    }
    
    public String swap(String a, int i, int j){ 
		char temp; 
		char[] charArray = a.toCharArray(); 
		temp = charArray[i] ; 
		charArray[i] = charArray[j]; 
		charArray[j] = temp; 
		return String.valueOf(charArray); 
	}