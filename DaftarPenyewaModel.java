package Model; 
import Entity.DaftarPenyewaEntity;
import Entity.ApartemenEntity;
import Entity.AdminEntity;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
import java.util.ArrayList; 
public class DaftarPenyewaModel implements ModeIinterfaces { 
    private ArrayList<DaftarPenyewaEntity> daftarpembeliArrayList;
    public DaftarPenyewaModel(){
    daftarpembeliArrayList = new ArrayList<DaftarPenyewaEntity>();
        }
    public void insertDataPembeli(DaftarPenyewaEntity daftarpembeli){
        daftarpembeliArrayList.add(daftarpembeli);
    }
    public ArrayList<DaftarPenyewaEntity> getdaftarpembeliArrayList(){
        return daftarpembeliArrayList;
    }
    @Override 
    public int cekData(String id, String nama){
        int loop = 0;
        if(daftarpembeliArrayList.size() ==0){
            loop = -1;//data kosong
        }else{
            for(int i = 0; i <daftarpembeliArrayList.size(); i++){
            if(daftarpembeliArrayList.get(i).getPembeli().getId().equals(id)){
                loop = i;
                break;
            }else{
                loop = -2;
                }
            }
        }   return loop;
    }
    public DaftarPenyewaEntity showDaftarPembeli(int index){
        return daftarpembeliArrayList.get(index); //menampilkan data pelanggan
    }
    public void hapusPembeliModel(int index) {
        daftarpembeliArrayList.remove(daftarpembeliArrayList.get(index)); //mengapus data pelanggan
    }
    public void updateIsVerified(int index,DaftarPenyewaEntity daftarpembeli){
    daftarpembeliArrayList.set(index, daftarpembeli); 
    }
    public ArrayList <DaftarPenyewaEntity> alldatapembeli(){
        return  daftarpembeliArrayList;
    }
}
