package xin.jerome.datastructures.stack.impl;

import xin.jerome.datastructures.stack.MyStack;
import xin.jerome.datastructures.linked.MyLinkedList;

/**
 * {@link MyStack}链表{@link MyLinkedList}实现
 *
 * @author Jerome Zhu
 * @since 2019.06.03 15:52
 */
public class MyLinkedListStack<E> implements MyStack<E>{

    /**
     * 存放栈中元素的容器
     */
    private MyLinkedList<E> list;

    /**
     * 构造函数
     */
    public MyLinkedListStack() {
        list = new MyLinkedList<>();
    }

    @Override
    public void push(E e) {
        list.addHead(e);
    }

    @Override
    public E pop() {
        return list.del(0);
    }

    @Override
    public E peek() {
        return list.getHead();
    }

    @Override
    public int size() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("MyLinkedListStack: top ");
        sb.append(list);
        return sb.toString();
    }
}
