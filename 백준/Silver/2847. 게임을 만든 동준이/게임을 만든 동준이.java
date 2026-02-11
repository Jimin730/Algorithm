import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] point = new int[N+1];
        for(int i=0; i<N; i++) {
            point[i+1] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        for(int i=N; i>0; i--) { // 큰 레벨부터 확인
            if(point[i]<=point[i-1]) { // 현제 레벨보다 낮은 레벨의 점수가 더 높거나 같을 경우
                while(point[i-1] >= point[i]) {
                    point[i-1] -= 1;
                    result++; 
                }
            }
        }

        System.out.println(result);
    }
}