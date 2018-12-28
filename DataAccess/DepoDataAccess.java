/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nesneodev.DataAccess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Caglar
 */
public class DepoDataAccess extends DataAccessBase {
    
    //Depoda yüklü olan paketleri getirir.
    public ArrayList DepoPaketler() throws FileNotFoundException, IOException{
        
        File fl = new File(super.DataAccessPath + "\\Data\\Depo.txt");
        BufferedReader br = new BufferedReader(new FileReader(fl));
        ArrayList<Paket> paketler = new ArrayList<Paket>();
        
        String row;
        
        while((row = br.readLine()) != null){
            
            if(row.contains(" ")){
                String part[] = row.split(" ");
            
                paketler.add(new Paket(part[0], part[1].charAt(0), part[2].charAt(0), Double.parseDouble(part[3])));
            }
        }
        
        br.close();
        
        return paketler;
    }
    
}
