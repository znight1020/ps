package solved.s4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FindRank {
    // N(점수 개수), 태수의 새로운 점수 , P(랭킹 리스트에 올라가는 점수 개수)
    // 태수의 새로운 점수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int newPoint = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int rank = 1; // 영수의 순위

        PriorityQueue<Integer> pointArr = new PriorityQueue<>(Collections.reverseOrder());

        if(N > 0){
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                pointArr.add(Integer.parseInt(st.nextToken()));
            }

            int temp;
            for(int i = 0; i < pointArr.size(); i++){
                if(!pointArr.isEmpty()){
                    temp = pointArr.poll();
                    if(temp < newPoint) break;
                    else if(newPoint == temp){
                        if(rank < P){
                            int oldRank = rank;
                            for(int x : pointArr){
                                if(x == newPoint){
                                    rank++;
                                }
                            }
                            if(rank == P){
                                rank = P + 1;
                            }
                            else{
                                rank = oldRank;
                            }

                            break;
                        }
                        else if(rank == P){
                            rank = P + 1;
                            break;
                        }
                    }
                    else {
                        i--;
                        rank++;
                    }
                }
            }

            if(rank <= P) System.out.print(rank);
            else System.out.print(-1); // 랭크는 마지막 순서이지만 점수가 같아 랭크 리스트에서 밀려난 경우
        }
        else {
            System.out.print(1);
        }



    }
}
