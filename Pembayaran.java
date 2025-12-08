public interface Pembayaran {
    void bayar(int jumlah) throws SaldoTidakCukupException;
}
