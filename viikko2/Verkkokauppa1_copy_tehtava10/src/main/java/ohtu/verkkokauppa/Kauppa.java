package ohtu.verkkokauppa;

import ohtu.verkkokauppa.interfaces.Bank;
import ohtu.verkkokauppa.interfaces.Generator;
import ohtu.verkkokauppa.interfaces.ShoppingCart;
import ohtu.verkkokauppa.interfaces.Storage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Kauppa {

    private Storage varasto;
    private Bank pankki;
    private ShoppingCart ostoskori;
    private Generator viitegeneraattori;
    private String kaupanTili;

    @Autowired
    public Kauppa(Storage s, Bank b, Generator g) {
        varasto = s;
        pankki = b;
        viitegeneraattori = g;
        kaupanTili = "33333-44455";
    }

    public void aloitaAsiointi() {
        ostoskori = new Ostoskori();
    }

    public void poistaKorista(int id) {
        Tuote t = varasto.haeTuote(id); 
        varasto.palautaVarastoon(t);
    }

    public void lisaaKoriin(int id) {
        if (varasto.saldo(id)>0) {
            Tuote t = varasto.haeTuote(id);             
            ostoskori.lisaa(t);
            varasto.otaVarastosta(t);
        }
    }

    public boolean tilimaksu(String nimi, String tiliNumero) {
        int viite = viitegeneraattori.uusi();
        int summa = ostoskori.hinta();
        
        return pankki.tilisiirto(nimi, viite, tiliNumero, kaupanTili, summa);
    }

}
