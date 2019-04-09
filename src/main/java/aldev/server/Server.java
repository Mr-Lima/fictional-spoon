package aldev.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

import aldev.Package;

/**
 * Server
 */
public class Server extends Thread {
  private int PORT;
  private List<Client> clients;

  public Server(int port) {
    this.PORT = port;
    this.clients = new ArrayList<>();
  }

  public void run() {

    try {
      ServerSocket server = new ServerSocket(this.PORT);
      System.out.println("SERVER INICIADO EM: " + this.PORT);

      while (true) {
        this.clients.add(new Client(server.accept()));
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public <T, R> void receiveTask(Package<T, R> pack) {

    List<R> packs = Arrays.asList(pack.split(clients.size()));
    AtomicInteger i = new AtomicInteger(0);
    packs.parallelStream().forEach(p -> {
      try {
        this.clients.get(i.getAndIncrement()).getOs().writeObject(p);
      } catch (IOException e) {
        e.printStackTrace();
      }
    });

    ConcurrentLinkedQueue<T> packsResponse = new ConcurrentLinkedQueue<>();
    this.clients.parallelStream().forEach(c -> {
      try {
        packsResponse.add((T) c.getIs().readObject());
      } catch (ClassNotFoundException | IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    });

    List<T> solution = pack.join(packsResponse);
    System.out.println(solution);

  }

}