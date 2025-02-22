class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder sb = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        
        for(int i=s; i<=e; i++){
            sb.append(my_string.charAt(i));
        }
        
        sb.reverse();
        
        for(int i=0; i<s; i++){
            answer.append(my_string.charAt(i));
        }
        
        answer.append(sb);
        
        for(int i=e+1; i<my_string.length(); i++){
            answer.append(my_string.charAt(i));
        }
        
        return answer.toString();
    }
}