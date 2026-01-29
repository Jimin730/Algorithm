import java.io.*;
import java.util.*;

class Main {

    private static int N, M;
    private static int[] array;
    private static int[] number;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array); // 이분 탐색 전 정렬

        M = Integer.parseInt(br.readLine());
        number = new int[M];
        
        StringBuilder result = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            number[i] = Integer.parseInt(st.nextToken());

            int count = upperBound(number[i], N) - lowerBound(number[i], N);

            result.append(count).append(" ");
        }

        System.out.println(result);
    }

    private static int lowerBound(int target, int n) { // 타겟 값과 같거나 큰 값이 처음 나오는 위치 탐색
        int start = 0;
        int end = n;

        while (start < end) {
            int mid = (start + end) / 2;
            if(array[mid] >= target) end = mid; // 타겟 값을 찾아도 더 왼쪽 확인
            else start = mid + 1;
        }

        return start;
    }

    private static int upperBound(int target, int n) { // 타겟 값보다 큰 값이 처음 나오는 위치 탐색
        int start = 0; 
        int end = n;

        while (start < end) {
            int mid = (start + end) / 2;
            if(array[mid] > target) end = mid;
            else start = mid + 1;
        }

        return start;
    }
}