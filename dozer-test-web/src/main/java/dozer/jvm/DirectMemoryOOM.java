package dozer.jvm;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 直接内存溢出异常
 *
 * @author dufugang
 * @create 2019-06-05 14:41
 */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);

        while (true) {
            unsafe.allocateMemory(_1MB);
        }
    }
}
