import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 백준 2217번
public class Main {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> lope = new ArrayList<>();

        for(int i=0; i<N; i++){
            lope.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(lope); // 오름차순 정렬

        int maxWeight = 0;
        for(int i=lope.size(); i>=1; i--){
            int weight = i * lope.get(0);

            maxWeight = Math.max(maxWeight, weight); // 최대값 비교
            lope.remove(0); // 가장 적은 중량을 버티는 로프 제거
        }

        System.out.println(maxWeight);
    }
}
