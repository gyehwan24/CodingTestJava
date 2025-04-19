package programmers.큐;
// // https://school.programmers.co.kr/learn/courses/30/lessons/159994

import java.util.*;
class 카드뭉치 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        // cards1, cards2를 각각 큐로 변환한다.
        Deque<String> deque1 = new ArrayDeque<>();
        Deque<String> deque2 = new ArrayDeque<>();
        for (String card : cards1) {
            deque1.addLast(card);
        }
        for (String card : cards2) {
            deque2.addLast(card);
        }
        // goal[] 배열의 요소의 길이만큼 반복문을 돌면서 cards 큐 검사를 한다.
        for (String str : goal) {
            if (!deque1.isEmpty() && deque1.peekFirst().equals(str)) {
                deque1.removeFirst();
            } else if (!deque2.isEmpty() && deque2.peekFirst().equals(str)) {
                deque2.removeFirst();
            } else {
                return "No";
            }
        }
        return "Yes";
    }
}
