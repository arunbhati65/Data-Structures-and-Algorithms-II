/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
*/
class ValidParentheses {
    public  boolean isValid(String s) {
        HashMap<Character,Character> map=new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        char[] arr=s.toCharArray();
        if(arr.length==0) return true;
        Stack<Character> stack=new Stack<>();
        stack.push(arr[0]);
        for(int i=1;i<arr.length;++i){
            Character top=stack.isEmpty()?null:stack.peek();
            if(top !=null && isOpenBracket(top) && !isOpenBracket(arr[i])){
                if(map.get(top).equals(arr[i])){
                    stack.pop();
                }else {
                    return false;
                }
            }
            else {
                stack.push(arr[i]);
            }
        }
        return stack.isEmpty();
    }
     boolean isOpenBracket(char c){
        if(c=='('||c=='{'||c=='[')
            return true;
        return false;
    }
}