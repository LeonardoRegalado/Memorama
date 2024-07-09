//package play;
import play.Casilla;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

public class Tablero{  
    public static int eleccion,a,b,i,j,validar = 0,j1,j2;
    public static Random numero = new Random();
    public static Casilla cartas[][] = new Casilla[8][5];
    public static ImageIcon seleccion[][] = new ImageIcon[8][5];
    public static JFrame ventana = new JFrame("Memorama");
    static JPanel panelDeContenido = new JPanel(new GridLayout(4, 5)); 
    public static Casilla aux[] = new Casilla[2];
    public static JLabel texto[] = new JLabel[8];
    public static JFrame resultado = new JFrame("Resultado");
    static ArrayList<String> nombres = new ArrayList<>();
    public static int bandera = 0,turnos;
    public static boolean jugador = false;
    public static ImageIcon fondos = new ImageIcon("play/memorama/fondo.jpg");
    public static int rango = 0, suma;

    public static void sumar_puntos(){
        switch (String.valueOf(jugador)) {
            case "false":
            j2++;
            suma++;
                texto[2].setText(String.valueOf(j2));
                break;
            case "true":
            j1++;
            suma++;
                texto[4].setText(String.valueOf(j1));
                break;
        }
    }
    public static void marcador(){
        Timer timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String resultados="";
                if (suma >= 20) {
                    if (j1>j2) {
                        resultados = " GANÓ JUGADOR 2";
                    }else if(j2 > j1){
                        resultados = " GANÓ JUGADOR 1";
                    }else{
                        resultados = "EMPATE";
                    }
                    texto[7] = new JLabel(resultados);
                    texto[7].setHorizontalAlignment(SwingConstants.CENTER);
                    resultado.add(texto[7]);
                    resultado.setVisible(true);
                }
            }
        });
        timer.setRepeats(false);
        timer.start(); 
    }

    public static void cambiar_turno(){
        bandera = 4;
        for ( i = 0; i < 2; i++) aux[i] = new Casilla();

    }


    public static void voltear() {
        Timer timer = new Timer(1600, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aux[0].getBoton().setIcon(new ImageIcon(fondos.getImage().getScaledInstance(150, 140, Image.SCALE_SMOOTH)));
                aux[1].getBoton().setIcon(new ImageIcon(fondos.getImage().getScaledInstance(150, 140, Image.SCALE_SMOOTH)));
                ((Timer)e.getSource()).stop(); // Detener el temporizador
                jugador = !(jugador);
                if (jugador) {
                    texto[6].setText("Jugador 2");
                }else{
                    texto[6].setText("Jugador 1");
                }
                aux[0].setLado(!aux[0].getLado());
                aux[1].setLado(!aux[1].getLado());
                cambiar_turno();
            }
        });
        timer.setRepeats(false);
        timer.start();
    }

    public static void deshabilitar(){
        aux[0].getBoton().setEnabled(false);
        aux[1].getBoton().setEnabled(false);
    }
    public static void agregar_cartas() {
        nombres.add("algas");
        nombres.add("amarillo");
        nombres.add("azul");
        nombres.add("burbuja");
        nombres.add("cafe");
        nombres.add("caracol");
        nombres.add("concha");
        nombres.add("naranja");
        nombres.add("rosa");
        nombres.add("verde");
        nombres.add("algas");
        nombres.add("amarillo");
        nombres.add("azul");
        nombres.add("burbuja");
        nombres.add("cafe");
        nombres.add("caracol");
        nombres.add("concha");
        nombres.add("naranja");
        nombres.add("rosa");
        nombres.add("verde");
        nombres.add("ballena");
        nombres.add("boca");
        nombres.add("caballo");
        nombres.add("calamar");
        nombres.add("camaron");
        nombres.add("cangrejo");
        nombres.add("estrella");
        nombres.add("gary");
        nombres.add("globo");
        nombres.add("pulpo");
        nombres.add("ballena");
        nombres.add("boca");
        nombres.add("caballo");
        nombres.add("calamar");
        nombres.add("camaron");
        nombres.add("cangrejo");
        nombres.add("estrella");
        nombres.add("gary");
        nombres.add("globo");
        nombres.add("pulpo");
    }

    public static void turno(Casilla actual) {
        turnos = turnos%2;
        if (turnos == 0) {
            for ( i = 0; i < 2; i++) {
                aux[i] = new Casilla();
            }
        }
        aux[turnos] = actual;
        turnos++;
        bandera++;//5
        bandera = bandera % 4;
        if (bandera == 0) {
            jugador = !(jugador);
        }
        if (jugador) {
            texto[6].setText("Jugador 2");
        }else{
            texto[6].setText("Jugador 1");
        }
    }

    public static void inicializar(){
        for ( i = 0; i < 8; i++) {
            for ( j = 0; j < 5; j++){  
                
                cartas[i][j] = new Casilla(i, j, "play/memorama/fondo.jpg");
                cartas[i][j].getBoton().setPreferredSize(new Dimension(150, 140));
            
                // Obtener el icono y escalar la imagen al tamaño del botón
                ImageIcon icono = cartas[i][j].getIcono();
                Image imagenEscalada = icono.getImage().getScaledInstance(150, 140, Image.SCALE_SMOOTH);
                icono = new ImageIcon(imagenEscalada);
                cartas[i][j].setIcono(icono);
               
                int a = cartas[i][j].getI();
                int b = cartas[i][j].getJ();


                cartas[i][j].getBoton().addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(cartas[a][b].getLado()){    // Voltea la carta 
                            cartas[a][b].getBoton().setIcon(new ImageIcon(new ImageIcon("play/memorama/fondo.jpg").getImage().getScaledInstance(150, 140, Image.SCALE_SMOOTH)));
                        }else{
                            cartas[a][b].setIcono(seleccion[a][b]);
                        }
                        cartas[a][b].setLado(!cartas[a][b].getLado());
                        
                        turno(cartas[a][b]);
                        System.out.println(aux[0].getIcono().getImage()+"--"+aux[1].getIcono().getImage());
                        if (aux[0].getIcono().getImage().equals(aux[1].getIcono().getImage()) && aux[0].getLado() == true &&  aux[1].getLado() == true ) {
                           
                            deshabilitar();
                            cambiar_turno();   //Si coinciden las imagenes
                            sumar_puntos();
                        }
                        if(bandera == 2 && !aux[1].getIcono().getImage().equals(null) && aux[0].getLado() == true ){
                            voltear();//Si no coinciden las imagenes
                        }else if(aux[0].getLado() == false &&  aux[1].getLado() == false){
                            cambiar_turno();      //Si voltea la misma imgen
                        }
                        marcador();
                    }
                });
                panelDeContenido.add(cartas[i][j].getBoton());
            }
        }
    }
    public static void memorama(){
        agregar_cartas();
        rango = 40;
        int num = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 5; j++) {
                rango--;
                if (nombres.size() != 1) {
                    num = numero.nextInt(rango);
                }else{
                    num = 0;
                }
                seleccion[i][j] = new ImageIcon("play/memorama/"+nombres.get(num)+".jpg");
                nombres.remove(nombres.get(num).toString());
            }
        }
    }
    public static void main(String[] args) {
        resultado.setSize(380,120);
        resultado.setLocationRelativeTo(null);
        ventana.setSize(1600, 860);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout()); 
        JPanel panelMarcadores = new JPanel(new GridLayout(1, 5));
        for (int k = 0; k < 8; k++) {
            texto[k] = new JLabel();
            panelMarcadores.add(texto[k]).setFont(new Font("Arial", Font.BOLD, 30));
        }
        for ( i = 0; i < 2; i++) {
            aux[i] = new Casilla();
        }
        ventana.add(panelMarcadores, BorderLayout.NORTH); 
        ventana.add(panelDeContenido,BorderLayout.CENTER);
        texto[0].setText(" Puntuación   ");
        texto[1].setText("   Jugador 1:");
        texto[2].setText("0");
        texto[3].setText("Jugador 2:");
        texto[4].setText("0");
        texto[5].setText("Turno:");
        texto[6].setText("Jugador 1");
        memorama(); 
        inicializar();
        ventana.setVisible(true);
    }   
}                                                                                                                                               