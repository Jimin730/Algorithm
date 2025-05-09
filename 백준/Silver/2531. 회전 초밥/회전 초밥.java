import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2531반
public class Main {

    static int N,d,k,c;
    static int[] sushiTable;
    static int[] sushi;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushiTable = new int[N];
        for (int i = 0; i < N; i++) {
            sushiTable[i] = Integer.parseInt(br.readLine());
        }
        sushi = new int[d+1];

        System.out.println(check());

    }

    public static int check() {
        int cnt = 0; // 먹은 초밥 종류 개수
        int max; // 최대로 먹을 수 있는 초밥의 수

        for (int i = 0; i < k; i++) {
            int a = sushiTable[i];

            if(sushi[a] == 0){ // 한 번도 먹지 않은 초밥일 경우 카운팅
                cnt++;
            }
            sushi[a]++;
        }

        // 쿠폰으로 받은 초밥 종류가 한 번도 먹지 않은 종류라면 +1
        max = (sushi[c] == 0) ? cnt + 1 : cnt;

        // 슬라이딩 윈도우
        for (int i = 0; i < N; i++) {

            // 맨 앞 초밥 제거
            sushi[sushiTable[i]]--;
            if (sushi[sushiTable[i]] == 0) {
                cnt--; // 해당 종류의 초밥을 더 이상 먹지 않는 경우
            }

            // 새로운 초밥 추가
            int newSushi = sushiTable[(i + k) % N];
            if (sushi[newSushi] == 0) {
                cnt++; // 새로 추가되는 초밥이 처음 먹는 종류인 경우
            }
            sushi[newSushi]++; // 먹은거 기록

            // 쿠폰 초밥을 고려한 최댓값 업데이트
            int currentMax = (sushi[c] == 0) ? cnt + 1 : cnt;
            max = Math.max(max, currentMax);

        }

        return max;
    }
}