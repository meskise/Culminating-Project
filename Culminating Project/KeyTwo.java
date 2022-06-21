import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KeyTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KeyTwo extends Key
{
    //Sets counter to 0
    int counter = 0;
    public KeyTwo()
    {
        GreenfootImage image = getImage();
        image.scale(30, 30);
        setImage(image);
    }
    
    /**
     * Act - do whatever the KeyTwo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (isTouching(PlayerOne.class) && Greenfoot.isKeyDown("f"))
        {
            // Remove key after touching player.
            getWorld().removeObject(this);
            
        }
    }
}
