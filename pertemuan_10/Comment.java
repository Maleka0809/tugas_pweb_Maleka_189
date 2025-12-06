public class Comment
{
    private String author;
    private String text;
    private int rating;

    public Comment(String author, String text, int rating)
    {
        this.author = author;
        this.text = text;
        this.rating = rating;
    }

    public String getAuthor()
    {
        return author;
    }

    public String getText()
    {
        return text;
    }

    public int getRating()
    {
        return rating;
    }

    public void printDetails()
    {
        System.out.println("Oleh: " + author);
        System.out.println("Rating: " + rating + "/5");
        System.out.println("Ulasan: " + text);
        System.out.println("-------------------------");
    }
}