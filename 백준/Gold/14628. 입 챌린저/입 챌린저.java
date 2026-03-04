import java.io.*;
import java.util.*;

class Main {

    private static int N, M, K;
    private static int[] damage, baseCost;
    private static long[][] memo;
    private static long INF = 987654321987654321L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        baseCost = new int[N];
        damage = new int[N];
        memo = new long[N][M+1]; // 적의 체력과 인덱스 일치시키기

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            baseCost[i] = Integer.parseInt(st.nextToken());
            damage[i] = Integer.parseInt(st.nextToken());
            Arrays.fill(memo[i], -1); // 메모이제이션 테이블 초기화
        }

        System.out.println(solve(0, M));
    }

    private static long solve(int idx, int enermyHp) {
        // 적의 체력을 0으로 만들었을 때
        if(enermyHp == 0) return 0;

        // 모든 스킬을 고려했거나 체력이 음수가 됐을 때
        if(idx == N || enermyHp < 0) return INF;

        // 이미 계산한 적이 있으면 해당 값 반환
        if(memo[idx][enermyHp] != -1) return memo[idx][enermyHp];

        // 현재 idx번째 스킬을 r번 사용하는 모든 경우의 수 탐색
        // r * damage[idx]가 남은 체력 enermyHp를 넘지 않을 때까지
        long minCost = INF;
        for(int r = 0; r * damage[idx] <= enermyHp; r++) {
            long currentSkillCost = (long) r * baseCost[idx] + (long) r * (r-1) / 2 * K;

            long next = solve(idx + 1, enermyHp - (r * damage[idx]));

            if(next != INF) {
                minCost = Math.min(minCost, currentSkillCost + next);
            }
        }

        return memo[idx][enermyHp] = minCost;
    }
}