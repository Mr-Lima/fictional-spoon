package aldev.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientServer extends Thread {

  private Socket client;
  private String textRequest;
  private String textResponse;

  public ClientServer(Socket client) {
    this.client = client;
    if (this.client.isConnected())
      System.out.println("CLIENTE CONECTADO" + this.client.getInetAddress().getHostAddress());
    else
      System.out.println("CLIENTE DESCONECTADO");
  }

  public void run() {
    try {
      System.out.println(this.client.getInputStream());
      BufferedReader in = new BufferedReader(new InputStreamReader(this.client.getInputStream()));

      String line;
      System.out.println(in.readLine());
      // while (1 == 1) {
      // System.out.println(in.readLine());
      // }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
