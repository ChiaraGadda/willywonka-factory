import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Start APP: Chocolate Factory!");

        Factory factory = new Factory(args);

        String nextOrder = null;
        boolean status = true;
        do {
            System.out.println("Sono arrivati nuovi ordini?");
            Scanner input = new Scanner(System.in);
            nextOrder = input.nextLine();
            if (nextOrder.compareTo("N")==0) {
                System.out.println("Chiudo la fabbrica!");
                status = false;
            } else {
                factory.nuovoOrdine(Integer.parseInt(nextOrder));
            }
        } while (status);
    }
}
