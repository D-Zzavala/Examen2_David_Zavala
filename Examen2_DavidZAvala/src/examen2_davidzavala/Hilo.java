package examen2_davidzavala;

import java.awt.TextArea;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

public class Hilo implements Runnable {

    private boolean Vive;
    private boolean siono;
    private Orden orden;
    private JProgressBar barra;
    private JTable tabla;
    private JTextArea text;

    public Hilo(Orden orden, JProgressBar barra, JTable tabla, JTextArea text) {
        this.orden = orden;
        this.barra = barra;
        this.tabla = tabla;
        this.text = text;
    }

    public boolean isSiono() {
        return siono;
    }

    public void setSiono(boolean siono) {
        this.siono = siono;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public JTextArea getText() {
        return text;
    }

    public void setText(JTextArea text) {
        this.text = text;
    }

    @Override
    public void run() {
        while (Vive) {

            text.append("Popeyes\n");
            Date fecha = new Date();
            SimpleDateFormat F = new SimpleDateFormat("MM/DD/YY");
            SimpleDateFormat H = new SimpleDateFormat("HH:MM:SS");
            F.format(fecha);
            H.format(fecha);
            text.append(F.toString() + "\n");
            text.append(H.toString() + "\n");

            while (siono) {
                if (orden.getPiezas() > 0) {

                    barra.setMaximum(orden.getPiezas());
                    for (int i = 0; i < orden.getPiezas(); i++) {
                        barra.setValue(i);
                    }

                    DefaultTableModel Model = (DefaultTableModel) tabla.getModel();
                    Object[] row = new Object[2];
                    row[0] = orden.getNumero();
                    row[1] = "Piezas";
                    row[2] = barra.getMaximum();
                    Model.addRow(row);
                    tabla.setModel(Model);

                    text.append("Piezas de Pollo" + orden.getPiezas() + "\n");

                } else if (orden.getFresco() > 0) {
                    DefaultTableModel Model = (DefaultTableModel) tabla.getModel();
                    barra.setMaximum(orden.getFresco());
                    for (int i = 0; i < orden.getFresco(); i++) {
                        barra.setValue(i);
                    }
                    Object[] row = new Object[2];
                    row[0] = orden.getNumero();
                    row[1] = "Fresco";
                    row[2] = barra.getMaximum();
                    Model.addRow(row);
                    tabla.setModel(Model);

                    text.append("Refresco(s)" + orden.getFresco() + "\n");

                } else if (orden.getBiscuit() > 0) {
                    DefaultTableModel Model = (DefaultTableModel) tabla.getModel();
                    barra.setMaximum(orden.getBiscuit());
                    for (int i = 0; i < orden.getBiscuit(); i++) {
                        barra.setValue(i);
                    }
                    Object[] row = new Object[2];
                    row[0] = orden.getNumero();
                    row[1] = "Biscuit";
                    row[2] = barra.getMaximum();
                    Model.addRow(row);
                    tabla.setModel(Model);

                    text.append("Biscuit(s)" + orden.getBiscuit()+ "\n");

                } else if (orden.getPapas() > 0) {
                    DefaultTableModel Model = (DefaultTableModel) tabla.getModel();
                    barra.setMaximum(orden.getPapas());
                    for (int i = 0; i < orden.getPapas(); i++) {
                        barra.setValue(i);
                    }
                    Object[] row = new Object[2];
                    row[0] = orden.getNumero();
                    row[1] = "Papas";
                    row[2] = barra.getMaximum();
                    Model.addRow(row);
                    tabla.setModel(Model);
                    
                    text.append("Papas" + orden.getPapas()+ "\n");

                } else if (orden.getPure() > 0) {
                    DefaultTableModel Model = (DefaultTableModel) tabla.getModel();
                    barra.setMaximum(orden.getPure());
                    for (int i = 0; i < orden.getPure(); i++) {
                        barra.setValue(i);
                    }
                    Object[] row = new Object[2];
                    row[0] = orden.getNumero();
                    row[1] = "Puré";
                    row[2] = barra.getMaximum();
                    Model.addRow(row);
                    tabla.setModel(Model);
                    
                    text.append("Puré(s)" + orden.getPure()+ "\n");

                } else if (orden.getPie() > 0) {
                    DefaultTableModel Model = (DefaultTableModel) tabla.getModel();
                    barra.setMaximum(orden.getPie());
                    for (int i = 0; i < orden.getPie(); i++) {
                        barra.setValue(i);
                    }
                    Object[] row = new Object[2];
                    row[0] = orden.getNumero();
                    row[1] = "Pie(s)";
                    row[2] = barra.getMaximum();
                    Model.addRow(row);
                    tabla.setModel(Model);
                    
                    text.append("Pie(s)" + orden.getPie()+ "\n");
                }
                
            }
        }
    }

}
