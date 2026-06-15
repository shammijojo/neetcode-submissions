class Solution {
    public String simplifyPath(String path) {
        Stack<String>stack = new Stack<>();
        StringBuilder result = new StringBuilder();

        String[] dirs = path.split("/");

        for(int i = 0; i < dirs.length; i++) {
            String s = dirs[i];

            if(s.equals(".") || s.length() == 0) {
                continue;
            } else if(s.equals("..")) {
                if(!stack.isEmpty())
                stack.pop();
                continue;
            } 

            stack.push(dirs[i]);
        }

        if(stack.isEmpty()) {
            return "/";
        }

        while(!stack.isEmpty()) {
            result.insert(0,"/"+stack.pop());
        }

        return result.toString();
    }
}