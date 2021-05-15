import collections


class LRUCache(collections.OrderedDict):
    def __init__(self, capacity: int):
        super().__init__()
        self.capacity = capacity

    def get(self, key: int) -> int:
        if key not in self:
            return -1
        self.move_to_end(key)
        return self[key]

    def put(self, key: int, value: int) -> None:
        if key in self:
            self.move_to_end(key)
        self[key] = value
        if len(self) > self.capacity:
            self.popitem(last=False)


lRUCache = LRUCache(2)
lRUCache.put(1, 1)
lRUCache.put(2, 2)
assert lRUCache.get(1) == 1
lRUCache.put(3, 3)
assert lRUCache.get(2) == -1
lRUCache.put(4, 4)
assert lRUCache.get(1) == -1
assert lRUCache.get(3) == 3
assert lRUCache.get(4) == 4
print("OK")