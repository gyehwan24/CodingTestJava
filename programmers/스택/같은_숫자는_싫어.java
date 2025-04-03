package programmers.스택;
// https://school.programmers.co.kr/learn/courses/30/lessons/12906

import java.util.*;

public class 같은_숫자는_싫어 {
    public int[] solution(int []arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            if (deque.isEmpty() || deque.peekLast() != arr[i]) {
                deque.addLast(arr[i]);
            }
        }
        int[] answer = new int[deque.size()];
        int index = 0;
        while (!deque.isEmpty()) {
            answer[index++] = deque.removeFirst();
        }
        return answer;
    }
}
