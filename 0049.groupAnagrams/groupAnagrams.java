class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<Double, List<String>> map = new HashMap<Double, List<String>>();
        HashMap<Character, Integer> nums = new HashMap<Character, Integer>() {
            {
                put('a', 2);   
                put('b', 3);  
                put('c', 5);   
                put('d', 7);  
                put('e', 11);   
                put('f', 13);  
                put('g', 17);   
                put('h', 19);  
                put('i', 23);   
                put('j', 29);  
                put('k', 31);   
                put('l', 37);  
                put('m', 41);   
                put('n', 43);  
                put('o', 47);   
                put('p', 53); 
                put('q', 59);   
                put('r', 61);  
                put('s', 67);   
                put('t', 71);   
                put('u', 73);   
                put('v', 79);  
                put('w', 83);   
                put('x', 89);  
                put('y', 97);   
                put('z', 101);  
            }
        };
        for (String str : strs) {
            char[] array = str.toCharArray();
            double sum = 1;
            for(char s : array){
                sum = sum * nums.get(s) ;
            }
            if(map.containsKey(sum)){
                List<String> list = map.get(sum);
                list.add(str);
            }else{
                List<String> list = new ArrayList<String>();
                map.put(sum, list);
                list.add(str);
            }
        }
        return new ArrayList<List<String>>(map.values());
    }
}
