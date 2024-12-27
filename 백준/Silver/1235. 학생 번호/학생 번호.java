import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//백준 1235
public class Main {

    public static int N;
    public static int result;
    public static int len;
    public static String[] list;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); //학생 수 입력 받기
        list = new String[N];
        for (int i = 0; i < N; i++) {
            list[i] = br.readLine().trim(); //학생 수 만큼 입력 받기
        }

        len = list[0].length(); //학생 번호 길이 저장

        for(int k=1; k<=len; k++){ //k범위 만큼

            boolean isValid = true; //학생 번호가 모두 다른지 체크하기 위한 boolean

            for (int i = 0; i < N; i++) {
                String str = list[i].substring(len-k,len);
                for(int j = 0; j<N; j++){
                    if(i != j && str.equals(list[j].substring(len-k,len))){ //비교할 대상 중 본인 제외하고, 그 값이 같다면
                        isValid = false;
                        break;
                    }
                }
                if(!isValid)
                    break;
            }


            if(isValid){ //번호가 모두 다르다면
                result = k;
                break;
            }
        }

        //결과 출력
        System.out.println(result);
    }
}