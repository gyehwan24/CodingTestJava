package programmers.해시;
// https://school.programmers.co.kr/learn/courses/30/lessons/92334

import java.util.*;
class 신고_결과_받기 {
    public int[] solution(String[] id_list, String[] report, int k) {
        // 신고현황 해시
        HashMap<String, Set<String>> reportMap = new HashMap<>();
        // 피신고 현황 해시
        HashMap<String, Integer> reportedMap = new HashMap<>();
        for (String id : id_list) { // 신고현황 해시맵 초기화
            reportMap.put(id, new HashSet<>());
        }
        for (String log : report) {
            String[] record = log.split(" ");
            // 한 유저가 같은 유저를 여러 번 신고한 경우, 1회로 계산
            if (reportMap.get(record[0]).contains(record[1])) continue;
            reportMap.get(record[0]).add(record[1]);
            reportedMap.put(record[1], reportedMap.getOrDefault(record[1], 0) + 1);
        }
        // 피신고 현황 해시에서 정지된 유저 추출
        Set<String> reportedUserList = new HashSet<>();
        for (Map.Entry<String, Integer> entry : reportedMap.entrySet()) {
            if (entry.getValue() >= k) {
                reportedUserList.add(entry.getKey());
            }
        }

        // id_list 를 순회하면서 결과리스트 계산
        int[] answer = new int[id_list.length];
        int index = 0;
        for (String id : id_list) {
            int mailCount = 0;
            for (String checkUser : reportMap.get(id)) {
                if (reportedUserList.contains(checkUser)) {
                    mailCount++;
                }
            }
            answer[index] = mailCount;
            index++;
        }
        return answer;
    }
}
