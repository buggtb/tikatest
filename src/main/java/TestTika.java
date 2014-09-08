import org.apache.tika.Tika;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;
import org.apache.tika.mime.MimeTypesFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by bugg on 08/09/14.
 */
public class TestTika {



    private MimeTypes mimeTypes;
    private boolean mimeMagic;

    public TestTika() throws FileNotFoundException {


        this(Thread.currentThread().getContextClassLoader().getResourceAsStream("tika-mimetypes.xml"), true);
    }
    public TestTika(InputStream mimeIs, boolean magic) {
        try {
            this.mimeTypes = MimeTypesFactory.create(mimeIs);
            this.mimeMagic = magic;
            run();
        }catch (Exception e) {
        }
    }


    public void run() {
        Tika t = new Tika();
        URL u = null;
        try {
            u = new URL("http://svn.apache.org/repos/asf/oodt/trunk/protocol/http/src/test/org/apache/oodt/cas/protocol/http/util/");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        String ret = null;
        try {
            ret = t.detect(u);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Detected Type is: "+ret);
        try {
            System.out.println("Registered Mime Type is :" + mimeTypes.getRegisteredMimeType(ret));
        } catch (MimeTypeException e) {
            e.printStackTrace();
        }


        try {
            System.out.println("If I pass text/html :" + mimeTypes.getRegisteredMimeType("text/html"));
        } catch (MimeTypeException e) {
            e.printStackTrace();
        }

    }
}
