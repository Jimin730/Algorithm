import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//backjoon 1195
public class Main {

    public static String upperGear; //위 기어
    public static String lowerGear; //아래 기어

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        upperGear = br.readLine().trim();
        lowerGear = br.readLine().trim();
        System.out.println(calMinWidth());
        br.close();
    }

    private static int calMinWidth(){
        int minWidth = upperGear.length() + lowerGear.length(); //초기 최소 너비 설정

        for(int offset = -lowerGear.length(); offset <= upperGear.length(); offset++){
            boolean isValid = true; //현재 오프셋(맞물린 것)에 대해 유효성 체크

            for(int i=0; i<upperGear.length(); i++){
                //현재 겹쳐진 인덱스 계산
                int lowerIdx = i - offset;
                if(lowerIdx < 0 || lowerIdx >= lowerGear.length()){
                    continue; //겹치지 않는 경우는 패스
                }

                //기어의 맞물림 상태 검사
                int sum = (lowerGear.charAt(lowerIdx) - '0') + (upperGear.charAt(i) - '0');
                if(sum > 3){ //맞물리지 않은 경우
                    isValid = false;
                    break;
                }
            }

            //유효한 경우 최소 너비 계산
            if(isValid){
                int currentWidth = Math.max(offset + lowerGear.length(), upperGear.length()) - Math.min(offset, 0);
                minWidth = Math.min(minWidth, currentWidth);
            }
        }

        return minWidth; //계산된 최소 너비 반환
    }
}