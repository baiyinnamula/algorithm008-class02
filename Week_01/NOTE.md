## 学习笔记

本周学习的内容主要有：数组、链表、跳表。

### 数组

##### 存储结构

顺序存储

##### 时间复杂度

Prepend：O(1)，Append：O(1)，Lookup：O(1)，Insert：O(n)，Delete：O(n)。

备注：n 是数组元素个数。

##### 缺点

插入和删除时间复杂度高，效率低。



### 链表

##### 存储结构

链式存储

##### 细分

双向链表：每个节点多了指向前一个节点的指针。

循环链表：尾结点指向头节点（判断一个链表是否循环链表或尾结点指向哪个节点的题目较多）。

静态链表：用数组描述的链表。

##### 时间复杂度

Prepend：O(1)，Append：O(1)，Lookup：O(n)，Insert：O(1)，Delete：O(1)。

##### 缺点

1. 查询时间复杂度高，效率低

2. 比数组占用更多的存储空间

3. 不支持随机访问



### 跳表

跳表其实不能算是单独的基础数据结构，它是为了提高链表的搜索效率在链表上加了多层索引。

##### 时间复杂度

跳表中查询任意数据的时间复杂度是 O(logn)。

##### 空间复杂度

O(n)：跳表其实是需要比原链表多一倍的空间来存储各级索引的。

##### 核心思想

1. 以空间换时间。
2. 升级思维（跳表其实是把原先一维的链表升级为二维的数据结构）。