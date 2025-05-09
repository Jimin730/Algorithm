import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 백준 20922번
public class Main {

    public static int N, K;
    public static final int MAX_NUM = 100_000;
    public static int[] arr;
    public static int[] cntNum = new int[MAX_NUM+1];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){

            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(twoPointer());
    }

    public static int twoPointer(){

        int maxLen = 0;
        int start = 0;
        int end = 0;

        while (end < N) {

            // 현재 end 위치의 숫자가 K개 이하인 경우
            if (cntNum[arr[end]] < K) {
                cntNum[arr[end]]++;  // 해당 숫자 카운트 증가
                end++;               // 끝 포인터 이동
            }
            // 현재 end 위치의 숫자가 이미 K개 있는 경우
            else {
                cntNum[arr[start]]--; // 시작 포인터 위치의 숫자 카운트 감소
                start++;              // 시작 포인터 이동
            }

            // 현재 부분 수열의 길이를 계산하여 최대 길이 갱신
            maxLen = Math.max(maxLen, end - start);

        }

        return maxLen;
    }
}