import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Login {
    // 1. Variabel dideklarasikan di tingkat Class agar bisa diakses oleh Listener
    String validUsername = "james3302";
    String validPassword = "pass";
    String msg = " ";
    
    // Komponen GUI
    JFrame frame;
    JTextField txtUsername;
    JPasswordField txtPassword; // Menggunakan JPasswordField agar sandi tersembunyi
    
    public static void main(String[] args){
        Login gui = new Login();
        gui.go();
    }
    
    public void go(){
        frame = new JFrame("Login System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        // Menggunakan GridLayout agar susunan lebih rapi (3 baris, 2 kolom)
        panel.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblUsername = new JLabel("Username:");
        JLabel lblPassword = new JLabel("Password:");
        
        txtUsername = new JTextField(20);
        txtPassword = new JPasswordField(20);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new LoginListener());
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener(new CancelListener());
        
        // Menambahkan komponen ke panel
        panel.add(lblUsername);
        panel.add(txtUsername);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);
        panel.add(btnCancel);
        
        frame.getContentPane().add(BorderLayout.CENTER, panel);
        frame.setSize(300, 150);
        frame.setVisible(true);
    }
    
    public class LoginListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            // Mengambil password dari JPasswordField
            String inputPass = new String(txtPassword.getPassword());
            
            // Logika pengecekan username dan password
            if(validUsername.equals(txtUsername.getText()) && validPassword.equals(inputPass)){
                msg = "Login Granted!";
                JOptionPane.showMessageDialog(frame, msg, "Success", JOptionPane.INFORMATION_MESSAGE);
                
                // --- INTEGRASI KE IMAGE VIEWER ---
                // Jika kamu sudah punya class ImageViewer, aktifkan baris di bawah ini:
                
                /*
                ImageViewer viewer = new ImageViewer();
                viewer.go();
                frame.dispose(); // Menutup jendela login
                */
                
            } else {
                msg = "Login Denied";
                JOptionPane.showMessageDialog(frame, msg, "Alert", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
    
    public class CancelListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            // Membersihkan field input
            txtUsername.setText("");
            txtPassword.setText("");
            txtUsername.requestFocus();
        }
    }
}