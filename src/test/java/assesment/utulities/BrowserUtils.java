package assesment.utulities;

public class BrowserUtils {

    /*
We will create utility methods for repeated steps that can be used
in browsers, and store in this class.
 */

        //create method name: wait
        //converting milliseconds to seconds
        //handle checked exception

        public static void sleep(int second) {
            second *= 1000;
            try {
                Thread.sleep(second);
            } catch (InterruptedException e) {
                System.out.println("something happened in sleep method");

            }
        }

    }
