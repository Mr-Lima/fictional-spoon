package aldev.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * Client
 */
public class Client {

  private Socket socket;
  private ObjectOutputStream os;
  private ObjectInputStream is;

  public Client(Socket socket) {
    this.socket = socket;
    try {
      this.os = new ObjectOutputStream(socket.getOutputStream());
      this.is = new ObjectInputStream(socket.getInputStream());
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * @return the is
   */
  public ObjectInputStream getIs() {
    return is;
  }

  /**
   * @return the os
   */
  public ObjectOutputStream getOs() {
    return os;
  }

  /**
   * @return the socket
   */
  public Socket getSocket() {
    return socket;
  }

}