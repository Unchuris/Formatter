import com.Formatter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Simplest Formatter implementation.
 */
public final class Main {
    /**
     * default constructor.
     */
    private Main() {

     }
    /**
     * Entry method.
     * @param args filenames
     */
     public static void main(final String[] args) {
        if (args.length >= 2) {
            File sourceName = new File(args[0]);
            File destinationName = new File(args[1]);
            Formatter formatter = new Formatter();
            try {
                if (!sourceName.exists()) {
                    throw new IOException();
                }
                if (!destinationName.exists()) {
                    //destinationName.createNewFile();
                    throw new IOException();
                }
                BufferedReader source = new BufferedReader(new FileReader(sourceName));
                BufferedWriter destination = new BufferedWriter(new FileWriter(destinationName));
                formatter.format(source, destination);
                source.close();
                destination.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
