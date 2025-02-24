import java.util.*;

class Solution {
    public int[] solution(int n, int k) {
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i=k; i<=n; i=i+k){
            al.add(i);
        }
        
        int[] answer = new int[al.size()];
        for(int i=0; i<answer.length; i++){
            answer[i] = al.get(i);
        }
        
        return answer;
        
    }
}