/**
 * Kelas ini menyimpan daftar semua kata perintah yang valid untuk permainan.
 */
public class CommandWords
{
    // Mengubah nama array menjadi huruf kapital sesuai konvensi konstanta
    private static final String[] VALID_COMMANDS = {
        "go", "quit", "help", "look" // Menggunakan perintah standar game Zuul
    };

    /**
     * Memeriksa apakah String yang diberikan adalah salah satu perintah yang valid.
     * @param commandString Kata yang akan diperiksa.
     * @return true jika kata tersebut valid, false sebaliknya.
     */
    public boolean isCommand(String commandString){
        // Mengubah Perintahvalid menjadi VALID_COMMANDS
        // Memperbaiki typo: lenght menjadi length
        for(int i = 0; i < VALID_COMMANDS.length; i++){
            if(VALID_COMMANDS[i].equals(commandString)){
                return true;
            }
        }
        return false;
    }
    
    /**
     * Menampilkan semua perintah yang valid.
     */
    public void showAll() {
        for(String command : VALID_COMMANDS) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}