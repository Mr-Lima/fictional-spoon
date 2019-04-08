package aldev.server;

import java.net.ServerSocket;
import java.net.Socket;

import aldev.pagkages.Name;

/**
 * Server
 */
public class Server implements Runnable {
  private int PORT;
  private Name[] pack;

  public Server(int port, Name[] pack) {
    this.PORT = port;
    this.pack = pack;
  }

  public void run() {

    try {
      ServerSocket server = new ServerSocket(this.PORT);
      System.out.println("SERVER INICIADO EM: " + this.PORT);

      for (Name name : pack) {
        Socket clientSocket = server.accept();
        ClientServer clientServer = new ClientServer(clientSocket, name);
        new Thread(clientServer).start();
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}