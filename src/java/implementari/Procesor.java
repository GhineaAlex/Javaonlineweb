package implementari;

/**
 *
 * @author Valentin
 */
public class Procesor extends Componenta {

    public Procesor() {
        super();
    }

    public Procesor(Integer codProdus, double pret, String marca, int anFabricatie, int garantie, String producator, String taraProvenienta, int stoc) {
        super(codProdus, pret, marca, anFabricatie, garantie, producator, taraProvenienta, stoc);
    }

    public Procesor(double pret, String marca, int anFabricatie, int garantie, String producator, String taraProvenienta, int stoc) {
        super(pret, marca, anFabricatie, garantie, producator, taraProvenienta, stoc);
    }
}