
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int answer = 0;
        
        HashSet<Integer> set = new HashSet<>();
        
        for (int n : nums) {
            set.add(n);
        }
        
        int length = nums.length / 2;
        
        //선택할 수 있는 포켓몬 종류가 많아서, 최대 선택 수 만큼만 선택하더라도 모든 종류를 고를 수 있음
        if (set.size() >= length) {
            answer = length;
        } else { // 선택할 수 있는 포켓몬 종류가 적어서 모든 종류를 선택할 수밖에 없으면
            answer = set.size();    
        }
        
        return answer;
    }
}
