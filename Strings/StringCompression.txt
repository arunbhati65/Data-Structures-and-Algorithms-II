class Solution {
    public int compress(char[] chars) {
        char currChar=chars[0];
        int currCharCount=1;
        if(chars.length==1){
            return 1;
        }
        int size=0;
        for(int i=1;i<chars.length;++i){
            char temp=chars[i];
            if(temp==currChar){
                currCharCount++;
            }else{
                String number=(currCharCount==1)?"":currCharCount+"";
                chars[size++]=currChar;
                if(number.length()>0){
                    for(int m=0;m<number.length();++m){
                        chars[size++]=number.charAt(m);
                    }
                }
                currChar=temp;
                currCharCount=1;
            }
        }
        String number=(currCharCount==1)?"":currCharCount+"";
        chars[size++]=currChar;
        if(number.length()>0){
            for(int m=0;m<number.length();++m){
                chars[size++]=number.charAt(m);
            }
        }
        return size;
    }
}