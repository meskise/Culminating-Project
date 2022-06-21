import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FindKey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FindKey extends Actor
{
    private int counter = 0;
    public FindKey()
    {
        // Load image and resize it.
        GreenfootImage image = getImage();
        image.scale(125, 40);
        setImage(image);
    }
    /**
     * Act - do whatever the FindKey wants to do. This method is called whenever
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
