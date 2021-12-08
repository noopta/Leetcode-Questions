class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> stackOne = new Stack<Character>();
        Stack<Character> extraBrackets = new Stack<Character>();
        int i = 0;
        
        for(i = 0; i < s.length(); i++){
            
            if(s.charAt(i) == '('){
                stackOne.push(s.charAt(i));
            } else if (s.charAt(i) == ')'){
                if(stackOne.size() == 0){
                    extraBrackets.push(s.charAt(i));
                } else {
                    stackOne.pop();
                }
            }
            
        }
        
        
        return stackOne.size() + extraBrackets.size();
    }
}