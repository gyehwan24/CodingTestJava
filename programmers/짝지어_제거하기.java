package programmers;
// https://school.programmers.co.kr/learn/courses/30/lessons/12973

import java.util.*;
class 짝지어_제거하기 {
    public int solution(String s) {
        // 1. s.length만큼의 반복문을 순회
        boolean flag = true;
        StringBuilder sb = new StringBuilder(s);
        while(flag) {
            flag = false;
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < sb.length(); i++) {
                // 2. stack을 초기화하고 push, 다음 반복문에서 pop. 지금 문자열과 비교
                char nowChar = sb.charAt(i);
                if (stack.isEmpty()) { // 비어있으면 그냥 넣고 끝
                    stack.push(nowChar);
                    continue;
                }
                char target = stack.pop();
                // 2-1. 같으면 subString으로 자른 후에 새로운 문자열로 반복문 재시작
                if (target == nowChar) {
                    sb.delete(i-1, i+1);
                    flag = true;
                    continue;
                } else { // 2-2. 다르면 stack.push 후 반복문 돌기
                    stack.push(nowChar);
                }
            }
        }
        if (sb.length() == 0) {
            return 1;
        }
        return 0;
    }
}
