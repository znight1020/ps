package lecture.section6_sorting_searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 결정 알고리즘 -> 주어진 start, end 값 사이에 정답이 있는 경우 사용 가능 lt = 1, rt = 100 이면 답은 1~100 사이에 있다.
 * 이분 검색을 통해 1~100 중간값인 50이 답이 될 수 있는가? O
 * 51~100 제외, 1~50 중간값인 25가 답이 될 수 있는가? X
 * ---
 *  => 예시입력에서의 lt = 9(DVD는 한 곡을 완전히 담아야 하므로 제일 큰 값인 9), rt = 45(모든 데이터의 합)
 *
 * 9와 45의 중간값인 27의 용량을 가진 DVD가 있을 경우, (1,2,3,4,5,6), (7,8,9) 2개의 DVD 만으로도 충분 -> 최소가 아니지 답은 될 수 있다. 27~45 제외 rt = 26
 * 현재 answer = 27이 저장되어있고 위의 과정을 반복하여 최적의 답을 찾을 수 있게 답의 범위를 좁혀나간다.
 * 결국 lt가 rt보다 커지게 되는데 이때 answer 값이 답이 된다.
 * */
public class Music_video_decision_algorithm {
    public int count(int[] arr, int capacity){
        int cnt = 1, sum = 0;
        for(int x : arr){
            if(sum + x > capacity){
                cnt++;
                sum = x;
            } else sum+= x;
        }
        return cnt;
    }

    public int solution(int[] arr, int target){
        int answer = 0;
        int lt = Arrays.stream(arr).max().getAsInt(); // stream으로 만든 후, max값 구하면 OptionalInt형이 반환되는데, getAsInt 메소드를 사용하여 int로 반환
        int rt = Arrays.stream(arr).sum(); // sum은 기본적으로 int로 반환

        while(lt <= rt){
            int mid = (lt + rt) / 2;
            if(count(arr, mid) <= target){ // disk의 개수가 요구 disk보다 작거나 같은 경우 rt는 작아져야하고 mid는 답이 될 수 있다.
                answer = mid;
                rt = mid-1; // mid보다 큰 값들은 '최소'를 만족시킬 수 없기 때문에 제외
            }
            else{ // disk의 개수가 요구 disk보다 많다면 lt는 커져야한다.
                lt  = mid+1;
            }
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        Music_video_decision_algorithm m = new Music_video_decision_algorithm();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        int[] arr = new int[size];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < size; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(m.solution(arr, target));
    }
}
