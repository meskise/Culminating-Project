import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PickUp here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PickUp extends Actor
{   
    private int counter = 0;
    public PickUp()
    {
        // Load image and resize it.
        GreenfootImage image = getImage();
        image.scale(125, 40);
        setImage(image);
    }
    /**
     * Act - do whatever the PickUp wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        counter++; 
        if(counter >= 150)
        {
            getWorld().removeObject(this);
        }
    
    }
}
