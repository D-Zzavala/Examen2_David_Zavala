package examen2_davidzavala;

import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class AdminOrden {

    private ArrayList<Orden> Ordenes;
    private File Archivo;

    public AdminOrden() {
    }
    
    public AdminOrden(String path) {
        Archivo = new File(path);
    }

    public ArrayList<Orden> getOrdenes() {
        return Ordenes;
    }

    public void setOrdenes(ArrayList<Orden> Ordenes) {
        this.Ordenes = Ordenes;
    }

    public File getArchivo() {
        return Archivo;
    }

    public void setArchivo(File Archivo) {
        this.Archivo = Archivo;
    }

    public void setOrden(Orden orden) {
        Ordenes.add(orden);
    }
    
    public void CargarArchivo() {
        try {            
            Ordenes = new ArrayList();
            Orden temp;
            if (Archivo.exists()) {
                FileInputStream entrada
                    = new FileInputStream(Archivo);
                ObjectInputStream objeto
                    = new ObjectInputStream(entrada);
                try {
                    while ((temp = (Orden) objeto.readObject()) != null) {
                        Ordenes.add(temp);
                    }
                } catch (EOFException e) {
                    //encontro el final del archivo
                }
                objeto.close();
                entrada.close();
            }            
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void EscribirArchivo() {
        FileOutputStream fw = null;
        ObjectOutputStream bw = null;
        try {
            fw = new FileOutputStream(Archivo);
            bw = new ObjectOutputStream(fw);
            for (Orden t : Ordenes) {
                bw.writeObject(t);
            }
            bw.flush();
        } catch (Exception ex) {
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception ex) {
            }
        }
    }

    public void WriteFile(Orden orden, JTextArea text) {
        File archivo = null;
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            archivo = new File("./Ordenes/"+orden.getCliente()+","+orden.getNumero()+".txt");
            fw = new FileWriter(archivo, true);
            bw = new BufferedWriter(fw);
            bw.write(text.getText());
            bw.flush();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error en el Writer.");
        }
    }
    
}
