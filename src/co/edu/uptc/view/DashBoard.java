package co.edu.uptc.view;

import co.edu.uptc.presenter.ContractPlay;
import co.edu.uptc.presenter.Presenter;
import co.edu.uptc.utils.GameConstants;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DashBoard extends JFrame implements ContractPlay.view {
    public ContractPlay.presenter presenter;
    private GamePanel screenGame;

    public DashBoard() {
        setParameters();
        addPanels();
    }

    public void setParameters() {
        setTitle("Pong Game");
        setSize(GameConstants.GAME_WIDTH, GameConstants.GAME_HEIGHT);
        setLocationRelativeTo(null);
        setResizable(false);
        addKeyListener(new KeyboardEvent());
        setVisible(true);
        setFocusable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void addPanels() {
        screenGame = new GamePanel(this);
        add(screenGame);
    }

    @Override
    public void updateScreen() {
        screenGame.updateGame(presenter.getEndGame());
    }

    @Override
    public void update(){
        presenter.update(screenGame.getBounds());

    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public int getScoreLeft(){
        return presenter.getLeftScore();
    }

    public int getScoreRight(){
        return presenter.getRightScore();
    }
}
