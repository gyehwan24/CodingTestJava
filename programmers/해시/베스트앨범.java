package programmers.해시;
// https://school.programmers.co.kr/learn/courses/30/lessons/42579

import java.util.*;
class 베스트앨범 {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> genreMap = new HashMap<>(); // 장르별 재생횟수 해시맵
        HashMap<String, List<Song>> genreToSongs = new HashMap<>(); // 장르별 곡 정보 해시맵
        for (int i = 0; i < genres.length; i++) {
            genreMap.put(genres[i], genreMap.getOrDefault(genres[i], 0) + plays[i]);
            if (!genreToSongs.containsKey(genres[i])) {
                genreToSongs.put(genres[i], new ArrayList<>());
            }
            genreToSongs.get(genres[i]).add(new Song(i, plays[i]));
        }

        List<Map.Entry<String, Integer>> genreEntry = new ArrayList<>(genreMap.entrySet());
        genreEntry.sort(Map.Entry.<String, Integer>comparingByValue().reversed());

        List<Integer> answerList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : genreEntry) {
            List<Song> nowList = genreToSongs.get(entry.getKey());
            nowList.sort((a, b) -> {
                if (a.plays != b.plays) return  b.plays - a.plays;
                return a.index - b.index;
            });

            for (int i = 0; i < Math.min(2, nowList.size()); i++) {
                answerList.add(nowList.get(i).index);
            }
        }
        return answerList.stream().mapToInt(i -> i).toArray();

    }
    class Song {
        int index;
        int plays;
        public Song (int index, int plays) {
            this.index = index;
            this.plays = plays;
        }
    }
}
