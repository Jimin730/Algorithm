import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 2230
public class Main {

    protected static int N,M;
    protected static int[] arr;
    protected final static int MAX_NUM = 2_000_000_000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];

        for(int i=0; i<N; i++){

            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr); // 오름차순 정렬

        System.out.println(twoPointer());
    }

    protected static int twoPointer(){

        int left = 0;
        int right = 0;
        int diff;
        int result = MAX_NUM; // 두 수의 차이 중 최솟값

        while(right < N) {

            diff = Math.abs(arr[right] - arr[left]);

            if(diff < M) {
                right++;
            } else if (diff == M) {
                result = Math.min(result, diff);
                right++;
            } else {
                result = Math.min(result, diff);
                left++;
            }
        }

        return result;
    }
}