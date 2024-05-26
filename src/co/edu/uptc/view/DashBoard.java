package co.edu.uptc.view;

import co.edu.uptc.presenter.ContractPlay;
import co.edu.uptc.presenter.Presenter;

public class DashBoard implements ContractPlay.view {
    public ContractPlay.presenter presenter;

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }
}
