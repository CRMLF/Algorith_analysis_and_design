import java.util.Arrays;

/**
 * @Description 二分归并排序
 * @Author ZhengLing
 * @Date 2021/03/29 15:14
 */
public class Merge {
    public static void main(String[] args) {
        int[] numArr = {12, 11, 10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] res = Solution.mergeSort(numArr);
        System.out.println(Arrays.toString(res));
    }
}

class Solution {
    public static int[] mergeSort(int[] numArr) {
        if (numArr.length < 2) {
            return numArr;
        }
        int mid = numArr.length / 2;
        int[] left = Arrays.copyOfRange(numArr, 0, mid);
        int[] right = Arrays.copyOfRange(numArr, mid, numArr.length);
        return merge(mergeSort(left), mergeSort(right));
    }

    public static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < res.length; index++) {
            if (i >= left.length) {
                res[index] = right[j++];
            } else if (j >= right.length) {
                res[index] = left[i++];
            } else if (left[i] > right[j]) {
                res[index] = right[j++];
            } else {
                res[index] = left[i++];
            }
        }
        return res;
    }
}
