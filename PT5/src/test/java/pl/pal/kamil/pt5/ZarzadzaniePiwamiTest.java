package pl.pal.kamil.pt5;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;

class ZarzadzaniePiwamiTest {

    @Test
    void TestUsuniecieIstniejacegoPiwaReturnsDone(){
        BazaPiw bp = mock(BazaPiw.class);
        doNothing().when(bp).usun("PiwoBazowe");
        ZarzadzaniePiwami zp = new ZarzadzaniePiwami(bp);
        assertThat(zp.usun("PiwoBazowe")).isEqualTo("done");
    }

    @Test
    void TestUsuniecieNieistniejacegoPiwaReturnsNotFound(){
        BazaPiw bp = mock(BazaPiw.class);
        doThrow(IllegalArgumentException.class).when(bp).usun("PiwoSpozaBazy");
        ZarzadzaniePiwami zp = new ZarzadzaniePiwami(bp);
        assertThat(zp.usun("PiwoSpozaBazy")).isEqualTo("not found");
    }

    @Test
    void TestPobranieNieistniejacegoPiwaReturnsNotFound(){
        BazaPiw bp = mock(BazaPiw.class);
        when(bp.znajdz("PiwoSpozaBazy")).thenReturn(Optional.empty());
        ZarzadzaniePiwami zp = new ZarzadzaniePiwami(bp);
        assertThat(zp.znajdz("PiwoSpozaBazy")).isEqualTo("not found");

    }

    @Test
    void TestPobranieIstniejacegoPiwaReturnsPiwoToString(){
        Piwo piwerko = new Piwo("PiwerkoBazowe", 10.5f);
        BazaPiw bp = mock(BazaPiw.class);
        when(bp.znajdz("PiwerkoBazowe")).thenReturn(Optional.of(piwerko));
        ZarzadzaniePiwami zp = new ZarzadzaniePiwami(bp);
        assertThat(zp.znajdz("PiwerkoBazowe")).isEqualTo(piwerko.toString());

    }

    @Test
    void TestZapisanieNowegoNieistniejacegoPiwaReturnsDone(){
        BazaPiw bp = mock(BazaPiw.class);
        ZarzadzaniePiwami zp = new ZarzadzaniePiwami(bp);
        assertThat(zp.dodaj("PiwoNowe",3.8f)).isEqualTo("done");

    }

    @Test
    void TestZapisanieNowegoIstniejacegoPiwaReturnsBadRequest(){
        BazaPiw bp = mock(BazaPiw.class);
        doNothing().doThrow(IllegalArgumentException.class).when(bp).dodaj(any(Piwo.class));
        ZarzadzaniePiwami zp = new ZarzadzaniePiwami(bp);
        assertThat(zp.dodaj("PowtarzalnePiwo",7.6f)).isEqualTo("done");
        assertThat(zp.dodaj("PowtarzalnePiwo",11.2f)).isEqualTo("bad request");

        verify(bp,times(2)).dodaj(any (Piwo.class));

    }

}