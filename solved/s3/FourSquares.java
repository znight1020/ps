package solved.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FourSquares {
    static int min = Integer.MAX_VALUE;

    static void BFS(int root, int n, int L){
        int square = root * root;
        if(L == 5 || root < 1) return;
        if(n == square) min = Math.min(L, min);

        else{
            if(root == 1) BFS(root, n - square, L+1); // root가 0인 경우 답 도출 X -> 1까지 내려왔다면 1 고정
            else {
                BFS(root - 1, n - square, L+1); // 최대 root 빼기
                BFS(root - 1, n, L); // 최대 root 보다 작은게 더 효율적일 수도?
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int root = (int) Math.sqrt(n);
        BFS(root, n,1);
        System.out.print(min);
    }
}
