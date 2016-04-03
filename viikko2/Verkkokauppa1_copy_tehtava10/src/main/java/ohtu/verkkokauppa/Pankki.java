package ohtu.verkkokauppa;

import ohtu.verkkokauppa.interfaces.Bank;
import ohtu.verkkokauppa.interfaces.BookKeeping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Pankki implements Bank {

    private BookKeeping kirjanpito;

    @Autowired
    public Pankki(BookKeeping b) {
        kirjanpito = b;
    }

    @Override
    public boolean tilisiirto(String nimi, int viitenumero, String tililta, String tilille, int summa) {
        kirjanpito.lisaaTapahtuma("tilisiirto: tililtä " + tilille + " tilille " + tilille
                + " viite " + viitenumero + " summa " + summa + "e");

        // täällä olisi koodi joka ottaa yhteyden pankin verkkorajapintaan
        return true;
    }
}
