public class Machine {
    private int produzioneOraria;
    private double tempoFine;

    public Machine(int productivity) {
        this.produzioneOraria = productivity;
        this.tempoFine = 0.0;
    }

    public void assegnaOrdine(Ordine ordine) {
        double tempoRichiesto=tempoNecessarioOrdine(ordine);
        tempoFine += tempoRichiesto;
    }

    private double tempoNecessarioOrdine(Ordine ordine){
        float pezziNecessari = ordine.getPezzi();
        double tempoRichiesto = pezziNecessari / produzioneOraria;
        return tempoRichiesto;
    }
    public double getTempoFine(){
        return tempoFine;
    }
    public double getTempoTotale(Ordine ordine) {
        double tempoRichiesto=tempoNecessarioOrdine(ordine);
        return tempoFine+tempoRichiesto;
    }
}
