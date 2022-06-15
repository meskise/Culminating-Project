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
        shootBow();
    }    
    
    public void shootBow()
    {
        if (Greenfoot.isKeyDown("g"))
        {
            animate(imagesBowShootRight);
        }
    }
    
    void loadImages()
    {
        imagesBowShootRight = new GreenfootImage[6];
        
        for (int i = 0; i < imagesBowShootRight.length; i++)
        {
            // Assuming the image files are tile0.png, tile1.png, etc.
            String imagePath = "Bow/tile" + i + ".png";
            imagesBowShootRight[i] = new GreenfootImage(imagePath);
            //imagesBowShootLeft[i] = new GreenfootImage(imagePath);
            
            imagesBowShootRight[i].scale(15,40);
            //imagesBowShootLeft[i].scale(12,33);
            
            //imagesBowShootLeft[i].mirrorHorizontally();
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
