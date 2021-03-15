/**
 * @Description MST的Kruskal算法
 * @Author ZhengLing
 * @Date 2021/03/15 21:39
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Kruskal {
    
    static class Edge {
        public int a;// 开始顶点
        public int b;   //结束顶点
        public int value;   //权值

        Edge(int a, int b, int value) {
            this.a = a;
            this.b = b;
            this.value = value;
        }
    }
    //使用合并排序，把数组A按照其value值进行从小到大排序
    public void edgeSort(Edge[] A){
        if(A.length > 1) {
            Edge[] leftA = getHalfEdge(A, 0);
            Edge[] rightA = getHalfEdge(A, 1);
            edgeSort(leftA);
            edgeSort(rightA);
            mergeEdgeArray(A, leftA, rightA);
        }
    }
    //judge = 0返回数组A的左半边元素，否则返回右半边元素
    public Edge[] getHalfEdge(Edge[] A, int judge) {
        Edge[] half;
        if(judge == 0) {
            half = new Edge[A.length / 2];
            for(int i = 0;i < A.length / 2;i++) {
                half[i] = A[i];
            }
        } else {
            half = new Edge[A.length - A.length / 2];
            for(int i = 0;i < A.length - A.length / 2;i++) {
                half[i] = A[A.length / 2 + i];
            }
        }
        return half;
    }
    //合并leftA和rightA，并按照从小到大顺序排列
    public void mergeEdgeArray(Edge[] A, Edge[] leftA, Edge[] rightA) {
        int i = 0;
        int j = 0;
        int len = 0;
        while(i < leftA.length && j < rightA.length) {
            if(leftA[i].value < rightA[j].value) {
                A[len++] = leftA[i++];
            } else {
                A[len++] = rightA[j++];
            }
        }
        while(i < leftA.length) {
            A[len++] = leftA[i++];
        }
        while(j < rightA.length) {
            A[len++] = rightA[j++];
        }
    }

    //获取节点a的根节点编号
    public int find(int[] id, int a) {
        int i, root, k;
        root = a;
        while(id[root] >= 0) {
            root = id[root];  
        }
        k = a;
        while(k != root) {  
            i = id[k];
            id[k] = root;
            k = i;
        }
        return root;
    }
   
    public void union(int[] id, int a, int b) {
        int ida = find(id, a);   
        int idb = find(id, b);  
        int num = id[ida] + id[idb];  
        if(id[ida] < id[idb]) {
            id[idb] = ida;    
            id[ida] = num;   
        } else {
            id[ida] = idb;   
            id[idb] = num;    
        }
    }
    
    public ArrayList<Edge> getMinSpanTree(int n, Edge[] A) {
        ArrayList<Edge> list = new ArrayList<Edge>();
        int[] id = new int[n];
        for(int i = 0;i < n;i++) {
            id[i] = -1;        
        }
        edgeSort(A);   
        int count = 0;
        for (Kruskal.Edge edge : A) {
            int a = edge.a;
            int b = edge.b;
            int ida = find(id, a - 1);
            int idb = find(id, b - 1);
            if (ida != idb) {
                list.add(edge);
                count++;
                union(id, a - 1, b - 1);
            }

            for (int i : id) {
                System.out.print(i + " ");
            }
            System.out.println();

            if (count >= n - 1) {
                break;
            }
        }
        return list;
    }

    public static void main(String[] args){
        Kruskal test = new Kruskal();
        Scanner in = new Scanner(System.in);
        System.out.println("请输入顶点数a和具体边数p：");
        int n = in.nextInt();
        int p = in.nextInt();
        Edge[] A = new Edge[p];
        System.out.println("请依次输入具体边对于的顶点和权值：");
        for(int i = 0;i < p;i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int value = in.nextInt();
            A[i] = new Edge(a, b, value);
        }
        ArrayList<Edge> list = test.getMinSpanTree(n, A);
        System.out.println("使用Kruskal算法得到的最小生成树具体边和权值分别为：");
        for (Kruskal.Edge edge : list) {
            System.out.println(edge.a + "——>" + edge.b + ", " + edge.value);
        }
    }
    
}
