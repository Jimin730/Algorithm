import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 22862
public class Main {

    protected static int N, K;
    protected static int[] S;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        S = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){

            S[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(twoPointer());

    }

    protected static int twoPointer(){

        int left = 0;
        int right = 0;
        int oddCount = 0;  // 홀수 개수
        int maxEvenLength = 0;  // 최대 짝수 연속 부분 수열 길이

        while (right < N) {

            if (S[right] % 2 == 1) { // 홀수일 경우
                oddCount++;
            }

            // 홀수 개수가 K를 초과하는 경우
            if (oddCount > K) {
                // 왼쪽 포인터를 이동하며 홀수를 제거
                while (oddCount > K) {
                    if (S[left] % 2 == 1) {
                        oddCount--;
                    }
                    left++;
                }
            }

            // 현재 부분 수열에서 짝수 개수 계산
            int evenCount = (right - left + 1) - oddCount;
            maxEvenLength = Math.max(maxEvenLength, evenCount);

            right++;
        }

        return maxEvenLength;

    }
}