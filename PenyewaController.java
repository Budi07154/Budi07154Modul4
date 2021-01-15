package Controller;
import Entity.DaftarPenyewaEntity;
import Entity.PenyewaEntity;
import Model.PenyewaModel;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
public class PenyewaController implements ControllerInterface{
    int indexLogin = 0;
    
    public PenyewaController() {
    }
    
    public PenyewaEntity getData() {
        return AllObjectModel.pembeliModel.getpembeliEntityArrayList(indexLogin);
    }
    
    public void DaftarPembeli(int indexCamera,  PenyewaEntity pembeli,
            boolean isVerified) {
        AllObjectModel.daftarPembelimodel.insertDataPembeli(new 
        DaftarPenyewaEntity (indexCamera,pembeli, isVerified));
    }
    
    @Override
    public void login(String id, String nama) {
        indexLogin = AllObjectModel.pembeliModel.cekData(id, nama);
    }
    
    public void insert(String id,String nama,
    String alamat, String noIdentitas,String notelp) {
        PenyewaEntity pelangganModel = new PenyewaEntity();
        pelangganModel.setid(id);
        pelangganModel.setnama(nama);
        pelangganModel.setalamat(alamat);
        pelangganModel.setnoIdentitas(noIdentitas);
        pelangganModel.setnotelp(notelp);
        AllObjectModel.pembeliModel.insert(pelangganModel);
    }

    public int cekDaftarPembeli(String id) {
        int cek = AllObjectModel.daftarPembelimodel.cekData(id, null);
        return cek;
    }
    
    public DaftarPenyewaEntity showDaftarPembeli(int index) {
        return AllObjectModel.daftarPembelimodel.showDaftarPembeli(index);
    }
    public void deleteDataPembeli(int index) {
        AllObjectModel.daftarPembelimodel.hapusPembeliModel(index);
    }
    public ArrayList<DaftarPenyewaEntity> cekDaftarPembeliModel() {
        return AllObjectModel.daftarPembelimodel.getdaftarpembeliArrayList();
    }
    public DefaultTableModel daftarpel(){
        DefaultTableModel dtmdaftarpel = new DefaultTableModel();
        Object[] kolom ={"Id","Nama","Alamat","No Pelanggan","No Telp","Apartemen","Verified"};
        dtmdaftarpel.setColumnIdentifiers(kolom);
        int size = AllObjectModel.daftarPembelimodel.alldatapembeli().size();
        String verif = null;
        for(int i=0;i<size;i++){
            if(AllObjectModel.daftarPembelimodel.alldatapembeli().get(i).isIsVerified()==false){
                verif = "NO";
            }else{
                verif = "YES";
            }
            Object [] data = new Object[9];
            data[0] = AllObjectModel.daftarPembelimodel.alldatapembeli().get(i).getPembeli().getId();
            data[1] = AllObjectModel.daftarPembelimodel.alldatapembeli().get(i).getPembeli().getnama();
            data[2] = AllObjectModel.daftarPembelimodel.alldatapembeli().get(i).getPembeli().getalamat();
            data[3] = AllObjectModel.daftarPembelimodel.alldatapembeli().get(i).getPembeli().getnoIdentitas();
            data[4] = AllObjectModel.daftarPembelimodel.alldatapembeli().get(i).getPembeli().getnotelp();
            data[5] = AllObjectModel.daftarPembelimodel.alldatapembeli().get(i).getIndexTas();
            data[6] = verif;
            dtmdaftarpel.addRow(data);
    }
        return dtmdaftarpel;
    }

}
