import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sword here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sword extends Actor
{
    // Booleans.
    private boolean swordThrow;
    private boolean swordPickedUp;
    boolean isFacingRight;
    // Movement.
    double deltaX = 0;
    double deltaY = 0;
    // Rotation.
    public static int rotation = 0;
    // Actors.
    private Actor playerone;
    private Actor sword;
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
        swordThrow();
    }
    
    public void swordThrow()
    {
        // Rotation is the rotation of the sword.
        rotation = getRotation();
        
        // If rotation of sword is 180 or higher, is facing right is true.
        if (rotation >= 180)
        {
            isFacingRight = true;
        }
        else // If sword rotation isn't 180 or higher, is facing right is false.
        {
            isFacingRight = false;
        }
        
        // If facing right and mouse is left clicked, throw sword right.
        if (isFacingRight == true && Greenfoot.mousePressed(null))
        {
            swordThrow = true;
            deltaX = 7;
        }
        // If facing left and mouse is left clicked, throw sword left.
        if (isFacingRight == false && Greenfoot.mousePressed(null))
        {
            swordThrow = true;
            deltaX = -7;
        }
        
        // If sword has been thrown, and facing right is true, set swords rotation to 270 to appear as if the sword is facing right.
        if (swordThrow == true && isFacingRight == true)
        {
            setRotation(270);
        }
        else if (swordThrow == true && isFacingRight == false) // If sword has been thrown, and facing right is falase, set swords rotation to 90 to appear as if the sword is facing left
        {
            setRotation(90);
        }
        // Allows sword to move in different directions.
        setLocation(getX() + (int)deltaX, getY() + (int)deltaY);
    }

    public static int getActorsRotation() 
    {
        return rotation;
    }
}
