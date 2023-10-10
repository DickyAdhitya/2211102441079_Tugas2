import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Random;
import java.util.List;

/**
 * Write a description of class Myworld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Myworld extends World
{
    ScoreBoard ScoreBoard;

    float combo = 0;
    int shotDone = 0;
    int shotMiss = 0;
    Boards accBoard;
    Boards comboBoard;

    private void recalculate(){
        float accuracy;
        if(shotDone <=0){
            accuracy = 0;
        } else {
            accuracy = ((float) (shotDone - shotMiss) / shotDone) * 100;
        }

        accBoard.setMessage("Acc: " +accuracy + "%\nShot:" + shotDone + "%\nMiss: " + shotMiss);

    }

    private void updateCombo(){
        combo++;
        comboBoard.setMessage("combo: " + combo);
    }

    
    public void incShotMiss(){
        this.shotMiss++;
        combo = 0;
        comboBoard.setMessage("Combo: " + combo);
    }

    public Myworld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1200, 600, 1);
        spawnPlayer();
        prepare();
    }

    private void spawnPlayer(){
        Random rnd = new Random();
        Player p1 = new Player();
        p1.setRotation(270);
        this.addObject(p1, rnd.nextInt(this.getWidth() - 30), this.getHeight()-30);
    }

    private void spawnEnemies(){
        Random rnd = new Random();
        for(int i=0; 1<rnd.nextInt(5);  i++){
            Enemies en = new Enemies();
            this.addObject(en, rnd.nextInt(this.getWidth() -30), 5);    
        }
    }

    public void act(){
        List<Enemies> enemies = this.getObjects(Enemies.class);
        System.out.println(enemies.size());
        if(enemies.size()==0){
            spawnEnemies();
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}