class Solution {
    public long calculateSpeed(int[] piles , int speed){
        long totalH = 0;
        for(int bananas : piles){
             totalH += (bananas + speed - 1) / speed;
        }
        return totalH;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int ans= 0;
        while(low <= high){
            int mid = (low + high)/2;
            long totalH = calculateSpeed(piles,mid);
            if(totalH <= h){
                ans = mid;
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}