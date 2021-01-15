package Entity;
public class DaftarPenyewaEntity {
   private PenyewaEntity pembeli; 
    private boolean isVerified;
    private int indexTas; 
     public DaftarPenyewaEntity(int indexTas,
             PenyewaEntity pembeli, boolean isVerified) { 
         this.indexTas = indexTas;
        this.pembeli = pembeli;
        this.isVerified = isVerified;
    }
    public PenyewaEntity getPembeli() {
        return pembeli;
    }
    public boolean isIsVerified() {
        return isVerified;
    }
    public int getIndexTas() {
        return indexTas;
    }
    public void setPembeli(PenyewaEntity pembeli) {
        this.pembeli = pembeli;
    }
    public void setIsVerified(boolean isVerified) {
        this.isVerified = isVerified;
    }
    public void setIndexTas(int indexTas) {
        this.indexTas = indexTas;
    }
}
