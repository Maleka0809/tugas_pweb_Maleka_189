import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {
    static final int GAME_WIDTH = 800;
    static final int GAME_HEIGHT = 600;
    Thread gameThread;
    Image image;
    Graphics graphics;
    Paddle player1, player2;
    Ball ball;

    public GamePanel() {
        newBall(); // Buat bola baru
        newPaddles(); // Buat paddle baru
        
        this.setPreferredSize(new Dimension(GAME_WIDTH, GAME_HEIGHT));
        this.setFocusable(true);
        this.addKeyListener(new AL());
        
        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void newBall() {
        // Reset bola ke tengah layar
        ball = new Ball((GAME_WIDTH/2)-10, (GAME_HEIGHT/2)-10);
    }
    
    public void newPaddles() {
        // Buat Paddle dengan ID (1 = kiri, 2 = kanan)
        player1 = new Paddle(0, (GAME_HEIGHT/2)-50, 1);
        player2 = new Paddle(GAME_WIDTH-20, (GAME_HEIGHT/2)-50, 2);
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }
    
    public void draw(Graphics g) {
        // Gambar latar belakang hitam (opsional agar terlihat jelas)
        // g.setColor(Color.BLACK);
        // g.fillRect(0,0,GAME_WIDTH, GAME_HEIGHT);
        
        player1.draw(g);
        player2.draw(g);
        ball.draw(g);
    }
    
    public void move() {
        player1.move();
        player2.move();
        ball.move();
        checkCollision(); // Cek tabrakan setiap pergerakan
    }
    
    public void checkCollision() {
        // 1. Batasi Paddle agar tidak keluar layar
        if(player1.y <= 0) player1.y = 0;
        if(player1.y >= (GAME_HEIGHT - player1.height)) player1.y = GAME_HEIGHT - player1.height;
        if(player2.y <= 0) player2.y = 0;
        if(player2.y >= (GAME_HEIGHT - player2.height)) player2.y = GAME_HEIGHT - player2.height;
        
        // 2. Bola memantul dinding ATAS & BAWAH
        if(ball.y <= 0) ball.yVelocity = -ball.yVelocity;
        if(ball.y >= GAME_HEIGHT - ball.diameter) ball.yVelocity = -ball.yVelocity;
        
        // 3. Bola memantul jika kena PADDLE
        if(ball.getBounds().intersects(player1.getBounds())) {
            ball.xVelocity = Math.abs(ball.xVelocity); // Pantul ke Kanan
            // Opsional: Tambah kecepatan sedikit setiap kena
            // ball.xVelocity++; 
        }
        if(ball.getBounds().intersects(player2.getBounds())) {
            ball.xVelocity = -Math.abs(ball.xVelocity); // Pantul ke Kiri
            // ball.xVelocity--;
        }
        
        // 4. CEK KALAH / MENANG (Bola lewat kiri/kanan)
        if(ball.x <= 0) {
            System.out.println("Player 2 Skor!");
            newBall();
        }
        if(ball.x >= GAME_WIDTH - ball.diameter) {
            System.out.println("Player 1 Skor!");
            newBall();
        }
    }
    
    public void run() {
        // Game Loop
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        while(true) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if(delta >= 1) {
                move();
                repaint();
                delta--;
            }
        }
    }
    
    // Key Listener
    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            player1.keyPressed(e);
            player2.keyPressed(e);
        }
        public void keyReleased(KeyEvent e) {
            player1.keyReleased(e);
            player2.keyReleased(e);
        }
    }
}