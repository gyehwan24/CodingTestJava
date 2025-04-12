package programmers.큐;
// // https://school.programmers.co.kr/learn/courses/30/lessons/42583

import java.util.*;
class 다리를_지나는_트럭 {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) queue.add(0);
        int sumW = 0, index = 0;
        while (!queue.isEmpty()) {
            answer++;
            int out = queue.removeFirst();
            sumW -= out;
            if (index >= truck_weights.length) continue;
            if (truck_weights[index] + sumW <= weight) {
                queue.addLast(truck_weights[index]);
                sumW += queue.peekLast();
                index++;
            } else {
                queue.addLast(0);
            }
        }
        return answer;
    }
}
