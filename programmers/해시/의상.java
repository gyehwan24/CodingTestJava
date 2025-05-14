package programmers.해시;
// https://school.programmers.co.kr/learn/courses/30/lessons/42578

import java.util.*;
class 의상 {
    public int solution(String[][] clothes) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            String type = clothes[i][1];
            String cloth = clothes[i][0];
            if (map.get(type) == null) { // 최초 초기화
                map.put(type, new ArrayList<>());
            }
            map.get(type).add(cloth);
        }
        int calculate = 1;
        for (Map.Entry<String, List<String>> entry : map.entrySet()) {
            calculate *= entry.getValue().size() + 1;
        }
        return calculate - 1;
    }
}
