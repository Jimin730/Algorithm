import java.io.*;
import java.util.*;

class Main {

    private static int N;
    private static int[] U;
    private static ArrayList<Integer> sum = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        U = new int[N];

        for(int i=0; i<N; i++) {
            U[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(U);

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                sum.add(U[i] + U[j]); // x + y
            }
        }
        Collections.sort(sum);

        int target = 0;
        for(int i=N-1; i>=0; i--) {
            for(int j=0; j<N; j++) {
                target = U[i] - U[j]; // k - z
                boolean isTrue = binarySearch(target, 0, sum.size()-1);

                if(isTrue) {
                    System.out.println(U[i]);
                    return;
                }
            }
        }
    }

    private static boolean binarySearch(int target, int start, int end) {
        while(start <= end) {
            int mid = (start + end) / 2;

            if(sum.get(mid) == target) return true;
            else if(sum.get(mid) > target) end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }
}