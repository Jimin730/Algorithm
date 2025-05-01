import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2559번
public class Main {

    static int n,k;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(slidingWindow());
    }

    public static int slidingWindow() {

        int max = 0;
        int sum = 0;

        for (int i = 0; i < n; i++) {

            sum += arr[i];

            if(i == k - 1) { // 최초에 나온 합을 최댓값으로 잡아 놓는다
                max = sum;
            }

            if(i >= k) { // 한 칸씩 밀어주면서 최댓값 비교
                sum -= arr[i-k];
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}