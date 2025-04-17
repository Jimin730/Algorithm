import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//백준 11399
public class Main {

    final static int MAX_NUM = 1000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] time = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){

            time[i] = Integer.parseInt(st.nextToken());
        }

        int sum = 0;
        int result = 0;
        for (int i = 0; i < N; i++) {

            int min = MAX_NUM;
            int idx = 0;
            for(int j=0; j<time.length; j++){

                if(min > time[j]) { //최솟값 찾기
                    min = time[j];
                    idx = j; //인덱스 기록
                }
            }
            time[idx] = MAX_NUM; //더 이상 최솟값을 찾지 못하도록 초기화

            result += (min + sum);
            sum += min; // 누적된 시간 기록

        }

        System.out.println(result);

    }
}