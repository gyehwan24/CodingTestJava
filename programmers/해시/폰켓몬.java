package programmers.해시;
// https://school.programmers.co.kr/learn/courses/30/lessons/1845

import java.util.*;
class 폰켓몬 {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // map의 key 개수가 N/2 보다 작으면 key 개수 반환, N/2 보다 크면 N/2 반환
        if (map.size() < (nums.length / 2)) {
            return map.size();
        }
        return nums.length / 2;
    }
}
