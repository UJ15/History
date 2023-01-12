import java.util.Stack;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> stack = new Stack<Integer>();
        int size = temperatures.length;
        int result[] = new int[size];
        //push in stack the index of temperatures  
        for (int i = 0 ; i < temperatures.length ; i++){
            //compare current temperatures and stack temperatures 
            //store index diff in result
            while (!stack.empty() && temperatures[stack.peek()] < temperatures[i]){
                result[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        return result;
    }
}
