import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class stopDocker {

    @Test
    public void stopFile() throws IOException, InterruptedException {

        boolean flag = false;

        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /c start dockerdown.bat");
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
                if (currenLine.contains("exited with code 143")) {
                    System.out.println("Docker shutdown Complete");
                    Thread.sleep(5000);
                    flag = true;
                    break;
                }
                currenLine = reader.readLine();
            }
            reader.close();
        }
        Assert.assertTrue(flag);
        Thread.sleep(2000);
        File delfile = new File("output.txt");
        if (delfile.delete()){
            System.out.println("Output File Deleted Successfully");
        }

    }
}
