package programmers.트리;
// https://school.programmers.co.kr/learn/courses/30/lessons/12985

class 예상_대진표 {
    public int solution(int n, int a, int b) {
        int answer = 0;

        for (answer = 0; a != b ; answer++) {
            a = (a + 1) / 2;
            b = (b + 1) / 2;
        }
        return answer;
    }
}
