class DlinkedNode:
    def __init__(self, key=0, value=0):
        self.key = key
        self.value = value
        self.pre = None
        self.next = None

class LRUCache:
    def __init__(self, capacity):
        # 初始化
        self.capacity = capacity  # 容量
        self.head = DlinkedNode()  # 虚拟头节点
        self.tail = DlinkedNode()  # 虚拟尾节点
        self.head.next = self.tail
        self.tail.pre = self.head
        self.mySet = {}

    def put(self, key: int, value: int):
        if key in self.mySet:
            self.mySet[key].value = value
            node = self.mySet.get(key)
            self.removeNode(node)
            self.addToHead(node)
        else:
            node = DlinkedNode(key, value)
            self.addToHead(node)
            self.mySet[key] = node

        if len(self.mySet)>self.capacity:
            node = self.removeTail()
            self.mySet.pop(node.key)


    def get(self, key: int):
        if key in self.mySet:
            node = self.mySet.get(key)
            self.removeNode(node)
            self.addToHead(node)
            return node.value
        else:
            return -1


    def addToHead(self, node: DlinkedNode):
        node.pre = self.head
        node.next = self.head.next
        self.head.next.pre = node
        self.head.next = node

    def removeNode(self, node: DlinkedNode):
        node.pre.next = node.next
        node.next.pre = node.pre

    def removeTail(self):
        node = self.tail.pre
        self.removeNode(node)
        return node