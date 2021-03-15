/**
 * @Description MST的Prim算法
 * @Author ZhengLing
 * @Date 2021/03/15 21:36
 */
import java.util.Arrays;
import java.util.Scanner;

public class Prim {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n =  scanner.nextInt();
        int m = scanner.nextInt();
        int[][] cost = new int[n+1][n+1];
        for(int i = 1; i<n+1; i++){
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        for(int i = 0; i<m; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            int p = scanner.nextInt();
            cost[x][y] = cost[y][x] = p;
        }
        prim(cost, n, Integer.MAX_VALUE);
    }

    public static void prim(int[][] cost, int n, int maxi){
        int[] lowcost = new int[n+1];
        int[] closest = new int[n+1];

        for(int i = 2; i<n+1; i++){
            lowcost[i] = cost[1][i];
            closest[i] = 1;
        }
        int min, m;
        //寻找邻近最小路径
        for(int i = 2; i<n+1; i++){
            min = maxi;
            m = 1;
            for(int j = 2; j<n+1; j++){
                if(lowcost[j] < min && lowcost[j] != 0){
                    m = j;
                    min = lowcost[j];
                }
            }
            //输出生成树的边
            System.out.println("closest[" + m + "]=" + closest[m]);
            lowcost[m] = 0;
            closest[m] = 0;
            //调整代价
            for(int j = 2; j<n+1; j++){
                if(cost[m][j] < lowcost[j] && cost[m][j] != 0){
                    lowcost[j] = cost[m][j];
                    closest[j] = m;
                }
            }
        }
    }
}


