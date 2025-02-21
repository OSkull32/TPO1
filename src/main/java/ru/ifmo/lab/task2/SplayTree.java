package ru.ifmo.lab.task2;

import lombok.Getter;

@Getter
class SplayTree {
    static class Node {
        int key;
        Node left, right, parent;

        Node(int key) {
            this.key = key;
            this.left = this.right = this.parent = null;
        }
    }

    private Node root;

    public SplayTree() {
        this.root = null;
    }

    private void rightRotate(Node x) {
        Node y = x.left;
        x.left = y.right;
        if (y.right != null) {
            y.right.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.right) {
            x.parent.right = y;
        } else {
            x.parent.left = y;
        }
        y.right = x;
        x.parent = y;
    }

    private void leftRotate(Node x) {
        Node y = x.right;
        x.right = y.left;
        if (y.left != null) {
            y.left.parent = x;
        }
        y.parent = x.parent;
        if (x.parent == null) {
            this.root = y;
        } else if (x == x.parent.left) {
            x.parent.left = y;
        } else {
            x.parent.right = y;
        }
        y.left = x;
        x.parent = y;
    }

    private void splay(Node x) {
        while (x.parent != null) {
            if (x.parent.parent == null) {
                if (x == x.parent.left) {
                    // Zig rotation
                    rightRotate(x.parent);
                } else {
                    // Zag rotation
                    leftRotate(x.parent);
                }
            } else if (x == x.parent.left && x.parent == x.parent.parent.left) {
                // Zig-zig rotation
                rightRotate(x.parent.parent);
                rightRotate(x.parent);
            } else if (x == x.parent.right && x.parent == x.parent.parent.right) {
                // Zag-zag rotation
                leftRotate(x.parent.parent);
                leftRotate(x.parent);
            } else if (x == x.parent.right && x.parent == x.parent.parent.left) {
                // Zig-zag rotation
                leftRotate(x.parent);
                rightRotate(x.parent);
            } else {
                // Zag-zig rotation
                rightRotate(x.parent);
                leftRotate(x.parent);
            }
        }
    }

    public void insert(int key) {
        Node node = new Node(key);
        Node y = null;
        Node x = this.root;

        while (x != null) {
            y = x;
            if (node.key < x.key) {
                x = x.left;
            } else {
                x = x.right;
            }
        }

        node.parent = y;
        if (y == null) {
            this.root = node;
        } else if (node.key < y.key) {
            y.left = node;
        } else {
            y.right = node;
        }

        splay(node);
    }

    public Node search(int key) {
        Node x = this.root;
        while (x != null) {
            if (key < x.key) {
                x = x.left;
            } else if (key > x.key) {
                x = x.right;
            } else {
                splay(x);
                return x;
            }
        }
        return null;
    }

    public void delete(int key) {
        Node node = search(key);
        if (node == null) {
            return;
        }

        splay(node);

        if (node.left == null) {
            this.root = node.right;
            if (this.root != null) {
                this.root.parent = null;
            }
        } else if (node.right == null) {
            this.root = node.left;
            this.root.parent = null;
        } else {
            Node x = node.right;
            while (x.left != null) {
                x = x.left;
            }
            splay(x);
            x.left = node.left;
            x.left.parent = x;
            this.root = x;
            this.root.parent = null;
        }
    }
}