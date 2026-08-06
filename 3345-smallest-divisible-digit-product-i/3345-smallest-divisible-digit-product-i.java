class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
        int num = n;
        int prod = 1;
        while(num > 0){
            int digi = num % 10;
             num = num/10;
            prod *= digi;
        }
        if(prod % t == 0){
            return n;
        } 
        n++;
     }
    }
}