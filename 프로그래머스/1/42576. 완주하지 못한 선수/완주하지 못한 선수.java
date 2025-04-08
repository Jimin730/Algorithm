import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String name : participant){
            map.put(name, map.getOrDefault(name, 0) + 1); // 이미 동일한 이름을 가진 사람이 있으면 +1
        }
        
        for(String name : completion){
            map.put(name, map.get(name) - 1); //완주한 사람의 수를 대조해 -1
        }
        
        for(String name : map.keySet()){ //전체 키 값을 가져와 순회
            if(map.get(name) > 0){
                return name;
            }
        }
        
        return "";
    }
}