import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bat here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bat extends Actor
{
    int deltaY;
    int deltaX;
    final int ANIMATION_INTERVAL = 3;
    int frameCounter = 0;
    boolean isFacingRight;
    boolean isDead = false;
    GreenfootImage[]imagesFlyLeft;
    GreenfootImage[]imagesFlyRight;
    public Bat()
    {
        deltaY = 0;
        deltaX = -3;
        loadImages();
    }
    /**
     * Act - do whatever the Bat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

       if (isTouching(Arrow.class))
       {
           isDead = true;
           getWorld().removeObject(this);
       }
       else if (isTouching(Sword.class))
       {
           isDead = true;
           getWorld().removeObject(this);
       }
       //if Bat gets too close to Left edge, change y direction to go Right.
       else if(isTouching(LeftWall.class))
       {
           deltaX= 3;
           isFacingRight = true;
           //getImage().mirrorVertically();
       }
       else if(isTouching(BatWallLeft.class))
       {
           deltaX=3;
           isFacingRight = true;
           //getImage().mirrorVertically();
       }
       //if Bat gets too close to Right edge, change y direction to go Left.
       else if(isTouching(RightWall.class))
       {
           deltaX=-3;
           isFacingRight = false;
           //getImage().mirrorVertically();
       }
       else if(isTouching(SolidCastleGround.class))
       {
           deltaX=-3;
           isFacingRight = false;
           //getImage().mirrorVertically();
       }
        //if Bat gets too close to Left edge, change y direction to go Right.
       else if(isTouching(LeftCastleWall.class))
       {
           deltaX=3;
           isFacingRight = true;
           //getImage().mirrorVertically();
       }
       //if Bat gets too close to Right edge, change y direction to go Left.
       else if(isTouching(RightCastleWall.class))
       {
           deltaX= -3;
           isFacingRight = false;
           //getImage().mirrorVertically();
       }
       
       if(isFacingRight == true)
       {
           animate(imagesFlyRight);
       }
       else
       {
           animate(imagesFlyLeft);
       }

       setLocation(getX() + deltaX, getY() + deltaY);
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
    void loadImages()
    {
        imagesFlyLeft = new GreenfootImage[8];
        imagesFlyRight = new GreenfootImage[8];
        for (int i = 0; i < imagesFlyLeft.length; i++)
        {
            // Assuming the image files are tile0.png, tile1.png, etc.
            String imagePath = "Bat Fly/Bat" + i + ".png";
            imagesFlyLeft[i] = new GreenfootImage(imagePath);
            imagesFlyRight[i] = new GreenfootImage(imagePath);
            
            imagesFlyRight[i].mirrorHorizontally();
        }
    }
}
