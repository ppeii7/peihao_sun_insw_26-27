// IMPORTAR LIBRERÍAS JUNIT
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import com.uem.Calculator;



public class CalculatorTest {
    
    private Calculator calculator;

    @BeforeEach
    public void setup() {
        calculator = new Calculator();
    }

    @Test
    public void TestMultiplicarDosEnteros() {
        assertEquals(6, calculator.multiply(2, 3));
    }

    @Test 
    public void TestMultiplicarConCero() {
        assertEquals(0, calculator.multiply(5, 0));
    }

    @Test
    public void TestMultiplicarConNegativos() {
        assertEquals(-15, calculator.multiply(-5, 3));
    }

    @Test 
    public void TestConcatenarDosStrings(){
        assertEquals("HelloWorld", calculator.concat("Hello", "World"));
    }

    @Test
    public void TestConcatenarConNull(){
        assertEquals(Calculator.EMPTY, calculator.concat("Hello", null));
    }

    @Test 
    public void TestSumaPositiva() {
        assertEquals(5, calculator.sum(2, 3));
    }
    
    @Test 
    public void TestSumaNegativa(){
        assertEquals(-4, calculator.sum(-1,-3));
    }

    @Test 
    public void TestDescuento(){
        assertEquals(50, calculator.discount(100,50));
    }

    @Test 
    public void TestDescuento100(){
        assertEquals(0, calculator.discount(100, 100));
    }

        @Test 
    public void TestDescuento0(){
        assertEquals(100, calculator.discount(100, 0));
    }
    
    @Test
    public void TestDescuentoException(){
            assertThrows(IllegalArgumentException.class, () -> calculator.discount(100, 1000));
    }


    List <Double> listaNumeros = List.of(2.0,3.0,4.0,5.0);
    @Test 
    public void TestLista(){
        assertEquals(14.0, calculator.calculateTotal(listaNumeros));
    }

    List <Double> listaVacia = List.of();

    @Test
    public void TestListaVacia(){
        assertEquals(0.0, calculator.calculateTotal(listaVacia));
    } 

}
