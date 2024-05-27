package co.edu.uptc.presenter;

import co.edu.uptc.model.Ball;
import co.edu.uptc.model.Game;
import co.edu.uptc.model.Racket;
import co.edu.uptc.view.DashBoard;

import java.awt.*;

public class Presenter implements ContractPlay.presenter{
    private ContractPlay.model model;
    private ContractPlay.view view;

    public Presenter(){
        makeMVP();
    }

    public void makeMVP(){
        Game game = new Game();
        game.setPresenter(this);

        DashBoard dashBoard = new DashBoard();
        dashBoard.setPresenter(this);

        setModel(game);
        setView(dashBoard);

        view.updateScreen();
    }

    @Override
    public void setModel(ContractPlay.model model){
        this.model = model;
    }

    @Override
    public void setView(ContractPlay.view view){
        this.view = view;
    }


    @Override
    public Ball getBall(){
        return model.getBall();
    }

    @Override
    public Racket getRacketLeft(){
        return model.getRacketLeft();
    }
    @Override
    public Racket getRacketRight(){
        return model.getRacketRight();
    }

    @Override
    public void update(Rectangle bounds){
        model.finishGame();
        model.update(bounds);
    }

    @Override
    public boolean getEndGame(){
        return model.getEndGame();
    }
    @Override
    public int getLeftScore(){
        return model.getLeftScore();
    }

    @Override
    public int getRightScore(){
        return model.getRightScore();
    }

}
