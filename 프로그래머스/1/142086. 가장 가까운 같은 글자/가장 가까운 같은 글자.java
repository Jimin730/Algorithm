
class Solution {
    public int[] solution(String s){
        
        int len = s.length(); //문자열 길이 저장
        int[] result = new int[len]; //문자열 길이만큼 결과 배열 생성
        
        for(int i=0; i<len; i++){
            char c = s.charAt(i);
            boolean isValid = true;
            
            for(int j=i-1; j>=0; j--){
                if(c == s.charAt(j)){//앞에 같은 문자가 있으면
                    result[i] = i-j; //가장 가까운 인덱스 값 계산해서 넣어주기
                    isValid = false;
                    break;
                }
            }
            
            if(isValid) //앞에 같은 문자가 하나도 없으면 처음 나왔다는 의미니까 -1
                result[i] = -1; 
        }
        
        return result;
    }
}