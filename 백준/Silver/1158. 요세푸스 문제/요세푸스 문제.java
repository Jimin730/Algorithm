import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static int N, K;
    public static ArrayList<Integer> al;
    public static ArrayList<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //N,K 입력 받기
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        al = new ArrayList<>();
        result = new ArrayList<>();

        //배열에 N명 채우기
        for(int i=0; i<N; i++){
            al.add(i+1);
        }

        //배열 안에 수가 있는 동안 반목문 실행하며 값을 K 순서대로 뺴준다.
        int index = 0;
        while(!al.isEmpty()){
            index = (index + (K-1)) % al.size(); //K번쨰 순서에 있는 사람 삭제
            result.add(al.remove(index)); //삭제한 순서대로 결과 배열에 저장
        }

        //결과 출력
        System.out.print("<");
        for(int i=0; i<result.size(); i++){
            if(i==result.size()-1){
                System.out.print(result.get(i));
            } else {
                System.out.print(result.get(i));
                System.out.print(", ");
            }
        }
        System.out.print(">");
    }
}