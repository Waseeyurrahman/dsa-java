class Solution {
    public boolean rotateString(String s, String goal) {
        String result = s + s;
        if(result.contains(goal)){
            return true;
        }
        return false;
    }
}