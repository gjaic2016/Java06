package main;

public class Employee {

    private String ime;
    private String prezime;
    private int satnica;
    private int brojRadnihSati;

    public Employee(String ime, String prezime, int satnica, int brojRadnihSati) {
        this.ime = ime;
        this.prezime = prezime;
        this.satnica = satnica;
        this.brojRadnihSati = brojRadnihSati;
    }

    public Employee(){}

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public int getSatnica() {
        return satnica;
    }

    public void setSatnica(int satnica) {
        this.satnica = satnica;
    }

    public int getBrojRadnihSati() {
        return brojRadnihSati;
    }

    public void setBrojRadnihSati(int brojRadnihSati) {
        this.brojRadnihSati = brojRadnihSati;
    }
}
