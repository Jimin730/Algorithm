import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i=n; i<num_list.length; i++){
            al.add(num_list[i]);
        }
        
        for(int i=0; i<n; i++){
            al.add(num_list[i]);
        }
        
        int[] answer = new int[al.size()];
        
        for(int i=0; i<al.size(); i++){
            answer[i] = al.get(i);
        }
        
        return answer;
    }
}