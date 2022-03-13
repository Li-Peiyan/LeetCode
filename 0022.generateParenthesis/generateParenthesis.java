class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generate(res, new StringBuffer(), 0, 0, n);
        return res;
    }
    public void generate(List<String> res, StringBuffer s, int numL, int numR, int n){
        if(s.length() == 2*n){
            res.add(s.toString());
            return;
        }
        if(numL < n){
            generate(res, s.append('('), numL + 1, numR, n);
            s.deleteCharAt(s.length() - 1);
        }
        if(numL > numR){
            generate(res, s.append(')'), numL, numR + 1, n);
            s.deleteCharAt(s.length() - 1);
        }
    }
}
