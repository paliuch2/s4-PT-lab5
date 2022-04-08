package pl.pal.kamil.pt5;

import java.util.Optional;

public class ZarzadzaniePiwami {
    private BazaPiw baza;

    public ZarzadzaniePiwami(BazaPiw baza) {
        this.baza = baza;
    }

    public String znajdz(String nazwa) {
        Optional<Piwo> znaleziono = baza.znajdz(nazwa);

        if (znaleziono.isPresent()) {
            return znaleziono.get().toString();
        }
        return "not found";
    }

    public String usun(String nazwa) {
        try {
            baza.usun(nazwa);
        } catch (IllegalArgumentException e) {
            return "not found";
        }
        return "done";
    }

    public String dodaj(String nazwa, float procenty) {
        try {
            baza.dodaj(new Piwo(nazwa, procenty));
        } catch (IllegalArgumentException e) {
            return "bad request";
        }
        return "done";

    }

}
