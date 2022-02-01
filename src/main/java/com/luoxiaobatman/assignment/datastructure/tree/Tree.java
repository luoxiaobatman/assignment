package com.luoxiaobatman.assignment.datastructure.tree;

import com.luoxiaobatman.assignment.datastructure.support.Identifier;
import com.luoxiaobatman.assignment.designpattern.behavior.vistor.Visitor;

import java.util.function.Consumer;

/**
 * 练习种树
 */
public interface Tree extends Consumer<Visitor> {
    /**
     * 是否存在改节点
     */
    boolean exists(Identifier identifier);

    int size();

    /**
     * 返回根节点, 如果没有根节点, 返回Null
     */
    Identifier getRoot();

    /**
     * 子树, 不复用子树的根节点, 复用其他子节点
     * @param identifier 子树的根节点
     * @return 树, 如果表示不存在this中, 返回null
     */
    Tree subTree(Identifier identifier);

    /**
     * 剪枝
     */
    void cut(Identifier identifier);
}
