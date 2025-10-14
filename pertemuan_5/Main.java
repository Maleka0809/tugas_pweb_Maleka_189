package pertemuan_5;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Dosen d1 = new Dosen("Pak FB");
        Dosen d2 = new Dosen("Bu SW");

        MataKuliah mk1 = new MataKuliah("A", "PWeb", d1);
        MataKuliah mk2 = new MataKuliah("C", "KPPL", d2);

        System.out.print("Masukkan nama mahasiswa: ");
        String nama = sc.nextLine();
        System.out.print("Masukkan NRP mahasiswa: ");
        String nrp = sc.nextLine();

        Mahasiswa mhs = new Mahasiswa(nama, nrp);

        System.out.println("Pilih mata kuliah yang ingin diambil:");
        System.out.println("1. " + mk1);
        System.out.println("2. " + mk2);
        System.out.print("Masukkan pilihan (1/2): ");
        int pilihan = sc.nextInt();

        if (pilihan == 1) {
            mhs.tambahMatkul(mk1);
        } else if (pilihan == 2) {
            mhs.tambahMatkul(mk2);
        } else {
            System.out.println("Pilihan tidak valid.");
        }

        System.out.println();
        mhs.tampilkanKRS();

        sc.close();
    }
}

