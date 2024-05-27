package co.edu.uptc.presenter;

import co.edu.uptc.model.Ball;
import co.edu.uptc.model.Racket;

import java.awt.*;

public interface ContractPlay {
    interface model{
        void setPresenter(Presenter presenter);

        Ball getBall();

        Racket getRacketLeft();

        Racket getRacketRight();

        boolean getEndGame();

        int getLeftScore();

        int getRightScore();

        void finishGame();

        void update(Rectangle bounds);
    }

    interface presenter{

        void setModel(model model);

        void setView(view view);

        Ball getBall();

        Racket getRacketLeft();

        Racket getRacketRight();

        void update(Rectangle bounds);

        boolean getEndGame();

        int getLeftScore();

        int getRightScore();
    }

    interface view{

        void updateScreen();

        void update();

        void setPresenter(Presenter presenter);
    }
}
