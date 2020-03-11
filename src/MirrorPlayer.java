import java.awt.*;

public class MirrorPlayer extends Sprite {

    Game game;
    int dx = 4, dy = 4;

    public MirrorPlayer(Color color, int x, int y, int width, int height, Board board, Game game, int phase) {
        super(color, x, y, width, height, board, phase);
        this.game = game;
    }


    @Override
    public void move(){
        if(game.isUpPressed()&&board.getHeight()>(y+height)){
            y+=dy;
        }
        if(game.isDownPressed()&&0<(y)){
            y-=dy;
        }
        if(game.isLeftPressed()&&(600)>(x+width)){
            x+=dx;
        }
        if(game.isRightPressed()&&0<x){
            x-=dx;
        }

    }




    @Override
    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }


}