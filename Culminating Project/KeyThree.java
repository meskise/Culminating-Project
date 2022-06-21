import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class KeyThree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class KeyThree extends Key
{
    public KeyThree()
    {
        //Sets scale of image
        GreenfootImage image = getImage();
        image.scale(30, 30);
        setImage(image);
    }
    
    /**
     * Act - do whatever the KeyThree wants to do. This method is called whenever
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
