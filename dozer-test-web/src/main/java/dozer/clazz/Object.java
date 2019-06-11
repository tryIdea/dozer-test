package dozer.clazz;

/**
 * @author dufugang
 * @create 2019-06-10 16:21
 */
public class Object {
    static {
        System.out.println("object init");
    }

    public static int val = 1;

    public static void main(String[] args) {
        System.out.println(Object.val);
    }
}
