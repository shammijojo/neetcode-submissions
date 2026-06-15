class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int trappedWater = 0;
        // left[0] = 0;
        // right[height.length-1] = 0;

        int max = height[0];
        for(int i = 0; i < height.length-1; i++) {
            left[i] = max;
            max = Math.max(max,height[i]);
        }

        max = height[height.length-1];
        for(int i = height.length-1; i >= 0; i--) {
            right[i] = max;
            max = Math.max(max,height[i]);
        }


        for(int i = 1;i < height.length-1; i++) {
            int min = Math.min(left[i],right[i]);
            if(min-height[i] > 0) {
                trappedWater+=min-height[i];
            }
        }

        return trappedWater;


    }
}
