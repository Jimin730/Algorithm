import java.util.*;

//백준 1260
public class Main {

    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //정점의 수(N), 간선의 수(M), 시작 정점(V) 입력 받기
        int N = sc.nextInt();
        int M = sc.nextInt();
        int V = sc.nextInt();

        //사용할 배열 생성
        visited = new boolean[N+1];
        //ArrayList로 2차원 배열 구현
        graph = new ArrayList[N+1];
        for(int i=0; i<N+1; i++){
            graph[i] = new ArrayList<Integer>();
        }

				//연결된 간선을 graph에 추가
        for (int i = 0; i < M; i++) {
            int idx1 = sc.nextInt();
            int idx2 = sc.nextInt();

            graph[idx1].add(idx2);
            graph[idx2].add(idx1);
        }

        //오름차순 방문을 위해 정렬
        for (int i = 1; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }

        sb = new StringBuilder();

        dfs(V);
        sb.append("\n");
        //dfs에 사용한 배열 초기화
        visited = new boolean[N+1];

        bfs(V, graph, visited);
				
				//최종 결과 출력
        System.out.println(sb);

    }

    static void dfs(int nodeIdx) {
        //방문 노드 처리
        visited[nodeIdx] = true;

        sb.append(nodeIdx).append(" ");

        for (int node : graph[nodeIdx]) {
			      //방문 노드가 아닐때만 재귀 호출
            if (!visited[node]) {
                dfs(node);
            }
        }
    }

    static void bfs(int start, ArrayList<Integer>[] graph, boolean[] visited) {
        //bfs를 위한 큐 생성
        Queue<Integer> q = new LinkedList<Integer>();

				//시작 정점 큐에 추가
        q.offer(start);
				
				//방문 처리
        visited[start] = true;
				
				//큐가 빌 때까지 실행
        while (!q.isEmpty()) {
            int nodeIdx = q.poll();
            sb.append(nodeIdx).append(" ");
            for (int i = 0; i < graph[nodeIdx].size(); i++) {
                int temp = graph[nodeIdx].get(i);
								
								//방문한 노드가 아닐 경우만 실행
                if (!visited[temp]) {
		                //방문 처리
                    visited[temp] = true;
                    
                    //큐에 추가
                    q.offer(temp);
                }
            }
        }


    }
}