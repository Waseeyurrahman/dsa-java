class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
     int pfreq[] = new int[26];
     int winfreq[] = new int[26];
     
     if(p.length() > s.length()){
        return ans;
     }

     for(int i=0;i<p.length();i++){
        pfreq[p.charAt(i) - 'a']++;
        winfreq[s.charAt(i) - 'a']++;
    }  
    if(Arrays.equals(pfreq,winfreq)){
        ans.add(0);
    }
    int left = 0, right = p.length();
    while(right < s.length()){
        winfreq[s.charAt(left) - 'a']--;
        winfreq[s.charAt(right) - 'a']++;
        left++;
        right++;
        if(Arrays.equals(pfreq,winfreq)){
            ans.add(left);
        }
    }
    return ans;
    }
}