import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken()); // 데이터
        m = Integer.parseInt(st.nextToken()); // 연산의 개수

        parent = new int[n+1];

        make();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int func = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(func == 0){
                union(a, b);
            } else{
                if(find(a) != find(b)) sb.append("NO").append("\n");
                else sb.append("YES").append("\n");
            }
        }
        System.out.print(sb);
    }
    static void make(){
        for(int i = 0; i <= n; i++) parent[i] = i;
    }
    static void union(int a, int b){
        a = find(a);
        b = find(b);

        if(a != b) {
            if(a > b) parent[b] = a;
            else parent[a] = b;
        }
    }
    static int find(int x){
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }
}
