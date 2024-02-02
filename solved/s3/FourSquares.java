package solved.s3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class FourSquares {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE, cnt;

        for(int i = 0; i < 223; i++){
            for(int j = 0; j < 223; j++){
                for(int k = 0; k < 223; k++){
                    if(i*i + j*j + k*k == n){
                        cnt = 0;
                        if(i > 0) cnt++;
                        if(j > 0) cnt++;
                        if(k > 0) cnt++;

                        min = Math.min(cnt, min);
                    }
                }
            }
        }

        System.out.println(Math.min(4, min));
    }
}

//public class FourSquares {
//    static int min = Integer.MAX_VALUE;
//
//    static void recur(int root, int n, int L){
//        int square = root * root;
//        if(L == 5 || root < 1) return;
//        if(n == square) min = Math.min(L, min);
//        else{
//            recur(root - 1, n - square, L+1); // 최대 root 빼기
//            recur(root - 1, n, L); // 최대 root 보다 작은게 더 효율적일 수도?
//        }
//    }
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        int root = (int) Math.sqrt(n);
//
//        if(n % (root * root) == 0){
//            System.out.println(n / (root * root));
//        }
//        else {
//            recur(root, n,1);
//            System.out.print(min);
//        }
//    }
//}


