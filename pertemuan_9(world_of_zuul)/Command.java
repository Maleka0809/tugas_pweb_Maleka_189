/**
 * Kelas Command menyimpan informasi tentang perintah yang dimasukkan oleh pengguna.
 */
public class Command
{
    private String perintah;
    private String kalimat2;

    // Nama parameter diganti menjadi 'perintah' (kata pertama) dan 'kalimat2' (kata kedua)
    public Command(String perintah, String kalimat2) {
        this.perintah = perintah;
        this.kalimat2 = kalimat2;
    }

    public String getPerintah(){
        return perintah;
    }

    public String getKalimat2(){
        return kalimat2;
    }

    /**
     * @return true jika kata perintah (perintah) adalah null.
     */
    public boolean isUnknown(){
        return (perintah == null);
    }

    /**
     * @return true jika perintah ini memiliki kata kedua (kalimat2 tidak null).
     */
    public boolean hasSecondWord(){
        // Logika yang benar: memeriksa apakah kalimat2 ada
        return (kalimat2 != null);
    }
}