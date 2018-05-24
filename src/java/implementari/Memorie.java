package implementari;


/**
 *
 * @author Valentin
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

public class Memorie extends Componenta{
    
    public Memorie()
    {
    super();
    }
    public Memorie(Integer codProdus, double pret, String marca, int anFabricatie, int garantie, String producator, String taraProvenienta, int stoc) {
        super(codProdus, pret, marca, anFabricatie, garantie, producator, taraProvenienta, stoc);
        
    }

    public Memorie(double pret, String marca, int anFabricatie, int garantie, String producator, String taraProvenienta, int stoc)
    {
        super(pret, marca, anFabricatie, garantie, producator, taraProvenienta, stoc);
    }

}