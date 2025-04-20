package programmers.해시;
//// https://school.programmers.co.kr/learn/courses/30/lessons/42888

import java.util.*;
class 오픈채팅방 {
    public String[] solution(String[] record) {
        // uid, nickname으로 해시맵 생성
        HashMap<String, String> userMap = new HashMap<>();
        // record 배열을 돌면서 해시맵에 데이터 입력/수정
        for (String str : record) {
            String[] command = str.split(" ");
            if (!command[0].equals("Leave")) {
                userMap.put(command[1], command[2]);
            }
        }
        // 해시맵 데이터 수정 완료 후 다시 record 배열을 돌면서 Enter/Leave에 대해 result 문자열 배열 생성
        List<String> list = new ArrayList<>();
        for (String str : record) {
            String[] command = str.split(" ");
            if (command[0].equals("Enter")) {
                list.add(userMap.get(command[1]) + "님이 들어왔습니다.");
            } else if (command[0].equals("Leave")) {
                list.add(userMap.get(command[1]) + "님이 나갔습니다.");
            }
        }
        return list.toArray(new String[list.size()]);
    }
}
