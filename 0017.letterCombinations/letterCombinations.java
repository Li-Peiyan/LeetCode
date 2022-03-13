class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> letterList = new ArrayList<String>();
        if(digits.length() == 0)return letterList;
        combinations(letterList, digits, 0, new StringBuffer());
        return letterList;
    }
    public static String phoneMap(char a){
        switch(a)
        {
            case '2' : return "abc";
            case '3' : return "def";
            case '4' : return "ghi";
            case '5' : return "jkl";
            case '6' : return "mno";
            case '7' : return "pqrs";
            case '8' : return "tuv";
            case '9' : return "wxyz";
        }
        return "";
    }
    public static void combinations(List<String> letterList, String digits, int index, StringBuffer str){
        if(index == digits.length())
        {
            letterList.add(str.toString());
        }
        else{
            char digit = digits.charAt(index);
            String s = phoneMap(digit);
            int count = s.length();
            for(int i=0; i<count; i++)
            {
                str.append(s.charAt(i));
                combinations(letterList, digits, index + 1, str);
                str.deleteCharAt(index);
            }
        }
    }
}
