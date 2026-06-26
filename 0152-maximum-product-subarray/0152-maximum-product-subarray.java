class Solution {
    public int maxProduct(int[] nums) {
         int maxEnding = nums[0];
        int minEnding = nums[0];
        int answer = nums[0];

        for (int i = 1; i < nums.length; i++) {

            int num = nums[i];

            int tempMax = Math.max(num,
                    Math.max(num * maxEnding, num * minEnding));

            int tempMin = Math.min(num,
                    Math.min(num * maxEnding, num * minEnding));

            maxEnding = tempMax;
            minEnding = tempMin;

            answer = Math.max(answer, maxEnding);
        }

        return answer; 
    }
}