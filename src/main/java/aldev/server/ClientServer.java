package aldev.server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import aldev.pagkages.Name;

public class ClientServer implements Runnable {

  private Socket client;
  private String textRequest;
  private Name processed;
  private Name tiny;

  public ClientServer(Socket client, Name tiny) {
    this.client = client;
    this.tiny = tiny;
    if (this.client.isConnected())
      System.out.println("CLIENTE CONECTADO" + this.client.getInetAddress().getHostAddress());
    else
      System.out.println("CLIENTE DESCONECTADO");
  }

  public void run() {
    try {
      ObjectOutputStream os = new ObjectOutputStream(this.client.getOutputStream());
      ObjectInputStream is = new ObjectInputStream(this.client.getInputStream());

      // FIXME: thread para esperar resposta processada
      new Thread() {
        @Override
        public void run() {
          try {
            while (true) {
              // this.getPro = new Object();
            }
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }.start();

      os.writeObject(this.tiny);
    } catch (IOException e) {
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
