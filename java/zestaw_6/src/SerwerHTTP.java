import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class SerwerHTTP {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serv = new ServerSocket(7171);

        while (true) {
            //przyjecie polaczenia
            System.out.println("Oczekiwanie na polaczenie...");
            Socket sock = serv.accept();

            //strumienie danych
            InputStream is = sock.getInputStream();
            OutputStream os = sock.getOutputStream();
            BufferedReader inp = new BufferedReader(new InputStreamReader(is));
            DataOutputStream outp = new DataOutputStream(os);
            FileInputStream fis = null;

            //przyjecie zadania (request)
            String request = inp.readLine();
            String[] requestSplited = request.split("\\s+");

            //wyslanie odpowiedzi (response)
            if (requestSplited[0].equals("GET")) {

                if (requestSplited[1].equals("/obrazek.jpg")) {
                    //response header
                    outp.writeBytes("HTTP/1.0 200 OK\r\n");
                    outp.writeBytes("Content-Type: text/html\r\n");
                    outp.writeBytes("Content-Length: \r\n");
                    outp.writeBytes("\r\n");
                    System.out.println(Arrays.toString(requestSplited));

                    File myFile = new File ("myImage.jpg");
                    byte [] mybytearray  = new byte [(int)myFile.length()];

                    fis = new FileInputStream(myFile);
                    BufferedInputStream bis = new BufferedInputStream(fis);
                    bis.read(mybytearray,0,mybytearray.length);

                    System.out.println("Sending " + "myImage.jpg" + "(" + mybytearray.length + " bytes)");
                    os.write(mybytearray,0,mybytearray.length);
                    os.flush();
                    System.out.println("Done.");
                }

                if (requestSplited[1].equals("/")) {
                    //response header
                    outp.writeBytes("HTTP/1.0 200 OK\r\n");
                    outp.writeBytes("Content-Type: text/html\r\n");
                    outp.writeBytes("Content-Length: \r\n");
                    outp.writeBytes("\r\n");

                    //response body
                    outp.writeBytes("<html>\r\n");
                    outp.writeBytes("<H1>Strona testowa</H1>\r\n");
                    outp.writeBytes("<button>Click me</button>\r\n");
                    outp.writeBytes("<img src=\"/obrazek.jpg\" style=\"width: 200px; height: 200px;\">\r\n");
                    outp.writeBytes("</html>\r\n");
                } else if (requestSplited[1].equals("/plik")) {
                    String FILE_TO_SEND = "tekst.txt";
                    File myFile = new File(FILE_TO_SEND);
                    byte [] mybytearray  = new byte [(int)myFile.length()];

                    fis = new FileInputStream(myFile);
                    System.out.println("chce sciagnac plik");

                    BufferedInputStream bis = new BufferedInputStream(fis);
                    bis.read(mybytearray,0,mybytearray.length);
                    os = sock.getOutputStream();
                    System.out.println("Sending " + FILE_TO_SEND + "(" + mybytearray.length + " bytes)");
                    os.write(mybytearray,0,mybytearray.length);
                    os.flush();
                    System.out.println("Done.");
                    os.close();
                    fis.close();
                    inp.close();
                    outp.close();
                    sock.close();

                } else {
                    System.out.println("fetching: " + requestSplited[1].substring(1));
                    outp.writeBytes("HTTP/1.0 404 Not Found\r\n");
                    outp.writeBytes("Content-Type: text/html\r\n");
                    outp.writeBytes("Content-Length: \r\n");
                    outp.writeBytes("\r\n");

                    outp.writeBytes("<html>\r\n");
                    outp.writeBytes("<div style=\" width: 100%; text-align: center; font-size: 1.5rem; margin-top: 10em\">404 FILE NOT FOUND</div>\r\n");
                    outp.writeBytes("</html>\r\n");
                }
            } else if (requestSplited[0].equals("POST")) {
                //response header
                outp.writeBytes("HTTP/1.0 200 OK\r\n");
                outp.writeBytes("Content-Type: text/html\r\n");
                outp.writeBytes("Content-Length: \r\n");
                outp.writeBytes("\r\n");

                //response body
                outp.writeBytes("<html>\r\n");
                outp.writeBytes("<H1>POST huheuheu</H1>\r\n");
                outp.writeBytes("<img src=\"localhost:7171/obrazek.jpg\">co tam?\r\n");

                outp.writeBytes("</html>\r\n");

            } else {
                outp.writeBytes("HTTP/1.1 501 Not supported.\r\n");
            }

            //zamykanie strumieni
            inp.close();
            outp.close();
            sock.close();
        }
    }
}