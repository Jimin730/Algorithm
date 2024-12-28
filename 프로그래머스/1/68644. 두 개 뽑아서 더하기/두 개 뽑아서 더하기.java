import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> al = new ArrayList<>();
        
        //numbers에 있는 모든 값을 하나씩 더해주고 결과 배열에 삽입
        for(int i=0; i<numbers.length; i++){
            int num = numbers[i];
            
            for(int j=0; j<numbers.length; j++){
                int sum = 0;
                if(i!=j){ //본인 인덱스를 제외한 수를 더해줌
                    sum = num + numbers[j];
                    if(!al.contains(sum)) //결과 배열에 이미 같은 수가 있으면 pass
                        al.add(sum); //없으면 추가
                }
            }
        }
        
        Collections.sort(al); //오름차순 정렬
        
        //arrayList를 array로 변환
        int[] result = new int[al.size()];
        
        for(int i=0; i<al.size(); i++){
            result[i] = al.get(i);
        }
        
        return result;
    }
}