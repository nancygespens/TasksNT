import java.io.*;

public class Task2 {
    public static void main(String[] args)  throws Exception{

            String pathOne = args[0];
            String pathTwo = args[1];

            BufferedReader readerOne = new BufferedReader(new FileReader(new File(pathOne)));
            BufferedReader readerTwo = new BufferedReader(new FileReader(new File(pathTwo)));

            float x0 = 0.0f;
            float y0 = 0.0f;
            float x = 0.0f;
            float y = 0.0f;

            float r = 0.0f;

            String[] arrayS = new String[2];
            String s;
            int count = 0;

            while((s = readerOne.readLine()) != null){
                arrayS[count] = s;
                count++;
            }

            if(arrayS[0] == null || arrayS[1] == null){
                System.out.println("error entering radius or initial coordinates");
                return;
            }

            x0 = Float.parseFloat(arrayS[0].substring(0, arrayS[0].indexOf(" ")));
            y0 = Float.parseFloat(arrayS[0].substring(arrayS[0].indexOf(" ")));
            r = Float.parseFloat(arrayS[1]);
            if(r <= 0){
                System.out.println("Error radius <=0");
                return;
            }

            count = 0;
            String[] arrayS2 = new String[100];
            while((s = readerTwo.readLine()) != null){
                arrayS2[count] = s;
                count++;
            }

            for (int i = 0; i < arrayS2.length; i++) {
                if(arrayS2[i] != null) {
                    x = Float.parseFloat(arrayS2[i].substring(0, arrayS2[i].indexOf(" ")));
                    y = Float.parseFloat(arrayS2[i].substring(arrayS2[i].indexOf(" ")));
                    float f1 = (float) (Math.pow((x - x0), 2) + Math.pow((y - y0), 2));
                    if (f1 == Math.pow(r, 2)) {
                        System.out.println(0);
                    } else if (f1 < Math.pow(r, 2)) {
                        System.out.println(1);
                    } else {
                        System.out.println(2);
                    }
                }
            }

    }
}
