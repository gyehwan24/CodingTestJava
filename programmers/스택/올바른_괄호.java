package programmers.스택;
// https://school.programmers.co.kr/learn/courses/30/lessons/12909

import java.util.*;
class 올바른_괄호 {
    boolean solution(String s) {
        // 1. Stack을 선언하고, '('이면 push, ')'이면 pop을 한다.
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(1);
            } else {
                // 2. pop을 할 때 Stack이 비어있다면, false로 return한다.
                if(stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
