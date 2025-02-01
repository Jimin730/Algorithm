import java.util.*;

class Solution {
    public String[] solution(String[] todo_list, boolean[] finished) {
        ArrayList<String> al = new ArrayList<>();
        
        for(int i=0; i<finished.length; i++){
            if(!finished[i]){
                al.add(todo_list[i]);
            }
        }
        
        String[] result = new String[al.size()];
        
        for(int i=0; i<al.size(); i++){
            result[i] = al.get(i);
        }
        
        return result;
    }
}