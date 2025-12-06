import java.util.Scanner;

/**
 * Kelas Parser membaca masukan baris dari pengguna dan mencoba menginterpretasikannya 
 * sebagai perintah. Ini mengembalikan objek Command jika masukan valid.
 */
public class Parser 
{
    private CommandWords commands; // Daftar kata perintah yang valid
    private Scanner reader;       // Sumber masukan perintah

    public Parser() 
    {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * @return Objek Command yang berisi perintah berikutnya dari pengguna.
     */
    public Command getCommand() 
    {
        String inputLine;   // Untuk menampung seluruh baris masukan
        String word1 = null;
        String word2 = null;

        System.out.print("> ");     // Prompt

        inputLine = reader.nextLine();

        // Cari hingga dua kata dalam baris masukan
        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next();      // Ambil kata pertama
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();  // Ambil kata kedua
                // Catatan: mengabaikan semua kata lain di baris ini
            }
        }
        
        tokenizer.close(); // Tutup tokenizer setelah digunakan

        // Periksa apakah kata pertama adalah perintah yang valid
        if (commands.isCommand(word1)) {
            return new Command(word1, word2);
        }
        else {
            // Jika tidak valid, kembalikan perintah unknown/null.
            return new Command(null, word2); 
        }
    }

    /**
     * Menampilkan daftar semua perintah yang valid.
     */
    public void showCommands()
    {
        commands.showAll();
    }
}