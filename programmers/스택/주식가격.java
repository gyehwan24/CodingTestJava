package programmers.스택;
 // https://school.programmers.co.kr/learn/courses/30/lessons/42584#

class 주식가격 {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int target = prices[i];
            for (int j = i+1; j < prices.length; j++) {
                answer[i]++;
                if (target > prices[j]) {
                    break;
                }
            }
        }
        return answer;
    }
}
