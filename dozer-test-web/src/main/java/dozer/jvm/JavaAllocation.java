package dozer.jvm;

/**
 * 新生代minor GC
 * -XX:PretenureSizeThreshold=3145728
 * -XX:MaxTenuringThreshold=1
 * @author dufugang
 * @create 2019-06-05 18:15
 */
public class JavaAllocation {
    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() {
        byte[] a1, a2, a3, a4;
        a1 = new byte[2 * _1MB];
        a2 = new byte[2 * _1MB];
        a3 = new byte[2 * _1MB];
        a4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
