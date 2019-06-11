package dozer.clazz;

/**
 * @author dufugang
 * @create 2019-06-10 17:52
 */
public class StaticDispatch {
    static abstract class Human{

    }

    static class Man extends Human{

    }

    static class Women extends Human{

    }

    public void sayHello(Human guy) {
        System.out.println("hello guy!");
    }

    public void sayHello(Man man) {
        System.out.println("gentle man!");
    }

    public void sayHello(Women women){
        System.out.println("hello lady!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human women = new Women();

        StaticDispatch sd = new StaticDispatch();
        sd.sayHello(man);
        sd.sayHello(women);
    }
}
