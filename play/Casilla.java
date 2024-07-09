
package play;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Casilla{

    private int i,j;
    private ImageIcon icono;
    private JButton boton = new JButton();
    private boolean lado;

    public Casilla(int i, int j, String fondoRedimensionado){
        this.i = i;
        this.j = j;
        this.icono = new ImageIcon(fondoRedimensionado);
        this.boton.setIcon(icono);
        this.lado = false;
    }

    public boolean getLado() {
        return lado;
    }
    public void setLado(boolean lado) {
        this.lado = lado;
    }
    public Casilla(){
        this.icono = new ImageIcon();
        this.lado = false;
    }


    public void setBoton(JButton boton){
        this.boton = boton;
    }

    public JButton getBoton(){
        return boton;
    }

    public void accion(JButton boton, ImageIcon icono){
        //this.boton 
    }
    
     // Getters y Setters
     public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    public ImageIcon getIcono() {
        return icono;
    }

    public void setIcono(ImageIcon icono) {
        this.icono = icono;
        boton.setIcon(icono);
    }
    public void setEnabled(boolean b) {
        throw new UnsupportedOperationException("Unimplemented method 'setEnabled'");
    }
    

}