package View;
import Controller.AllObjectModel;
import Controller.PenyewaController;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
public class Budi07154_PegawaiGUI {
    private static PenyewaController pembeli = new PenyewaController();
    JFrame pegawai = new JFrame();
    JTable tabelpenyewa = new JTable();
    JScrollPane scrollpegawai = new JScrollPane(tabelpenyewa);
    JButton back,verif,hapus;
    JLabel admin,idlabel,namalabel;
    JTextField idtext,namatext;
     public Budi07154_PegawaiGUI(){
        pegawai.setSize(650,500);
        pegawai.setLayout(null);
        pegawai.getContentPane().setBackground(Color.RED);
        
        admin = new JLabel("Pegawai");
        admin.setBounds(250, 30, 200, 30);
        admin.setFont(new Font("Timer New Roman",Font.BOLD,26));
        pegawai.add(admin);
        
        scrollpegawai.setBounds(30, 100, 570, 200);
        tabelpenyewa.setModel(pembeli.daftarpel());
        pegawai.add(scrollpegawai);
        
        idlabel = new JLabel("Id");
        idlabel.setBounds(50, 320, 100, 30);
        pegawai.add(idlabel);
        idtext = new JTextField();
        idtext.setBounds(50, 350, 100, 30);
        pegawai.add(idtext);
        
        namalabel = new JLabel("Nama");
        namalabel.setBounds(200, 320, 100, 30);
        pegawai.add(namalabel);
        namatext = new JTextField();
        namatext.setBounds(200, 350, 100, 30);
        pegawai.add(namatext);
        
        verif = new JButton("verif");
        verif.setBounds(350, 350, 100, 30);
        verif.setBackground(Color.GRAY);
        pegawai.add(verif);
        
        back = new JButton("back");
        back.setBounds(50, 400, 100, 30);
        back.setBackground(Color.GRAY);
        pegawai.add(back);
        
        hapus = new JButton("Hapus");
        hapus.setBounds(350, 410, 100, 30);
        hapus.setBackground(Color.GRAY);
        pegawai.add(hapus);
        
        pegawai.setLocationRelativeTo(null);
        pegawai.setVisible(true);
        pegawai.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        back.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){
                pegawai.dispose();
                Budi07154_GUI men = new Budi07154_GUI();//nama objek men
            }
        });
        
        verif.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){ //untuk verifikasi id, dan nama
                String id = idtext.getText();
                String nama = namatext.getText();
                int index = AllObjectModel.daftarPembelimodel.cekData(id, nama); //dicek
                Budi07154_Allobjctrl.admin.updateIsVerified(index, Budi07154_Allobjctrl.pembeli.showDaftarPembeli(index)
                        .getIndexTas(),Budi07154_Allobjctrl.pembeli.showDaftarPembeli(index).getPembeli());
                tabelpenyewa.setModel(pembeli.daftarpel());
            }
        });
        
        hapus.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ae){ //untuk verifikasi id, dan nama
                String id = idtext.getText();
                int index = AllObjectModel.daftarPembelimodel.alldatapembeli().size(); //dicek
                Budi07154_Allobjctrl.pembeli.deleteDataPembeli(index);
                tabelpenyewa.setModel(pembeli.daftarpel());
            }
        });
        
        tabelpenyewa.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){  //method
                int i = tabelpenyewa.getSelectedRow();
                idtext.setText(Budi07154_Allobjctrl.pembeli.daftarpel().getValueAt(i, 0).toString());
                namatext.setText(Budi07154_Allobjctrl.pembeli.daftarpel().getValueAt(i, 1).toString());
            }
        });
     }
}