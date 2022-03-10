package cube3d;

import java.awt.*;
import javax.swing.*;

public class Fen�tre extends JFrame implements Runnable {
  private float valeurdegr�=0f;
  private float valeurdegr�2=0f;
  private Cube unNouveauCube;
  private Cube unNouveauCubeCopie;
  private Point unPoint;
  private JPanel unUnivers ;
  public Fen�tre() {
    this.setSize(700,700);
    this.setLocation(0,0);
    this.setTitle("Cube 3D");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Container maToile = this.getContentPane();
    maToile.setLayout(new BorderLayout());
    unUnivers = new JPanel();
    unUnivers.setSize(500,500);
    maToile.add(unUnivers,BorderLayout.CENTER);
    unPoint = new Point(0,0,0);
    unUnivers.setLayout(new BorderLayout());
  }


    public void run() {
      unNouveauCube = new Cube(150,
                             unPoint,
                             unUnivers);
    unUnivers.add(unNouveauCube,BorderLayout.CENTER);
          unNouveauCube.rotationZ( (float) valeurdegr�);
          unNouveauCube.rotationY( (float) valeurdegr�2);
          unNouveauCube.rotationX( (float)valeurdegr�);
          unNouveauCube.repaint();
          valeurdegr� = valeurdegr� - 0.005f;
          valeurdegr�2 = valeurdegr�2 - 0.0345f;
          if(valeurdegr� > 2*Math.PI)valeurdegr�-=2*Math.PI;
          if(valeurdegr�2 > 2*Math.PI)valeurdegr�2-=2*Math.PI;
    }
}