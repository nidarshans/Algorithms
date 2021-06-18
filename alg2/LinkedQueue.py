class Node:
    def __init__(self, val) -> None:
        self.val = val
        self.next = None
        self.prev = None
class LinkedQ:
    def __init__(self) -> None:
        self.head = None
        self.tail = None
        self.size = 0
    def append(self, val):
        if self.head is None or self.size == 0:
            self.head = Node(val)
            self.tail = self.head
        else:
            temp = self.head
            self.head = Node(val)
            self.head.next = temp   
            temp.prev = self.head
        self.size += 1
    def pop(self) -> Node:
        if self.size == 0:
            return
        if self.size == 1:
            val = self.tail
            self.tail.next = None
            self.tail.prev = None
            self.tail = self.head = None
            self.size -= 1
            return val
        temp = self.tail
        self.tail = self.tail.prev
        self.tail.next = None
        self.size -= 1
        return temp
    def print(self):
        ptr = self.head
        array = []
        while ptr != None:
            array.append(ptr.val)
            ptr = ptr.next
        print(array)