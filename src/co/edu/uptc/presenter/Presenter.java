package co.edu.uptc.presenter;

import co.edu.uptc.model.Game;
import co.edu.uptc.view.DashBoard;

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
    }

    @Override
    public void setModel(ContractPlay.model model){
        this.model = model;
    }

    @Override
    public void setView(ContractPlay.view view){
        this.view = view;
    }
}
