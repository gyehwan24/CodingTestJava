package programmers.스택;
// https://school.programmers.co.kr/learn/courses/30/lessons/120853

import java.util.*;
class 컨트롤_제트 {
    public int solution(String s) {
        int answer = 0;
        // 공백 기준으로 문자열을 쪼개서 저장
        String[] str = s.split(" ");
        // Z가 아니면 숫자이므로 숫자로 변환해서 썸에 더한다. 더한 후에는 스택에도 푸시 (deque 사용)
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < str.length; i++) {
            if (!str[i].equals("Z")) {
                int number = Integer.parseInt(str[i]);
                answer += number;
                deque.addLast(number);
            } else {
                // Z가 나오면 스택에서 pop해서 해당 값을 썸에서 뺀다.
                int minus = deque.removeLast();
                answer -= minus;
            }
        }
        return answer;
    }
}
