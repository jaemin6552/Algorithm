import java.util.Arrays;
import java.util.Scanner;
public class Main {
        public static void main(String[]args){
            Scanner sc =new Scanner(System.in);
            int k = sc.nextInt(); //가지고있는 랜선의 개수
            int n = sc.nextInt(); //필요한 랜선의 개수
            int []arr = new int[k];
            for(int i =0; i<arr.length; i++){
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            long start = 1;
            long end = arr[arr.length-1];
            long result = 0;

            while (start <= end) {
                long mid = (start + end) / 2;

                if (isPossible(arr, n, mid)) {
                    result = Math.max(result, mid);
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
            System.out.println(result);
        }
        private static boolean isPossible(int[] lanCables, int n, long length) {
            int count = 0;

            for (int i = 0; i < lanCables.length; i++) {
                count += lanCables[i] / length;
            }

            return count >= n;
        }
    }
