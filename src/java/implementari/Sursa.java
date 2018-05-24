package implementari;

/**
 *
 * @author Alex
 */
public class Sursa extends Componenta {

    public Sursa() {
        super();
    }

    public Sursa(Integer codProdus, double pret, String marca, int anFabricatie, int garantie, String producator, String taraProvenienta, int stoc) {
        super(codProdus, pret, marca, anFabricatie, garantie, producator, taraProvenienta, stoc);
    }

    public Sursa(double pret, String marca, int anFabricatie, int garantie, String producator, String taraProvenienta, int stoc) {
        super(pret, marca, anFabricatie, garantie, producator, taraProvenienta, stoc);
    }
}