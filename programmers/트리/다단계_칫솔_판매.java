package programmers.트리;
// https://school.programmers.co.kr/learn/courses/30/lessons/77486

import java.util.*;
class 다단계_칫솔_판매 {
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        HashMap<String, String> referMap = new HashMap<>();
        HashMap<String, Integer> profitMap = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            if (!referral[i].equals("-")) {
                referMap.put(enroll[i], referral[i]);
            }
        } // referMap 완성
        for (int i = 0; i < seller.length; i++) {
            // seller의 refer가 있는지
            String checkSeller = seller[i];
            int profit = amount[i] * 100;
            while (true) { // 수익 분배할 추천인이 있는 것. 없을 때까지 반복
                int stock = profitMap.getOrDefault(checkSeller, 0);
                if (profit * 0.1 > 1) {
                    profitMap.put(checkSeller, stock + (profit - (int) (profit*0.1)));
                } else {
                    profitMap.put(checkSeller, stock + profit);
                    break;
                }
                if (!referMap.containsKey(checkSeller)) break;
                checkSeller = referMap.get(checkSeller); // 다음 추천인 초기화
                profit = (int) (profit*0.1); // 수익금 초기화
            }
        }

        int[] answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            if (profitMap.containsKey(enroll[i])) {
                answer[i] = profitMap.get(enroll[i]);
            } else {
                answer[i] = 0;
            }

        }
        return answer;
    }
}
