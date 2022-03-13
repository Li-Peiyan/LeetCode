class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() < 2)return 0;

        char[] str = s.toCharArray();
        int[] dp = new int[s.length()];
        int max = 0;

        for(int i = 1; i < s.length(); i++){
            if(str[i] == ')'){
                if(str[i] == '('){
                    dp[i] = (i > 2? dp[i - 2] : 0) + 2;
                }else if(i - dp[i - 1] > 0 && str[i - dp[i - 1] - 1] == '('){
                    dp[i] = dp[i-1] + 2 + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    } 
}


class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() < 2)return 0;

        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        char[] str = s.toCharArray();
        stack.push(-1);
        for(int i = 0; i < s.length(); i++){
            if(str[i] == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}


class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() < 2)return 0;

        Stack<Integer> stack = new Stack<Integer>();
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        int index = 0, i = s.length() - 1, max = 0;
        char[] str = s.toCharArray();
        al:
        while(i >= 0){
            while(stack.isEmpty() && str[i] != ')'){
                --i;
                if(i < 0){
                    break al;
                }
            }
            while(str[i] == ')'){
                stack.push(i);
                --i;
                if(i < 0){
                    break al;
                }
            }
            while(i >= 0 && str[i] == '('){
                index = stack.pop();
                if(stack.isEmpty()){
                    --i;
                    break;
                }
                --i;
            }
            if(i > -2)hash.put(index, i);
        }
        for(index = s.length() - 1; index > -1; --index){
            if(hash.containsKey(index)){
                i = hash.get(index);
                while(hash.containsKey(i)){
                    i = hash.get(i);
                }
                if(index - i > max){
                    max = index - i;
                }
                index = i;
            }
        }
        return max;
    }
}
