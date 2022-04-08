package pl.pal.kamil.pt5;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

class BazaPiwTest {

    @Test
    void TestUsuniecieNieistniejacegoPiwaThrowsIllegalArgumentException()
    {
        BazaPiw bp = new BazaPiw();
        assertThatThrownBy(() -> {
            bp.usun("PiwoSpozaBazy");

        }).isOfAnyClassIn(IllegalArgumentException.class); }


    @Test
    void TestPobranieNieistniejacegoPiwa()
    {
        BazaPiw bp = new BazaPiw();
        assertThat(bp.znajdz("Piwerko")).isEqualTo(Optional.empty());
    };

    @Test
    void TestPobranieIstniejacegoPiwa()
    {
        BazaPiw bp = new BazaPiw();
        Piwo piwko = new Piwo("Piwko na przeciwko",3.69f);
        bp.dodaj(piwko);
        assertThat(bp.znajdz("Piwko na przeciwko")).isEqualTo(Optional.of(piwko));
    };

    @Test
    void TestZapisanieIstniejacegoPiwaThrowsIllegalArgumentException()
    {
        BazaPiw bp = new BazaPiw();
        bp.dodaj(new Piwo("PowtorzonePiwo", 4.20f));
        assertThatThrownBy(() -> {
            bp.dodaj(new Piwo("PowtorzonePiwo", 6.20f));

    }).isOfAnyClassIn(IllegalArgumentException.class); }

}