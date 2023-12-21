package basic;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Arrays;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static basic.문자열잘라서정렬하기.solution;

//문제 설명
//정수 배열 arr와 2개의 구간이 담긴 배열 intervals가 주어집니다.
//intervals는 항상 [[a1, b1], [a2, b2]]의 꼴로 주어지며 각 구간은 닫힌 구간입니다.
//닫힌 구간은 양 끝값과 그 사이의 값을 모두 포함하는 구간을 의미합니다.
//이때 배열 arr의 첫 번째 구간에 해당하는 배열과 두 번째 구간에 해당하는 배열을 앞뒤로 붙여
//새로운 배열을 만들어 return 하는 solution 함수를 완성해 주세요.
public class 배열만들기3 {

    public static void main(String[] args) throws ParseException {
        int a= solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}});
        System.out.println(a);
    }
        static int []dy = {1,0,-1,0};
        static int []dx = {0,1,0,-1};
        public static int solution(int[][] land) {
            int []oil = new int[land[0].length+1];
            int [][]visited = new int[land.length][land[0].length];
            bfs(land,visited,oil);
            Arrays.sort(oil);
            return oil[oil.length-1];
        }
        public static void bfs(int[][] land, int[][] visited, int[] oil) {
            Queue<int[]> current = new LinkedList<>();
            for (int k = 0; k < land[0].length; k++) {
                List<Integer> check = new ArrayList<>();
                for (int i = 0; i < land.length; i++) {
                    if (land[i][k] == 1 && visited[i][k] == 0) {
                        current.add(new int[]{0, i});
                        while (!current.isEmpty()) {
                            int[] c = current.remove();
                            int cy = c[1];
                            int cx = c[0];
                            for (int j = 0; j < 4; j++) {
                                int ny = cy + dy[j];
                                int nx = cx + dx[j];
                                if (ny < 0 || ny > land.length - 1 || nx < 0 || nx > land[0].length - 1) continue;
                                if (land[ny][nx] == 1 && visited[ny][nx] == 0) {
                                    visited[ny][nx] = i + 1;
                                    oil[i + 1]++;
                                    current.add(new int[]{nx, ny});
                                }
                            }
                        }
                    } else if (land[i][k] == 1 && !check.contains(visited[i][k])) {
                        check.add(visited[i][k]);
                        oil[i + 1] += oil[visited[i][k]];
                    }
                }
            }
        }
}

