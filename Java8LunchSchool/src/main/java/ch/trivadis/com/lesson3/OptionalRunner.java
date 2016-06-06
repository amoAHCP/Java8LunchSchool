package ch.trivadis.com.lesson3;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

/**
 * Created by Andy Moncsek on 06.06.16.
 */
public class OptionalRunner {

    public static void main(String[] args) {
        OptionalRunner runner = new OptionalRunner();
        runner.step1();
        runner.step2();
        runner.step3();
        runner.step4();
        runner.step5();

    }

    /**
     * This will cause a NoSuchElementException
     */
    public  void step1() {
        Optional op = ofNullable(null);
        try {
            op.get();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * This is valid, but has no value over if-than-else
     */
    public  void step2() {
        String value = null;
        Optional op = ofNullable(value);
        if(op.isPresent()) {
            op.get();
        }


        // same as
        if(value !=null) {
             //.....
        }

    }

    /**
     * Create always Non-Null values
     */
    public  void step3() {
        String value = null;
        String v2 = ofNullable(value).orElse("Hello");
        // v2 never will be NULL
        System.out.println(v2.toString());

        String v3 = ofNullable(value).orElseGet(()->{
            if(v2!=null) return v2;
            return "us a String supplier";
        });
        // v3 never will be NULL
        System.out.println(v3.toString());
    }

    /**
     * safe operations
     */
    public  void step4() {
        ofNullable("Hello").ifPresent(value -> System.out.println(value));

        char[] characterValues = Optional.ofNullable("Hello").map(stringValue-> stringValue.toCharArray()).orElse(new char[]{'x','y'});
        System.out.println(String.valueOf(characterValues));
    }

    /**
     * common usage
     */
    public  void step5() {
       MyService service = new MyService();

        Optional.ofNullable(service.getPersonIds()).ifPresent(list -> {
            for(String s: list) {
                System.out.println(s);
            }
            service.getNullSavePersonIds().ifPresent(nullSafe-> {
                // do something else
            });
        });

    }


    protected class MyService{

        public List<String> getPersonIds() {
            return Arrays.asList("id01","id02");
        }

        public Optional<List<String>> getNullSavePersonIds() {
            return Optional.of(Arrays.asList("id01","id02"));
        }
    }
}
