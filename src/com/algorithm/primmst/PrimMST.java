package com.algorithm.primmst;

public class PrimMST {
    private static int MAX = 50;   // 最大结点个数
    private static int GIGANTIC = 99999;    // 定义为无穷大
    private static int[][] graph = new int [MAX][MAX];
    private int[] lowCost = new int[MAX];   // 到达j结点的最低花费
    private int[] previousNode = new int[MAX];  // j结点的上一个结点
    private int minCost = 0;    // 最小成本
    private static int n;   // 结点个数
    private int middleNode; // 中间结点
    private int sum = 0;    // 记录最小生成树的总权重

    /**
     * Prim算法，返回最小生成树的总权重。
     * @param graph
     * @param n
     * @return sum
     */
    public int prim(int[][] graph, int n) {
        // 邻接矩阵，有权值的（直接相邻的）赋权值。没有权值的（非直接相邻的）赋无穷大值
        for (int i=1; i <= n; i++) {
            for (int j=1; j <= n; j++) {
                if (graph[i][j] == 0) {
                    graph[i][j] = GIGANTIC;
                }
            }
        }
        // 所有点默认起点是A
        for (int i = 2; i <= n; i++) {
            lowCost[i] = graph[1][i];
            previousNode[i] = 1;
        }
        previousNode[1] = 0;
        // 进行n-1次循环运算
        for (int i = 2; i <= n; i++) {
            minCost = GIGANTIC;
            middleNode = 0;

            // 找出最小的lowCost
            for (int j = 2; j <= n; j++) {
                if (lowCost[j] != 0 && lowCost[j] < minCost) {
                    minCost = lowCost[j];
                    middleNode = j;
                }
            }
            System.out.println(previousNode[middleNode] + "<-->" + middleNode + ", weight: " + minCost);
            sum += minCost;

            // lowCost[middleNode] = 0; previousNode[middleNode] = 0;表示middleNode被选入最小生成树
            lowCost[middleNode] = 0;
            previousNode[middleNode] = 0;

            // middleNode加入最小生成树，更新lowCost与previousNode
            for (int j = 2; j <= n; j++) {
                if (graph[middleNode][j] < lowCost[j]) {
                    lowCost[j] = graph[middleNode][j];
                    previousNode[j] = middleNode;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        // 设置图。A: 1, B: 2, C: 3, D: 4, E: 5, F: 6, G: 7, H: 8
        graph[1][2] = 4;
        graph[1][3] = 3;

        graph[2][1] = 4;
        graph[2][3] = 5;
        graph[2][4] = 5;
        graph[2][5] = 9;

        graph[3][1] = 3;
        graph[3][2] = 5;
        graph[3][4] = 5;
        graph[3][8] = 5;

        graph[4][2] = 5;
        graph[4][3] = 5;
        graph[4][5] = 7;
        graph[4][8] = 4;
        graph[4][7] = 5;
        graph[4][6] = 6;

        graph[5][2] = 9;
        graph[5][4] = 7;
        graph[5][6] = 3;

        graph[6][5] = 3;
        graph[6][4] = 6;
        graph[6][7] = 2;

        graph[7][6] = 2;
        graph[7][4] = 5;
        graph[7][8] = 6;

        graph[8][3] = 5;
        graph[8][4] = 4;
        graph[8][7] = 6;

        PrimMST primMST = new PrimMST();
        int mstCost = primMST.prim(graph, 8);
        System.out.println("最小生成树的权值为：" + mstCost);
    }
}
