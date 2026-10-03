import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import com.uem.model.*;

import java.util.ArrayList;
import java.util.List;

public class OrderTest {
    
    private Order order1;

    @BeforeEach
    public void setup() {
        Article a1 = new Article("Patatas", 10, 1.2 , 10);
        Article a2 = new Article("Cebolla", 3, 0.3 , 5);
        Article a3 = new Article("Huevos", 17, 0.6 , 15);
        Article a4 = new Article("Chorizo", 5, 1.6 , 0);
        List<Article> listaArticulos = new ArrayList<>(List.of(a1, a2, a3, a4));

        order1 = new Order("00000001", listaArticulos);
    }


    @Test 
    public void getGrossTotalTest(){

        assertEquals(31.1  ,order1.getGrossTotal());
    }

        @Test 
    public void getDiscountedTotalTest(){

        //En este ejemplo existe un error del 3^-15, por lo que permito un margen de error a partir del tercer decimal.
        assertEquals(28.325  ,order1.getDiscountedTotal() , 0.001); 
    }
    


}
