package xin.jerome.datastructures.linked;

/**
 * 自定义链表带有虚拟头结点
 *
 * @author Jerome Zhu
 * @since 2018.11.27 20:13
 */
public class MyLinkedListTwo<E> {

    /**
     * 虚拟的头结点
     */
    private Node dummyHead;
    private int size;

    /**
     * 构造函数，初始化链表对象
     */
    public MyLinkedListTwo() {
        this.dummyHead = new Node();
        this.size = 0;
    }

    /**
     * 在指定索引位置添加元素
     *
     * @param index 指定的索引
     * @param e     添加的元素
     */
    public void addIndex(int index, E e) {
        // 如果角标小于0获取越界则报错
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("索引越界了");
        }
        // 定义插入位置的前一个结点
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//        Node node = new Node(e);
//        node.next = prev.next;
//        prev.next = node;
        prev.next = new Node(e, prev.next);

        // 维护size
        size++;
    }

    /**
     * 向链表头添加元素
     *
     * @param e 添加的元素
     */
    public void addHead(E e) {
        addIndex(0, e);
    }

    /**
     * 在链表的尾部添加元素
     *
     * @param e 添加的元素
     */
    public void addLast(E e) {
        addIndex(size, e);
    }

    public E getIndex(int index) {
        // 如果角标小于0获取越界则报错
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界了");
        }
        Node cur = dummyHead;
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 获取头结点的元素
     * @return 元素内容
     */
    public E getHead() {
        return getIndex(0);
    }

    /**
     * 获取尾结点的元素
     * @return 元素内容
     */
    public E getLast() {
        return getIndex(size - 1);
    }

    /**
     * 修改指定位置的元素
     * @param index 指定的位置
     * @param e 修改后的元素
     */
    public void set(int index, E e) {
        // 如果角标小于0获取越界则报错
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界了");
        }
        Node idnexNode = dummyHead;
        for (int i = 0; i <= index; i++) {
            idnexNode = idnexNode.next;
        }
        idnexNode.e = e;

    }

    /**
     * 删除指定位置的元素
     * @param index 指定位置
     * @return 删除元素
     */
    public E del(int index) {
        // 如果角标小于0获取越界则报错
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("索引越界了");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    /**
     * 判断是否包含某个元素
     * @param e 查找的元素
     * @return 布尔值
     */
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node cur = dummyHead.next;
        while (cur != null) {
            sb.append(cur.e + "->");
            cur = cur.next;
        }
        sb.append("null");
        return sb.toString();
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