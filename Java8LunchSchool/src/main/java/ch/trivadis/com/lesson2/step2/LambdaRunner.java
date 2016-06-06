package ch.trivadis.com.lesson2.step2;

/**
 * Created by Andy Moncsek on 06.06.16.
 */
public class LambdaRunner {

    public static void main(String[] args) {
        LambdaRunner runner = new LambdaRunner();
        runner.testConsumer(value -> System.out.println(value));
        runner.testTriConsumer((a,b,c) -> System.out.println(a+(b+2)+c));
        runner.testTriConsumer2((a,b,c) -> System.out.println(a+(b+3)+c));
    }

    public void testConsumer(CustomConsumer<String> c) {
        c.consume("hello world");
    }

    public void testTriConsumer(CustomTriConsumer<String, Integer, String> c) {
         c.consume("Hello ",1," World");
    }

    public void testTriConsumer2(CustomTriConsumer<String, Integer, String> c) {
        c.consume(c.convert('H','e','l','l','o',' '),1," World");
    }
}
