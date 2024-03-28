import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static final int INF = 987654321;
    static int N;
    static ArrayList<Point> vertexList = new ArrayList<>();
    static Point home, festival;
    static int[][] map;


    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            vertexList = new ArrayList<>();
            N = Integer.parseInt(br.readLine());
            map = new int[N+2][N+2];

            st = new StringTokenizer(br.readLine());
            home = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            vertexList.add(home);

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                vertexList.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }
            st = new StringTokenizer(br.readLine());
            festival = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            vertexList.add(festival);
            
            initMatrix();
            floyd();

            if(map[0][N+1] == INF) sb.append("sad").append("\n");
            else sb.append("happy").append("\n");
        }

        System.out.print(sb);
    }

    static void initMatrix(){
        for(int i = 0; i < vertexList.size(); i++){
            Point p1 = vertexList.get(i);
            for(int j = 0; j < vertexList.size(); j++){
                Point p2 = vertexList.get(j);
                map[i][j] = Math.abs(p2.y - p1.y) + Math.abs(p2.x - p1.x);
                if(map[i][j] > 1000) map[i][j] = INF;
            }
        }
    }

    static void floyd(){
        for(int k = 0; k < N+2; k++){
            for(int i = 0; i < N+2; i++){
                for(int j = 0; j < N+2; j++){
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }
    static class Point{
        int y, x;

        public Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
