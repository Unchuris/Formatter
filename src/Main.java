import java.io.*;
import com.Formatter;
/**
 * Created by vlad on 19.10.16.
 */
public class Main {

    public static void main(String[] args) {
        if (args.length >= 2) {
            File sourceName = new File(args[0]);
            File destinationName = new File(args[1]);
            Formatter formatter = new Formatter();
            try {
                if (!sourceName.exists()) {
                    throw new IOException();
                }
                if (!destinationName.exists()) {
                    destinationName.createNewFile();
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