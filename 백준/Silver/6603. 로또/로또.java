import java.io.*;
import java.util.*;

class Main {

    private static int k;
    private static int[] S;
    private static int cnt = 6;
    private static boolean[] isUsed;
    private static int[] result;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            if(num == 0) {
                System.out.println(sb);
                return;
            }

            k = num;
            S = new int[k];
            isUsed = new boolean[k];
            result = new int[cnt];

            for(int i=0; i<k; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }

            backTracking(0, -1);
            sb.append("\n");
        }
    }

    private static void backTracking(int index, int pos) {
        if(index == cnt) {
            for(int i=0; i<cnt; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=0; i<k; i++) {
            if(isUsed[i] || S[i] < pos) continue;

            isUsed[i] = true;
            result[index] = S[i];
            pos = S[i];

            backTracking(index+1, pos);

            isUsed[i] = false;
        }
    }
}