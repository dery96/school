import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serv = new ServerSocket(7676);

        while (true) {
            //przyjecie polaczenia
            System.out.println("Oczekiwanie na polaczenie...");
            Socket sock = serv.accept();

            //strumienie danych
            InputStream is = sock.getInputStream();
            OutputStream os = sock.getOutputStream();
            BufferedReader inp = new BufferedReader(new InputStreamReader(is));
            DataOutputStream outp = new DataOutputStream(os);

            //przyjecie zadania (request)
            String request = inp.readLine();

            //wyslanie odpowiedzi (response)
            if (request.startsWith("GET")) {
                //response header
                outp.writeBytes("HTTP/1.0 200 OK\r\n");
                outp.writeBytes("Content-Type: text/html\r\n");
                outp.writeBytes("Content-Length: \r\n");
                outp.writeBytes("\r\n");

                //response body
                outp.writeBytes("<html>\r\n");
                outp.writeBytes("<H1>Strona testowa</H1>\r\n");
                outp.writeBytes("</html>\r\n");
            } else {
                outp.writeBytes("HTTP/1.1 501 Not supported.\r\n");
            }

            inp.close();
            outp.close();
            sock.close();
        }
    }
}
