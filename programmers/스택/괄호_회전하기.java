package programmers.스택;
// https://school.programmers.co.kr/learn/courses/30/lessons/76502

import java.util.*;
class 괄호_회전하기 {
    public int solution(String s) {
        int answer = 0;
        // 1. Queue<Character> 선언
        Queue<Character> queue = new LinkedList<>();
        // 2. s를 char로 쪼개서 Queue에 넣는다.
        for (int i = 0; i < s.length(); i++) {
            queue.offer(s.charAt(i));
        }
        // 3. x = 0부터 s의길이 -1 까지 Queue에서 빼고 넣는다.
        for (int x = 0; x < s.length(); x++) {
            Queue<Character> queueClone = new LinkedList<>(queue);
            for (int i = 1; i <= x; i++) {
                queueClone.offer(queueClone.poll());
            }

            // 회전한 후 올바른 괄호인지 체크 -> anwer++
            if (isValid(queueClone)) answer++;
        }

        // 4. 3번을 진행하면서 올바른 괄호인지 체크한다. -> 함수 분리
        return answer;
    }
    public boolean isValid (Queue<Character> queue) {
        Stack<Character> stack = new Stack<>();
        while (!queue.isEmpty()) {
            char c = queue.poll();
            switch (c) {
                case '(' -> stack.push(c);
                case '[' -> stack.push(c);
                case '{' -> stack.push(c);
                case ')' -> {
                    if(!stack.isEmpty() && stack.peek() == '(') stack.pop();
                    else return false;
                }
                case ']' -> {
                    if(!stack.isEmpty() && stack.peek() == '[') stack.pop();
                    else return false;
                }
                case '}' -> {
                    if(!stack.isEmpty() && stack.peek() == '{') stack.pop();
                    else return false;
                }
            };
        }
        return stack.isEmpty();
    }
}
