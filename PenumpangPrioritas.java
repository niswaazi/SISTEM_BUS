public class PenumpangPrioritas extends Penumpang {

    public PenumpangPrioritas(int id, int umur, boolean hamil) {
        super(id, umur, hamil);
    }

    @Override
    public String toString() {
        return "Penumpang Prioritas - " + super.toString();
    }
}
