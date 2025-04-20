package programmers.해시;
// https://school.programmers.co.kr/learn/courses/30/lessons/131127

import java.util.*;
class 할인행사 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        // discount 배열의 원소를 10개씩 (슬라이딩윈도우) 해시맵으로 만든다.
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0) + 1);
        }
        for (int start = 0; start <= discount.length - 10; start++) {
            if (isSatisfy(map, want, number)) answer++;
            // 반복문이 1회 끝나면 discount 배열의 슬라이딩 윈도우를 오른쪽으로 한 칸 움직인다.
            if (start+10 >= discount.length) break;
            map.put(discount[start], map.get(discount[start]) - 1);
            map.put(discount[start+10], map.getOrDefault(discount[start+10], 0) + 1);
        }
        return answer;
    }
    public boolean isSatisfy(HashMap<String, Integer> map, String[] want, int[] number) {
        for (int i = 0; i < want.length; i++) {
            if (!map.containsKey(want[i])) return false;
            if (map.get(want[i]) != number[i]) return false;
        }
        return true;
    }
}
