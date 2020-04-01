import java.util.Arrays;

public class Solution {
    public static int minIncrementForUnique(int[] A) {
//        HashMap<Integer, Boolean> hashMap = new HashMap<>();
//        int move = 0;
//        for (int num : A) {
//            if (hashMap.get(num) == null) {
//                hashMap.put(num, true);
//            } else {
//                boolean hasPut = false;
//                while (!hasPut) {
//                    move++;
//                    if (hashMap.get(++num) == null) {
//                        hashMap.put(num, true);
//                        hasPut = true;
//                    }
//                }
//            }
//        }
        if (A.length <= 1) {
            return 0;
        }
        Arrays.sort(A);
        int oriSum = 0;
        int uniqueSum = 0;
        int increaseNum = A[0];
        for (int num : A) {
            oriSum += num;
            if (increaseNum < num) {
                uniqueSum += num;
                // 下面这句很重要
                increaseNum = num;
            } else {
                uniqueSum += increaseNum;
            }
            increaseNum++;
        }
        return uniqueSum - oriSum;
    }

    public static void main(String[] args) {
        System.out.println(minIncrementForUnique(new int[]{3, 2, 1, 2, 1, 7}));
    }
}
