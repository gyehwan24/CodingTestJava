package programmers.해시;
// https://school.programmers.co.kr/learn/courses/30/lessons/42577

import java.util.*;
class 전화번호_목록 {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>();
        for (String phone : phone_book) {
            set.add(phone);
        }
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 1; j < phone_book[i].length(); j++) {
                String prefix = phone_book[i].substring(0, j);
                if (set.contains(prefix)) {
                    return false;
                }
            }
        }
        return true;
    }
}
