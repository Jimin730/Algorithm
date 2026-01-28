import java.io.*;
import java.util.*;

class Main {

    private static int N, M;
    private static int[] array; // 나열된 정수
    private static int[] numX; // 찾으려는 수
    private static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(array); // 이진 탐색 전 정렬

        M = Integer.parseInt(br.readLine());
        numX = new int[M];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++) {
            numX[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<M; i++) {
            result[i] = binery_search(numX[i], 0, N-1);
            System.out.println(result[i]);
        }
    }

    private static int binery_search(int target, int start, int end) {
        while(start <= end) {
            int mid = (start + end) / 2;

            if(array[mid] == target) return 1;
            else if(array[mid] > target) end = mid - 1; // 원하는 값이 중간 값보다 작을 경우
            else start = mid + 1; // 원하는 값이 중간 값보다 클 경우
        }
        return 0;
    }
}