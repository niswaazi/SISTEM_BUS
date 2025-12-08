public class Penumpang {
    // atribut (private sesuai konsep encapsulation)
    private int id;
    private int umur;
    private boolean hamil;
    private int saldo;

    // constructor: saldo awal = 10000
    public Penumpang(int id, int umur, boolean hamil) {
        this.id = id;
        this.umur = umur;
        this.hamil = hamil;
        this.saldo = 10000;
    }

    // getter
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

    // menambah saldo
    public void tambahSaldo(int saldoBaru) {
        if (saldoBaru > 0) {
            this.saldo += saldoBaru;
        }
    }

    // mengurangi saldo
    public void kurangiSaldo(int ongkos) {
        if (ongkos > 0 && saldo >= ongkos) {
            saldo -= ongkos;
        }
    }

    // untuk mencetak nama penumpang (opsional)
    public String toString() {
        return "ID: " + id + ", Umur: " + umur + ", Hamil: " + hamil + ", Saldo: " + saldo;
    }
}
