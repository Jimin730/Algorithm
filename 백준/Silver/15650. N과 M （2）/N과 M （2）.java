import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 15650번
public class Main {

    static int N, M;
    static boolean[] check;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        check = new boolean[N+1];
        ans = new int[N+1];

        go(0,1); // 이전 수의 초기값 1로 전달

        System.out.println(sb);
    }

    static void go(int idx, int pos) {
        if(idx == M) { // idx 가 마지막 위치에 도달하면 수열 출력
            for(int i=0; i<M; i++) {
                sb.append(ans[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++) { // 1부터 N까지 자연수 선택

            if(check[i]) continue; // 이미 선택한 적이 있으므로 패스
            if(i<pos) continue; // 현재 수가 이전 수보다 작으면 오름차순 조건에 맞지 않음

            check[i] = true; // 수 i 를 사용
            ans[idx] = i; // 해당 위치에 i 넣음
            pos = i; // 이전 수를 확인하기 위한 기록

            go(idx + 1, pos); // 위치 + 1 후 재귀

            check[i] = false; // idx 이후에 일어날 모든 경우를 수행했기 때문에 수 i를 사용하지 않았다고 바꿈

        }
    }
}