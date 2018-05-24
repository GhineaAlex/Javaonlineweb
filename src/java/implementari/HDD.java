package implementari;

/**
 *
 * @author Valentin
 */import java.io.Serializable;
public class HDD extends Componenta implements Serializable{
    //public static int stoc = 0;
  
    public HDD(Integer codProdus, double pret, String marca, int anFabricatie, int garantie, String producator, String taraProvenienta, int stoc) {
        super(codProdus, pret, marca, anFabricatie, garantie, producator, taraProvenienta, stoc);
        //stoc++;
    }
    
    public HDD(double pret, String marca, int anFabricatie, int garantie, String producator, String taraProvenienta, int stoc)
    {
        super(pret, marca, anFabricatie, garantie, producator, taraProvenienta, stoc);
    }

//    public static void setStoc(int stoc) {
//        HDD.stoc = stoc;
//    }
//    
//    public static int getStoc() {
//        return stoc;
//    }

    public HDD() {
        super();
    }
}