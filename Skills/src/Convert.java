import java.io.*;

public class Convert {
    public static void main (String[] args){
        InputStreamReader isr = null;
        BufferedReader br = null;
        InputStream is = new ByteArrayInputStream("We are the world, We are the children".getBytes());

        StringBuilder sb = new StringBuilder();
        String con;
        try {
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);

            while ((con =  br.readLine()) != null){
                sb.append(con);
            }
        }catch (IOException ioe){
            System.out.println("Exception has occurred on the IO side shun!");
            ioe.printStackTrace();
        }
        String s = sb.toString();
        System.out.println(s);
    }

}
