package aldev;

import aldev.pagkages.Name;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        Name n1 = new Name("andre fabiano de lima filho");
        Name[] names = n1.split(5);
        System.out.println(names.toString());
    }
}
