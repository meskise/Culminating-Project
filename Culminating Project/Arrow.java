import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Arrow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Arrow extends Actor
{

    boolean isFacingRight;
    // Movement.
    double deltaX = 0;
    double deltaY = 0;
    // Rotation.
    public static int rotation = 0;
    // Actors.
    private Actor playerone;
    private Actor bow;
    public Arrow()
    {
        GreenfootImage image = getImage();
        image.scale(4, 20);
        setImage(image);
    }
    
    /**
     * Act - do whatever the Arrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        bowShoot();
    }    
    
    public void bowShoot()
    {
        // Rotation is the rotation of the arrow.
        rotation = getRotation();
        
        if (rotation >= 180)
        {
            isFacingRight = false;
        }
        else
        {
            isFacingRight = true;
        }
        
        if (isFacingRight == true)
        {
            deltaX = 7;
        }
        
        if (isFacingRight == false)
        {
            deltaX = -7;
        }
        
        setLocation(getX() + (int)deltaX, getY() + (int)deltaY);
    }
}
