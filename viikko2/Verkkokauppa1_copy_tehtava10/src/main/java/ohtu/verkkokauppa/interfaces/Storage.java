package ohtu.verkkokauppa.interfaces;

import ohtu.verkkokauppa.Tuote;

public interface Storage {
    Tuote haeTuote(int id);

    int saldo(int id);

    void otaVarastosta(Tuote t);

    void palautaVarastoon(Tuote t);
}
