import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Stack<Integer> numbers = new Stack<>();
        int sum = 0;
        for(int i=0; i<K; i++) {
            int num = Integer.parseInt(br.readLine());
            
            if(num == 0) {
                sum -= numbers.pop();
            }
            else {
                numbers.push(num);
                sum += num;
            }
        }

        System.out.println(sum);
    }
}