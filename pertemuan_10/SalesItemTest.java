import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class SalesItemTest
{
    private SalesItem item1;

    public SalesItemTest()
    {
    }

    @Before
    public void setUp()
    {
        item1 = new SalesItem("Laptop Gaming", 15000000);
    }

    @Test
    public void testAddComment()
    {
        assertEquals(0, item1.getCommentCount());
        
        boolean result = item1.addComment("Budi", "Barang bagus!", 5);
        
        assertTrue(result);
        assertEquals(1, item1.getCommentCount());
    }

    @Test
    public void testInvalidRating()
    {
        boolean result = item1.addComment("Andi", "Terlalu mahal", 6);
        
        assertFalse(result);
        assertEquals(0, item1.getCommentCount());
    }
    
    @Test
    public void testItemDetails()
    {
        assertEquals("Laptop Gaming", item1.getName());
    }

    @After
    public void tearDown()
    {
    }
}