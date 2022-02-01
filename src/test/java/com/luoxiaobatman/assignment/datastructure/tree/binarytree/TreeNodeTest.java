package com.luoxiaobatman.assignment.datastructure.tree.binarytree;

import com.luoxiaobatman.assignment.datastructure.support.CharacterIdentifier;
import com.luoxiaobatman.assignment.datastructure.support.Identifier;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TreeNodeTest {
    private Identifier childIdentifier = new CharacterIdentifier('c');
    private Identifier parentIdentifier = new CharacterIdentifier('p');

    @Test
    void setLeftChild() {
        TreeNode parentNode = new TreeNode(parentIdentifier);
        parentNode.setLeftChild(childIdentifier);
        assertEquals(childIdentifier, parentNode.getLeftChild());
        assertEquals(parentNode.adjacent().size(), 1);
        assertTrue(parentNode.adjacent().contains(childIdentifier));

        parentNode.setLeftChild(null);
        assertNull(parentNode.getLeftChild());
        assertEquals(parentNode.adjacent().size(), 0);
    }

    @Test
    void setRightChild() {
        TreeNode parentNode = new TreeNode(parentIdentifier);
        parentNode.setRightChild(childIdentifier);
        assertEquals(childIdentifier, parentNode.getRightChild());
        assertEquals(parentNode.adjacent().size(), 1);
        assertTrue(parentNode.adjacent().contains(childIdentifier));

        parentNode.setRightChild(null);
        assertNull(parentNode.getRightChild());
        assertEquals(parentNode.adjacent().size(), 0);
    }
}