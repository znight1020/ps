import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int persepolis = 0, esteghlal = 0;

        int homePersepolis = Integer.parseInt(st.nextToken());
        int awayEsteghlal = Integer.parseInt(st.nextToken());
        persepolis += homePersepolis;
        esteghlal += awayEsteghlal;

        st = new StringTokenizer(br.readLine());
        int homeEsteghlal = Integer.parseInt(st.nextToken());
        int awayPersepolis = Integer.parseInt(st.nextToken());
        persepolis += awayPersepolis;
        esteghlal += homeEsteghlal;

        if (persepolis > esteghlal) System.out.println("Persepolis");
        else if(esteghlal > persepolis) System.out.println("Esteghlal");
        else {
            if(awayPersepolis > awayEsteghlal) System.out.println("Persepolis");
            else if(awayPersepolis < awayEsteghlal) System.out.println("Esteghlal");
            else System.out.println("Penalty");
        }
    }
}
