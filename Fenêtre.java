package cube3d;

import java.awt.*;
import javax.swing.*;

public class Fenêtre extends JFrame implements Runnable {
  private float valeurdegré=0f;
  private float valeurdegré2=0f;
  private Cube unNouveauCube;
  private Cube unNouveauCubeCopie;
  private Point unPoint;
  private JPanel unUnivers ;
  public Fenêtre() {
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
          unNouveauCube.rotationZ( (float) valeurdegré);
          unNouveauCube.rotationY( (float) valeurdegré2);
          unNouveauCube.rotationX( (float)valeurdegré);
          unNouveauCube.repaint();
          valeurdegré = valeurdegré - 0.005f;
          valeurdegré2 = valeurdegré2 - 0.0345f;
          if(valeurdegré > 2*Math.PI)valeurdegré-=2*Math.PI;
          if(valeurdegré2 > 2*Math.PI)valeurdegré2-=2*Math.PI;
    }
}