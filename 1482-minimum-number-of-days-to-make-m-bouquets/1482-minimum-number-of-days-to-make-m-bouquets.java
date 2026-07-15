class Solution {
    public boolean isPossible(int[] arr, int days , int m , int k){
        int count = 0;
        int Boquets = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i] <= days){
                count++;
                if(count == k){
                    Boquets++;
                    count = 0;
                }
            } else {
                count = 0;
            }
        }
        if(Boquets >= m){
            return true;
        } else {
            return false;
        }
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m * k > bloomDay.length){
            return -1;
        }
        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;
        for(int i = 0;i < bloomDay.length;i++){
            low = Math.min(low,bloomDay[i]);
            high = Math.max(high,bloomDay[i]);
        }
        int ans = 0;
        while(low <= high){
            int mid = (low + high)/2;
            if(isPossible(bloomDay,mid,m,k)){
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}