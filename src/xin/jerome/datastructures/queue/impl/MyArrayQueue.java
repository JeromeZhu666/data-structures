package xin.jerome.datastructures.queue.impl;

import xin.jerome.datastructures.array.MyGenericArray;
import xin.jerome.datastructures.queue.MyQueue;

/**
 * {@link MyQueue} 实现
 *
 * @author Jerome Zhu
 * @since 2018.10.25 21:23
 */
public class MyArrayQueue<E> implements MyQueue<E> {

    /**
     * 存储队列元素的容器
     */
    private MyGenericArray<E> array;

    /**
     * 无参构造，使用数组的默认长度
     */
    public MyArrayQueue() {
        this.array = new MyGenericArray<>();
    }

    /**
     * 根据参数初始化队列
     *
     * @param capacity 初始容量大小
     */
    public MyArrayQueue(int capacity) {
        this.array = new MyGenericArray<>(capacity);
    }

    @Override
    public void enqueue(E e) {
        array.addToLast(e);
    }

    @Override
    public E dequeue() {
        return array.deleteFirst();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int size() {
        return array.getSize();
    }

    @Override
    public boolean isEmpty() {
        return array.isEmpty();
    }

    /**
     * 获取队列的容量
     * @return 容量的大小
     */
    public int getCapacity() {
        return array.getCapacity();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MyArrayQueue: front[");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if(i != array.getSize() - 1)
                sb.append(",");
        }
        sb.append("] tail");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyArrayQueue<Integer> queue = new MyArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);
            if (i % 3 == 0) {
                Integer e = queue.dequeue();
                System.out.println(String.format("Integer : %d dequeue .", e));
            }
        }
    }
}
