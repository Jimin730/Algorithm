import java.io.*;
import java.util.*;

class Main {

    private static int N, M;
    private static int[] number;
    private static int[] result;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        number = new int[N];
        result = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(number);

        go(0);

        System.out.println(sb);
    }

    private static void go (int index) {
        if(index == M) {
            for(int i=0; i<M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        int lastUsed = -1;
        for(int i=0; i<N; i++) {
            if(number[i] == lastUsed) continue;

            result[index] = number[i];
            lastUsed = number[i];
            
            go(index+1);
        }
    }
}