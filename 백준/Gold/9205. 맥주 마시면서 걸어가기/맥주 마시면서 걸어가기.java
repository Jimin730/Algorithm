import java.io.*;
import java.util.*;

class Point{
    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

//백준 9205
public class Main {

    static int T, n;
    static boolean[] visited; //인덱스 순서대로 집, 편의점, 락페스티벌
    static Point[] points; //집, 편의점, 락페스티벌
    static StringBuilder result = new StringBuilder();


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            n = Integer.parseInt(br.readLine());
            points = new Point[n+2];
            visited = new boolean[n+2];

            for(int i=0; i<n+2; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                Point p = new Point(x,y);

                points[i] = p; //위치 정보 저장
            }

            //탐색 시작
            bfs();
        }

        //결과 출력
        System.out.println(result.toString());
    }

    public static void bfs(){
        Queue<Point> q = new LinkedList<>();
        q.offer(points[0]); //집 위치 추가
        visited[0] = true; //방문 처리

        while (!q.isEmpty()){
            Point now = q.poll(); //현재 위치 꺼내기

            int distance = calDist(now, points[points.length-1]);

            //현재 위치에서 목표 지점까지 1000미터 이내라면
            if(distance <= 1000){
                result.append("happy").append("\n");
                return;
            } else {
                for(int i=0; i<n; i++){
                    if(!visited[i+1]){ //아직 방문하지 않은 편의점만
                        distance = calDist(now, points[i+1]);

                        if(distance <= 1000){ //현재 위치에서 편의점이 1000이내라면
                            q.offer(points[i+1]);
                            visited[i+1] = true; //방문처리
                        }
                    }
                }
            }
        }

        //큐를 다 돌아도 갈 수 없을 경우
        result.append("sad").append("\n");
    }


    //거리계산 메소드
    public static int calDist(Point p1, Point p2){
        return Math.abs(p1.getX() - p2.getX()) + Math.abs(p1.getY() - p2.getY());
    }


}