import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class startDocker {

   @Test
    public void startFile() throws IOException, InterruptedException {

        boolean flag = false;

        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /c start dockerup.bat");
        Thread.sleep(5000);


        String file = "output.txt";
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MINUTE, 5);
        long stopnow = cal.getTimeInMillis();

        while (System.currentTimeMillis() < stopnow) {
            if (flag) {
                break;
            }
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String currenLine = reader.readLine();

            while (currenLine != null && !flag) {
                if (currenLine.contains("The node is registered to the hub and ready to use")) {
                    System.out.println("Read log file and found a match - setting flag to true");
                    Thread.sleep(5000);
                    flag = true;
                    break;
                }
                currenLine = reader.readLine();
            }
            reader.close();
        }
        Assert.assertTrue(flag);
        Thread.sleep(5000);

    }
}
