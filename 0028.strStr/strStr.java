class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)return 0;
        else if(haystack.length() == 0 || haystack.length() < needle.length())return -1;
        
        int nL = needle.length(), l = haystack.length(), i, j;
        int[] pi = new int[nL];
        char[] hay = haystack.toCharArray(), need = needle.toCharArray();
        for(i = 1, j = 0; i < nL; i++){
            while(j > 0 && need[i] != need[j]){   
                /* 
                 abcab d abcab c
                 abcabd 与 abcabc 在 d 与 c 不匹配但 abc 却能与最开始的 3 个字母匹配
                 不匹配时 j 位置已经在后面了，若 j+1 之前的字母与最前面的字母匹配，有可能存在 i+1 位置也能匹配

                 第 j+1 个和第 i+1 个不匹配，但 i 和 j 的前 j 个是匹配的；
                 j = pi[j - 1];  j+1 前面字母与前面最大匹配个数，即 i+1 前面字母与前面最大匹配位数
                 即知道第 j+1 个字母前面已经匹配了多少个
                 */
                j = pi[j - 1]; 
            }
            if(need[i] == need[j]){
                j++;
            }
            pi[i] = j;
        }
        for(i = 0, j = 0; i < l; i++){
            while(j > 0 && need[j] != hay[i]){
                j = pi[j - 1];
            }
            if(need[j] == hay[i]){
                j++;
            }
            if(j == nL){
                return i - nL + 1;
            }
        }
        return -1;
    }
}
