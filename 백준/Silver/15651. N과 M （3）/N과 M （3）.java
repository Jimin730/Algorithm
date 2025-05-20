import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 15651번
public class Main {

    static int N, M;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = new int[N+1];

        go(0);

        System.out.println(sb);
    }

    static void go(int idx) {
        if(idx == M) { // idx 가 마지막 위치에 도달하면 수열 출력
            for(int i=0; i<M; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++) { // 1부터 N까지 자연수 선택

            ans[idx] = i; // 해당 위치에 i 넣음
            go(idx + 1); // 위치 + 1 후 재귀

        }
    }
}