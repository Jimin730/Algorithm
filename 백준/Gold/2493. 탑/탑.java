import java.io.*;
import java.util.*;

class Main {

    static int N;
    static Stack<int[]> s = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            int currentHeight = Integer.parseInt(st.nextToken());

            while(!s.isEmpty()){
                if(s.peek()[1] >= currentHeight) {
                    sb.append(s.peek()[0]).append(" ");
                    break;
                }
                s.pop();
            }

            if(s.isEmpty()){
                sb.append("0 ");
            }

            s.push(new int[]{i, currentHeight});
        }

        System.out.println(sb);
    }
}