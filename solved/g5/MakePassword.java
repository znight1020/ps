package solved.g5;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MakePassword {
    static char[] checkArr = {'a', 'e', 'i', 'o', 'u'};
    static char[] src;
    static boolean[] vtd;
    static int L, C;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        src = new char[C];
        vtd = new boolean[C];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < C; i++) src[i] = st.nextToken().charAt(0);

        Arrays.sort(src);

        char[] target = new char[L];
        perm(0, target, 0);
        System.out.println(sb);
    }

    static void perm(int targetIdx, char[] target, int start){
        if(targetIdx == L){
            if(check(target) == 1){
                for(char c : target) sb.append(c);
                sb.append("\n");
            }
            return;
        }

        for(int i = start; i < src.length; i++){
            if(vtd[i]) continue;
            vtd[i] = true;
            target[targetIdx] = src[i];
            perm(targetIdx + 1, target, i);
            vtd[i] = false;
        }
    }

    static int check(char[] arr){
        int cnt = 0;
        for(char c : arr) for (char value : checkArr) if (c == value) cnt++;

        if(1 <= cnt && cnt <= L-2) return 1;
        else return -1;
    }
}
