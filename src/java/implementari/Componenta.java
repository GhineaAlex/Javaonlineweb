package implementari;

public abstract class Componenta {
    private Integer codProdus;
    private double pret;
    private String marca;
    private int anFabricatie;
    private int garantie;
    private String producator;
    private String taraProvenienta;
    private int stoc;
    public Componenta (){
    codProdus = 0;
    pret = 0;
    marca = "NULL";
    anFabricatie = 0;
    garantie = 0;
    producator = "NULL";
    taraProvenienta = "NULL";
    stoc = 0;
    }
    public Componenta(Integer codProdus, double pret, String marca, int anFabricatie, int garantie, 
            String producator, String taraProvenienta, int stoc) {
        this.codProdus = codProdus;
        this.pret = pret;
        this.marca = marca;
        this.anFabricatie = anFabricatie;
        this.garantie = garantie;
        this.producator = producator;
        this.taraProvenienta = taraProvenienta;
        this.stoc = stoc;
    }
    
    public Componenta(double pret, String marca, int anFabricatie, int garantie, String producator, 
            String taraProvenienta, int stoc) {
        this.pret = pret;
        this.marca = marca;
        this.anFabricatie = anFabricatie;
        this.garantie = garantie;
        this.producator = producator;
        this.taraProvenienta = taraProvenienta;
        this.stoc = stoc;
    }

    public Integer getCodProdus() {
        return codProdus;
    }

    public void setCodProdus(Integer codProdus) {
        this.codProdus = codProdus;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public int getGarantie() {
        return garantie;
    }

    public void setGarantie(int garantie) {
        this.garantie = garantie;
    }

    public String getProducator() {
        return producator;
    }

    public void setProducator(String producator) {
        this.producator = producator;
    }

    public String getTaraProvenienta() {
        return taraProvenienta;
    }

    public void setTaraProvenienta(String taraProvenienta) {
        this.taraProvenienta = taraProvenienta;
    }

    public int getStoc() {
        return stoc;
    }

    public void setStoc(int stoc) {
        this.stoc = stoc;
    }
    
    
    

    @Override
    public String toString() {
        return "Componenta{" + "codProdus=" + codProdus + ", pret=" + pret + ", marca=" + marca + ", anFabricatie=" + anFabricatie + ", garantie=" + garantie + ", producator=" + producator + ", taraProvenienta=" + taraProvenienta + '}';
    }
    
}  