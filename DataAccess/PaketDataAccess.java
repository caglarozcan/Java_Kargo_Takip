/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesneodev.DataAccess;

import java.awt.List;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author Caglar
 */
public class PaketDataAccess extends DataAccessBase {
    
    //Araçta yüklü olan paketleri getirir.
    public ArrayList AracaYukluPaketler(String plaka) throws FileNotFoundException, IOException{
        
        ArrayList<Paket> paketler = new ArrayList<Paket>();
        File fl = new File(super.DataAccessPath + "\\Data\\Araclar\\" + plaka + ".txt");
        
        BufferedReader bf = new BufferedReader(new FileReader(fl));
        String row;
        int i = 1;
        
        while((row = bf.readLine()) != null){
            i++;
            if(i<4)
                continue;
            
            String part[] = row.split(" ");
            
            paketler.add(new Paket(part[0], part[1].charAt(0), part[2].charAt(0), Double.parseDouble(part[3])));
        }
        
        bf.close();
        
        return paketler;
    }
    
    //Sisteme yeni paket ekleme.
    public boolean PaketEkle(Paket paket) throws IOException{
        
        File fl = new File(super.DataAccessPath + "\\Data\\Depo.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(fl, true));
        PrintWriter pw = new PrintWriter(bw);
        
        pw.println(paket.SeriNo + " " + paket.Tip + " " + paket.IcerikTip + " " + paket.Desi);
        
        bw.close();
        pw.close();
        
        return true;
    }
    
    //Depodan paket çıkarma.
    public void PaketCikar(ArrayList<String> paketler) throws IOException{
        
        File inputFile = new File(super.DataAccessPath + "\\Data\\Depo.txt");
        File tempFile = new File(super.DataAccessPath + "\\Data\\temp.txt");
        
        if(!tempFile.exists())
            tempFile.createNewFile();

        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        String row;
        boolean varmi=false;

        while((row = reader.readLine()) != null) {
            
            for(String paket : paketler)
            {
                if(paket.equals(row.split(" ")[0])){
                    varmi = true;
                    break;
                }else{
                    varmi = false;
                }
            }

            if(!varmi)
                writer.write(row + System.getProperty("line.separator"));
        }
        
        writer.close(); 
        reader.close();
        
        inputFile.delete();
        
        boolean olustur = tempFile.renameTo(inputFile);
    }
    
    //Depodaki paketlerin listesi.
    private ArrayList PaketListesi() throws FileNotFoundException, IOException{
        ArrayList<Paket> paketler = new ArrayList<Paket>();
        
        File fl = new File(super.DataAccessPath + "\\Data\\Depo.txt");
        BufferedReader br = new BufferedReader(new FileReader(fl));
        
        String row;
        while((row = br.readLine()) != null){
            
            if(!row.contains(" "))
                continue;
            
            String part[] = row.split(" ");
            
            paketler.add(new Paket(part[0], part[1].charAt(0), part[2].charAt(0), Double.parseDouble(part[3])));
        }
        br.close();
        return paketler;
    }
}
