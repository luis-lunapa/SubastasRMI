package Cliente;


import javax.swing.*;
import java.io.*;


public class Utilidades {

    public static int generateRandom(int maximo, int minimo) {

        return minimo + (int) (Math.random() * ((maximo - minimo) + 1));

    }

  

    public static void showWarning(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error !", JOptionPane.WARNING_MESSAGE);
    }
    
    public static int showConfirm (String mensaje){
        int option = JOptionPane.showConfirmDialog(null, mensaje, "UBay", 0, 0, null);
        return option;
        
    }
    public static void showMessage (String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }



    

}
