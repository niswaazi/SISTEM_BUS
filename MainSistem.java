import java.util.Scanner;

public class MainSistem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Bus bus = new Bus();

        while (true) {
            System.out.println("===== BUS TRANS KOETARADJA =====");
            System.out.println("Menu:");
            System.out.println("1. Naikkan Penumpang");
            System.out.println("2. Turunkan Penumpang");
            System.out.println("3. Lihat Penumpang");
            System.out.println("4. Keluar");
            System.out.print("Pilihan: ");

            int pilihan = input.nextInt();
            input.nextLine(); // membersihkan newline

            if (pilihan == 1) {
                System.out.print("Masukkan ID Penumpang: ");
                int id = input.nextInt();
                System.out.print("Umur: ");
                int umur = input.nextInt();
                input.nextLine();
                System.out.print("Hamil (y/n): ");
                String hamilInput = input.nextLine();

                boolean hamil = hamilInput.equalsIgnoreCase("y");

                Penumpang p;

                // gunakan inheritance
                if (umur > 60 || umur < 10 || hamil) {
                    p = new PenumpangPrioritas(id, umur, hamil);
                } else {
                    p = new Penumpang(id, umur, hamil);
                }

                boolean berhasil = bus.naikkanPenumpang(p);
                if (berhasil) {
                    System.out.println("Penumpang berhasil ditambahkan.");
                } else {
                    System.out.println("Gagal menambahkan penumpang.");
                }
            }

            else if (pilihan == 2) {
                System.out.print("Masukkan ID penumpang yang turun: ");
                int idTurun = input.nextInt();

                boolean turun = bus.turunkanPenumpang(idTurun);
                if (turun) {
                    System.out.println("Penumpang berhasil turun.");
                } else {
                    System.out.println("Penumpang tidak ditemukan.");
                }
            }

            else if (pilihan == 3) {
                System.out.println(bus.toString());
            }

            else if (pilihan == 4) {
                System.out.println("Program selesai.");
                break;
            }

            else {
                System.out.println("Pilihan tidak valid.");
            }

            System.out.println();
        }

        input.close();
    }
}
