import java.io.FileNotFoundException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        try {
            TestTika t =new TestTika();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
