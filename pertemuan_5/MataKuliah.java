package pertemuan_5;

public class MataKuliah {
    private String kode;
    private String nama;
    private Dosen dosen;

    public MataKuliah(String kode, String nama, Dosen dosen) {
        this.kode = kode;
        this.nama = nama;
        this.dosen = dosen;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public Dosen getDosen() {
        return dosen;
    }

    @Override
    public String toString() {
        return kode + " - " + nama + " (Dosen: " + dosen.getNama() + ")";
    }
}
