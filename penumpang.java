
public class penumpang {

    // atribut
    private int id_penumpang;
    private int umur;
    private boolean hamil;
    private int saldo; 

    //constructor
    public penumpang(int id_penumpang, int umur, boolean hamil, int saldo) {
        this.id_penumpang = id_penumpang;
        this.umur = umur;
        this.hamil = hamil;
        this.saldo = saldo;

    }

    //getter
    public int getid () {
        return id_penumpang;
    }

    public int getumur () {
        return umur;
    }

    public boolean gethamil () {
        return hamil;
    }

    public int getsaldo () {
        return saldo;
    }

    public void tambahsaldo (int saldobaru) {
        if (saldobaru > 0) {
            this.saldo = this.saldo + saldobaru;
        } else {
            System.out.println("Saldo tidak valid");
        }
    }

}
