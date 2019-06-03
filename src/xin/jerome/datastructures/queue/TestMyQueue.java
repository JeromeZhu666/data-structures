package xin.jerome.datastructures.queue;

import xin.jerome.datastructures.queue.MyQueue;
import xin.jerome.datastructures.queue.impl.MyArrayQueue;
import xin.jerome.datastructures.queue.impl.MyLoopQueue;

import java.util.Random;

/**
 * 测试队列与循环队列的性能
 *
 * @author Jerome Zhu
 * @since 2018.10.25 22:52
 */
public class TestMyQueue {

    public static Double testQueue(MyQueue<Integer> queue, int opCount) {
        // 纳秒值
        Long startTime = System.nanoTime();

        Random random = new Random();
        System.out.println("enqueue ...");
        for (int i = 0; i < opCount; i++)
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));

        System.out.println("dequeue ...");
        for (int i = 0; i < opCount; i++) {
            queue.dequeue();
        }

        Long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    public static void main(String[] args) {
        int opCount = 1000000;

        MyArrayQueue<Integer> arrayQueue = new MyArrayQueue<>();
        double arrayQueueTime = testQueue(arrayQueue, opCount);
        System.out.println("MyArrayQueue, time:" + arrayQueueTime + "s");

        MyLoopQueue<Integer> loopQueue = new MyLoopQueue<>();
        double loopQueueTime = testQueue(loopQueue, opCount);
        System.out.println("MyLoopQueue, time:" + loopQueueTime + "s");
    }
}
