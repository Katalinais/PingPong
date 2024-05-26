package co.edu.uptc.model;

import co.edu.uptc.presenter.ContractPlay;
import co.edu.uptc.presenter.Presenter;

public class Game implements ContractPlay.model {
    private ContractPlay.presenter presenter;
    private Racket racket1;
    private Racket racket2;
    private Ball ball;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
