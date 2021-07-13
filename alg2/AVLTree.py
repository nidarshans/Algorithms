import sys
class Node:
    def __init__(self, value, obj = None, parent = None) -> None:
        self.key = value
        self.obj = [obj]
        self.left = None
        self.right = None
        self.parent = parent
        self.childType = None
        if parent != None:
            self.childType = 'L' if parent.key > value else 'R'
        self.height = 1
class AVLTree:
    def __init__(self) -> None:
        self.root = None
    def get_height(self, node: Node):
        return node.height if node != None else 0
    def insert(self, root: Node, key: int, obj = None) -> Node:
        if root is None:
            root = Node(key, obj)
            return root
        itr = root
        path = []
        while itr != None:
            path.append(itr)
            if key < itr.key:
                if itr.left != None:
                    itr = itr.left
                else:
                    itr.left = Node(key, obj, itr)
                    path.append(itr.left)
                    break
            elif key > itr.key:
                if itr.right != None:
                    itr = itr.right
                else:
                    itr.right = Node(key, obj, itr)
                    path.append(itr.right)
                    break
            else:
                itr.obj.append(obj)
                return root
        node = path.pop()
        parent = node.parent
        while len(path) >= 0:
            node.height = 1 + max(self.get_height(node.left), self.get_height(node.right))
            balance = self.get_height(node.left) - self.get_height(node.right)
            if balance > 1:
                if key < node.left.key:
                    if node.childType == 'L':
                        parent.left = self.right_rotate(node, parent)
                    elif node.childType == 'R':
                        parent.right = self.right_rotate(node, parent)
                    else:
                        node = self.right_rotate(node, parent)
                else:
                    node.left = self.left_rotate(node.left, parent)
                    if node.childType == 'L':
                        parent.left = self.right_rotate(node, parent)
                    elif node.childType == 'R':
                        parent.right = self.right_rotate(node, parent)
                    else:
                        node = self.right_rotate(node, parent)
            if balance < -1:
                if key > node.right.key:
                    if node.childType == 'L':
                        parent.left = self.left_rotate(node, parent)
                    elif node.childType == 'R':
                        parent.right = self.left_rotate(node, parent)
                    else:
                        node = self.left_rotate(node, parent)
                else:
                    node.right = self.right_rotate(node.right, parent)
                    if node.childType == 'L':
                        parent.left = self.left_rotate(node, parent)
                    elif node.childType == 'R':
                        parent.right = self.left_rotate(node, parent)
                    else:
                        node = self.left_rotate(node, parent)
            #self.printHelper(self.root, "", True)
            #print(f'{node.key} {parent.key}')
            if len(path) == 0:
                break
            if len(path) > 0:
                node = path.pop()
                parent = node.parent
        return node
    def set_child(self, n: Node):
        if n.parent != None:
            return 'L' if n.parent.key > n.key else 'R'
        else:
            return None
    def left_rotate(self, root: Node, parent: Node):
        if root is None:
            return root
        temp = root
        root = root.right
        temp.right = root.left
        root.left = temp
        temp.height = 1 + max(self.get_height(temp.left), self.get_height(temp.right))
        root.height = 1 + max(self.get_height(root.left), self.get_height(root.right))
        temp.parent = root
        root.parent = parent
        temp.childType = self.set_child(temp)
        root.childType = self.set_child(root)
        return root
    def right_rotate(self, root: Node, parent: Node):
        if root is None:
            return root
        temp = root
        root = root.left
        temp.left = root.right
        root.right = temp
        temp.height = 1 + max(self.get_height(temp.left), self.get_height(temp.right))
        root.height = 1 + max(self.get_height(root.left), self.get_height(root.right))
        temp.parent = root
        root.parent = parent
        temp.childType = self.set_child(temp)
        root.childType = self.set_child(root)
        return root
    def preOrder(self, root):
        if not root:
            return
        print("{0} ".format(root.key), end="")
        self.preOrder(root.left)
        self.preOrder(root.right)
    def printHelper(self, currPtr, indent, last):
        if currPtr != None:
            sys.stdout.write(indent)
            if last:
                sys.stdout.write("R----")
                indent += "     "
            else:
                sys.stdout.write("L----")
                indent += "|    "
            print((currPtr.key))
            self.printHelper(currPtr.left, indent, False)
            self.printHelper(currPtr.right, indent, True)
    def isBalanced(self, root: Node) -> bool:
        self.Balanced = True
        if not root:
            return self.Balanced
        self.maxDepth(root)
        return self.Balanced
    def maxDepth(self, root):
        if not root:
            return 0
        else:
            ldepth = self.maxDepth(root.left)
            rdepth = self.maxDepth(root.right)
            if abs(ldepth - rdepth) >= 2:
                self.Balanced = False
            return max(ldepth, rdepth) + 1
'''
T = AVLTree()
for i in range(0, 10):
    T.root = T.insert(T.root, i)
#T.preOrder(T.root)
T.printHelper(T.root, "", True)
if T.isBalanced(T.root):
   print("Balanced")
else:
   print("Not Balanced")
'''