class Solution {
    public boolean isAnagram(String a,String b){
          if(a.length() != b.length()){
            return false;
        }
        int freq[] = new int[26];

        for(int i=0;i<a.length();i++){
            freq[a.charAt(i) - 'a']++;
            freq[b.charAt(i) - 'a']--;
        }

        for(int i=0;i<26;i++){
            if(freq[i] != 0){
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<=s.length()-p.length();i++){
            String sub = s.substring(i,i+p.length());
            if(isAnagram(sub,p)){
                ans.add(i);
            }
        }
        return ans;
    }
}