package form;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.regex.Pattern; 
 
public class Form extends JFrame {
 
   private final JPanel panel;
   private final JLabel label1, label2, label3, label4, label5;
   private final JTextField textField1, textField2;
   private final JPasswordField passField1, passField2;
   private JComboBox combo1, combo2, combo3;
   private final JButton Reset, Login;
   
    public static boolean Valid(String kataSandi){  
        String emailFormat = 
        "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
          
        Pattern p = Pattern.compile(emailFormat);  
        if(kataSandi == null){  
        return false;  
        }   
        return p.matcher(kataSandi).matches();  
    } 
 
   public Form() {
     Container c = getContentPane();
     c.setLayout(null);
     panel = new JPanel();
     label1 = new JLabel("Nama Pengguna");
     label1.setLayout(null);
     label1.setBounds(30,30,250,30);
     
     label2 = new JLabel("Kata Sandi");
     label2.setLayout(null);
     label2.setBounds(30, 60, 250, 30);
     
     label3 = new JLabel("Konfirmasi Kata Sandi");
     label3.setBounds(30, 90, 250,30);
     
     label4 = new JLabel("Email");
     label4.setBounds(30, 120, 250, 30);
     
     label5 = new JLabel("Tanggal Lahir");
     label5.setBounds(30, 150, 250, 30);
     
     textField1 = new JTextField(20);
     textField1.setBounds(170, 35, 250, 25);
     
     passField2 = new JPasswordField(20);
     passField2.setBounds(170, 65, 250, 25);
     
     passField1 = new JPasswordField(20);
     passField1.setBounds(170, 95, 250, 25);
     
     textField2 = new JTextField(20);
     textField2.setBounds(170, 125, 250, 25);
     
     combo1 = new JComboBox();
     combo1.setBounds(170, 155, 60, 25);
     combo1.addItem("");
     for(int i=1;i<32;i++){
         combo1.addItem(i);
     }
     combo2 = new JComboBox();
     combo2.setBounds(265, 155, 60, 25);
     combo2.addItem("");
     for(int i=1;i<13;i++){
         combo2.addItem(i);
     }
     combo3 = new JComboBox();
     combo3.setBounds(360, 155, 60, 25);
     combo3.addItem("");
     for(int i=1980;i<2021;i++){
         combo3.addItem(i);
     }
     Reset = new JButton("Reset");
     Reset.setBounds(260, 200, 90, 30);
     
     Login = new JButton("Login");
     Login.setBounds(120, 200, 90, 30);
     
     c.add(label1);
     c.add(textField1);
     c.add(label2);
     c.add(passField1);
     c.add(label3);
     c.add(passField2);
     c.add(label4);
     c.add(textField2);
     c.add(label5);
     c.add(combo1);
     c.add(combo2);
     c.add(combo3);
     c.add(Reset);
     c.add(Login);
     
     Login.addActionListener((ActionEvent ae) -> {
         if (textField1.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Nama Pengguna Harus Diisi!");
        } else if (passField1.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Kata Sandi Harus Diisi!");
        } else if (passField2.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Konfirmasi Kata Sandi Harus Diisi!");
        } else if (!passField1.getText().equals(passField2.getText())){
            JOptionPane.showMessageDialog(null, "Kata Sandi dan Konfirmasi Kata Sandi Harus Sama!");
        } else if (textField2.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Email harus Diisi!");
        } else if (Valid(textField2.getText())== false){
            JOptionPane.showMessageDialog(null, "Format Email Salah!");
        } else if (combo1.getSelectedItem()== ("")){
            JOptionPane.showMessageDialog(null, "Tanggal Harus Dipilih!");
        } else if (combo2.getSelectedItem()== ("")){
            JOptionPane.showMessageDialog(null, "Bulan Harus Dipilih!");
        } else if (combo3.getSelectedItem()== ("")){
            JOptionPane.showMessageDialog(null, "Tahun Harus Dipilih!");
        } else {
            JOptionPane.showMessageDialog(null, "Sukses Login!");
             textField1.setText("");
             textField2.setText("");
             passField1.setText("");
             passField2.setText("");
             combo1.setSelectedIndex(0);
             combo2.setSelectedIndex(0);
             combo3.setSelectedIndex(0);
        }
     });
     Reset.addActionListener((ActionEvent e) -> {
         int input = JOptionPane.showConfirmDialog(null, "Apakah Anda Yakin ?");
         if(input == JOptionPane.YES_OPTION){
             textField1.setText("");
             textField2.setText("");
             passField1.setText("");
             passField2.setText("");
             combo1.setSelectedIndex(0);
             combo2.setSelectedIndex(0);
             combo3.setSelectedIndex(0);
             }
        });
  }
   
  public static void main(String[] args) {
     Form frame = new Form();
     frame.setTitle("Program Pendaftaran");
     frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     frame.setSize(500, 300);
     frame.setVisible(true);
     
  }
}