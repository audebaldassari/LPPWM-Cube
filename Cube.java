package cube3d;

import java.awt.*;
import javax.swing.*;

public class Cube extends JPanel{

  private int arr�te;
  private Point centre;
  private Point[] tPoint;
  private Graphics graphique;
  private int largeurFen�tre = 700;
  private int hauteurFen�tre = 700;
  private int demiA;
  private int demiLargeurFen�tre;
  private int demiHauteurFen�tre;

  public Cube (int arr�te, Point centre, JPanel unPanneau) {

    super.setSize(this.largeurFen�tre,this.hauteurFen�tre);
    this.demiLargeurFen�tre = this.largeurFen�tre / 2;
    this.demiHauteurFen�tre = this.hauteurFen�tre / 2;
    this.graphique = unPanneau.getGraphics();
    this.arr�te = arr�te;
    this.centre = centre;
    this.demiA = this.arr�te / 2;
    this.tPoint = new Point[8];

    Point point1 = new Point(this.centre.getX()-demiA,
                             this.centre.getY()+demiA,
                             this.centre.getZ()+demiA);
    Point point2 = new Point(this.centre.getX()+demiA,
                             this.centre.getY()+demiA,
                             this.centre.getZ()+demiA);
    Point point3 = new Point(this.centre.getX()-demiA,
                             this.centre.getY()-demiA,
                             this.centre.getZ()+demiA);
    Point point4 = new Point(this.centre.getX()+demiA,
                             this.centre.getY()-demiA,
                             this.centre.getZ()+demiA);
    Point point5 = new Point(this.centre.getX()-demiA,
                             this.centre.getY()+demiA,
                             this.centre.getZ()-demiA);
    Point point6 = new Point(this.centre.getX()+demiA,
                             this.centre.getY()+demiA,
                             this.centre.getZ()-demiA);
    Point point7 = new Point(this.centre.getX()-demiA,
                             this.centre.getY()-demiA,
                             this.centre.getZ()-demiA);
    Point point8 = new Point(this.centre.getX()+demiA,
                             this.centre.getY()-demiA,
                             this.centre.getZ()-demiA);

    tPoint[0] = point1;
    tPoint[1] = point2;
    tPoint[2] = point3;
    tPoint[3] = point4;
    tPoint[4] = point5;
    tPoint[5] = point6;
    tPoint[6] = point7;
    tPoint[7] = point8;
  }

  public void rotationX(float degr�){
    for(int i=0;i<this.tPoint.length;i++){
      int z = this.tPoint[i].getZ();
      int y = this.tPoint[i].getY();
      this.tPoint[i].setX((int)1*this.tPoint[i].getX());
      this.tPoint[i].setY((int)(Math.cos(degr�)*y + (-(Math.sin(degr�)))*z));
      this.tPoint[i].setZ((int)(Math.sin(degr�)*y+Math.cos(degr�)*z));
    }
  }

  public void rotationY(float degr�){
    for(int i=0;i<this.tPoint.length;i++){
      int x = this.tPoint[i].getX();
      int z = this.tPoint[i].getZ();
      this.tPoint[i].setX((int)(Math.cos(degr�)*x + (-(Math.sin(degr�)))*z));
      this.tPoint[i].setY((int)1*this.tPoint[i].getY());
      this.tPoint[i].setZ((int)(Math.sin(degr�)*x+ Math.cos(degr�)*z));
    }
  }

  public void rotationZ(float degr�){
    for(int i=0;i<this.tPoint.length;i++){
      int x = this.tPoint[i].getX();
      int y = this.tPoint[i].getY();
      this.tPoint[i].setX((int)(Math.cos(degr�)*x + (-(Math.sin(degr�)))*y));
      this.tPoint[i].setY((int)(Math.sin(degr�)*x+ Math.cos(degr�)*y));
      this.tPoint[i].setZ((int)1*this.tPoint[i].getZ());
    }
  }

  public void paint(Graphics graphique) {
    try {
      graphique.setColor(Color.BLACK);
      graphique.fillRect(0,0,this.largeurFen�tre,this.hauteurFen�tre);
      graphique.setColor(Color.WHITE);
      graphique.drawLine(this.tPoint[0].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[0].getY(),
                         this.tPoint[1].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[1].getY());
      graphique.drawLine(this.tPoint[1].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[1].getY(),
                         this.tPoint[3].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[3].getY());
      graphique.drawLine(this.tPoint[3].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[3].getY(),
                         this.tPoint[2].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[2].getY());
      graphique.drawLine(this.tPoint[2].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[2].getY(),
                         this.tPoint[0].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[0].getY());
      graphique.drawLine(this.tPoint[0].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[0].getY(),
                         this.tPoint[4].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[4].getY());
      graphique.drawLine(this.tPoint[2].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[2].getY(),
                         this.tPoint[6].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[6].getY());
      graphique.drawLine(this.tPoint[3].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[3].getY(),
                         this.tPoint[7].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[7].getY());
      graphique.drawLine(this.tPoint[1].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[1].getY(),
                         this.tPoint[5].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[5].getY());
      graphique.drawLine(this.tPoint[4].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[4].getY(),
                         this.tPoint[5].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[5].getY());
      graphique.drawLine(this.tPoint[5].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[5].getY(),
                         this.tPoint[7].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[7].getY());
      graphique.drawLine(this.tPoint[7].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[7].getY(),
                         this.tPoint[6].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[6].getY());
      graphique.drawLine(this.tPoint[6].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[6].getY(),
                         this.tPoint[4].getX()+this.demiLargeurFen�tre, this.demiHauteurFen�tre- this.tPoint[4].getY());
    }
    catch (NullPointerException e) {
      System.out.println("Erreur --> Ne pointe sur rien");
    }
  }
}