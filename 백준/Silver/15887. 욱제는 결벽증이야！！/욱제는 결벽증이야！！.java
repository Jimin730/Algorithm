import java.io.*;
import java.util.*;

class Main {

    private static int N, op;
    private static int[] arr;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int idx=0; idx<N; idx++) {
            if(idx+1 != arr[idx]) { // 현재 가리키고 있는 값이 인덱스+1 값과 다르면
                int targetIdx = searchNumber(idx+1);
                sb.append(idx+1).append(" ").append(targetIdx+1).append("\n");
                reverseSort(idx, targetIdx);
                op++;
            }
        }

        System.out.println(op);
        System.out.println(sb);
    }

    private static int searchNumber(int target) {
        for(int idx=0; idx<N; idx++) {
            if(arr[idx] == target) return idx;
        }
        return -1;
    }
    
    private static void reverseSort(int start, int end) {
        while (start < end) { // 양 끝 값부터 정렬 수행
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // 포인터를 안쪽으로 이동
            start++;
            end--;
        }
    }
}