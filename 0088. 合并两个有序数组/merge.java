class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1, z = m + n - 1;
        while(j >= 0){
            if(i < 0 || nums2[j] > nums1[i]){
                nums1[z] = nums2[j];
                j--;
            }else {
                nums1[z] = nums1[i];
                i--;
            }
            z--;
        }
    }
}
