package dozer.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 运行时常量池内存溢出
 *
 * @author dufugang
 * @create 2019-06-05 14:27
 */
public class RuntimeConstantPoolOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
            break;
        }
    }
}
