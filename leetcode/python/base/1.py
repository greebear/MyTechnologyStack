class Node:
    def __init__(self, key):
        self.key = key
        self.pre = None
        self.next = None


class LRUCache:

    def __init__(self, capacity: int):
        self.map = dict()
        self.capacity = capacity
        self.head = Node(-1)
        self.tail = Node(-1)
        self.head.next = self.tail
        self.tail.pre = self.head

    def get(self, key: int) -> int:
        if key in self.map.keys():
            node = self.head
            while node:
                if key == node.key:
                    self.removeNode(node)
                    break
                node = node.next
            self.moveToHead(node)
            return self.map[key]
        else:
            return -1

    def put(self, key: int, value: int) -> None:
        if key in self.map.keys():
            self.map.pop(key)
            node = self.head
            while node:
                if key == node.key:
                    self.removeNode(node)
                node = node.next

        node = Node(key)
        self.addToHead(node)
        self.map[key] = value
        if len(self.map) > self.capacity:
            key = self.removeTail()
            self.map.pop(key)

    def addToHead(self, node):
        node.next = self.head.next
        node.pre = self.head
        self.head.next.pre = node
        self.head.next = node

    def removeNode(self, node):
        node.next.pre = node.pre
        node.pre.next = node.next

    def moveToHead(self, node):
        self.removeNode(node)
        self.addToHead(node)

    def removeTail(self):
        node = self.tail.pre
        self.removeNode(node)
        return node.key

# ["LRUCache","put","put","get","put","get","put","get","get","get"]
# [[2],[1,0],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]]
# lrucache = LRUCache(2)
# lrucache.put(1,0)
# lrucache.put(2,2)
# print(lrucache.get(1))
