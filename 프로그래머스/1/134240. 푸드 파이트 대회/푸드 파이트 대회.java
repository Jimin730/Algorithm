class Solution {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<food.length; i++){
            if(i==0) continue;
            else { //개수의 반만 sb에 저장
                sb.append(Integer.toString(i).repeat(food[i]/2));
            }
        }
        
        
        String result = sb.toString();
        result += "0"; //중간에 물 추가
        result += sb.reverse().toString(); //sb를 뒤집어서 문자열에 추가
        
        return result;
    }
}