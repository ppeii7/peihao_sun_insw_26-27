import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

import com.uem.Searcher;

public class SearcherTestCase{

    private Searcher searcher;
    private List<String> nombres = new ArrayList<>(Arrays.asList("Lucas", "Martina", "Diego", "Valeria", "Mateo",
                                                                 "Sofía", "Adrián", "Camila", "Bruno", "Elena",
                                                                  "Nicolás", "Clara", "Gabriel", "Julia", "Álex"));



    @BeforeEach 
    public void setup(){
        searcher = new Searcher();
    }


    @Test
    public void TestExistWord(){
        assertEquals(true ,searcher.searchExactPhrase("Diego",nombres));
    }



}