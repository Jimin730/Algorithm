import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int[] numbers = new int[N];
        for(int i=0; i<N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int result = solve(N, S, numbers);
        System.out.println(result);
    }

    private static int solve(int n, int s, int[] numbers) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;

        while(true) {
            if(sum >= s) {
                minLen = Math.min(minLen, end - start);
                sum -= numbers[start++];
            } else if (end == n) {
                break;
            } else { // 합이 s보다 작으면 구간 확장을 위해 오른쪽 포인터 이동
                sum += numbers[end++];
            }
        }

        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}