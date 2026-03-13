import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static int[] road;
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 인덱스 범위를 벗어나지 않도록 N+2 크기로 할당
        road = new int[N + 2];

        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N; i++) {
            road[i] = Integer.parseInt(st.nextToken());
            if(road[i] == 1 && road[i - 1] == 0) {
                count++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int status = Integer.parseInt(st.nextToken());

            if(status == 0) {
                sb.append(count).append("\n");
            } else if (status == 1) {
                int idx = Integer.parseInt(st.nextToken());
                
                if (road[idx] == 0) {
                    road[idx] = 1;

                    if (road[idx - 1] == 1 && road[idx + 1] == 1) { // 1 1 1로 뭉치가 하나가 됨
                        count--;
                    } else if (road[idx - 1] == 0 && road[idx + 1] == 0) { // 0 1 0 새로운 뭉치가 됨
                        count++;
                    }
                }
            }
        }
        System.out.print(sb);
    }
}