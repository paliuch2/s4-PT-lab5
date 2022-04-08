package pl.pal.kamil.pt5;

import java.util.*;

public class BazaPiw {

    private Collection<Piwo> piwa = new HashSet<>() ;

    public BazaPiw() { }

    public Optional<Piwo> znajdz(String nazwa)
    {
        for (Piwo p : piwa)
        {
            if (p.getNazwa() == nazwa)
            {
                return Optional.of(p);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BazaPiw bazaPiw = (BazaPiw) o;
        return Objects.equals(piwa, bazaPiw.piwa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(piwa);
    }

    public Collection<Piwo> getPiwa() {
        return piwa;
    }

    public void setPiwa(Collection<Piwo> piwa) {
        this.piwa = piwa;
    }



    public void usun(String nazwa) throws IllegalArgumentException
    {
        for (Piwo p : piwa) {
            if (p.getNazwa() == nazwa) {
              piwa.remove(p);
              return;
            }
        }

        throw new IllegalArgumentException();
    }

    public void dodaj (Piwo piwo)
    {
        for (Piwo p : piwa) {
            if (p.getNazwa() == piwo.getNazwa()) {
                throw new IllegalArgumentException();
            }
        }
        piwa.add(piwo);
    }

}
