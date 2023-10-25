package lecture.section5_stack_queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Crane_doll_claw_machine_kakao {
    public int solution(int[][] grid, int[] moves){
        int crainPoint, sol = 0, move = 0;
        Stack<Integer> basket = new Stack<>();
        Stack<Integer> temp;

        ArrayList<Stack<Integer>> s_arr = new ArrayList<>();
        basket.add(0);

        for(int i = 0; i < grid.length; i++){
            temp = new Stack<>();
            for(int j = grid[i].length - 1; j >= 0 ; j--){
                if(grid[j][i] != 0) temp.push(grid[j][i]);
            }
            s_arr.add(temp);
        }

        while(move < moves.length){
            crainPoint = moves[move] - 1;
            if(!s_arr.get(crainPoint).isEmpty()) {
                if(basket.peek() != s_arr.get(crainPoint).peek()) {
                    basket.push(s_arr.get(crainPoint).pop());
                }
                else{
                    sol += 2;
                    basket.pop();
                    s_arr.get(crainPoint).pop();
                }
            }
//            for(int i = 1; i < basket.size(); i++){
//                System.out.print(basket.get(i) + " ");
//            }
//            System.out.println();
            move++;
        }
        return sol;
    }
    public static void main(String[] args) throws IOException {
        Crane_doll_claw_machine_kakao c = new Crane_doll_claw_machine_kakao();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int gridSize = Integer.parseInt(br.readLine());
        int[][] grid = new int[gridSize][gridSize];

        for(int i = 0; i < gridSize; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < gridSize; j++){
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int movesSize = Integer.parseInt(br.readLine());
        int[] moves = new int[movesSize];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < movesSize; i++){
            moves[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(c.solution(grid, moves));
    }
}