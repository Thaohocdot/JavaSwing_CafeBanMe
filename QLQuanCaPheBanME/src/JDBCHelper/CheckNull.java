/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBCHelper;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Admin
 */
public class CheckNull {
    public static boolean Check(JTextField tf, String mss){
        if(tf.getText().equals("")){
            JOptionPane.showMessageDialog(null, mss);
            tf.setBackground(Color.YELLOW);
            tf.requestFocus();//đặt trỏ chuột vào ô tf
            return true; 
        }else{
            tf.setBackground(Color.white);
        }
        return false;
    }
}
