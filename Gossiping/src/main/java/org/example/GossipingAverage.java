package org.example;

import java.util.*;
import java.util.List;
import java.util.ArrayList;
class Node {
    private double totalSum;
    private int count;
    private List<Node> neighbors;
    private String name; // 为每个节点增加名称，以便跟踪

    public Node(String name, double initialValue) {
        this.name = name;
        this.totalSum = initialValue;
        this.count = 1;
        this.neighbors = new ArrayList<>();
    }

    public void addNeighbor(Node neighbor) {
        neighbors.add(neighbor);
    }

    public void gossip() {
        if (neighbors.size() == 0) return; // 如果没有邻居，返回

        Random rand = new Random();
        // 随机选择一个邻居进行 gossip
        Node neighbor = neighbors.get(rand.nextInt(neighbors.size()));

        System.out.printf("%s: Gossiping to %s with totalSum = %.2f, count = %d%n",
                this.name, neighbor.name, this.totalSum, this.count);

        // 发送当前的 totalSum 和 count 给邻居
        neighbor.receiveGossip(this.totalSum, this.count);
    }

    public void receiveGossip(double receivedSum, int receivedCount) {
        System.out.printf("%s: Received gossip with totalSum = %.2f, count = %d%n",
                this.name, receivedSum, receivedCount);

        // 更新总和和计数
        this.totalSum += receivedSum;
        this.count += receivedCount;

        System.out.printf("%s: Updated totalSum = %.2f, updated count = %d%n",
                this.name, this.totalSum, this.count);
    }

    public double getAverage() {
        return this.totalSum / this.count;
    }

    public double getTotalSum() {
        return this.totalSum;
    }

    public int getCount() {
        return this.count;
    }
}
class GossipAverage {
    public static void main(String[] args) {
        // 创建节点
        Node node1 = new Node("Node 1", 10.0);
        Node node2 = new Node("Node 2", 20.0);
        Node node3 = new Node("Node 3", 30.0);
        Node node4 = new Node("Node 4", 40.0);
        Node node5 = new Node("Node 5", 50.0);

        // 建立邻居关系
        node1.addNeighbor(node2);
        node1.addNeighbor(node3);

        node2.addNeighbor(node4);
        node3.addNeighbor(node1);
        node3.addNeighbor(node5);
        node4.addNeighbor(node2);
        node5.addNeighbor(node3);
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入 gossip 轮数：");
        int rounds = scanner.nextInt();

        // 模拟多次 gossip 过程
        for (int i = 0; i < rounds; i++) {
            System.out.println("Gossip round " + (i + 1) + ":");
            node1.gossip();
            node2.gossip();
            node3.gossip();
            node4.gossip();
            node5.gossip();
            System.out.println();
        }

        // 计算和输出平均值
        double average = (node1.getTotalSum() + node2.getTotalSum() + node3.getTotalSum() +
                node4.getTotalSum() + node5.getTotalSum()) /
                (node1.getCount() + node2.getCount() + node3.getCount() +
                        node4.getCount() + node5.getCount());

        System.out.println("Final average: " + average);
    }
}


