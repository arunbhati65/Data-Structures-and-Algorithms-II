class Solution {
    public int calculate(String s) {
        Stack<Integer> numbers=new Stack<>();
        Stack<Character> operators=new Stack<>();
        Boolean isPrevInt=false;
        for(char c:s.toCharArray()){
            if(c==' ') continue;
            if(c>='0' && c<='9'){
                if(isPrevInt){
                    int prev=numbers.pop();
                    numbers.push(prev*10+(c-'0'));
                }else{
                    numbers.push(c-'0');
                }
                isPrevInt=true;
            }else if(c=='('){
                operators.push(c);
                isPrevInt=false;
            }
            else if(c=='-'|| c=='+'){
                while(!operators.isEmpty() && operators.peek()!='('){
                    char oper=operators.pop();
                    int b=numbers.pop();
                    int a=numbers.pop();
                    if(oper=='+'){
                        numbers.push(a+b);
                    }else{
                        numbers.push(a-b);
                    } 
                }
                operators.push(c);
                isPrevInt=false;
            }
            else if(c==')'){
                while(operators.peek()!='('){
                    char oper=operators.pop();
                    int b=numbers.pop();
                    int a=numbers.pop();
                    if(oper=='+'){
                        numbers.push(a+b);
                    }else{
                        numbers.push(a-b);
                    }
                }
                operators.pop();  
                isPrevInt=false;
            }
        }
        while(numbers.size()!=1){
            char oper=operators.pop();
            int b=numbers.pop();
            int a=numbers.pop();
            if(oper=='+'){
                numbers.push(a+b);
            }else{
                numbers.push(a-b);
            }
        }
        return numbers.peek();
    }
}