class Solution {
    public int solution(String myString, String pat) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<myString.length(); i++){
            sb.append(Character.toLowerCase(myString.charAt(i)));
        }
        
        myString = sb.toString();
        sb.setLength(0); //내용물 비우기
        
        for(int i=0; i<pat.length(); i++){
            sb.append(Character.toLowerCase(pat.charAt(i)));
        }
        
        pat = sb.toString();
        
        int answer = myString.contains(pat) ? 1 : 0;
        
        return answer;
    }
}