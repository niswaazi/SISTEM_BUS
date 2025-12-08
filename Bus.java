import java.util.ArrayList;

public class Bus {

    // kapasitas
    private final int KAPASITAS_BIASA = 16;
    private final int KAPASITAS_PRIORITAS = 4;
    private final int KAPASITAS_BERDIRI = 20;

    // daftar penumpang
    private ArrayList<Penumpang> penumpangBiasa;
    private ArrayList<Penumpang> penumpangPrioritas;
    private ArrayList<Penumpang> penumpangBerdiri;

    // ongkos bus
    public static final int ONGKOS_BUS = 2000;

    // pendapatan
    private int totalPendapatan;

    // constructor
    public Bus() {
        penumpangBiasa = new ArrayList<>();
        penumpangPrioritas = new ArrayList<>();
        penumpangBerdiri = new ArrayList<>();
        totalPendapatan = 0;
    }

    // getter daftar
    public ArrayList<Penumpang> getPenumpangBiasa() {
        return penumpangBiasa;
    }

    public ArrayList<Penumpang> getPenumpangPrioritas() {
        return penumpangPrioritas;
    }

    public ArrayList<Penumpang> getPenumpangBerdiri() {
        return penumpangBerdiri;
    }

    // getter jumlah
    public int getJumlahPenumpangBiasa() {
        return penumpangBiasa.size();
    }

    public int getJumlahPenumpangPrioritas() {
        return penumpangPrioritas.size();
    }

    public int getJumlahPenumpangBerdiri() {
        return penumpangBerdiri.size();
    }

    // cek prioritas
    private boolean isPrioritas(Penumpang p) {
        return p.getUmur() > 60 || p.getUmur() < 10 || p.getHamil();
    }

    // method naikkan penumpang
    public boolean naikkanPenumpang(Penumpang p) {

        // cek saldo
        if (p.getSaldo() < ONGKOS_BUS) {
            return false;
        }

        // jika prioritas
        if (isPrioritas(p)) {

            // kursi prioritas
            if (penumpangPrioritas.size() < KAPASITAS_PRIORITAS) {
                penumpangPrioritas.add(p);
            }
            // jika penuh, duduk di kursi biasa
            else if (penumpangBiasa.size() < KAPASITAS_BIASA) {
                penumpangBiasa.add(p);
            }
            // jika penuh, berdiri
            else if (penumpangBerdiri.size() < KAPASITAS_BERDIRI) {
                penumpangBerdiri.add(p);
            }
            else {
                return false;
            }
        }

        // jika penumpang biasa
        else {

            // kursi biasa
            if (penumpangBiasa.size() < KAPASITAS_BIASA) {
                penumpangBiasa.add(p);
            }
            // berdiri
            else if (penumpangBerdiri.size() < KAPASITAS_BERDIRI) {
                penumpangBerdiri.add(p);
            }
            else {
                return false;
            }
        }

        // transaksi sukses
        p.kurangiSaldo(ONGKOS_BUS);
        totalPendapatan += ONGKOS_BUS;

        return true;
    }

    // method turunkan penumpang
    public boolean turunkanPenumpang(int id) {

        // cari di prioritas
        for (int i = 0; i < penumpangPrioritas.size(); i++) {
            if (penumpangPrioritas.get(i).getID() == id) {
                penumpangPrioritas.remove(i);
                return true;
            }
        }

        // cari di biasa
        for (int i = 0; i < penumpangBiasa.size(); i++) {
            if (penumpangBiasa.get(i).getID() == id) {
                penumpangBiasa.remove(i);
                return true;
            }
        }

        // cari di berdiri
        for (int i = 0; i < penumpangBerdiri.size(); i++) {
            if (penumpangBerdiri.get(i).getID() == id) {
                penumpangBerdiri.remove(i);
                return true;
            }
        }

        return false;
    }

    // menampilkan daftar penumpang
    public String toString() {
        String hasil = "";

        hasil += "Penumpang Biasa: ";
        if (penumpangBiasa.isEmpty()) {
            hasil += "<kosong>\n";
        } else {
            for (Penumpang p : penumpangBiasa) {
                hasil += p.getID() + " ";
            }
            hasil += "\n";
        }

        hasil += "Penumpang Prioritas: ";
        if (penumpangPrioritas.isEmpty()) {
            hasil += "<kosong>\n";
        } else {
            for (Penumpang p : penumpangPrioritas) {
                hasil += p.getID() + " ";
            }
            hasil += "\n";
        }

        hasil += "Penumpang Berdiri: ";
        if (penumpangBerdiri.isEmpty()) {
            hasil += "<kosong>\n";
        } else {
            for (Penumpang p : penumpangBerdiri) {
                hasil += p.getID() + " ";
            }
            hasil += "\n";
        }

        int total = penumpangBiasa.size() + penumpangPrioritas.size() + penumpangBerdiri.size();
        hasil += "Jumlah Penumpang: " + total + "\n";
        hasil += "Total Pendapatan: " + totalPendapatan + "\n";

        return hasil;
    }
}
