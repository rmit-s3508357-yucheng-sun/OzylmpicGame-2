/*
 * @author YI YANG s3520987
 */

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteFileUtils {

    static File f = new File("d:\\gameresults.txt");

    public static void writeFile(String str) throws Exception {
        Writer out = new FileWriter(f, true);
        out.write(str);

        if (out != null) {
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static void writeFile(File f,String str) throws Exception {
        Writer out = new FileWriter(f, true);
        out.write(str);

        if (out != null) {
            try {
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
