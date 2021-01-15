package Controller;
import Entity.AdminEntity;
import Entity.DaftarPenyewaEntity;
import Entity.PenyewaEntity;
import java.util.Date;
import java.util.ArrayList;
public class AdminController implements ControllerInterface{
    int indexLogin = 0;
    public AdminController() {    
    }
    
    public void datapegawai(){
        String id[] = {"01","02","03"};
        String nama [] = {"budi","bri","dandy"};
        String alamat [] = {"surabaya","surabaya","sidoarjo"};
        String noIdentitas [] = {"01","02","03"};
        String notelp [] = {"01","02","03"};
              for(int i=0;i<id.length;i++){
                AllObjectModel.pegawaiModel.insertPegawai(new 
                AdminEntity(id[i],nama[i],alamat[i],
                noIdentitas[i],notelp[i]));
            }
    }
    
    @Override
    public void login(String id, String nama) {
        indexLogin =  AllObjectModel.pegawaiModel.cekData(id, nama);
    }
    
    public AdminEntity PegawaiEntity() {
        return AllObjectModel.pegawaiModel.showDataPegawai(indexLogin);
    }
    
    public void updateIsVerified(int index,int indexPembeli,PenyewaEntity pembeli ) {
        AllObjectModel.daftarPembelimodel.updateIsVerified(index, new 
        DaftarPenyewaEntity(indexPembeli, pembeli,true));
    }
    
    public ArrayList<DaftarPenyewaEntity> cekDaftarPembeliModel() {
        return AllObjectModel.daftarPembelimodel.getdaftarpembeliArrayList();
    }
}
