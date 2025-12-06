import java.util.ArrayList;
import java.util.Iterator;

public class SalesItem
{
    private String name;
    private int price;
    private ArrayList<Comment> comments;

    public SalesItem(String name, int price)
    {
        this.name = name;
        this.price = price;
        this.comments = new ArrayList<>();
    }

    public boolean addComment(String author, String text, int rating)
    {
        if(rating < 1 || rating > 5) {
            return false; 
        }
        
        Comment newComment = new Comment(author, text, rating);
        comments.add(newComment);
        return true;
    }

    public void showInfo()
    {
        System.out.println("=== ITEM INFO ===");
        System.out.println("Nama Produk: " + name);
        System.out.println("Harga: Rp " + price);
        System.out.println("Jumlah Komentar: " + comments.size());
        System.out.println("=================");
        
        System.out.println("Daftar Komentar:");
        for(Comment c : comments) {
            c.printDetails();
        }
    }
    
    public int getCommentCount()
    {
        return comments.size();
    }
    
    public String getName()
    {
        return name;
    }
}