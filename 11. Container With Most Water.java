class Solution {
    public int maxArea(int[] height) {

        int i = 0, j = height.length - 1;
        int max = Math.min(height[i], height[j]) * (j - i);
        while (i < j) {
            if (height[i] < height[j]) {
                int min = height[i];
                while (height[++i] < min)
                    if (i >= j)
                        break;
            } else {
                int min = height[j];
                while (height[--j] < min)
                    if (j <= i)
                        break;
            }

            if (j > i)
                max = Math.max(Math.min(height[i], height[j]) * (j - i), max);

        }

        return max;
    }

    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        Solution solution = new Solution();
        System.out.println(solution.maxArea(a));
    }

}


