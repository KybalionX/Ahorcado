package ahorcado;

import Extras.OSChecker;
import Music.Sound;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;

public class Animator {

    public void IniciarAnimacion() {
        
        String path = "";
        
        OSChecker checker = new OSChecker();
        
        if(checker.isWindows()){
            path = "Animations//Animacion.gif";
        }else if(checker.isLinux()){
            path = "Animations//Animacion.gif";
        }

        Icon icon = new ImageIcon(getClass().getClassLoader().getResource(path));
        JLabel label = new JLabel(icon);

        JFrame f = new JFrame("HAS PERDIDO!");
        f.getContentPane().add(label);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.pack();
        f.setLocationRelativeTo(null);

        Sound player = new Sound();

        player.play();

        f.setVisible(true);

        Timer timer = new Timer(14500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                JOptionPane.showMessageDialog(null, "perdio");
            }
        });
        timer.start();

    }
}
