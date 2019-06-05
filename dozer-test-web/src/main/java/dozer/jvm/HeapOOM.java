package dozer.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆内存溢出异常测试
 * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 *
 * @author dufugang
 * @create 2019-06-05 12:26
 */
public class HeapOOM {
    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
