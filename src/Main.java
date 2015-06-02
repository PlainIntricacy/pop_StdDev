import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

/** Integer Population Standard Deviation Calculator
 *  Given a list of positive integers, calculate its population standard deviation
 *
 *  Based on this reddit daily challenge:
 *  https://goo.gl/NNK0Wp
 *
 *  Author: todyerutz@plainintricacy.wordpress.com
 */

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Tudor/IdeaProjects/pop_StdDev/src/numList.txt"));
        String ln;
        List<Integer> list = new ArrayList<Integer>();
        while((ln=reader.readLine())!=null){
            int sum=0;
            double avg=0.0, devsum=0.0;
            list.clear();
            System.out.println();
            System.out.println(ln);
            String[] parts = ln.split(" ");
            for(int i=0; i<parts.length; i++){
                list.add(Integer.parseInt(parts[i]));
                sum+=Integer.parseInt(parts[i]);
            }
            avg = (double)sum / (double)list.size();
            for(int i=0; i<list.size(); i++){
                devsum+=Math.pow((double) list.get(i) - avg, 2);
            }
            DecimalFormat df = new DecimalFormat("#.0000");
            System.out.println("Population Standard Deviation: " + df.format(Math.sqrt(devsum / (double) list.size())));
        }
        reader.close();
    }
}
