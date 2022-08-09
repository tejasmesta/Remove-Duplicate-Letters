class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        
        Stack<Character> st = new Stack<>();
        
        int arr[] = new int[26];
        
        for(int i=0;i<n;i++)
        {
            char c = s.charAt(i);
            arr[c-'a']++;
        }
        
        boolean exists[] = new boolean[26];
        
        for(int i=0;i<n;i++)
        {
            char c = s.charAt(i);
            
            arr[c-'a']--;
            
            if(exists[c-'a'])
            {
                continue;
            }
            
            while(!st.isEmpty() && st.peek()>c && arr[st.peek()-'a']>0)
            {
                char v = st.pop();
                exists[v-'a'] = false;
            }
            
            st.push(c);
            
            exists[c-'a'] = true;
        }
        
        char h[] = new char[st.size()];
        
        int k=h.length-1;
        
        while(k>=0)
        {
            h[k--] = st.pop();
        }
        
        return new String(h);
        
    }
}
