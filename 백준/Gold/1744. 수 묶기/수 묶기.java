import java.io.*;
import java.util.*;

class Main {

    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        // 기본: 낮은 숫자가 먼저나옴. reverseOrder() 해주면 큰 숫자가 먼저 나옴
        PriorityQueue<Integer> posPQ = new PriorityQueue<>(Collections.reverseOrder()); // 양수
        PriorityQueue<Integer> negPQ = new PriorityQueue<>();

        int oneCnt = 0;
        int zeroCnt = 0;
        
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > 1) posPQ.add(num);
            else if(num == 1) oneCnt++;
            else if(num == 0) zeroCnt++;
            else negPQ.add(num);
        }

        int totalSum = 0;

        // 양수 처리
        while (posPQ.size() > 1) { // 큐에 1개만 남을 때까지 수행
            totalSum += posPQ.poll() * posPQ.poll();
        }
        if(!posPQ.isEmpty()) {
            totalSum += posPQ.poll();
        }

        // 음수 처리
        while (negPQ.size() > 1) {
            totalSum += negPQ.poll() * negPQ.poll();
        }
        if(!negPQ.isEmpty()) {
            if(zeroCnt == 0) { // 0이 없으면 남은 음수 값 그냥 더해주기
                totalSum += negPQ.poll();
            }
            // 0이 한 개 이상 있다면 곱한걸로 치고 음수 없애기
        }

        // 1은 그냥 더해주기
        totalSum += oneCnt;

        System.out.println(totalSum);
    }

    
}