class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> theStack = new Stack<Integer>();
        int j = 0;
        
        
        for(int num : pushed){
            theStack.push(num);
            
            while(!theStack.isEmpty() && theStack.peek() == popped[j]){
                theStack.pop();
                j++;
            }
            
        }
        
        return j == pushed.length;
    }
}