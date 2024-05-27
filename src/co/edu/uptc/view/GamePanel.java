package co.edu.uptc.view;

import co.edu.uptc.pojo.ElementPojo;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

public class GamePanel extends JPanel {
    private DashBoard dashBoard;

    public GamePanel(DashBoard dashBoard) {
        this.dashBoard = dashBoard;
        setParameters();
    }

    public void setParameters() {
        setBackground(Color.black);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setColor(Color.WHITE);
            //scoreBoard(g2);
            draw(g2);
        }

    }

    public void updateGame(boolean endGame) {
        while (!endGame) {
            dashBoard.update();
            repaint();
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public Rectangle2D makeFigure(ElementPojo elementPojo){
        return new Rectangle(elementPojo.getX(),elementPojo.getY(),elementPojo.getWidth(),elementPojo.getHeight());
    }

    public void draw(Graphics2D g) {
        Line2D.Double line = new Line2D.Double(getBounds().getCenterX(), 0, getBounds().getCenterX(),
                getBounds().getMaxY());

        g.draw(line);
        g.fill(makeFigure(dashBoard.presenter.getBall().getElementPojo()));
        g.fill(makeFigure(dashBoard.presenter.getRacketLeft().getElementPojo()));
        g.fill(makeFigure(dashBoard.presenter.getRacketRight().getElementPojo()));
    }
}
