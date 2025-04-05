package programmers.스택;
// https://school.programmers.co.kr/learn/courses/30/lessons/64061

import java.util.*;
class 크레인_인형뽑기_게임 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int size = board.length;
        // 이중 반복문을 통해 stack array를 만든다.
        // 외부 반복문: 열 / 내부 반복문: 행 (역순)
        Deque<Integer>[] stackArray = new Deque[size];
        for (int i = 0; i < size; i++) {
            stackArray[i] = new ArrayDeque<>(); // 중요 포인트
            for (int j = size-1 ; j >= 0; j--) {
                if (board[j][i] == 0) continue; // 0이면 스택에 넣지 않는다.
                stackArray[i].addLast(board[j][i]);
            }
        }
        Deque<Integer> bucket = new ArrayDeque<>();
        // moves를 따라 인덱스로 접근해서 stack pop
        for (int i = 0; i < moves.length; i++) {
            if (stackArray[moves[i]-1].isEmpty()) continue; // 인형이 없으면 아무것도 하지 않는다.
            int boardNumber = stackArray[moves[i]-1].removeLast();
            Integer bucketNumber = bucket.isEmpty() ? null : bucket.peekLast();
            // 넣기 전에 bucket.peek해서 같은 숫자면 pop -> answer+=2
            if (bucketNumber != null && boardNumber == bucketNumber) {
                bucket.removeLast();
                answer += 2;
            } else { // 다른 숫자면 bucket.push
                bucket.addLast(boardNumber);
            }
        }
        return answer;
    }
}
