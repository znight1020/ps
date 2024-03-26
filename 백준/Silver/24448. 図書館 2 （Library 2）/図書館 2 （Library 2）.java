import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        Stack<String> stack = new Stack<>();
        while(N != 0){
            String str = br.readLine();

            if(str.equals("READ")) sb.append(stack.pop()).append("\n");
            else stack.push(str);
            N--;
        }

        System.out.print(sb);
    }
}
