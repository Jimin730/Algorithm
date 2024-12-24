import java.util.Scanner;

public class Main {

    public static int x;
    public static int parent;
    public static int child;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //x 입력 받기
        x = sc.nextInt();

        int crossCount = 1; //현재 대각선에 있는 칸의 개수. 0칸인 대각선은 없으니 1부터 시작
        int prevCrossCount = 0; //이전 대각선의 있는 칸의 개수. 1/1 전에 칸은 없으므로 0부터 시작

        while (true) {
            // 전 대각선 칸 개수 + 현재 대각선 칸 개수로 x의 범위 판별
            if(x <= prevCrossCount + crossCount){ 

                if(crossCount % 2 == 1){ //대각선 칸의 개수가 홀수면 (T가 짝수면)
                    //분자가 큰 수부터 시작
                    //분자는 현재 대각선 내 칸 개수 - (x - 전 대각선 칸 개수 - 1)
                    //분모는 x - 전 대각선 칸 개수
                    child = crossCount - (x - prevCrossCount - 1);
                    parent = x - prevCrossCount;
                    break;
                } else { //대각선 칸의 개수가 짝수면 (T가 홀수면)
                    //홀수의 경우에서 분모 분자가 반대로 바뀜
                    child = x - prevCrossCount;
                    parent = crossCount - (x - prevCrossCount - 1);
                    break;
                }
            } else {
                prevCrossCount += crossCount;
                crossCount++;
            }
        }

        //결과 출력
        System.out.println(child + "/" + parent);
    }
}
