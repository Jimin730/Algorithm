class Solution {
    public int solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<myString.length(); i++){
            char c = myString.charAt(i);
            
            if(c == 'A') sb.append("B");
            else if(c == 'B') sb.append("A");
        }
        
        myString = sb.toString();
        
        int answer = 0;
        if(myString.contains(pat)){
            answer = 1;
        }
        else {
            answer = 0;
        }
        
        return answer;
    }
}