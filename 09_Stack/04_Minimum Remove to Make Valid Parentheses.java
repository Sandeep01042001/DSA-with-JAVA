class Solution {
    public String minRemoveToMakeValid(String s) {
        
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ')'){
                if(!stack.isEmpty() && stack.peek() == '('){
                    stack.pop();
                    result.append(ch);
                }
            }else if(ch == '('){
                result.append(ch);
                stack.push(ch);
            }else{
                result.append(ch);
            }
        }
        //System.out.println(stack.size());
        while(!stack.isEmpty() && stack.peek() == '('){
            for(int i=result.length()-1; i>=0; i--){
                char ch = result.charAt(i);
                if(ch == '('){
                    if(!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                        result.deleteCharAt(i);
                    }
                }
            }
        }
        return result.toString();
    }
}
