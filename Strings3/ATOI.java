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

class Solution {//Revision
    public int myAtoi(String str) {//"123" "4193 with words" "words and 987" "-91283472332"
        str=str.trim();
        if(str.length()==0) return 0;
        int start=-1;
        int startWords=Integer.MAX_VALUE; 
        boolean signEncounterd=false ;
        boolean zeroEncounterd=false;
        for(int i=0;i<str.length();++i){
            char c=str.charAt(i);
            if(c>='1' && c<='9'){
                start=i;
                break;
            }else if(c=='-' || c=='+'){
                if(signEncounterd==true || zeroEncounterd==true){
                    return 0;
                }
                signEncounterd=true;
                continue;
            }else if(c=='0'){
                zeroEncounterd=true;
                continue;
            }else{
                startWords=i;
            }
        }
        if(startWords<start || start==-1){
            return 0;
        }
        int negativeMultiplier=1;
        if(str.charAt(0)=='-'){
            negativeMultiplier=-1;
        }
        double resultF=0.0;
        for(int i=start;i<str.length();++i){
            char c=str.charAt(i);
            if(c<'0' || c>'9') break;
            resultF=resultF*10+(c-'0');
        }
        int ans=0;
        if(resultF>Integer.MAX_VALUE && negativeMultiplier==1){
            ans=Integer.MAX_VALUE;
        }
        else if(resultF>Integer.MAX_VALUE && negativeMultiplier==-1){
            ans=Integer.MIN_VALUE;
        }else{
           ans=(int)resultF;
           ans=ans*negativeMultiplier;
        }
        return ans;
    }
}