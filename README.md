# Gossiping
根据gossip协议实现的去中心化的平均数算法
基于Gossip协议的平均值计算
该项目实现了一个简单的Gossip协议模拟，以计算分布在多个节点上的值的平均数。每个节点可以与其邻居进行通信，以共享其总值和计数，最终达成所有节点共同的平均值。

概述
项目主要包含两个类：

Node：表示网络中的一个节点。每个节点具备：

名称
值的总和
已接收消息或值的计数
一组可以进行Gossip消息发送的邻居节点。
GossipAverage：主类，负责：

创建节点网络
建立节点间的通信（邻居关系）
模拟多轮Gossip通信
在所有Gossip轮结束后计算并打印最终的平均值。
特性
随机Gossip协议，每个节点随机选择一个邻居进行通信。
在接收Gossip消息时更新总和和计数。
计算所有节点累计数据后的最终平均值。
如何运行项目
克隆仓库：

bash
git clone https://github.com/你的用户名/gossip-average.git  
cd gossip-average  
编译和运行：
确保您的计算机上已安装Java开发工具包（JDK）。您可以使用以下命令编译和运行程序：

bash
javac org/example/GossipAverage.java  
java org.example.GossipAverage  
输入：程序会提示您输入想要模拟的Gossip轮数。

示例输出
当程序运行时，您将看到类似以下的输出：

ini
请输入 gossip 轮数：5  
Gossip round 1:  
Node 1: Gossiping to Node 2 with totalSum = 10.00, count = 1  
Node 2: Received gossip with totalSum = 10.00, count = 1  
Node 2: Updated totalSum = 30.00, updated count = 2  
...  

Final average: 30.00  
需求
Java开发工具包（JDK）版本8或以上。

