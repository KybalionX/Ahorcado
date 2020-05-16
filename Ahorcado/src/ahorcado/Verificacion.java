package ahorcado;

import javax.swing.JOptionPane;

public class Verificacion {

    private String palabra;
    private int tamaño;
    private int intentos;

    public Verificacion(String palabra, int tamaño) {
        this.palabra = palabra;
        this.tamaño = tamaño;
        this.intentos = (tamaño * 2);
    }

    public void Verifica(String letra) {
        char[] palabrasus;
        String pala = "";
        int ite = 0;
        palabrasus = palabra.toCharArray();
        for (int i = 0; i < this.palabra.length(); i++) {
            if (letra.equals(Character.toString(palabrasus[i]))) {
                tamaño--;
            }
        }
        for (int j = 0; j < this.palabra.length(); j++) {
            if (letra.equals(Character.toString(palabrasus[j]))) {
            } else {
                pala += palabrasus[j];
            }
        }
        this.palabra = pala;
        validacion();

    }

    public void Verifica() {
        validacion();
    }

    private void validacion() {
        Animator anim = new Animator();
        intentos--;
        if (intentos == 0) {
            if (tamaño == 0) {
                JOptionPane.showMessageDialog(null, "gano");
            } else {

                anim.IniciarAnimacion();

            }
        } else if (tamaño == 0) {
            JOptionPane.showMessageDialog(null, "gano");
        }

    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public int getIntentos() {
        return intentos;
    }

    public void setIntentos(int intentos) {
        this.intentos = intentos;
    }

}
