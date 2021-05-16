class Trie:

    def __init__(self):
        """
        Initialize your data structure here.
        """
        self.end = False
        self.children = [None]*26

    def insert(self, word: str) -> None:
        """
        Inserts a word into the trie.
        """
        node = self
        for ch in word:
            index = ord(ch) - ord("a")
            if not node.children[index]:
                node.children[index] = Trie()

            node = node.children[index]
        node.end = True

    def search(self, word: str) -> bool:
        """
        Returns if the word is in the trie.
        """
        node = self.search_node(word)
        if node:
            return node.end
        else:
            return False

    def startsWith(self, prefix: str) -> bool:
        """
        Returns if there is any word in the trie that starts with the given prefix.
        """
        node = self.search_node(prefix)
        if node is not None:
            return True
        else:
            return False

    def search_node(self, predix: str) -> "Trie":
        node = self
        for ch in predix:
            index = ord(ch) - ord("a")
            if not node.children[index]:
                return None
            else:
                node = node.children[index]
        return node

