package ahorcado;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ahorcado {
    
    static String CategoriaSeleccionada;
    static String Palabra;
    
    public static void main(String[] args) {
        
        MenuPrincipal menu = new MenuPrincipal();
        
        Categorias seleccionador = new Categorias();
        
        menu.btnIniciar.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                String Categoria = menu.ComboCategorias.getSelectedItem().toString();
                Palabra=seleccionador.SeleccionarPalabra(Categoria);
                System.out.println("Palabra: "+Palabra);
                
            }
            
        });
        
        
        menu.show();
        
    }
    
}
