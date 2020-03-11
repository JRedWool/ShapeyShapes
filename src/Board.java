import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board extends JPanel implements ActionListener{
    Game game;
    Menu menu;
    Player player;
    MirrorPlayer mirrorPlayer;
    Split split;
    Timer timer;
    ArrayList<Sprite> actors;
    Food food;


    int paddingNum = 25;
    long moment;
    long nextMoment;


    public Board(Game game){
        this.game = game;
        setPreferredSize(new Dimension(1200, 800));
        setBackground(Color.BLACK);
        this.player = player;
        this.mirrorPlayer = mirrorPlayer;
        split = new Split(this);

    }

    public void setup(){

        STATS.getLevel();
        actors = new ArrayList<>();

        actors.add(new Player(Color.BLACK, 900, getHeight()/2, 50, 50, this, game, 2));
        actors.add(new MirrorPlayer(Color.WHITE, 250 , getHeight()/2, 50, 50, this, game, 2));

        for(int i = 1; i < STATS.getNumFood(); i++){
            actors.add(new Food(Color.CYAN, (int)(Math.random()*((600)-paddingNum)+paddingNum), (int)(Math.random()*(getHeight()-paddingNum)+paddingNum), 40,40,this, 2));
        }

        for(int i = 1; i < STATS.getNumEnemies(); i++){
            actors.add(new Enemy(Color.MAGENTA, (int)(Math.random()*((1200-600)+1)+600), (int)(Math.random()*(getHeight()-paddingNum)+paddingNum), 50,50,this, 2));

        }


        moment = System.currentTimeMillis();
        timer = new Timer(1000 / 60, this);
        timer.start();

    }

    public void clear(){
        for(int i = 0; i < actors.size(); i++){
            actors.get(i).setRemove();
        }
    }


    public void checkCollisions(){
        for(int i = 2; i < actors.size(); i++) {
            if (actors.get(0).collidesWith((actors.get(i)))) {

                if (actors.get(i) instanceof Enemy) {
                    game.setMouseClicked();
                    setup();

                }

                if (actors.get(i) instanceof Food) {
                    if (actors.get(i).getPhase() == 2) {

                        actors.add(new Food(Color.PINK, actors.get(i).getX(), actors.get(i).getY(), 20, 20, this, 1));
                        actors.add(new Food(Color.PINK, actors.get(i).getX(), actors.get(i).getY(), 20, 20, this, 1));
                        actors.get(i).setRemove();

                    }
                }
                if (actors.get(i) instanceof Food) {
                    if (actors.get(i).getPhase() == 1) {
                        {
                            actors.get(i).setRemove();
                        }
                    } else
                        actors.get(i).setRemove();
                }
            }

                if (actors.get(1).collidesWith((actors.get(i)))) {
                    if (actors.get(i) instanceof Enemy) {
                        game.setMouseClicked();
                        setup();
                    }

                    if (actors.get(i) instanceof Food) {
                        if (actors.get(i).getPhase() == 2) {
                            actors.add(new Food(Color.PINK, actors.get(i).getX(), actors.get(i).getY(), 20, 20, this, 1));
                            actors.add(new Food(Color.PINK, actors.get(i).getX(), actors.get(i).getY(), 20, 20, this, 1));
                            actors.get(i).setRemove();

                        }
                    }

                    if (actors.get(i) instanceof Food) {
                        if (actors.get(i).getPhase() == 1) {

                            actors.get(i).setRemove();
                        }

                    } else
                        actors.get(i).setRemove();
                }



        }

                for (int i = actors.size() - 1; i >= 0; i--) {
                    if (actors.get(i).isRemove()) {
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



        if(STATS.getFoodCurrent(actors) == 0){
            game.setMouseClicked();
            //STATS.setLevel(STATS.getLevel()+1);
            STATS.updateLevel();
            Gamestates.setSTART(false);
            setup();
        }

        repaint();
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        split.paint(g);



            for(Sprite thisGuy: actors){
                thisGuy.paint(g);}


    }

    private void printSimpleString(String s, int width, int i, int i1, Graphics g) {
        int stringLen = (int)g.getFontMetrics().getStringBounds(s,g).getWidth();
        int start = width/2 - stringLen/2;
        g.drawString(s, start+i, i1);
    }


}
