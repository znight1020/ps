import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    static TreeMap<Integer, Integer> tree = new TreeMap<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for(int t = 1; t <= T; t++){
            tree.clear();
            int k = Integer.parseInt(br.readLine());
            for(int i = 0; i < k; i++){
                st = new StringTokenizer(br.readLine());
                calc(st.nextToken().charAt(0), Integer.parseInt(st.nextToken()));
            }

            if(tree.isEmpty()) sb.append("EMPTY").append("\n");
            else  sb.append(tree.lastKey()).append(" ")
                    .append(tree.firstKey()).append("\n");
        }
        System.out.print(sb);
    }

    static void calc(char command, int value){
        switch(command){
            case 'D':
                if(tree.isEmpty()) return;
                else{
                    if(value == 1) {
                        if(tree.get(tree.lastKey()) - 1 == 0) tree.remove(tree.lastKey());
                        else tree.put(tree.lastKey(), tree.get(tree.lastKey()) - 1);
                    }
                    else {
                        if(tree.get(tree.firstKey()) - 1 == 0) tree.remove(tree.firstKey());
                        else tree.put(tree.firstKey(), tree.get(tree.firstKey()) - 1);
                    }
                }
                break;
            case 'I':
                tree.put(value, tree.getOrDefault(value, 0) + 1);
                break;
        }
    }
}