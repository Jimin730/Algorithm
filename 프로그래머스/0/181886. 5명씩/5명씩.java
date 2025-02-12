import java.util.*;

class Solution {
    public String[] solution(String[] names) {
        ArrayList<String> firstName = new ArrayList<>();
        
        for(int i=0; i<names.length; i+=5){
            firstName.add(names[i]);
        }
        
        String[] answer = new String[firstName.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = firstName.get(i);
        }
        
        return answer;
    }
}