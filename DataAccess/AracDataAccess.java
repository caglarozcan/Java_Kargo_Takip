/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesneodev.DataAccess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
/**
 *
 * @author Caglar
 */
public class AracDataAccess extends DataAccessBase {
    
     public ArrayList AracGetir() throws IOException{
        return this.AracListe();
     }
    //Araç listesi detaylı bilgiler, max desi, özel desi, sigortalı desi
    public ArrayList AracDetayBigiler() throws FileNotFoundException, IOException{
        ArrayList<String> araclar = this.AracListe(); //Sistemdeki araçların plaka bilgileri
        
        ArrayList<Arac> aracDetayListe = new ArrayList<Arac>();
         
        for(int i=0; i<araclar.size(); i++){  
            File fl = new File(super.DataAccessPath + "\\Data\\Araclar\\" + araclar.get(i) + ".txt");
            BufferedReader br = new BufferedReader(new FileReader(fl));
            
            String row[] = br.readLine().split(" ");
            
            aracDetayListe.add(new Arac(row[0], Integer.parseInt(row[1]), Integer.parseInt(row[2]), Integer.parseInt(row[3])));
            System.out.println(br.readLine());
        }
         
         return aracDetayListe;
     }
    
    //Araçta yüklü paketlerin listesini getirir.
    public ArrayList AracYukluPaketler(String plaka) throws FileNotFoundException, IOException{
         ArrayList<Paket> paketler = new ArrayList<Paket>();
         File fl = new File(super.DataAccessPath + "\\Data\\Araclar\\" + plaka + ".txt");
         BufferedReader br = new BufferedReader(new FileReader(fl));
         
         String row;
         int i = 1;
         
         while((row = br.readLine()) != null){
             i++;
             if(i<4)
                 continue;
             
             String part[] = row.split(" ");
             
             paketler.add(new Paket(part[0], part[1].charAt(0), part[2].charAt(0), Double.parseDouble(part[3])));
         }
         
         return paketler;
     }
    
    //Araç listesini getirir.
    private ArrayList AracListe() throws FileNotFoundException, IOException{
        
        ArrayList<String> araclar = new ArrayList<String>();
         
        File fl = new File(super.DataAccessPath + "\\Data\\Depo.txt");
        BufferedReader br = new BufferedReader(new FileReader(fl));
        
        String row;
        
        while(!(row = br.readLine()).contains(" ") && row != "\n" && row.length() > 5){
            araclar.add(row);
        }
        
        br.close();
        
        return araclar;
     }
    
    //tek bir araca ait detaylı bilgiler.
    public Arac AracBilgiler(String plaka) throws FileNotFoundException, IOException{
         
         File fl = new File(super.DataAccessPath + "\\Data\\Araclar\\" + plaka + ".txt");
         BufferedReader br = new BufferedReader(new FileReader(fl));
         
         String[] part = br.readLine().split(" ");
         
         return new Arac(part[0], Integer.parseInt(part[1]), Integer.parseInt(part[2]), Integer.parseInt(part[3]));
     }
    
    //Araç ekleme.
    public boolean AracEkle(Arac arac) throws FileNotFoundException, IOException{
        
        DepoAracEkle(arac.Plaka);
        
        File aracDosya = new File(super.DataAccessPath + "\\Data\\Araclar\\" + arac.Plaka + ".txt");
        aracDosya.createNewFile();
        BufferedWriter bwArac = new BufferedWriter(new FileWriter(aracDosya, true));
        PrintWriter pwArac = new PrintWriter(bwArac);
        pwArac.println(arac.Plaka + " " + arac.MaxDesi + " " + arac.SigortaDesi + " " + arac.OzelDesi);
        bwArac.close();
        pwArac.close();
        
        return true;
     }
    
