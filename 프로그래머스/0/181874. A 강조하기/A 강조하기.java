class Solution {
    public String solution(String myString) {
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<myString.length(); i++){
            char c = myString.charAt(i);
            
            if(c == 'a')
                sb.append("A");
            else if(c != 'A')
                sb.append(Character.toLowerCase(c));
            else
                sb.append(c);
        }
        
        return sb.toString();
    }
}