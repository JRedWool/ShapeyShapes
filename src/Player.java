import java.awt.*;

public class Player extends Sprite {

    Game game;
    int dx = 4, dy = 4;


    public Player(Color color, int x, int y, int width, int height, Board board, Game game, int phase){
        super(color, x, y, width, height, board, phase);
        this.game = game;

    }


    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }


    @Override
    public void move(){
        if(game.isUpPressed()&&(0)<(y)){
            y-=dy;
        }
        if(game.isDownPressed()&&board.getHeight()>(y+height)){
            y+=dy;
        }
        if(game.isLeftPressed()&&(600)<x){
            x-=dx;
        }
        if(game.isRightPressed()&&board.getWidth()>(x+width)){
            x+=dx;
        }

    }




    @Override
    public void paint(Graphics g) {
        g.setColor(getColor());
        g.fillRect(getX(), getY(), getWidth(), getHeight());
    }


}
