
package Databases_Lambdas_Streams.Q1;

/**
 *
 * @author hp
 */
public class Q1 {

    public static void main(String[] args) {
        
        operation1 accept = (v) -> System.out.printf("%d \n", v);
        accept.operation(5);

        
        operation2 operation2 = String::toUpperCase;
        System.out.println(operation2.operation("tamer"));

        
        operation3 print = () -> {
            return "Welcome to lambdas!";
        };
        System.out.println(print.operation());

        
        operation4 operation4 = Math::sqrt;
        System.out.println(operation4.operation(25));

        
        operation5 cube = (number) -> number * number * number;
        System.out.println(cube.operation(4));
    }

    interface operation1 {

        void operation(int value);
    }

    interface operation2 {

        String operation(String text);
    }

    interface operation3 {

        String operation();
    }

    interface operation4 {

        double operation(double num);
    }

    interface operation5 {

        double operation(double num);
    }
}
