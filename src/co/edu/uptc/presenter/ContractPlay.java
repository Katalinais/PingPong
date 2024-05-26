package co.edu.uptc.presenter;

public interface ContractPlay {
    interface model{
        void setPresenter(Presenter presenter);
    }

    interface presenter{

        void setModel(model model);

        void setView(view view);
    }

    interface view{
        void setPresenter(Presenter presenter);
    }
}
