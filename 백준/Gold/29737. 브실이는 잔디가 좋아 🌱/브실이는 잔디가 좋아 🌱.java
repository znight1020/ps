import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static char[][] streakData;
    static ArrayList<Person> personArrayList = new ArrayList<>();
    static int N, W;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int grade = 0;

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        streakData = new char[7][W];
        for(int t = 0; t < N; t++){
            String name = br.readLine();

            for(int i = 0; i < 7; i++) streakData[i] = br.readLine().toCharArray();
            setPersonData(name);
        }

        Collections.sort(personArrayList);
        Person old = new Person(" ", -1, 0, 0, 0);
        for(Person p: personArrayList){
            if(checkEqual(p, old)) sb.append(grade).append(".").append(" ").append(p.name).append("\n");
            else {
                grade++;
                sb.append(grade).append(".").append(" ").append(p.name).append("\n");
            }
            old = p;
        }
        System.out.print(sb);
    }
    static public boolean checkEqual(Person cur, Person o){
        if(cur.streakLength != o.streakLength) return false;
        if(cur.streakFreezeCount != o.streakFreezeCount) return false;
        if(cur.streakStart != o.streakStart) return false;
        if(cur.streakFailCount != o.streakFailCount) return false;

        return true;
    }
    static void setPersonData(String name){
        int streakCnt = 0, failCnt = 0, startIdx = 0, streakFreezeCnt = 0, temp = 0;
        Person p = new Person(name, 0,0,0,0);
        for(int i = 0; i < W; i++){
            for(int j = 0; j < 7; j++){
                if(streakData[j][i] == 'O') {
                    if(streakCnt == 0) startIdx = (i*7) + j+1;
                    streakCnt++; // 연속 스트릭 쌓기
                    streakFreezeCnt += temp;
                    temp = 0;
                }
                else if(streakData[j][i] == 'X'){
                    if(p.streakLength == streakCnt && p.streakFreezeCount > streakFreezeCnt){
                        p.streakStart = startIdx;
                        p.streakFreezeCount = streakFreezeCnt;
                    }
                    if(p.streakLength < streakCnt) {
                        p.streakLength = streakCnt; // 최장 스트릭 갱신
                        p.streakStart = startIdx; // 최장 스트릭이 갱신되면 최장 스트릭 시작 일도 갱신
                        p.streakFreezeCount = streakFreezeCnt;
                    }
                    temp = 0;
                    failCnt++; // 스트릭 실패 개수
                    streakCnt = 0; // 다시 0부터 시작
                    streakFreezeCnt = 0; // 다시 0부터 시작
                }
                else { // 스트릭 프리즈 사용
                    if(streakCnt > 0) temp += 1;
                }
            }
        }
        // for 문을 빠져나와서도 마지막 기록일까지 streak 을 채웠다면 최장 스트릭 길이가 갱신될 수 있음
        if(p.streakLength < streakCnt) {
            p.streakLength = streakCnt; // 최장 스트릭 갱신
            p.streakStart = startIdx; // 최장 스트릭이 갱신되면 최장 스트릭 시작 일도 갱신
            p.streakFreezeCount = streakFreezeCnt;
        }
        p.streakFailCount = failCnt;

        personArrayList.add(p);
    }

    static class Person implements Comparable<Person>{
        String name;

        int streakLength, streakFreezeCount, streakStart, streakFailCount;

        public Person(String name, int streakLength, int streakFreezeCount, int streakStart, int streakFailCount) {
            this.name = name;
            this.streakLength = streakLength; // 최장 스트릭 길이
            this.streakFreezeCount = streakFreezeCount; // 스트릭 개수
            this.streakStart = streakStart; // 스트릭프리즈 시작일
            this.streakFailCount = streakFailCount; // 스트릭 채우기 실패 개수
        }

        @Override
        public int compareTo(Person o) {
            if(this.streakLength == o.streakLength) return compareToStreakFreezeCount(o);
            return o.streakLength - this.streakLength;
        }

        public int compareToStreakFreezeCount(Person o){
            if(this.streakFreezeCount == o.streakFreezeCount) return compareToStreakStart(o);
            return this.streakFreezeCount - o.streakFreezeCount;
        }
        public int compareToStreakStart(Person o){
            if(this.streakStart == o.streakStart) return compareToStreakFailCount(o);
            return this.streakStart - o.streakStart;
        }
        public int compareToStreakFailCount(Person o){
            if(this.streakFailCount == o.streakFailCount) return compareToPersonName(o);
            return this.streakFailCount - o.streakFailCount;
        }
        public int compareToPersonName(Person o){
            return this.name.compareTo(o.name);
        }
    }
}
