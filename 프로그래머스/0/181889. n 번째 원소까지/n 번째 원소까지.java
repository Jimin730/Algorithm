import java.util.*;

class Solution {
    public int[] solution(int[] num_list, int n) {
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i=0; i<n; i++){
            al.add(num_list[i]);
        }
        
        int[] answer = new int[al.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = al.get(i);
        }
        
        return answer;
        
    }
}