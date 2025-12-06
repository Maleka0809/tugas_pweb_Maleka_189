import java.awt.*;
import java.awt.event.*;

public class Paddle {
    int x, y;
    int yVelocity = 0;
    int speed = 5;
    int width = 20;
    int height = 100;
    int id; // 1 untuk Player kiri, 2 untuk Player kanan

    public Paddle(int x, int y, int id) {
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public void draw(Graphics g) {
        if(id == 1)
            g.setColor(Color.BLUE);
        else
            g.setColor(Color.RED);
            
        g.fillRect(x, y, width, height);
    }

    public void move() {
        y += yVelocity;
    }
    
    // Fungsi untuk mendapatkan area kotak (untuk tabrakan)
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void keyPressed(KeyEvent e) {
        switch(id) {
            case 1: // Kontrol Player 1 (WASD)
                if(e.getKeyCode() == KeyEvent.VK_W) {
                    yVelocity = -speed;
                }
                if(e.getKeyCode() == KeyEvent.VK_S) {
                    yVelocity = speed;
                }
                break;
            case 2: // Kontrol Player 2 (Panah Atas/Bawah)
                if(e.getKeyCode() == KeyEvent.VK_UP) {
                    yVelocity = -speed;
                }
                if(e.getKeyCode() == KeyEvent.VK_DOWN) {
                    yVelocity = speed;
                }
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch(id) {
            case 1:
                if(e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
                    yVelocity = 0;
                }
                break;
            case 2:
                if(e.getKeyCode() == KeyEvent.VK_UP || e.getKeyCode() == KeyEvent.VK_DOWN) {
                    yVelocity = 0;
                }
                break;
        }
    }
}