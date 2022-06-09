import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerOne extends Actor
{
    // Check if facing right or is in air.
    boolean isFacingRight;
    boolean isInAir;
    
    // Movement variables.
    double deltaX = 0;
    double deltaY = 0;
    
    // Gravity
    double g = 0.8;
    
    private boolean touchedKey = false;
    /** 
     * Scale and load all images.
     */
    public PlayerOne()
    {
        GreenfootImage image = getImage();
        image.scale(35,45);
        setImage(image);
    }
    
    /**
     * Act for all voids.
     */
    public void act() 
    {
        movementKeys();
        applyGravity();
        collisonCheck();
        
    }
    
    /**
     * Basic movement.
     */
    public void movementKeys()
    {
        // Movement keys.
        if (Greenfoot.isKeyDown("a"))
        {
            deltaX = - 3.5;
        }
        else if (Greenfoot.isKeyDown("d"))
        {
            deltaX = 3.5;
        }
        else
        {
            deltaX = 0;
        }
        
        if (Greenfoot.isKeyDown("space"))
        {
            // Only allow jump when touching Ground / Platform classes.
            if (isTouching(Platform.class))
            {
                // Jump. 
                deltaY = -14;
            }
        }
        
        
        // Allows movement.
        setLocation(getX() + (int)deltaX, getY() + (int)deltaY);
        
        // If deltaX is greater than 0 then facing right is true.
        if (deltaX > 0)
        {
            isFacingRight = true;
        }
        // If deltaX is less than 0 then facing right is false.
        else if (deltaX < 0)
        {
            isFacingRight = false;
        }
        
    }
    
    /**
     * Move to the top of an object when called.
     */
    public void moveOnTopOfObject(Actor object)
    {
        // Allows player to be adjusted to top of the platforms to prevent bugs.
        int height = getImage().getHeight();
        int objectHeight = object.getImage().getHeight();
        
        setLocation(getX(), object.getY() - objectHeight / 2 - height / 2 + 1);
    }
    
    /**
     * Move to the bottom of an object when called.
     */
    public void moveOnBottomOfObject(Actor object)
    {
        // Allows player to be adjusted to top of the platforms to prevent bugs.
        int height = getImage().getHeight();
        int objectHeight = object.getImage().getHeight();
        
        setLocation(getX(), object.getY() + objectHeight / 2 + height / 2 + 1);
    }
    
    /**
     * Stop right on object when called.
     */
    public void stopOnRightObject(Actor object)
    {
        int width = getImage().getWidth();
        int objectWidth = object.getImage().getWidth();
        
        setLocation(object.getX() + objectWidth /2 + width /2, getY());
    }
    
    /**
     * Stop left on object when called.
     */
    public void stopOnLeftObject(Actor object)
    {
        int width = getImage().getWidth();
        int objectWidth = object.getImage().getWidth();
        
        setLocation(object.getX() - objectWidth /2 - width /2, getY());
    }
    
    /**
     * Apply gravity to player.
     */
    public void applyGravity()
    {
        // Height of the character, which is just height of the current image.
        int height = getImage().getHeight();
        int width = getImage().getWidth();
        
        Actor platform = getOneObjectAtOffset(0, height / 2, Platform.class);
        if (platform != null) // If there is a platform below.
        {
            deltaY = 0; // Don't apply gravity
            isInAir = false;
          
            moveOnTopOfObject(platform); // Adjust position to just touching platform.
        }
        else // No platform below.
        {
            
            isInAir = true;
        }
        
        platform = getOneObjectAtOffset(0, - height / 2, Platform.class);
        if (platform != null) // If there is a platform above.
        {
            isInAir = true;
            deltaY = 0;
          
            moveOnBottomOfObject(platform); // Adjust position to just touching platform.
        }
        
        if (isInAir == true)
        {
            deltaY = deltaY + g; // Apply gravity
        }
    }
    
    /**
     * Check for collisons.
     */
    public void collisonCheck()
    {
        int height = getImage().getHeight();
        int width = getImage().getWidth();
        
        Actor platform = getOneObjectAtOffset( - width /2, 0 ,Platform.class);
        if (platform != null)
        {
            deltaX = 0;
            
            stopOnRightObject(platform);
        }
        
        platform = getOneObjectAtOffset( width /2, 0, Platform.class);
        if (platform != null)
        {
            deltaX = 0;
            
            stopOnLeftObject(platform);
        }
        
        if (getY() >= 395)
        {
            //Greenfoot.setWorld(new GameOver());
            Greenfoot.stop();
        }
    }
}
