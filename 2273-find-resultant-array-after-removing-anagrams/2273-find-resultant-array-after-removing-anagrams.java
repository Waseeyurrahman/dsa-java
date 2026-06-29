class Solution {
    public List<String> removeAnagrams(String[] words) {
        List<String> ans = new ArrayList<>();
        ans.add(words[0]);
        for(int i=1;i<words.length;i++){
        if(!isAnagram(ans.get(ans.size()-1),words[i])){
            ans.add(words[i]);
        }
        }
       return ans; 

    }
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
}