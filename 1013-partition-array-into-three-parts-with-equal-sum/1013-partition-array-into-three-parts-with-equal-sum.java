class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
       int totalsum = 0;
       int n = arr.length;
       for(int i=0;i<n;i++){
        totalsum += arr[i];
       } 
       int target = totalsum/3;
       if(totalsum % 3 != 0){
        return false;
       }
        int count = 0;
       int currsum = 0;
       for(int i=0;i<n;i++){
        currsum += arr[i];
        if(currsum == target){
            count++;
            currsum = 0;
        }
       }
       return count >= 3;
    }
}