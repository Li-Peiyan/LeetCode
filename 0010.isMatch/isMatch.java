class Solution {
     public boolean isMatch(String s, String p) {
        boolean[][] f = new boolean[s.length() + 1][p.length() + 1];
        char[] cs = s.toCharArray();
        char[] cp = p.toCharArray();

        f[0][0] = true;

        for(int j=1; j< f[0].length; j++){
            if(j == 1 && cp[j-1] == '*'){ 
                f[0][j] = true;
            }else if( j > 1 && cp[j-1] == '*'){
                f[0][j] = f[0][j-2];
            }
        }

        for(int i =1; i<f.length; i++){
            for(int j =1; j<f[0].length;j++){
                if(cs[i-1] == cp[j-1] || cp[j-1] == '.'){
                    f[i][j] = f[i-1][j-1];

                }else if(cp[j-1] == '*' && j > 1){
                    
                    if(f[i][j-2]){
                        f[i][j] = true;

                    
                    }else if(cs[i-1] == cp[j-2] || cp[j-2] == '.'){
                        f[i][j] = f[i-1][j];
                    }
                }
            }
        }
        return f[f.length-1][f[0].length-1];
    }
}
