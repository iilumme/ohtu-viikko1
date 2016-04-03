package ohtu.verkkokauppa.interfaces;

import ohtu.verkkokauppa.Tuote;

public interface ShoppingCart {
    void lisaa(Tuote t);

    void poista(Tuote t);

    int hinta();
}
