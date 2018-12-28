package nesneodev.DataAccess;

public class Paket {
    public String SeriNo;
    public char Tip;
    public char IcerikTip;
    public double Desi;
    
    public Paket(String seriNo, char tip, char icerikTip, double desi){
        this.SeriNo = seriNo;
        this.Tip = tip;
        this.IcerikTip = icerikTip;
        this.Desi = desi;
    }
}