    //Eklenen aracı depo.txt dosyasına ekler.
    private void DepoAracEkle(String plaka) throws FileNotFoundException, IOException{
         ArrayList<String> depo = new ArrayList<String>();
         
        File fl = new File(super.DataAccessPath + "\\Data\\Depo.txt");
        BufferedReader br = new BufferedReader(new FileReader(fl));
        
        String row;
        
        while((row = br.readLine()) != null)
            depo.add(row);
        
        depo.add(0, plaka);
        
        PrintWriter writer = new PrintWriter(fl);
        writer.print("");
        writer.close();
        
        BufferedWriter bw = new BufferedWriter(new FileWriter(fl, true));
        PrintWriter pw = new PrintWriter(bw);
        for(String line : depo){
           pw.println(line);
        }

        br.close();
        pw.close();
        bw.close();
     }
    
    //Seçilen araç dosyasını sisteme aktarır.
    public boolean AracAktar(String dosyaYolu) throws FileNotFoundException, IOException{
        File fl = new File(dosyaYolu);
        BufferedReader br = new BufferedReader(new FileReader(fl));
        String[] line = br.readLine().split(" ");
        
        Arac arac = new Arac(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), Integer.parseInt(line[3]));
        
        DepoAracEkle(arac.Plaka);
       
        File dest = new File(super.DataAccessPath + "\\Data\\Araclar\\" + arac.Plaka + ".txt");
        
        copyFile(fl, dest);
        
