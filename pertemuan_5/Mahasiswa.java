package pertemuan_5;

import java.util.ArrayList;
public class Mahasiswa {
    private String nama;
    private String nrp;
    private ArrayList<MataKuliah> krs;

    public Mahasiswa(String nama, String nrp) {
        this.nama = nama;
        this.nrp = nrp;
        this.krs = new ArrayList<>();
    }

    public void tambahMatkul(MataKuliah mk) {
        krs.add(mk);
    }

    public void tampilkanKRS() {
        System.out.println("KRS Mahasiswa: " + nama + " (" + nrp + ")");
        if (krs.isEmpty()) {
            System.out.println("Belum ada mata kuliah yang diambil.");
        } else {
            for (MataKuliah mk : krs) {
                System.out.println("- " + mk);
            }
        }
    }
}
