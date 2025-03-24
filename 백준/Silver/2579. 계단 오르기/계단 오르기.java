import java.io.BufferedReader;
import java.io.InputStreamReader;

//백준
public class Main {

    static final int MAX_NUM = 301;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] stair = new int[MAX_NUM];
        int[] score = new int[MAX_NUM];

        for(int i=1; i<=N; i++){
            stair[i] = Integer.parseInt(br.readLine());
        }

        score[1] = stair[1];
        score[2] = stair[1] + stair[2];
        score[3] = Math.max(stair[1], stair[2]) + stair[3];

        for(int i=4; i<=N; i++){
            score[i] = Math.max(score[i-3] + stair[i-1], score[i-2]) + stair[i];
        }

        System.out.println(score[N]);
    }
}