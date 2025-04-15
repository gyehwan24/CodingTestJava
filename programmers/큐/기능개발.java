package programmers.큐;
// https://school.programmers.co.kr/learn/courses/30/lessons/42586

import java.util.*;
class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();
        // 각 기능 별 소요시간을 계산해서 큐에 담아둔다.
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < progresses.length; i++) {
            deque.addLast(convertSpendTime(progresses[i], speeds[i]));
        }
        // pop을 하고 pop한 숫자보다 그 다음 peek의 숫자가 작다면 같이 pop. 더 큰 숫자가 나올 때 까지 pop
        while (!deque.isEmpty()) {
            int feature = 1;
            int compare = deque.removeFirst();
            while (!deque.isEmpty() && compare >=deque.peekFirst()) {
                feature++;
                deque.removeFirst();
            }
            list.add(feature);
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }

    // 소요시간 계산 함수
    public int convertSpendTime (int progress, int speed) {
        int remainProgress = 100 - progress;
        int needSpendTime = remainProgress / speed;
        // 나머지가 0이 아니라면 +1을 해준다.
        if (remainProgress % speed != 0) needSpendTime += 1;
        return needSpendTime;
    }
}
