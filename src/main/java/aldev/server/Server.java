package aldev.server;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server
 */
public class Server implements Runnable {
  private int PORT;

  public Server(int port) {
    this.PORT = port;
  }

  public void run() {

    try {
      ServerSocket server = new ServerSocket(this.PORT);
      System.out.println("SERVER INICIADO EM: " + this.PORT);

      do {

        Socket clientSocket = server.accept();
        ClientServer clientServer = new ClientServer(clientSocket);
        clientServer.run();
      } while (true);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}