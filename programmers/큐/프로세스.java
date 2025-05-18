package programmers.큐;
//// https://school.programmers.co.kr/learn/courses/30/lessons/42587

import java.util.*;
class 프로세스 {
    public int solution(int[] priorities, int location) {
        // 가장 큰 우선순위 관리
        // 우선순위 큐와 인덱스 큐 따로 관리
        // pop > 가장 큰 우선순위라면 그대로 처리, 가장 큰 우선순위 아니라면 다시 add
        // 인덱스 큐도 똑같이 관리. 그래야 location의 처리 순서를 알 수 있음.
        ArrayDeque<Integer> priorityQueue = new ArrayDeque<>();
        ArrayDeque<Integer> indexQueue = new ArrayDeque<>();
        int index = 0;
        for (int priority : priorities) {
            priorityQueue.addLast(priority);
            indexQueue.addLast(index++);
        }
        int answer = 0;
        while (!priorityQueue.isEmpty()) {
            int maxPriority = Collections.max(priorityQueue);
            int popPriority = priorityQueue.removeFirst();
            int popIndex = indexQueue.removeFirst();
            if (popPriority < maxPriority) {
                priorityQueue.addLast(popPriority);
                indexQueue.addLast(popIndex);
            } else {
                // pop 되는 경우
                answer++;
                if (popIndex == location) break;
            }
        }

        return answer;
    }
}
