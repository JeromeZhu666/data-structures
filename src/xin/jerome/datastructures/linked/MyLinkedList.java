package xin.jerome.datastructures.linked;

/**
 * 自定义链表
 *
 * @author Jerome Zhu
 * @since 2018.11.27 20:13
 */
public class MyLinkedList<E> {

    private Node head;
    private int size;

    /**
     * 构造函数，初始化链表对象
     */
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    /**
     * 向链表头添加元素
     *
     * @param e 添加的元素
     */
    public void addHead(E e) {
//        Node node = new Node(e);
//        node.next = head;
//        head = node;
        head = new Node(e, head);
        size++;
    }

    /**
     * 在指定索引位置添加元素
     *
     * @param index 指定的索引
     * @param e     添加的元素
     */
    public void addIndex(int index, E e) {
        // 如果角标小于0获取越界则报错
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界了");
        }
        if (index == 0) {
            addHead(e);
        } else {
            // 定义插入位置的前一个结点
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
            prev.next = new Node(e, prev.next);

            // 维护size
            size++;
        }
    }

    /**
     * 在链表的尾部添加元素
     * @param e 添加的元素
     */
    public void addLast(E e) {
        addIndex(size, e);
    }

    /**
     * 获取链表的大小
     *
     * @return 链表的大小
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取链表是否为空
     *
     * @return 布尔值
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 私有的结点类
     */
    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }
}