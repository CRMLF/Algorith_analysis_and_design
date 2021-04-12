import java.util.Scanner;

/**
 * @Description 最近对问题
 * @Author ZhengLing
 * @Date 2021/04/12 16:08
 */
public class s2_4 {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = 0, x1 = 0, x2 = 0, x3 = 0, x4 = 0;
        int y = 0, y1 = 0, y2 = 0;
        double dis1 = 0, dis2 = 0;

        System.out.print("输入需要生成多少个随机点N：");
        int n = s.nextInt();
        int A[][] = new int[n][2];
        int B[][] = new int[n][2];
        int C[][] = new int[n][2];
        int D[][] = new int[n][2];
        for (int i = 0; i < n; i++) {
            //生成100以内的随机数,放入横坐标
            A[i][0] = (int) (Math.random() * 100) + 1;
        }
        for (int i = 0; i < n; i++) {
            //生成100以内的随机数,放入纵坐标
            A[i][1] = (int) (Math.random() * 100) + 1;
        }
        for (int i = 0; i < n; i++) {
            System.out.println("(" + A[i][0] + "," + A[i][1] + ")");
        }

        int minX = (int) Double.POSITIVE_INFINITY;        	
        int maxX = (int) Double.NEGATIVE_INFINITY;        
        for (int i = 0; i < A.length; i++) {
            if (A[i][0] < minX) {
                minX = A[i][0];
            }
            if (A[i][0] > maxX) {
                maxX = A[i][0];
            }
        }
        int mid = (minX + maxX) / 2;

        int p = 0, t = 0;
        for (int i = 0; i < n; i++) {   
            if (A[i][0] <= mid) {
                B[p][0] = A[i][0];
                B[p][1] = A[i][1];
                p++;
            } else {
                C[t][0] = A[i][0];
                C[t][1] = A[i][1];
                t++;
            }
        }

        int d1 = (int) Double.POSITIVE_INFINITY, d2 = (int) Double.POSITIVE_INFINITY;  
        int dx = 0, dy = 0, dz = 0;
        for (int i = 0; i <= p - 2; i++) {
            for (int j = i + 1; j <= p - 1; j++) {
                dx = (B[j][0] - B[i][0]) * (B[j][0] - B[i][0]) + (B[j][1] - B[i][1]) * (B[j][1] - B[i][1]);
                if (dx < d1) {
                    d1 = dx;
                    x1 = i;  
                    x2 = j;
                }
            }
        }

        for (int i = 0; i <= t - 2; i++) {
            for (int j = i + 1; j <= t - 1; j++) {
                dy = (C[j][0] - C[i][0]) * (C[j][0] - C[i][0]) + (C[j][1] - C[i][1]) * (C[j][1] - C[i][1]);
                if (dy < d2) {
                    d2 = dy;
                    x3 = i;  
                    x4 = j;
                }
            }
        }
        System.out.println("mid=" + mid + " " + "d1=" + d1 + " " + "d2=" + d2);

        if (d1 < d2) {
            dz = d1;
            dis1 = Math.sqrt(dz);
            System.out.println("x坐标中的最小距离的俩个点为：" + A[x1][0] + "," + A[x1][1] + " " + A[x2][0] + "," + A[x2][1]);
            System.out.println("最小距离为：" + dis1);
            x = x1;
            y = x2;
        } else {
            dz = d2;
            dis1 = Math.sqrt(dz);
            System.out.println("x坐标中的最小距离的俩个点为：" + A[x3][0] + "," + A[x3][1] + " " + A[x4][0] + "," + A[x4][1]);
            System.out.println("最小距离为：" + dis1);
            x = x3;
            y = x4;
        }

        int q = 0;
        for (int i = 0; i < n; i++) {
            if ((mid - dis1) <= A[i][0] && A[i][0] <= (mid + dis1)) {  
                D[q][0] = A[i][0];
                D[q][1] = A[i][1];
                q++;
            }
        }
        double mind = Double.POSITIVE_INFINITY;
        double dis = 0;
        for (int k = 0; k <= q - 2; k++) {
            for (int j = k + 1; j <= q - 1; j++) {
                dis = (D[j][0] - D[k][0]) * (D[j][0] - D[k][0]) + (D[j][1] - D[k][1]) * (D[j][1] - D[k][1]);
                if (dis < mind) {
                    mind = dis;
                    y1 = k;  
                    y2 = j;
                }
            }
        }
        dis2 = Math.sqrt(mind);
        System.out.println("dis1=" + dis1 + " " + "dis2=" + dis2);

        if (dis1 < dis2) {
            System.out.println("最小距离为：" + dis1);
            System.out.print("俩个点分别为：" + "(" + A[x][0] + "," + A[x][1] + ")");
            System.out.println(" " + "(" + A[y][0] + "," + A[y][1] + ")");
        } else {
            System.out.println("最小距离为：" + dis2);
            System.out.print("俩个点分别为：" + "(" + A[y1][0] + "," + A[y1][1] + ")");
            System.out.println(" " + "(" + A[y2][0] + "," + A[y2][1] + ")");
        }
    }
}
