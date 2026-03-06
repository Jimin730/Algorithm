import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> s = new Stack<>();

        int N = Integer.parseInt(br.readLine());
        int nextNum = 1;

        for(int i=0; i<N; i++) {
            int target = Integer.parseInt(br.readLine());

            while(nextNum <= target) {
                s.push(nextNum++);
                sb.append("+\n");
            }

            if(!s.isEmpty() && s.peek() == target) {
                s.pop();
                sb.append("-\n");
            }
            else {
                System.out.println("NO");
                return;
            }
        }
       
        System.out.println(sb);
    }
}