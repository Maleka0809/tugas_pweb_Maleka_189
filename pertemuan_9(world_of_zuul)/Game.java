/**
 * Ini adalah kelas utama dari game "World of Zuul".
 */
public class Game 
{
    private Parser parser;
    private Ruangan currentRoom;

    public Game() 
    {
        createRooms();
        parser = new Parser();
    }

    /**
     * Membuat semua ruangan dan mengeset pintu keluarnya.
     */
    private void createRooms()
    {
        Ruangan outside, theater, pub, lab, office;

        // Ciptakan ruangan
        outside = new Ruangan("di luar pintu masuk utama universitas");
        theater = new Ruangan("di dalam gedung kuliah/teater");
        pub = new Ruangan("di dalam pub kampus");
        lab = new Ruangan("di dalam lab komputer kampus");
        office = new Ruangan("di dalam kantor administrasi");
        
        // Tetapkan pintu keluar
        outside.setExit("timur", theater);
        outside.setExit("selatan", lab);
        outside.setExit("barat", pub);

        theater.setExit("barat", outside);

        pub.setExit("timur", outside);

        lab.setExit("utara", outside);
        lab.setExit("timur", office);

        office.setExit("barat", lab);

        currentRoom = outside;  // Mulai permainan di luar
    }

    /**
     * Perulangan utama game, memproses perintah hingga permainan berakhir.
     */
    public void play() 
    {            
        printWelcome();

        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Terima kasih sudah bermain. Sampai jumpa.");
    }

    /**
     * Tampilkan pesan sambutan awal.
     */
    private void printWelcome()
    {
        System.out.println();
        System.out.println("Selamat datang di World of Zuul!");
        System.out.println("World of Zuul adalah permainan petualangan baru yang sangat membosankan.");
        System.out.println("Ketik 'help' jika Anda memerlukan bantuan.");
        System.out.println();
        System.out.println(currentRoom.getLongDescription());
    }

    /**
     * Memproses perintah yang diberikan.
     * @param command Perintah untuk diproses.
     * @return true jika perintah mengakhiri permainan, false sebaliknya.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        if (command.isUnknown()) {
            System.out.println("Saya tidak mengerti...");
            return false;
        }

        String commandWord = command.getPerintah();
        if (commandWord.equals("help")) {
            printHelp();
        }
        else if (commandWord.equals("go")) {
            goRoom(command);
        }
        else if (commandWord.equals("quit")) {
            wantToQuit = quit(command);
        }
        // Tambahkan perintah 'look'
        else if (commandWord.equals("look")) {
            look();
        }

        return wantToQuit;
    }

    // implementasi perintah 'help'
    private void printHelp() 
    {
        System.out.println("Anda tersesat. Anda sendirian. Anda berjalan-jalan di sekitar universitas.");
        System.out.println("Kata perintah Anda adalah:");
        parser.showCommands();
    }

    // implementasi perintah 'look'
    private void look()
    {
        System.out.println(currentRoom.getLongDescription());
    }

    /** * Pindah ke ruangan di arah yang ditentukan.
     */
    private void goRoom(Command command) 
    {
        if (!command.hasSecondWord()) {
            System.out.println("Pergi ke mana?");
            return;
        }

        String direction = command.getKalimat2();

        // Mencoba pintu keluar ruangan saat ini
        Ruangan nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Di sana tidak ada pintu!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    /** * Perintah "Quit" diimplementasikan.
     * @return true, jika permainan harus berakhir.
     */
    private boolean quit(Command command) 
    {
        if (command.hasSecondWord()) {
            System.out.println("Keluar apa?");
            return false;
        }
        else {
            return true;  // Berarti permainan berakhir
        }
    }
}