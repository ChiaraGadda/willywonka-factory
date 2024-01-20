import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Start APP: Chocolate Factory!");

        Factory factory = new Factory(args);

        String nextOrder = null;
        // boolean status = true;
        try {
            do {
                System.out.println("Sono arrivati nuovi ordini?");
                Scanner input = new Scanner(System.in);
                nextOrder = input.nextLine();
                factory.nuovoOrdine(Integer.parseInt(nextOrder));
            } while (true);
        } catch (NumberFormatException ex) {
            System.out.print("non hai inserito un ordine valido...");
        } finally {
            System.out.println("chiudo la fabbrica");
        }
    }
}
