import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        String[] str = my_string.split(" "); 
        ArrayList<String> al = new ArrayList<>();
        
        for(int i=0; i<str.length; i++){
            if(!str[i].equals("")){
                al.add(str[i]);
            }
        }
        
        String[] answer = new String[al.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = al.get(i);
        }
        
        return answer;
    }
}