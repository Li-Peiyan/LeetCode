class Solution { //3ms
    public String intToRoman(int num) {
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuffer roman = new StringBuffer();
        for(int i=0; i<13; i++){
            while(num >= values[i]){
                num -= values[i];
                roman.append(symbols[i]);
            }
            if (num == 0) {
                break;
            }
        }
        return roman.toString();
    }
}

class Solution { //5ms
    public String intToRoman(int num) {
        StringBuffer roman = new StringBuffer();
        int i = 1;
        while(num != 0)
        {
            StringBuffer str = new StringBuffer();
            int n = num%10;
            num /= 10;
            if(n >= 9) {
                n -= 9;
                str.append(toRoman(i*9));
            }
            else if( n>=5 ){
                n -= 5;
                str.append(toRoman(i*5));
            }
            else if( n>=4 ){
                n -= 4;
                str.append(toRoman(i*4));
            }
            while( n>=1 )
            {
                n -= 1;
                str.append(toRoman(i*1));
            }
            i *= 10;
            roman.insert(0,str);
        }
        return roman.toString();
    }

    public static String toRoman(int i)
    {
        switch(i)
        {
            case 1 : return "I";
            case 4 : return "IV";
            case 5 : return "V";
            case 9 : return "IX";
            case 10 : return "X";
            case 40 : return "XL";
            case 50 : return "L";
            case 90 : return "XC";
            case 100 : return "C";
            case 400 : return "CD";
            case 500 : return "D";
            case 900 : return "CM";
            case 1000 : return "M";   
        }
        return "";
    } 
}
