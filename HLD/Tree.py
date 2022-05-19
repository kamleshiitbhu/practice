# binary tree -> binary search tree or not


    # O(n)
    #O(h) -> h ==> log(n)
    


class Node:
    def __init__(self, data):
        self.data = data
        self.left = None
        self.righ = None

def isTreeBinarySearch(node):
    return isTreeBinarySearchUtils(node, 100000, 100000)


def isTreeBinarySearchUtils(node, min_value, max_value):
    if node == None:
        return True
    if node.data >= min_value and node.data <= max_value:
        return isTreeBinarySearchUtils(node.left, min_value, node.data) and isTreeBinarySearchUtils(node.right, node.data, max_value)
    return False


