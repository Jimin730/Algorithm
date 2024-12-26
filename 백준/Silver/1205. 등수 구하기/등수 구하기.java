import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

//백준 1205번
public class Main {
    public static int N, newScore, P;
    public static ArrayList<Integer> scoreList;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        newScore = sc.nextInt();
        P = sc.nextInt();
        scoreList = new ArrayList<>();

        if(N>0){
            for(int i=0; i<N; i++){ //N만큼 점수 입력 받기
                scoreList.add(sc.nextInt());
            }
        }

        Collections.sort(scoreList, Collections.reverseOrder()); //내림차순 정렬

        //새로운 점수가 리스트에 더이상 들어갈 수 없다면
        if(N == P && newScore <= scoreList.get(scoreList.size()-1)){
            System.out.println(-1); //-1 출력
            return;
        }

        //리스트에 새로운 점수 추가
        for(int i=0; i<scoreList.size(); i++){
            int num = scoreList.get(i);
            if(num <= newScore){
                scoreList.add(i, newScore);
                break;
            }
        }

        //새로운 점수는 몇등인지 체크
        int rank = 1;
        for(int i=0; i<scoreList.size(); i++){
            if(newScore < scoreList.get(i))
                rank++;
            else
                break;
        }

        //결과 출력
        System.out.println(rank);
        
    }
}