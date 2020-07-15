class Solution {
    public int myAtoi(String str) {//"123"
        if(str.length()==0) return 0;
        str.trim();
        char [] chars=str.toCharArray();
        int result=0;
        int start=0;
        while(start<chars.length && chars[start]==' '){
            ++start;
        }
        boolean isNegative=false;
        if(start<chars.length && chars[start]=='-'){
            ++start;
            isNegative=true;
        }else if(start<chars.length && chars[start]=='+'){
            ++start;
        }
        for(int i=start;i<chars.length;++i){
            if(chars[i]>='0' && chars[i]<='9'){
                int d=chars[i]-'0';
                if(result>(Integer.MAX_VALUE-d)/10){
                    result=isNegative?Integer.MIN_VALUE:Integer.MAX_VALUE;
                    return result;
                }
                result=result*10+(d);
            }else{
                break;
            }
        }
        if(isNegative){
            result=-1*result;
        }
        if(result>Integer.MAX_VALUE){
            return Integer.MAX_VALUE;
        }else if(result<Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        return result;
    }
}