import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bow extends Actor
{
    final int ANIMATION_INTERVAL = 7;
    int frameCounter = 0;
    int shotCounter = 0;
    private Actor arrow;
    private Actor playerone;
    
    boolean isFacingRight;
    boolean setLocation = false;
    
    public static int rotation;
    
    GreenfootImage[] imagesBowShootLeft;
    GreenfootImage[] imagesBowShootRight;
    
    public Bow()
    {
        GreenfootImage image = getImage();
        image.scale(15, 40);
        setImage(image);
        loadImages();
    }
    
    /**
     * Act - do whatever the Bow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        bowRotation();
        shootBow();
    } 
    
    public void bowRotation()
    {
        // Rotation is the rotation of the sword.
        rotation = getRotation();
        
        // If rotation of bow is 100 or less, is facing right is true.
        if (rotation <= 100)
        {
            isFacingRight = true;
        }
        else // If bow rotation is 100 or higher, is facing right is false.
        {
            isFacingRight = false;
        }
        
    }
    
    public void shootBow()
    {
        Arrow arrow = new Arrow();
        // If g is pressed, facing right is true, and is touching player one then animate, setlocation, and start shot counter.
        if (Greenfoot.isKeyDown("g") && isFacingRight == true && isTouching(PlayerOne.class))
        {
            animate(imagesBowShootRight);
            shotCounter++;
            setLocation = true;
            //setRotation(0);
        }
        
        if (Greenfoot.isKeyDown("g") && isFacingRight == false && isTouching(PlayerOne.class))
        {
            animate(imagesBowShootLeft);
            shotCounter++;
            setLocation = true;
            //setRotation(180);
        }
        
        if (shotCounter >= 30 && isFacingRight == true && isTouching(PlayerOne.class))
        {
            getWorld().addObject(arrow, getX() + 2, getY());
            arrow.setRotation(90);
            shotCounter = 0;
        }
        
        if (shotCounter >= 30 && isFacingRight == false && isTouching(PlayerOne.class))
        {
            getWorld().addObject(arrow, getX() - 2, getY());
            arrow.setRotation(270);
            shotCounter = 0;
        }
        
        
    }
    
    void loadImages()
    {
        imagesBowShootRight = new GreenfootImage[6];
        imagesBowShootLeft = new GreenfootImage[6];
        for (int i = 0; i < imagesBowShootRight.length; i++)
        {
            // Assuming the image files are tile0.png, tile1.png, etc.
            String imagePath = "Bow/tile" + i + ".png";
            imagesBowShootRight[i] = new GreenfootImage(imagePath);
            imagesBowShootLeft[i] = new GreenfootImage(imagePath);
            
            imagesBowShootRight[i].scale(15,40);
            imagesBowShootLeft[i].scale(15,40);
        }
    }
    
    /**
     * Animates using the specified images.
     */
    void animate(GreenfootImage[] images)
    {
        if (frameCounter >= images.length * ANIMATION_INTERVAL)  // Greater or equal (>=) takes care of animations with different number of images.
        {
            frameCounter = 0;
        }
        
        if (frameCounter % ANIMATION_INTERVAL == 0)  // If it's time to switch to next animation image.
        {
            setImage(images[frameCounter/ANIMATION_INTERVAL]);
        }
        
        frameCounter++;
    }
}
