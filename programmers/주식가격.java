package programmers;
 // https://school.programmers.co.kr/learn/courses/30/lessons/42584#

import java.io.*;
class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int target = prices[i];
            for (int j = i+1; j < prices.length; j++) {
                System.out.println(target + "vs" + prices[j]);
                if (target <= prices[j]) {
                    answer[i]++;
                } else {
                    break;
                }
            }
            System.out.println("========");
        }
        return answer;
    }
}
