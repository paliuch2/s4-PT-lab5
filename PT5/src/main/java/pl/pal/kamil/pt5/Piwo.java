package pl.pal.kamil.pt5;

import java.util.Objects;

public class Piwo {
    private String nazwa;
    private float procenty;

    public Piwo(String nazwa, float procenty) {
        this.nazwa = nazwa;
        this.procenty = procenty;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public float getProcenty() {
        return procenty;
    }

    public void setProcenty(float procenty) {
        this.procenty = procenty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piwo piwo = (Piwo) o;
        return Float.compare(piwo.procenty, procenty) == 0 &&
                Objects.equals(nazwa, piwo.nazwa);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwa, procenty);
    }

    public String toString() {
        return this.nazwa + " "+ this.procenty;
    }


}
