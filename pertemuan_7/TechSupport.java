package pertemuan_7;
import java.util.Map;  
import java.util.HashMap;  
import java.util.Random;  
import java.util.ArrayList;  

public class TechSupport {  
    private Map<String, String> responses;  
    private Random random;  

    public TechSupport() {  
        responses = new HashMap<>();  
        random = new Random();  


        responses.put("error", "Apakah Anda menerima pesan kesalahan? Coba restart sistem.");  
        responses.put("help", "Apa yang bisa saya bantu?");  
        responses.put("crash", "Kapan crash terjadi? Apakah ada pesan spesifik?");  
        responses.put("slow", "Sudahkah Anda memeriksa penggunaan CPU dan RAM?");
        responses.put("terlambat", "Waktu pengambilan matkul telah selesai.");
        responses.put("kelas penuh", "Matkul ini telah penuh.");
        responses.put("login", "Apakah Anda yakin username dan password sudah benar?");
        responses.put("password", "Coba reset password Anda melalui menu lupa password.");
        responses.put("network", "Pastikan koneksi internet Anda stabil dan tersambung.");
        responses.put("update", "Pastikan Anda sudah menginstal pembaruan terbaru.");
        responses.put("virus", "Jalankan pemindaian antivirus penuh untuk memastikan sistem aman.");
        responses.put("printer", "Apakah printer sudah dinyalakan dan terhubung ke komputer?");
        responses.put("screen", "Apakah layar menampilkan gambar atau hanya gelap?");
        responses.put("sound", "Periksa pengaturan volume dan koneksi speaker/headset Anda.");
        responses.put("battery", "Coba ganti charger atau pastikan kabel tidak rusak.");
        responses.put("freeze", "Jika sistem membeku, tahan tombol power selama 10 detik untuk restart.");  
    }  

    public String getResponse(String userInput) {  
        String[] words = userInput.toLowerCase().split("\\s+");  
        ArrayList<String> foundResponses = new ArrayList<>();  


        for (String w : words) {  
            if (responses.containsKey(w)) {  
                foundResponses.add(responses.get(w));  
            }  
        }  


        if (!foundResponses.isEmpty()) {  
            return String.join(" ", foundResponses);  
        }  

        
        String[] generic = {  
            "Coba jelaskan lebih rinci.",  
            "Saya belum mengerti, bisa ulangi?",  
            "Bisakah Anda memberi detail lebih lanjut?"  
        };  
        return generic[random.nextInt(generic.length)];  
    }  

    public static void main(String[] args) {  
        TechSupport ts = new TechSupport();  

     
        System.out.println(ts.getResponse("My computer is slow after update"));  
        System.out.println(ts.getResponse("I need help"));  
        System.out.println(ts.getResponse("It gives an unknown error"));  
        System.out.println(ts.getResponse("My printer is not working"));  
        System.out.println(ts.getResponse("I forgot my password"));  
        System.out.println(ts.getResponse("The screen freeze and no sound"));  
    }  
}
