package programmers.해시;
// https://school.programmers.co.kr/learn/courses/30/lessons/42576

import java.util.*;
class 완주하지_못한_선수 {
    public String solution(String[] participant, String[] completion) {
        // 해시맵으로 참가자 이름, 명수를 저장한다.
        HashMap<String, Integer> map = new HashMap<>();
        for (String player : participant) {
            map.put(player, map.getOrDefault(player, 0) + 1);
        }
        // completion 배열을 순회하면서 명수를 -1씩 뺀다.
        for (String player : completion) {
            if (map.containsKey(player)) {
                map.put(player, map.get(player) - 1);
            }
        }
        // 배열이 끝났을 때 value 가 1인 key를 Return한다.
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) return entry.getKey();
        }
        return "";
    }
}
