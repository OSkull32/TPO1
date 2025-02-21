package ru.ifmo.lab.task2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SplayTreeTest {

    @Test
    void testInsert() {
        SplayTree tree = new SplayTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        assertEquals(30, tree.getRoot().key);
        assertEquals(20, tree.getRoot().left.key);
        assertEquals(10, tree.getRoot().left.left.key);
    }

    @Test
    void testSearch() {
        SplayTree tree = new SplayTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        assertNotNull(tree.search(20));
        assertEquals(20, tree.getRoot().key);
        assertEquals(10, tree.getRoot().left.key);
        assertEquals(30, tree.getRoot().right.key);
    }

    @Test
    void testDelete() {
        SplayTree tree = new SplayTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);

        tree.delete(20);

        assertEquals(30, tree.getRoot().key);
        assertEquals(10, tree.getRoot().left.key);
        assertNull(tree.getRoot().right);
    }

    @Test
    void testSplayOperations() {
        SplayTree tree = new SplayTree();
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);

        assertNotNull(tree.search(30));
        assertEquals(30, tree.getRoot().key);
        assertEquals(20, tree.getRoot().left.key);
        assertEquals(40, tree.getRoot().right.key);
        assertEquals(10, tree.getRoot().left.left.key);
        assertEquals(50, tree.getRoot().right.right.key);
    }
}