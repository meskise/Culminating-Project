import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sword extends Actor
{
    private boolean swordThrow;
    boolean isFacingRight;
    double deltaX = 0;
    double deltaY = 0;
    int rotation = getRotation();
    public Sword()
    {
        // Load image and resize it.
        GreenfootImage image = getImage();
        image.scale(12, 45);
        setImage(image);
    }
    /**
     * Act - do whatever the Sword wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        if (Greenfoot.mousePressed(null) && isTouching(PlayerOne.class))
        {
            swordThrow = true;
        }
        
        if (rotation == 240)
        {
            isFacingRight = true;
        }
        else
        {
            isFacingRight = false;
        }
        
        
        if (isFacingRight == true && swordThrow == true)
        {
            setRotation(270);
            deltaX = 7;
        }
        
        if (isFacingRight == false && swordThrow == true)
        {
            setRotation(90);
            deltaX = -7;
        }
        setLocation(getX() + (int)deltaX, getY() + (int)deltaY);
    }
}
