import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.uem.model.Article;

public class ArticleTest {
    
    private Article a1;

    @BeforeEach 
    public void setup(){
        a1 = new Article("Patatas", 10, 1.2 , 50);
    }


    

    @Test 
    public void getGrossAmountTest(){
        assertEquals(12, a1.getGrossAmount());
    }

    @Test 
    public void getDiscountedAmountTest(){
        assertEquals(6.0, a1.getDiscountedAmount());

    }


}
