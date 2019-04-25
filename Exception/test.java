package Exception;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/*
 *By: Tamer Raed Alnauizi, 120170770
 */
public class test {

    public static void test1() throws ExceptionA {
        throw new ExceptionA("ExceptionA");
    }

    public static void test2() throws ExceptionB {
        throw new ExceptionB("ExceptionB");
    }

    public static void test3() throws ExceptionC {
        throw new ExceptionC("ExceptionC");
    }

//  To NullPointerException
    public static void test4(String s) {
        System.out.println(s.toLowerCase());
    }

//  someMethod call someMethod2
    public static void someMethod(int num) throws Exception {
        someMethod2(num);
    }

//  someMethod2 throw an exception
    public static void someMethod2(int num) throws Exception {
        if (num > 20) {
            throw new Exception("value > 20");
        }
    }

    public static void main(String[] args) {

//      ExceptionA catches exceptions of types ExceptionB and ExceptionC.
        try {
            test1();
            test2();
            test3();

        } catch (ExceptionC e1) {
            System.out.println(e1.getMessage());
        } catch (ExceptionB e2) {
            System.out.println(e2.getMessage());
        } catch (ExceptionA e3) {
            System.out.println(e3.getMessage());
        }

//      To NullPointerException
        try {
            test4(null);

        } catch (NullPointerException e) {
            System.out.println("NullPointerException");
        }

//      To IOException
        File file = new File("test.txt");
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
            fileInputStream.read();
        } catch (IOException ne) {
            System.out.println("IOException");
        }

//      Test someMethod
        try {
            someMethod(50);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