        return true;
     }
    
    //Seçili paketlerin depoya yüklenmesi.
    public void PaketDepoYukle(String plaka, ArrayList<String> seciliPaketler) throws FileNotFoundException, IOException{
        
        ArrayList<String> paketler = new ArrayList<String>();
         
        File fl = new File(super.DataAccessPath + "\\Data\\Araclar\\" + plaka + ".txt");
        BufferedReader br = new BufferedReader(new FileReader(fl));
        String row;
        
        while((row=br.readLine()) != null){
            paketler.add(row);
        }
        
        File dfl = new File(super.DataAccessPath + "\\Data\\Depo.txt");
        BufferedWriter bwr = new BufferedWriter(new FileWriter(dfl, true));
        PrintWriter pw = new PrintWriter(bwr);
        
        for(int i=0; i<paketler.size(); i++){
            for(int j=0; j<seciliPaketler.size(); j++){
                if(paketler.get(i).contains(seciliPaketler.get(j))){
                    pw.println(paketler.get(i));
                    paketler.remove(i);
                }
            }
        }
        
        pw.close();
        bwr.close();
        
        PrintWriter writer = new PrintWriter(fl);
        writer.print("");
        writer.close();
        
        BufferedWriter wrt = new BufferedWriter(new FileWriter(fl, true));
        PrintWriter prt = new PrintWriter(wrt);
        
        for(int i=0; i<paketler.size(); i++){
            prt.println(paketler.get(i));
        }
        
        prt.close();
        wrt.close();
        
     }
    
    //Araçtaki tüm paketlerin depoya yüklenmesi.
    public void PaketDepoAktar(String plaka) throws FileNotFoundException, IOException{
        
        File fl = new File(super.DataAccessPath + "\\Data\\Araclar\\" + plaka + ".txt");
        BufferedReader br = new BufferedReader(new FileReader(fl));
        String row;
        
        File dfl = new File(super.DataAccessPath + "\\Data\\Depo.txt");
        BufferedWriter bwr = new BufferedWriter(new FileWriter(dfl, true));
        PrintWriter pw = new PrintWriter(bwr);
        
        String aracBilgi = br.readLine();
        
        for (int i = 0; i < 1; i++)
            br.readLine();
        
        while((row = br.readLine()) != null){
            pw.println(row);
        }
        
        pw.close();
        bwr.close();
        
        PrintWriter writer = new PrintWriter(fl);
        writer.print(aracBilgi);
        writer.close();
        
     }
    
    //Aracın sistemden çıkarılması.
    public void AracCikar(String plaka) throws FileNotFoundException, IOException{
        File fl = new File(super.DataAccessPath + "\\Data\\Depo.txt");
        BufferedReader br = new BufferedReader(new FileReader(fl));
        String row;
        ArrayList<String> veri = new ArrayList<String>();
         
        while((row = br.readLine()) != null){
            veri.add(row);
        }
         
        br.close();
        
        veri.remove(veri.indexOf(plaka));
         
        PrintWriter writer = new PrintWriter(fl);
        writer.print("");
        writer.close();
        
        BufferedWriter wrt = new BufferedWriter(new FileWriter(fl, true));
        PrintWriter pw = new PrintWriter(wrt);
        for(String line : veri){
            pw.println(line);
        }
        pw.close();
        wrt.close();
         
     }
    
    //Araca paket yüklenmesi.
    public boolean AracaPaketYukle(String plaka, ArrayList<Paket> seciliPaketler) throws IOException{
        
        Arac arac = AracBilgiler(plaka);
        Depo depo = new Depo();
        
        File aracDetay = new File(super.DataAccessPath + "\\Data\\Araclar\\" + plaka + ".txt");
        BufferedReader brdr = new BufferedReader(new FileReader(aracDetay));
        
        String pkt = brdr.readLine();
        pkt = brdr.readLine();
        
        while((pkt = brdr.readLine()) != null){
            if(pkt.split(" ")[2] == "N"){
                depo.topNormalDesi += Double.parseDouble(pkt.split(" ")[3]);
            }else if(pkt.split(" ")[2] == "T"){
                depo.topOzelDesi += Double.parseDouble(pkt.split(" ")[3]);
            }else if(pkt.split(" ")[2] == "S"){
                depo.topSigortaDesi += Double.parseDouble(pkt.split(" ")[3]);
            }
        }
        
        
        boolean hata = false;
        for(Paket paket : seciliPaketler){
            if(paket.IcerikTip == 'N'){
                depo.topNormalDesi += paket.Desi;
                if(!((arac.MaxDesi - arac.SigortaDesi) > depo.topNormalDesi || (arac.SigortaDesi - arac.OzelDesi) > depo.topNormalDesi)){
                    hata = true;
                    break;
                }
            }else if(paket.IcerikTip == 'T'){
                depo.topOzelDesi += paket.Desi;
                if(!((arac.SigortaDesi - (arac.SigortaDesi - arac.OzelDesi)) > depo.topOzelDesi)){
                    hata = true;
                    break;
                }
            }else if(paket.IcerikTip == 'S'){
                depo.topSigortaDesi += paket.Desi;
                if(!((arac.SigortaDesi - arac.OzelDesi) > depo.topNormalDesi)){
                    hata = true;
                    break;
                }
            }
        }
        
        if(!hata){
            File fl = new File(super.DataAccessPath + "\\Data\\Araclar\\" + plaka + ".txt");
            BufferedWriter wr = new BufferedWriter(new FileWriter(fl, true));
            PrintWriter pwr = new PrintWriter(wr);
            
            for(Paket paket : seciliPaketler){
                pwr.println(paket.SeriNo + " " + paket.Tip + " " + paket.IcerikTip + " " + Double.toString(paket.Desi));
            }
            
            pwr.close();
            wr.close();
            
            //Depo.txt den de paketleri çıkar.
            File depoFl = new File(super.DataAccessPath + "\\Data\\Depo.txt");
            BufferedReader rd = new BufferedReader(new FileReader(depoFl));
            String row;
            ArrayList<String> liste = new ArrayList<String>();
         
            while((row = rd.readLine()) != null){
                    liste.add(row);
            }
            
            for(Paket line : seciliPaketler)
                liste.removeIf(s->s.contains(line.SeriNo));
            
            rd.close();
            depoFl.delete();
            depoFl.createNewFile();
            
            File dfl = new File(super.DataAccessPath + "\\Data\\Depo.txt");
            BufferedWriter bwrt = new BufferedWriter(new FileWriter(dfl, true));
            PrintWriter pwrt = new PrintWriter(bwrt);
            
            for(int i=0; i<liste.size(); i++){
                pwrt.println(liste.get(i));
            }
            
            pwrt.close();
            bwrt.close();
            
            return true;
        }
        
        return hata;
    }
     
    //Dosya kopyalama metodu.
    private void copyFile(File source, File dest) throws IOException {
         //Seçilen araç dosyasını data klasörüne kopyalama.
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (input != null)
            input.close();
            if (output != null)
            output.close();
        }
    }
}
