import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int n, d, k, cnt = 0;
    static PriorityQueue<Person> personList = new PriorityQueue();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int sal = Integer.parseInt(st.nextToken());

            personList.add(new Person(name, sal));
        }

        int sum = 0;
        while(!personList.isEmpty()){
            Person p = personList.poll();
            sum += p.sal;
            sb.append(p.name).append(", YOU ARE FIRED!\n");
            k--;
            cnt++;

            if(sum >= d || k < 0) break;
        }


        if(k < 0 || sum < d){
            sb.delete(0, sb.length());
            sb.append("impossible");
        }
        else System.out.println(cnt);

        System.out.print(sb);
    }

    static class Person implements Comparable<Person>{
        String name;
        int sal;

        public Person(String name, int sal) {
            this.name = name;
            this.sal = sal;
        }

        @Override
        public int compareTo(Person o) {
            return o.sal - this.sal;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", sal=" + sal +
                    '}';
        }
    }
}
