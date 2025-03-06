import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] room;
    static int[] dx = {0, 1, 0, -1}; // 북, 동, 남, 서
    static int[] dy = {-1, 0, 1, 0}; // 북, 동, 남, 서
    static int count = 0; // 청소한 칸의 개수

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // y
        M = Integer.parseInt(st.nextToken()); // x
        room = new int[N][M];

        st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken()); // 시작 y
        int c = Integer.parseInt(st.nextToken()); // 시작 x
        int d = Integer.parseInt(st.nextToken()); // 시작 방향

        // 방 상태 저장
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 로봇 청소기 작동 시작
        dfs(r, c, d);

        // 결과 출력
        System.out.println(count);
    }

    public static void dfs(int y, int x, int d) {
        // 현재 위치 청소
        if (room[y][x] == 0) {
            room[y][x] = -1; // 청소한 칸을 -1로 표시
            count++; // 청소한 칸 개수 증가
        }

        boolean canMove = false; // 청소할 수 있는 빈 칸이 있는지 확인

        // 모든 방향을 확인
        for (int k = 0; k < 4; k++) {
            // 현재 방향을 반시계로 회전
            d = (d + 3) % 4; // 방향 회전
            int ny = y + dy[d];
            int nx = x + dx[d];

            // 청소되지 않은 빈 칸이 있는 경우
            if (checkMove(ny, nx) && room[ny][nx] == 0) {
                dfs(ny, nx, d); // 이동
                canMove = true; // 이동 가능
                break; // 이동 후 현재 dfs 호출 종료
            }
        }

        // 모든 방향을 확인한 후 청소할 수 있는 칸이 없으면 후진
        if (!canMove) {
            int backDir = (d + 2) % 4; // 후진 방향
            int backX = x + dx[backDir];
            int backY = y + dy[backDir];

            // 후진할 수 있는 경우
            if (checkMove(backY, backX) && room[backY][backX] != 1) {
                dfs(backY, backX, d); // 후진
            }
        }
    }

    public static boolean checkMove(int y, int x) {
        return x >= 0 && y >= 0 && x < M && y < N; // 이동 가능 여부 확인
    }
}