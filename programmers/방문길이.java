package programmers;// https://school.programmers.co.kr/learn/courses/30/lessons/49994

import java.io.*;
import java.util.*;
class Solution {
    public int solution(String dirs) {
        int answer = 0; // 처음 가본 길의 개수
        // 1. 현재 좌표 설정. 초기화 0,0
        int[] position = {0, 0};
        // 2. dirs 문자열 하나씩 읽으면서 좌표 이동, 이동하면서 List에 넣고 중복체크 후 길 개수 count
        List<Way> wayList = new ArrayList<>(); // 가본 길 list
        String[] dir = dirs.split("");
        for (String direction : dir) {
            int startX = position[0];
            int startY = position[1];
            switch (direction) {
                case "U":
                    position[1]++;
                    if(position[1] > 5) {position[1]--; continue;}
                    break;
                case "D":
                    position[1]--;
                    if(position[1] < -5) {position[1]++; continue;}
                    break;
                case "R":
                    position[0]++;
                    if(position[0] > 5) {position[0]--; continue;}
                    break;
                case "L":
                    position[0]--;
                    if(position[0] < -5) {position[0]++; continue;}
                    break;
            }
            if(!wayCheck(wayList, startX, startY, position[0], position[1])) {
                answer++;
            }
            wayList.add(new Way(startX, startY, position[0], position[1]));
        }
        return answer;
    }
    public boolean wayCheck (List<Way> wayList, int startX, int startY, int endX, int endY) {
        Way newWay = new Way(startX, startY, endX, endY);
        boolean isDuplicate = false;
        for (Way w : wayList) {
            if (w.startX == newWay.startX && w.startY == newWay.startY
                    && w.endX == newWay.endX && w.endY == newWay.endY) {
                isDuplicate = true;
            }
            if (w.startX == newWay.endX && w.startY == newWay.endY
                    && w.endX == newWay.startX && w.endY == newWay.startY) {
                isDuplicate = true;
            }
        }
        return isDuplicate;
    }
    class Way {
        int startX, startY, endX, endY;
        public Way (int startX, int startY, int endX, int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }
    }
}
