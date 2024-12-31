import java.io.*;
import java.util.StringTokenizer;

//백준 1244
public class Main {

    public static int switchCount;
    public static int studentCount;
    public static int[] switchStatus;
    public static int sex, num;

    public static void main(String[] arg) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        switchCount = Integer.parseInt(br.readLine()); //스위치 개수 입력
        switchStatus = new int[switchCount];

        StringTokenizer st = new StringTokenizer(br.readLine()); //스위치 상태 입력
        for (int i = 0; i < switchStatus.length; i++) {
            switchStatus[i] = Integer.parseInt(st.nextToken());
        }

        studentCount = Integer.parseInt(br.readLine()); //학생수 입력

        for (int i = 0; i < studentCount; i++) {
            st = new StringTokenizer(br.readLine());

            sex = Integer.parseInt(st.nextToken()); //성별 입력
            num = Integer.parseInt(st.nextToken()); //스위치 번호 입력

            if(sex == 1){ //남자일 경우
                for (int idx = 0; idx < switchStatus.length; idx++) {
                    if((idx+1)%num == 0) { //스위치 인덱스가 배수이면
                        changeSwitch(idx);
                    }
                }
            } else { //여자일 경우

                int center = num-1; //기준이 되는 인덱스 값
                int count = 0;

                //최대로 대칭이 되는 범위 체크
                while (center - count >= 0 && center + count < switchStatus.length) { //최대로 체크할 수 있는 범위까지만
                    if (switchStatus[center - count] == switchStatus[center + count]) {
                        count++;
                    } else {
                        break;
                    }
                }

                //최대 대칭 범위까지 스위치 상태 변경
                for (int k = 0; k < count; k++) {
                    if(center-k == center+k)
                        changeSwitch(center-k); //기준이 되는 부분은 한번만 수행
                    else {
                        changeSwitch(center - k);
                        if (center + k < switchStatus.length) {
                            changeSwitch(center + k);
                        }
                    }
                }
            }
        }

        //결과 출력
        for (int i = 0; i < switchStatus.length; i++) {
            System.out.print(switchStatus[i] + " ");
            if((i+1)%20 == 0) //한줄에 20개씩만 출력
                System.out.print("\n");
        }
    }

    //스위치 on/off 변경 메서드
    public static void changeSwitch(int idx){
        if(switchStatus[idx] == 0)
            switchStatus[idx] = 1;
        else
            switchStatus[idx] = 0;
    }

}