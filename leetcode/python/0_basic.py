# ==========================================数组
# 初始化固定数组
array = [None]*3
# 添加元素
array[0] = 1
array[1] = 2
print(array)

# 初始化可变数组
array = []

# 向尾部添加元素
array.append(2)
array.append(3)
array.append(1)
array.append(0)
array.append(2)


# ==========================================链表
class ListNode:
    def __init__(self, x):
        self.val = x     # 节点值
        self.next = None # 后继节点引用


# 实例化节点
n1 = ListNode(4) # 节点 head
n2 = ListNode(5)
n3 = ListNode(1)

# 构建引用指向
n1.next = n2
n2.next = n3

# ==========================================栈
stack = [] # Python 可将列表作为栈使用

stack.append(1) # 元素 1 入栈
stack.append(2) # 元素 2 入栈
stack.pop()     # 出栈 -> 元素 2
stack.pop()     # 出栈 -> 元素 1

# ==========================================队列
# Python 通常使用双端队列 collections.deque
from collections import deque

queue = deque()

queue.append(1) # 元素 1 入队
queue.append(2) # 元素 2 入队
queue.popleft() # 出队 -> 元素 1
queue.popleft() # 出队 -> 元素 2



# ==========================================树
class TreeNode:
    def __init__(self, x):
        self.val = x      # 节点值
        self.left = None  # 左子节点
        self.right = None # 右子节点

# 初始化节点
n1 = TreeNode(3) # 根节点 root
n2 = TreeNode(4)
n3 = TreeNode(5)
n4 = TreeNode(1)
n5 = TreeNode(2)

# 构建引用指向
n1.left = n2
n1.right = n3
n2.left = n4
n2.right = n5


# ==========================================图
# ==========================================散列表
# 初始化散列表
dic = {}

# 添加 key -> value 键值对
dic["小力"] = 10001
dic["小特"] = 10002
dic["小扣"] = 10003

# 从姓名查找学号
dic["小力"] # -> 10001
dic["小特"] # -> 10002
dic["小扣"] # -> 10003


# ==========================================堆
print("="*50+"堆")
from heapq import heappush, heappop
import heapq

# 初始化小顶堆
heap = [10,8,9,10]
heapq.heapify(heap)
print(heap)


# 元素入堆
heappush(heap, 1)
heappush(heap, 4)
heappush(heap, 2)
heappush(heap, 6)
heappush(heap, 8)

# 元素出堆（从小到大）
heappop(heap)  # -> 1
heappop(heap) # -> 2
heappop(heap) # -> 4
heappop(heap) # -> 6
heappop(heap) # -> 8


# ==========================================优先队列



