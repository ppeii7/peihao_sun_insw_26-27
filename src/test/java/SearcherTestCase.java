import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestClassOrder;

import com.uem.Searcher;

public class SearcherTestCase{

    private Searcher searcher;
    private List<String> nombres = new ArrayList<>(Arrays.asList("Lucas", "Martina", "Diego", "Valeria", "Mateo",
                                                                 "Sofía", "Adrián", "Camila", "Bruno", "Elena",
                                                                  "Pablo", "Clara", "Gabriel", "Julia", "Álex"));



    @BeforeEach 
    public void setup(){
        searcher = new Searcher();
    }


    @Test
    public void testExistWord(){
        assertEquals(true ,searcher.searchWord("Diego",nombres));
    }

     @Test
    public void testNotExistWord(){
        assertEquals(false ,searcher.searchWord("Juana",nombres));
    }


    @Test
    public void testIndex(){
        assertEquals("Adrián",searcher.getWordByIndex(nombres, 6));
    }

    @Test
    public void testIndexFail(){
        assertEquals(null,searcher.getWordByIndex(nombres, 100));
    }

    List <String> a =  new ArrayList<>(List.of("Clara"));

    @Test 
    public void testSearchByPrefix(){
        assertEquals(a, searcher.searchByPrefix("Clar", nombres));
    }

    
    List <String> b =  new ArrayList<>(List.of());

    @Test 
    public void testSearchByPrefixFail(){
        assertEquals(b, searcher.searchByPrefix("Javi", nombres));
    }

    List <String> c =  new ArrayList<>(List.of("Camila","Clara"));

    @Test
    public void testFilterByKeywords(){
        assertEquals(c, searcher.filterByKeyword("la", nombres));

    }

    @Test
    public void testFilterByKeywordsFail(){
        assertEquals(b, searcher.filterByKeyword("lol", nombres));

    }


    @Test
    public void testSearchExactPhrase(){
        assertEquals(true,searcher.searchExactPhrase("Lucas", nombres));
    }

    @Test
    public void testSearchExactPhraseFail(){
        assertEquals(true,searcher.searchExactPhrase("Adrián", nombres));
    }













}