class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if(n<m) {
            return findMedianSortedArrays(nums2,nums1);
        }

        int low = 0, high = m;

        while(low <= high) {
            int pX = (low+high)/2;
            int pY = (m+n+1)/2 - pX;

            int maxLeftX = pX==0?Integer.MIN_VALUE:nums1[pX-1];
            int minRightX = pX==m?Integer.MAX_VALUE:nums1[pX];

            int maxLeftY = pY==0?Integer.MIN_VALUE:nums2[pY-1];
            int minRightY = pY==n?Integer.MAX_VALUE:nums2[pY];

            if(maxLeftX <= minRightY && minRightX >= maxLeftY) {
                if((m+n)%2==0) {
                    return ((double)Math.max(maxLeftX,maxLeftY)+(double)Math.min(minRightY,minRightX))/2;
                } else {
                    return Math.max(maxLeftX,maxLeftY);
                }
            } else if(maxLeftX > minRightY) {
                high = pX-1;
            } else {
                low = pX+1;
            }
        }

        return 0d;
    }
}
