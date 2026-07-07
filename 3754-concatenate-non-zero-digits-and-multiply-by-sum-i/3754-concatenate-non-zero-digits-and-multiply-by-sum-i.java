class Solution {
    public long sumAndMultiply(int n) {
        int rev = 0;
        int sum = 0;
        while(n > 0){
            int digit = n % 10;
            if(digit != 0){
                rev = rev * 10 + digit;
                sum += digit;
            }
            n /= 10;
        }
        int x = 0;
        while(rev > 0){
            int dig = rev % 10;
            x = x * 10 + dig;
            rev /= 10;
        }
        return (long)x * sum;
    }
}