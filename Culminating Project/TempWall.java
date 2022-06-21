import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TempWall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TempWall extends Platform
{
    public TempWall()
    {
        //Sets image scale
        GreenfootImage image = getImage();
        image.scale(40,40);
        setImage(image);
    }
    
    /**
     * Act - do whatever the TempWall wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (getWorld().getObjects(KeyTwo.class).isEmpty())
        {
            // Spawn temporary object on doors coordinates.
            getWorld().removeObject(this);
        }
    }
}
