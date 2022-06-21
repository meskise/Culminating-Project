import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class YouDied here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class YouDied extends World
{
    int counter = 0;
    /**
     * Constructor for objects of class YouDied.
     * 
     */
    public YouDied()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    
    public void act()
    {
        counter++;
        if (counter == 50)
        {
            Greenfoot.setWorld(new HomeScreen());
        }
    }
}
