public class MainMakhlukHidup {
    
    // Method untuk mengecek makhluk hidup (Polimorfisme)
    public void cekMakhlukHidup(MakhlukHidup mHidup){
        mHidup.berdiri();
        mHidup.oksigen();
    }
    
    public static void main(String[] args) {
        MainMakhlukHidup tMakhlukHidup = new MainMakhlukHidup();        
        
        // Cek Manusia
        tMakhlukHidup.cekMakhlukHidup(new Manusia("Dua Kaki"));       
        
        System.out.println("-----------------------------------------");                              
        
        // Cek Hewan
        tMakhlukHidup.cekMakhlukHidup(new Hewan("Empat Kaki", "Dua Kaki"));
        
        System.out.println("-----------------------------------------");        
        
        // Cek Tumbuhan
        tMakhlukHidup.cekMakhlukHidup(new Tumbuhan("Akar"));
    }
}