class Solution {
    public String simplifyPath(String path) {
        String[] names = path.split("/");
        Deque<String> stack = new LinkedList<String>();
        for(String str:names){
            if(str.equals(".") || str.equals("")){
                    continue;
            }else if(str.equals("..")) {
                if(!stack.isEmpty()){
                    stack.pollLast();
                }
            }else{
                stack.offer(str);
            }
        }
        StringBuffer name = new StringBuffer();
        if(stack.isEmpty()){
            return "/";
        }
        while(!stack.isEmpty()){
            name.append('/');
            name.append(stack.poll());
        }
        return name.toString();
    }
}
