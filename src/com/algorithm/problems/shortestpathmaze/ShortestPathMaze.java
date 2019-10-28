package com.algorithm.problems.shortestpathmaze;

import com.algorithm.queue.arrayqueue.ArrayQueue;

// 最短路径迷宫问题，使用逆向搜索，记录父节点，最后把(1, 1)的父节点们打印出来
public class ShortestPathMaze {
    int[][] maze = {
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 1, 0, 0, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 1, 0},
            {0, 1, 0, 1, 1, 0, 1, 0},
            {0, 1, 0, 1, 0, 1, 0, 0},
            {0, 1, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 1, 1, 1, 1, 0},
            {0, 0, 0, 0, 0, 0, 0, 0}
    };

    ArrayQueue<Node> nodeArrayQueue = new ArrayQueue<>();

    private class Node {
        public int line;    // 此Node的行索引
        public int column;  // 此Node的列索引
        public Node parentNode; // 父Node（谁检索到的此Node，谁就是父Node）
        public int step;    // 此Node距离起始点的步长

        @Override
        public String toString() {
            StringBuilder nodeStrBuilder = new StringBuilder();
            nodeStrBuilder.append("(" + this.line + ", " + this.column + ')');
            if (this.parentNode != null) {
                nodeStrBuilder.append(" -> ");
                nodeStrBuilder.append(this.parentNode);
            }
            return nodeStrBuilder.toString();
        }

        // new 一个新Node时，传入该Node的：行索引，列索引，此Node距离起始点的步长，父Node（谁检索到的此Node，谁就是父Node）
        public Node(int line, int column, int step, Node parentNode) {
            this.line = line;
            this.column = column;
            this.step = step;
            this.parentNode = parentNode;
        }
    }

    public void BFS() {
        nodeArrayQueue.enqueue(new Node(6, 6, 0, null));   // 起始点Node(7, 7)入队
        int[] dl = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dc = {-1, -1, 0, 1, 1, 1, 0, -1};

        int flag = 0;   // 指示灯，用于在找到endNode时从循环中跳出
        while (!nodeArrayQueue.isEmpty()) {
            for (int i=0; i<8; i++) {
                Node centerNode = nodeArrayQueue.getFront();    // 中心Node
                int nextLine = centerNode.line + dl[i];    // 下一个Node的纵坐标
                int nextColumn = centerNode.column + dc[i];  // 下一个Node的横坐标
                int nextStep = centerNode.step + 1; // 下一个Node距离起始点的步长

                // 找到终点endNode: (1, 1)
                if (nextLine == 1 && nextColumn == 1) {
                    Node endNode = new Node(nextLine, nextColumn, nextStep, centerNode);
                    maze[nextLine][nextColumn] = 0;
                    System.out.println("此迷宫最短路径为：");
                    System.out.println(endNode);
                    System.out.println("步长：" + endNode.step);
                    flag = 1;
                    break;
                }
                int nextMazeContent = maze[nextLine][nextColumn];
                if (nextMazeContent != 0) {
                    nodeArrayQueue.enqueue(new Node(nextLine, nextColumn, nextStep, centerNode));
                    maze[nextLine][nextColumn] = 0;
                }
            }
            if (flag == 1) {
                break;
            }
            nodeArrayQueue.dequeue();
        }
        if (flag == 0) {
            System.out.println("抱歉，没有找到通路");
        }
    }
}
