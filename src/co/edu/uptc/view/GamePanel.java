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
            scoreBoard(g2);
            draw(g2);
            dashBoard.update();
        }

    }

    public void updateGame(boolean endGame) {
        while (!endGame) {
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

    private void scoreBoard(Graphics2D g) {
        Font score = new Font("Magneto", Font.BOLD, 70);
        g.setFont(score);
        setScoreLeft(g);
        setScoreRight(g);
    }

    private void setScoreLeft(Graphics2D g) {

        g.drawString(Integer.toString(dashBoard.getScoreLeft()), (float) getBounds().getCenterX() - 70, 60);
        if (dashBoard.getScoreRight() == 5) {
            g.drawString("GAMER 2 WIN", (float) getBounds().getCenterX() -300 , (float) getBounds().getCenterY());
        }
    }

    private void setScoreRight(Graphics2D g) {

        g.drawString(Integer.toString(dashBoard.getScoreRight()), (float) getBounds().getCenterX() + 25, 60);
        if (dashBoard.getScoreLeft() == 5) {
            g.drawString("GAMER 1 WIN", (float) getBounds().getCenterX()-300 , (float) getBounds().getCenterY());
        }
    }
}
