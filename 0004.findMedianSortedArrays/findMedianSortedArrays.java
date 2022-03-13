class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length,n2 = nums2.length;
        int i1=0,i2=0,m=0,BOL=0;
        int midnum,mid = (n1 + n2 + 1 )/2;
        if((n1+n2) <= 1)
        {
            if(i1 < n1)return nums1[i1];
            else return nums2[i2];
        }
        while(true)
        {
            if(i1 < n1 && i2 < n2 && m < mid)
            {
                if( nums1[i1] <= nums2[i2] ){i1++;BOL=1;}
                else {i2++;BOL=2;}
            }
            else if( i1 < n1 && m < mid){i1++;BOL=1;}
            else if( i2 < n2 && m < mid){i2++;BOL=2;}
            else break;
            m++;
        }
        if(BOL == 1)midnum = nums1[i1-1];
        else midnum = nums2[i2-1];

        if( mid == (n1+n2)/2 ){
            if(i1 < n1 && i2 < n2 )
            {
                if(nums1[i1]<nums2[i2])return (( double)(midnum + nums1[i1])/2 );
                else return (( double) (midnum + nums2[i2])/2 );
            }
            else if(i1 < n1)return (( double)(midnum + nums1[i1])/2 );
            else  return ((double) (midnum + nums2[i2])/2) ;
        }
        return midnum;
    }
}
