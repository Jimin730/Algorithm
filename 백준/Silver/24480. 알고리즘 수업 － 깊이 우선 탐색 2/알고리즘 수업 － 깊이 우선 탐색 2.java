
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

import static java.util.Collections.reverseOrder;

//백준 24480
public class Main {

    public static int N, M, R;
    public static ArrayList<Integer>[] map;
    public static boolean[] visited;
    public static int[] order;
    public static int currentOrder = 1;

    public static void main(String[] arg) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visited = new boolean[N+1];
        order = new int[N+1];
        Arrays.fill(order, 0); // 0으로 채워주기

        //2차원 배열 생성
        map = new ArrayList[N+1];
        for (int i = 0; i < N + 1; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            //map에 추가
            map[u].add(v);
            map[v].add(u);
        }

        for(int i=0; i<map.length; i++){
            Collections.sort(map[i], reverseOrder()); //내침차순 정렬
        }

        order[R] = 1; //시작 지점 순서 초기화
        dfs(R); //dfs 수행

        for(int i=1; i<order.length; i++){ //방문 순서 출력
            System.out.println(order[i]);
        }

    }


    public static void dfs(int start){
        visited[start] = true; //방문처리
        order[start] = currentOrder++; //순서 기록

        for (int i = 0; i < map[start].size(); i++) { //해당 정점에 인접한 정점 방문
            int temp = map[start].get(i);

            if(!visited[temp]){ //아직 방문하지 않은 정점이면
                dfs(temp); //dfs 재귀 수행
            }
        }
    }
}