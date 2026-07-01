class Solution {
    public int[] searchRange(int[] nums, int target) {
        
        int first = firstOccurence(nums,target);
        int last = lastOccurence(nums,target);

        return new int[]{first,last} ;     
    }
     public int firstOccurence(int[] nums,int target){
            int l = 0, r = nums.length-1;
            while(l<=r){
                int mid = (l + r)/2;
                if(nums[mid] < target){
                    l = mid + 1;
                }
                else if(nums[mid] > target){
                    r = mid - 1;
                }
                else if(nums[mid] == target){
                    if(mid == 0 || nums[mid-1]<target){
                        return mid;
                    }else{
                        r = mid -1;
                    }
                }
            }
            return -1;
        }

         public int lastOccurence(int[] nums,int target){
            int l = 0, r = nums.length-1;
            while(l<=r){
                int mid = (l + r)/2;
                if(nums[mid] < target){
                    l = mid + 1;
                }
                else if(nums[mid] > target){
                    r = mid - 1;
                }
                else if(nums[mid] == target){
                    if(mid == nums.length-1 || nums[mid+1]>target){
                        return mid;
                    }else{
                        l = mid + 1;
                    }
                }
            }
            return -1;
        }
}