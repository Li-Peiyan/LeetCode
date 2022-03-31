class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<Integer>();
        for (int i = 0; i < 1 << n; i++) {
            // 异或计算每位数对应的各类编码
            ret.add((i >> 1) ^ i);
        }
        return ret;
    }
}
