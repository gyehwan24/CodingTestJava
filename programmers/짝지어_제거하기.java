package programmers;
// https://school.programmers.co.kr/learn/courses/30/lessons/12973

import java.util.*;
class 짝지어_제거하기 {
    public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        // 1. s의 문자를 하나씩 읽으면서 stack에 push
        for (int i = 0; i < s.length(); i++) {
            // 스택이 비어있지 않고 stack.peek() == c 이면 stack.pop
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)) {
                stack.pop();
            } else {
                // else이면 push
                stack.push(s.charAt(i));
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
