import java.awt.*;

public class Ball {
    int x, y;
    int xVelocity = 3;
    int yVelocity = 3;
    int diameter = 20;

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void draw(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillOval(x, y, diameter, diameter);
    }
    
    public void move() {
        x += xVelocity;
        y += yVelocity;
    }
    
    // Fungsi untuk mendapatkan area bola (untuk tabrakan)
    public Rectangle getBounds() {
        return new Rectangle(x, y, diameter, diameter);
    }
}