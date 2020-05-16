/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcado;

import javax.swing.ImageIcon;

/**
 *
 * @author Nicolas Florez
 */
public class Animator {

    public void IniciarAnimacion() {

        Animation anim = new Animation();

        anim.setVisible(true);

        for (int i = 1; i <= 27; i++) {
            int sleep = 400;
            ImageIcon frame = new ImageIcon(getClass().getClassLoader().getResource("Frames\\Frame_" + i + ".png"));
            anim.setSize(frame.getIconWidth(), frame.getIconHeight());
            anim.Labeler.setIcon(frame);
            if(i>=13 && i<=23 ){
                sleep = 100;
            }
            if(i>=24){
                sleep=800;
            }
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {
            }
        }

    }

}
