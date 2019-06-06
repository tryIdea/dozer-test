package dozer.jvm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * -Xms100m -Xmx100m -XX:+UseSerialGC
 *
 * @author dufugang
 * @create 2019-06-06 15:17
 */
public class ConsoleTest {
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Thread.sleep(50);
            list.add(new OOMObject());
        }

        System.gc();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        //        fillHeap(1000);
        //        while (true){
        //            System.out.println("continue");
        //        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();

        createBusyThread();

        br.readLine();

        Object obj = new Object();
        createLockThread(obj);
    }

    /**
     * 线程死循环显示
     */
    public static void createBusyThread() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ;
                }
            }
        }, "testBusyThread");

        thread.start();
    }

    /**
     * 线程锁等待演示
     *
     * @param lock
     */
    public static void createLockThread(final Object lock) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (lock) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }, "testLockThread");

        thread.start();
    }
}
