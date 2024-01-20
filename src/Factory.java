import java.util.ArrayList;

public class Factory {
    ArrayList<Machine> machines = new ArrayList<>();
    public Factory(String[] args) {
        // Inizializza macchine
        machines.add(new Machine(50));
        machines.add(new Machine(200));
        machines.add(new Machine(100));
        ArrayList<Ordine> ordini = new ArrayList<Ordine>();
        ordini.add(new Ordine(500));
        ordini.add(new Ordine(300));
        ordini.add(new Ordine(100));
        ordini.add(new Ordine(1100));

        for (int i = 0; i < args.length; i++) {
            System.out.println("sto inserendo l'ordine di: " + args[i] + " pezzi.");
            ordini.add(new Ordine(Integer.parseInt(args[i])));
        }

        for (Ordine ordine : ordini) {
            processaNuovoOrdine(ordine);
        }
    }

    private void processaNuovoOrdine(Ordine ordine) {
        int fastIndex = indiceMacchinaPiuVeloce(ordine);
        machines.get(fastIndex).assegnaOrdine(ordine);
        System.out.println("Ordine di " + ordine.getPezzi() +
                " pezzi assegnato a Macchina " + (fastIndex + 1) + ". Tempo di fine: "
                + machines.get(fastIndex).getTempoFine());

    }

    public int indiceMacchinaPiuVeloce(Ordine ordine) {
        int index = -1;
        double tempoFine = -1;
        for (int j = 0; j < machines.size(); j++) {
            double temp = machines.get(j).getTempoTotale(ordine);
            if (tempoFine < 0 || temp < tempoFine) {
                tempoFine = temp;
                index = j;
            }
        }
        return index;
    }

    public void nuovoOrdine(int pezziOrdine) {
        processaNuovoOrdine(new Ordine(pezziOrdine));
    }
}
