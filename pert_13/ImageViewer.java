import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ImageViewer {
    
    JFrame frame;
    JLabel imageLabel; // Label ini akan digunakan sebagai kanvas gambar
    JButton openButton;

    public static void main(String[] args) {
        ImageViewer viewer = new ImageViewer();
        viewer.go();
    }

    public void go() {
        frame = new JFrame("Simple Image Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Bagian Bawah: Tombol Open
        openButton = new JButton("Buka Gambar");
        openButton.addActionListener(new OpenImageListener());
        
        // Bagian Tengah: Tempat Gambar (Label kosong dulu)
        imageLabel = new JLabel("Belum ada gambar", SwingConstants.CENTER);
        imageLabel.setPreferredSize(new Dimension(400, 300));
        
        // Menambahkan scrolling jika gambar terlalu besar
        JScrollPane scrollPane = new JScrollPane(imageLabel);

        // Layout
        frame.getContentPane().add(BorderLayout.CENTER, scrollPane);
        frame.getContentPane().add(BorderLayout.SOUTH, openButton);

        frame.setSize(500, 500);
        frame.setVisible(true);
    }

    // Listener untuk tombol "Buka Gambar"
    public class OpenImageListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            // Membuka jendela dialog pilih file
            JFileChooser fileChooser = new JFileChooser();
            
            // Hasil pilihan user (Yes/Cancel)
            int result = fileChooser.showOpenDialog(frame);

            // Jika user memilih file (klik Open)
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                
                // Membuat Icon dari file yang dipilih
                ImageIcon icon = new ImageIcon(selectedFile.getPath());
                
                // Opsional: Mengubah ukuran gambar agar pas di layar (Scaling)
                Image img = icon.getImage();
                Image newImg = img.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
                icon = new ImageIcon(newImg);

                // Menempelkan icon ke label
                imageLabel.setText(""); // Hapus teks "Belum ada gambar"
                imageLabel.setIcon(icon);
            }
        }
    }
}