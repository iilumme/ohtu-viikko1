
package ohtu.verkkokauppa;

import ohtu.verkkokauppa.interfaces.BookKeeping;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class Kirjanpito implements BookKeeping {
    
    private ArrayList<String> tapahtumat;

    public Kirjanpito() {
        tapahtumat = new ArrayList<String>();
    }

    @Override
    public void lisaaTapahtuma(String tapahtuma) {
        tapahtumat.add(tapahtuma);
    }
    @Override
    public ArrayList<String> getTapahtumat() {
        return tapahtumat;
    }       
}
