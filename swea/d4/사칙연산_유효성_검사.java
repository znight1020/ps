package swea.d4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
    char data;
    Node lt, rt;

    Node(char data){
        this.data = data;
        this.lt = null;
        this.rt = null;

    }
}
public class 사칙연산_유효성_검사 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int t = 1; t <= 10; t++){
            int N = Integer.parseInt(br.readLine());
            boolean flag = true;
            Node[] tree = new Node[N+1];
            for(int i = 1; i <= N; i++){
                st = new StringTokenizer(br.readLine());
                int index = Integer.parseInt(st.nextToken());
                char data = st.nextToken().charAt(0);
                tree[index] = new Node(data);
            }
            for(int i = 2; i <= N; i++){
                if(i + 1 > N) break;
                if(Character.isDigit(tree[i].data) && Character.isDigit(tree[i+1].data) && Character.isDigit(tree[i/2].data) ) flag = false;

                i++;
            }
            System.out.print("#" + t + " ");
            if(flag) System.out.println(1);
            else System.out.println(0);
        }
    }
}
