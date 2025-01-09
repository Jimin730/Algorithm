import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//백준 2644
public class Main {

    public static int n, m;
    public static int a, b;
    public static boolean[] visited;
    public static int[] count;
    public static ArrayList<Integer>[] map;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        visited = new boolean[n+1];
        count = new int[n+1];

        //2차원 배열 생성
        map = new ArrayList[n+1];
        for(int i=0; i<n+1; i++){
            map[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());

        //연결되어 있는대로 그래프 만들어주기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x].add(y);
            map[y].add(x);
        }

        //bfs 실행
        bfs(a);

        if(count[b] != 0){
            System.out.println(count[b]);
        } else {
            System.out.println("-1");
        }


    }

    public static void bfs(int start){

        Queue<Integer> q = new LinkedList<>();

        q.add(start);
        visited[start] = true; //방문 처리
        count[start] = 0;

        while(!q.isEmpty()){
            int now = q.poll();

            for(int i=0; i<map[now].size(); i++){ //현재 노드에 연결되어 있는 모든 노드 찾음
                int temp = map[now].get(i);

                if(!visited[temp]){ //아직 방문하지 않은 곳만
                    q.add(temp);
                    visited[temp] = true;
                    count[temp] = count[now] + 1; //촌수계산을 위해 그 전에 카운트된 값에 +1
                }
            }
        }
    }
}