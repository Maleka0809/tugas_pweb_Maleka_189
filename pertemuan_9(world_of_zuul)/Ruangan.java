import java.util.HashMap;

/**
 * Kelas Ruangan merepresentasikan satu lokasi dalam permainan.
 */
public class Ruangan
{
    private String deskripsi;
    // Gunakan HashMap untuk menyimpan pintu keluar: Key=arah (String), Value=ruangan tujuan (Ruangan)
    private HashMap<String, Ruangan> exits; 

    public Ruangan(String deskripsi) 
    {
        this.deskripsi = deskripsi;
        exits = new HashMap<>(); // Inisialisasi HashMap
    }

    /**
     * Menetapkan pintu keluar dari ruangan ini.
     * @param direction Arah pintu keluar (e.g., "utara", "timur").
     * @param neighbor Ruangan yang dapat diakses melalui arah tersebut.
     */
    public void setExit(String direction, Ruangan neighbor) 
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return Deskripsi pendek ruangan ini.
     */
    public String getDeskripsi()
    {
        return deskripsi;
    }

    /**
     * Mengembalikan ruangan yang dijangkau jika kita pergi ke arah yang diberikan.
     * @param direction Arah pintu keluar.
     * @return Ruangan tujuan, atau null jika tidak ada pintu keluar di arah tersebut.
     */
    public Ruangan getExit(String direction) 
    {
        return exits.get(direction);
    }

    /**
     * Mengembalikan deskripsi lengkap ruangan saat ini, termasuk pintu keluar.
     * @return Deskripsi ruangan dan pintu-pintu keluar yang tersedia.
     */
    public String getLongDescription()
    {
        return "Anda berada di " + deskripsi + ".\n" + getExitString();
    }

    /**
     * @return String yang mencantumkan semua pintu keluar.
     */
    private String getExitString()
    {
        String returnString = "Pintu keluar:";
        for (String direction : exits.keySet()) {
            returnString += " " + direction;
        }
        return returnString;
    }
}