package ohtu.verkkokauppa;

import ohtu.verkkokauppa.interfaces.ShoppingCart;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Ostoskori implements ShoppingCart{

    ArrayList<Tuote> tuotteet;

    public Ostoskori() {
        tuotteet = new ArrayList<Tuote>();
    }

    @Override
    public void lisaa(Tuote t) {
        tuotteet.add(t);
    }
    @Override
    public void poista(Tuote t) {
        tuotteet.remove(t);
    }
    @Override
    public int hinta() {
        int hinta = 0;

        for (Tuote tuote : tuotteet) {
            hinta += tuote.getHinta();
        }

        return hinta;
    }
}
