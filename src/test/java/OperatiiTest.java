import model.Monom;
import model.Operatii;
import model.Polinom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OperatiiTest {

    @Test
    public void adunareTest(){
        Polinom polinom1 = new Polinom();
        polinom1.adauga(new Monom(6, 3));
        polinom1.adauga(new Monom(-3, 2));
        polinom1.adauga(new Monom(2, 1));

        Polinom polinom2 = new Polinom();
        polinom2.adauga(new Monom(3, 2));
        polinom2.adauga(new Monom(-1, 0));

        String rezultat = "6x^3 + 2x - 1";
        assertTrue(Operatii.aduna(polinom1, polinom2).toString().compareTo(rezultat) == 0,
                "Rezultatul adunarii lui " + polinom1 + " cu " + polinom2 + " este " + rezultat);
    }

    @Test
    public void scadereTest(){
        Polinom polinom1 = new Polinom();
        polinom1.adauga(new Monom(6, 3));
        polinom1.adauga(new Monom(-3, 2));
        polinom1.adauga(new Monom(2, 1));

        Polinom polinom2 = new Polinom();
        polinom2.adauga(new Monom(3, 2));
        polinom2.adauga(new Monom(-1, 0));

        String rezultat = "6x^3 - 6x^2 + 2x + 1";
        assertTrue(Operatii.scade(polinom1, polinom2).toString().compareTo(rezultat) == 0,
                "Rezultatul scaderii lui " + polinom1 + " cu " + polinom2 + " este " + rezultat);
    }

    @Test
    public void inmultireTest(){
        Polinom polinom1 = new Polinom();
        polinom1.adauga(new Monom(6, 3));
        polinom1.adauga(new Monom(-3, 2));
        polinom1.adauga(new Monom(2, 1));

        Polinom polinom2 = new Polinom();
        polinom2.adauga(new Monom(3, 2));
        polinom2.adauga(new Monom(-1, 0));

        String rezultat = "18x^5 - 9x^4 + 3x^2 - 2x";
        assertTrue(Operatii.inmulteste(polinom1, polinom2).toString().compareTo(rezultat) == 0,
                "Rezultatul inmultirii lui " + polinom1 + " cu " + polinom2 + " este " + rezultat);
    }

    @Test
    public void impartireTest(){
        Polinom polinom1 = new Polinom();
        polinom1.adauga(new Monom(6, 3));
        polinom1.adauga(new Monom(-3, 2));
        polinom1.adauga(new Monom(2, 1));

        Polinom polinom2 = new Polinom();
        polinom2.adauga(new Monom(3, 2));
        polinom2.adauga(new Monom(-1, 0));

        String rezultatCat = "2x - 1";
        String rezultatRest = "4x - 1";
        Polinom [] polinom = new Polinom[2];
        polinom = Operatii.imparte(polinom1, polinom2);
        assertTrue(polinom[0].toString().compareTo(rezultatCat) == 0 && polinom[1].toString().compareTo(rezultatRest) == 0,
                "Rezultatul impartirii lui " + polinom1 + " la " + polinom2 + " determina catul: " + rezultatCat + " si restul: " +rezultatRest);
    }

    @Test
    public void derivareTest(){
        Polinom polinom1 = new Polinom();
        polinom1.adauga(new Monom(6, 3));
        polinom1.adauga(new Monom(-3, 2));
        polinom1.adauga(new Monom(2, 1));

        String rezultat = "18x^2 - 6x + 2";
        assertTrue(Operatii.deriveaza(polinom1).toString().compareTo(rezultat) == 0,
                "Rezultatul derivarii lui " + polinom1 + " este " + rezultat);
    }

    @Test
    public void integrareTest(){
        Polinom polinom1 = new Polinom();
        polinom1.adauga(new Monom(6, 3));
        polinom1.adauga(new Monom(-3, 2));
        polinom1.adauga(new Monom(2, 1));

        String rezultat = "1,50x^4 - x^3 + x^2";
        assertTrue(Operatii.integreaza(polinom1).toString().compareTo(rezultat) == 0,
                "Rezultatul integrarii lui " + polinom1 + " este " + rezultat);
    }
}
