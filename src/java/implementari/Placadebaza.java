package implementari;

/**
 *
 * @author Valentin
 */
public class Placadebaza extends Componenta{

    public Placadebaza(){
    super();}
    public Placadebaza(Integer codProdus, double pret, String marca, int anFabricatie, int garantie, String producator, String taraProvenienta, int stoc) {
        super(codProdus, pret, marca, anFabricatie, garantie, producator, taraProvenienta, stoc);

    }

    public Placadebaza(double pret, String marca, int anFabricatie, int garantie, String producator, String taraProvenienta, int stoc)
    {
        super(pret, marca, anFabricatie, garantie, producator, taraProvenienta, stoc);
    }
   
    
}