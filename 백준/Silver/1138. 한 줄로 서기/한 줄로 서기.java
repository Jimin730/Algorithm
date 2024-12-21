import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final int BLANK = -1;
    public static int N;
    public static int[] line;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        line = new int[N];
        Arrays.fill(line, BLANK); //배열에 모든 위치를 -1로 초기화

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int tall = 1; tall <= N; tall++) {
            int leftCount = Integer.parseInt(st.nextToken());

            //leftCount는 큰 수가 와야하는 공간의 개수를 의미
            //만약 Count가 leftCount와 같아진다면, 해당 자리에 tall 삽입
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (line[i] == BLANK) { //배열의 인덱스 위치가 비어있다면
                    if (count == leftCount) {
                        line[i] = tall;
                        break; //위치가 정해지면 다음으로 큰 키를 가진 사람의 위치를 찾음
                    }
                    count++;
                }
            }
        }

        //결과 출력
        for (int l : line) {
            System.out.print(l + " ");
        }

    }
}