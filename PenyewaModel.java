package Model;
import Entity.ApartemenEntity;
import Entity.PenyewaEntity;
import Model.DaftarPenyewaModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
public class PenyewaModel implements ModeIinterfaces { 
    private ArrayList<PenyewaEntity> pembeliEntityArrayList;
     
     public PenyewaModel(){
        pembeliEntityArrayList = new ArrayList<PenyewaEntity>();
    }
public void insert(PenyewaEntity pembeliEntity){ //menambah data pelanggan
    pembeliEntityArrayList.add(pembeliEntity);  
}
public void hapusPembeliModel(int index) { //hapus data pelanggan 
        pembeliEntityArrayList.remove(pembeliEntityArrayList.get(index));
    }
 public int size() {
        return pembeliEntityArrayList.size();
    }
 @Override
    public int cekData(String id, String nama){
        int loop = 0;
        while (!pembeliEntityArrayList.get(loop).getId().equals(id) && 
                !pembeliEntityArrayList.get(loop).getnama().equals(nama)){
            loop++;
        }
        return loop;
    }
    public PenyewaEntity getpembeliEntityArrayList(int index){ //
        return pembeliEntityArrayList.get(index);
    }
}
