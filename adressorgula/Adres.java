package adressorgula;

/**
 * Created by MhmdAlmz on 30.07.2017.
 */

public class Adres {
    String mahalle;
    String ilçe;
    int postaKodu;
    String il;
    String ilce;
    String tip;
    String numara;
    String sokak;
    String Ulke;

    public String getUlke() {
        return Ulke;
    }

    public void setUlke(String ulke) {
        Ulke = ulke;
    }

    public String getSokak() {
        return sokak;
    }

    public void setSokak(String sokak) {
        this.sokak = sokak;
    }

    public String getNumara() {
        return numara;
    }

    public void setNumara(String numara) {
        this.numara = numara;
    }

    public String getTip() {
        return tip;
    }

    public void setTip(String tip) {
        this.tip = tip;
    }

    public String getAcikAdres() {
        return acikAdres;
    }

    public void setAcikAdres(String acikAdres) {
        this.acikAdres = acikAdres;
    }

    String acikAdres;


    public String getMahalle() {
        return mahalle;
    }

    public void setMahalle(String mahalle) {
        this.mahalle = mahalle;
    }

    public String getIlçe() {
        return ilçe;
    }

    public void setIlçe(String ilçe) {
        this.ilçe = ilçe;
    }

    public int getPostaKodu() {
        return postaKodu;
    }

    public void setPostaKodu(int postaKodu) {
        this.postaKodu = postaKodu;
    }

    public String getIl() {
        return il;
    }

    public void setIl(String il) {
        this.il = il;
    }

    public String getIlce() {
        return ilce;
    }

    public void setIlce(String ilce) {
        this.ilce = ilce;
    }
}
