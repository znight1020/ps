package solved.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class FindPassword {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashMap<String, String> memo = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int siteNum = Integer.parseInt(st.nextToken());
        int findNum = Integer.parseInt(st.nextToken());
        String siteAddress;
        String password;

        for(int i = 0; i < siteNum; i++){
            st = new StringTokenizer(br.readLine());
            siteAddress = st.nextToken();
            password = st.nextToken();
            memo.put(siteAddress, password);
        }

        String findSitePassword;
        for(int i = 0; i < findNum; i++){
            findSitePassword = br.readLine();
            sb.append(memo.get(findSitePassword)).append("\n");
        }
        System.out.print(sb);

    }
}
