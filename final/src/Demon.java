/**
 * @Description
 * @Author ZhengLing
 * @Date 2021/06/22 8:47
 */
public class Demon {

    public static int min(int x, int y, int z) {
        if (x <= y && x <= z) {
            return x;
        }
        if (y <= x && y <= z) {
            return y;
        } else {
            return z;
        }
    }

    public static int editDist(String str1, String str2, int m, int n) {
        /*
         * 将str1变成str2
         * 如果str1为空字符串，则将str2的所有字符插入str1即可。
         * 这样str1经过编辑后，就和str2一样了。
         * 那么需要经过的编辑数就等同于str2的长度，即n。
         * */
        if (m == 0) {
            return n;
        }
        /*
         * 如果str1不为空字符串，而str2为空字符串，则将str1的所有字符删除即可。
         * 这样str1经过编辑后，就和str2一样了。
         * 那么需要经过的编辑数就等同于str1的长度，即m。
         * */

        if (n == 0) {
            return m;
        }

        /*
         * 如果str1和str2的最后一个字符相同，则无需做什么操作。
         * 则从右侧向左侧进行比较。
         * str1的长度为 m=str1.length()
         * str2的长度为 n=str2.length()
         * 递归调用方法：editDist(str1, str2, m - 1, n - 1)
         * */
        if (str1.charAt(m - 1) == str2.charAt(n - 1)) {
            return editDist(str1, str2, m - 1, n - 1);
        }

        /*
         * 如果str1和str2的最后一个字符不相同，则对于str1需要考虑下面三种情况
         * 通过递归调用来计算最小的编辑代价
         * 插入
         * 删除
         * 替换
         * */

        return 1 + min(editDist(str1, str2, m, n - 1), // 插入
                editDist(str1, str2, m - 1, n), // 删除
                editDist(str1, str2, m - 1, n - 1) // 替换
        );
    }

    public static void main(String args[]) {
        String str1 = "sunday";
        String str2 = "saturday";

        System.out.println(editDist(str1, str2, str1.length(), str2.length()));
    }

}
