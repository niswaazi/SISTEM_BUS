public class Penumpang {

    private int id;
    private int umur;
    private boolean hamil;
    private int saldo;

    public Penumpang(int id, int umur, boolean hamil) {
        this.id = id;
        this.umur = umur;
        this.hamil = hamil;
        this.saldo = 10000;
    }

    public int getID() {
        return id;
    }

    public int getUmur() {
        return umur;
    }

    public boolean getHamil() {
        return hamil;
    }

    public int getSaldo() {
        return saldo;
    }

    public void tambahSaldo(int saldoBaru) {
        if (saldoBaru > 0) {
            saldo += saldoBaru;
        }
    }

    public void kurangiSaldo(int ongkos) {
        if (ongkos > 0 && saldo >= ongkos) {
            saldo -= ongkos;
        }
    }

    public String toString() {
        return "ID: " + id + " | Umur: " + umur + " | Hamil: " + hamil + " | Saldo: " + saldo;
    }
}
