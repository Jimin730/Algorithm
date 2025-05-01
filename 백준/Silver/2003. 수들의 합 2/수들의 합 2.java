import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 백준 2003번
public class Main {

    static int[] arr;
    static int n, m;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {

            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(twoPointer());

    }

    public static int twoPointer() {

        int start = 0;
        int end = 0;
        int sum = 0;
        int count = 0;

        while (true) {

            // start~end 까지의 부분 배열의 합이 M보다 크거나 같으면 start + 1
            if(sum >= m ) {
                sum -= arr[start++];
            }
            else if(end == n) break; // 종료 조건. end 가 범위를 넘어갔을 경우
            else if(sum < m) {
                sum += arr[end++];
            }

            if(sum == m) { // m 이 되는 경우의 수 세어주기
                count++;
            }
        }

        return count;
    }
}