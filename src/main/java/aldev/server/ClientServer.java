package aldev.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import aldev.pagkages.Name;

public class ClientServer implements Runnable {

  private Socket client;
  private ObjectOutputStream os;
  private ObjectInputStream is;

  public ClientServer(Socket client) {
    this.client = client;
    if (this.client.isConnected())
      System.out.println("CLIENTE CONECTADO" + this.client.getInetAddress().getHostAddress());
    else
      System.out.println("CLIENTE DESCONECTADO");
  }

  public void run() {
    try {
      // FIXME: thread para esperar resposta processada

      os.writeObject(this.tiny);

      while (this.processed == null) {
        this.processed = (Name) is.readObject();
      }
      this.client.close();
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

  /**
   * @return the processed
   */
  public Name getProcessed() {
    return processed;
  }
}
