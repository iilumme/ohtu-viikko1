package ohtu.verkkokauppa.interfaces;

import java.util.ArrayList;

public interface BookKeeping {
    void lisaaTapahtuma(String tapahtuma);

    ArrayList<String> getTapahtumat();
}
