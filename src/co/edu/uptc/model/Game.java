package co.edu.uptc.model;

import co.edu.uptc.pojo.ElementPojo;
import co.edu.uptc.presenter.ContractPlay;
import co.edu.uptc.presenter.Presenter;
import co.edu.uptc.utils.GameConstants;

import java.awt.*;

public class Game implements ContractPlay.model {
    private ContractPlay.presenter presenter;
    private Racket racketLeft;
    private Racket racketRight;
    private Ball ball;
    private boolean endGame;

    public Game() {
        initComponents();
    }

    public void initComponents(){
        racketLeft = new Racket(0,50,GameConstants.WIDTH_RACKET, GameConstants.HEIGHT_RACKET);
        racketRight = new Racket(GameConstants.GAME_WIDTH-30,50,GameConstants.WIDTH_RACKET, GameConstants.HEIGHT_RACKET);
        ball = new Ball(50,50,GameConstants.WIDTH_BALL, GameConstants.HEIGHT_BALL);
        endGame = false;
    }

    @Override
    public void setPresenter(Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public Ball getBall() {
        return ball;
    }

    @Override
    public Racket getRacketLeft() {
        return racketLeft;
    }

    @Override
    public Racket getRacketRight() {
        return racketRight;
    }

    @Override
    public boolean getEndGame(){
        return endGame;
    }

    public boolean collision(ElementPojo e1) {
        Rectangle racket = new Rectangle(e1.getX(), e1.getY(), e1.getWidth(), e1.getHeight());
        Rectangle ballRectangle = new Rectangle(ball.elementPojo.getX(), ball.elementPojo.getY(), ball.elementPojo.getWidth(), ball.elementPojo.getHeight());
        return racket.intersects(ballRectangle);
    }

    @Override
    public void update(Rectangle bounds){
        ball.move(bounds, collision(racketLeft.elementPojo), collision(racketRight.elementPojo));
    }
}
