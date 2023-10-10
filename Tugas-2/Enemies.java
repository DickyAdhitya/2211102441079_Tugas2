import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemies here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemies extends Characters
{
    /**
     * Act - do whatever the Enemies wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Enemies (){
        GreenfootImage img = this.getImage();
        img.scale(60, 60);
        this.setImage(img);
        this.setRotation(90);
    }
    
    public void act()
    {
            this.move(6);
            World wrld = this.getWorld();
            if(this.isTouching(Bullets.class)){
                wrld.removeObject(this);
            }
            
            if(this.getY() == wrld.getHeight()-1){
                wrld.removeObject(this);
            }
    }
}
