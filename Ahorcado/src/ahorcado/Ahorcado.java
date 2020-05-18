package ahorcado;

import Extras.OSChecker;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;

public class Ahorcado {
    
    

    static String CategoriaSeleccionada;
    static String Palabra;
    static Verificacion verifica;

    public static void main(String[] args) {
        
        MenuPrincipal menu = new MenuPrincipal();
        menu.setLocationRelativeTo(null);
        
        String OS = System.getProperty("os.name").toLowerCase();
        
        System.out.println("Sistema: "+OS);
        
        Categorias seleccionador = new Categorias();

        menu.btnIniciar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String Categoria = menu.ComboCategorias.getSelectedItem().toString();
                Palabra = seleccionador.SeleccionarPalabra(Categoria);
                System.out.println("Palabra: " + Palabra);
                InitJuego(Palabra);
                menu.dispose();
            }

        });

        menu.show();
    }

    public static void InitJuego(String Palabra) {

        //Se descompone la palabra en String para que sea una cadena y poder manejarla luego
        char[] letrasPalabra = Palabra.toCharArray();
        
        verifica = new Verificacion(Palabra, Palabra.length());

        final Juego ventanaJuego = new Juego();
        ventanaJuego.setLocationRelativeTo(null);
        GridLayout layout = new GridLayout(1, 1);
        layout.setRows(1);
        ventanaJuego.panelPalabras.setLayout(layout);

        ventanaJuego.FieldLetra.setDocument(new Limitador(1));

        TextField[] fields = new TextField[letrasPalabra.length];

        for (int i = 0; i < letrasPalabra.length; i++) {
            fields[i] = new TextField();
            ventanaJuego.panelPalabras.add(fields[i], BorderLayout.CENTER);
        }

        ventanaJuego.btnIntentar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String letraIntento = ventanaJuego.FieldLetra.getText().toLowerCase();
                ventanaJuego.FieldLetra.setText("");
                System.out.println("\nLetra Intento: " + letraIntento);
                for (int i = 0; i < letrasPalabra.length; i++) {
                    System.out.println("\nProbando si " + letraIntento + " se parece a: " + letrasPalabra[i]);
                    if (letraIntento.equals(String.valueOf(letrasPalabra[i]))) {
                        System.out.println("\nSe parece la letra " + letraIntento + " a la letra " + letrasPalabra[i] + ", que tiene como pos: " + i);
                        fields[i].setText(letraIntento);
                    }
                }
                if (Palabra.contains(letraIntento)) {
                    verifica.Verifica(letraIntento);
                } else {
                    verifica.Verifica();
                }
                System.out.println("intentos restantes " + verifica.getIntentos());
            }
        });

        ventanaJuego.setVisible(true);

    }

}
