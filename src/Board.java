import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JPanel implements ActionListener{
    Game game;
    Box box;

    Timer timer;
    ArrayList<Sprite> actors;

    int paddingNum = 25;
    long moment;
    long nextMoment;


    public Board(Game game){
        this.game = game;
        setPreferredSize(new Dimension(600, 800));
        setBackground(Color.BLACK);

    }

    public void setup(){

        actors = new ArrayList<>();
        actors.add(new Player(Color.ORANGE, getWidth()/2, getHeight()/2, 50, 50, this, game));

        for(int i = 1; i < STATS.getNumFood(); i++){
            actors.add(new Food(Color.CYAN, (int)(Math.random()*(getWidth()-paddingNum)+paddingNum), (int)(Math.random()*(getWidth()-paddingNum)+paddingNum), 20,20,this));
        }

        for(int i = 1; i < STATS.getNumEnemies(); i++){
            actors.add(new Enemy(Color.MAGENTA, (int)(Math.random()*(getWidth()-paddingNum)+paddingNum), (int)(Math.random()*(getWidth()-paddingNum)+paddingNum), 20,20,this));

        }

        moment = System.currentTimeMillis();
        timer = new Timer(1000 / 60, this);
        timer.start();
        box = new Box();
        box.box(this);
    }


    public void checkCollisions(){
        for(int i = 1; i < actors.size(); i++){
            if(actors.get(0).collidesWith((actors.get(i)))){

                if(actors.get(i) instanceof Enemy){
                    game.setMouseClicked();
                    setup();
                }
                else
                    actors.get(i).setRemove();
            }
        }

        for(int i = actors.size()-1; i >= 0; i--){
            if(actors.get(i).isRemove()){
                actors.remove(i);
            }
        }

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        nextMoment = System.currentTimeMillis();

        if((nextMoment - game.getMoment()) >= 1500) {
            checkCollisions();
        }

        if(game.isMouseClicked()) {
            for(Sprite thisGuy: actors){
                thisGuy.move();
            }
        }

        if(actors.size() < STATS.getNumEnemies() +1){
            game.setMouseClicked();
            STATS.setLevel(STATS.getLevel()+1);
            STATS.updateLevel();
            setup();
        }

        repaint();
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        for(Sprite thisGuy: actors){
            thisGuy.paint(g);
        }

      //  box.paint(g);

    }


}
