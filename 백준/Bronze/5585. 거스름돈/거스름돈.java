
import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준 5585
public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int money = 1000 - N;
        int countChange = 0; //잔돈 개수

        int[] change = {500, 100, 50, 10, 5, 1}; //거슬러줄 잔돈

        for(int i=0 ;i<change.length; i++){
            if(money >= change[i]){

                countChange += money/change[i];
                money %= change[i];
            }

        }

        System.out.println(countChange);

    }
}