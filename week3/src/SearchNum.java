import java.util.HashMap;
import java.util.Map;

/**
 * @Description 检索算法
 * @Author ZhengLing
 * @Date 2021/03/22 15:07
 */
public class SearchNum {
    public static void main(String[] args) {
        int[] numArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int ans = new Solution().find_hashMap(numArr, 10);
        System.out.println(ans);
    }

}

class Solution {
    public int find_hashMap(int[] num, int targetNum) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < num.length; i++) {
            map.put(num[i], i);
        }
        if (map.containsKey(targetNum)) {
            return map.get(targetNum);
        }
        return 0;
    }
    
    public int find(int[] num,int targetNum){
        for (int i = 0; i < num.length; i++) {
            if (targetNum == num[i]){
                return i;
            }
        }
        return 0;
    }
}
