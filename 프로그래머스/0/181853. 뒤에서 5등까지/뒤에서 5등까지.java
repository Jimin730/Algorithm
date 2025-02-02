import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        ArrayList<Integer> al = new ArrayList<>();
        for(int i=0; i<num_list.length; i++){
            al.add(num_list[i]);
        }
        
        Collections.sort(al);
        
        int[] result = new int[5];
        
        for(int i=0; i<result.length; i++){
            result[i] = al.get(i);
        }
        
        return result;
    }
}