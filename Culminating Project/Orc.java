import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Animations using arrays of images.
 */
public class Orc extends Actor
{
    
    // Movement variables.
    boolean isInAir;
    boolean isFacingRight = true;
    int deltaY;
    int deltaX;
    final int gravity = 1;
    int move = 2;
    
    
    // Animation variables.
    int animationInterval = 5;  // Number of frames between animation images.
    int frameCounter = 0;       // Frame counter. For animations.
    
    // Health system variables.
    int health = 500;

    // Arrays for animation images.
    GreenfootImage[] imagesWalkRight;
    GreenfootImage[] imagesWalkLeft;
    GreenfootImage[] imagesIdleRight;
    GreenfootImage[] imagesIdleLeft;
    GreenfootImage[] imagesDieRight;
    GreenfootImage[] imagesDieLeft;
    
    /**
     * Public orc class.
     */
    public Orc()
    {
        loadImages();
    }
    
    
    public void act()
    {
        deltaX = move;
        setLocation(getX() + deltaX , getY() + deltaY);
        runAnimations();
        checkCollision();
        applyGravity();
        healthSystem();
    }
    
    public void healthSystem()
    {
        if (isTouching(Sword.class))
        {
            health = health - 25;
            System.out.println(health);
        }
        
        if (health <= 0)
        {
            die();
            getWorld().removeObject(this);
        }
    }
    
    public void runAnimations()
    {
        if (deltaX == 2)
        {
            isFacingRight = true;
            animate(imagesWalkRight);
            
        }
        else if (deltaX == -2)
        {
            isFacingRight = false;
            animate(imagesWalkLeft);
            
        }
        else if (isFacingRight == true)
        {
            animate(imagesIdleRight);
        }
        else
        {
            animate(imagesIdleLeft);
        }
    }
           
    public void applyGravity()
    {
        int height = getImage().getHeight();
        int width = getImage().getWidth();
      
        Actor Platform = getOneObjectAtOffset(0 , height /2, Platform.class);
      
        if (Platform != null)
        {
            deltaY = 0;
            isInAir = false;
            moveOnTopOfObject(Platform);
        }
      
        else
        {
            deltaY = deltaY + gravity;  // Apply gravity.
            isInAir = true;
            if(move == 2)
            {
                move = -2;
            }
            else if(move == -2)
            {
                move = 2;
            }
        }
      
        if (isAtEdge())
        {
            if(move == 2)
            {
                move = -2;
            }
            else if(move == -2)
            {
                move = 2;
            }
        }
    }
    
    public void moveOnTopOfObject(Actor object)//Move player to top of object
    {
        int height = getImage().getHeight();
        int objectHeight = object.getImage().getHeight();
      
        setLocation(getX(), object.getY() - objectHeight /2 - height /2 +1);
    }
    
    public void checkCollision()
    {
    
    }
    
    public void attack()
    {
    
    }
    
    public void die()
    {
        if (isFacingRight == true)
        {
            animate(imagesDieRight);
        }
        else
        {
            animate(imagesDieLeft);
        }
    }
    
    /**
     * Animates using the specified images.
     */
    void animate(GreenfootImage[] images)
    {
        if (frameCounter >= images.length * animationInterval)  // Greater or equal (>=) takes care of animations with different number of images.
        {
            frameCounter = 0;
        }
        
        if (frameCounter % animationInterval == 0)  // If it's time to switch to next animation image.
        {
            setImage(images[frameCounter/animationInterval]);
        }
        
        frameCounter++;
    }
    
    
    /**
     * Loads images used for animations.
     */
    void loadImages()
    {
        imagesWalkRight = new GreenfootImage[12];
        imagesWalkLeft = new GreenfootImage[12];
        imagesIdleRight = new GreenfootImage[6];
        imagesIdleLeft = new GreenfootImage[6];
        imagesDieRight = new GreenfootImage[6];
        imagesDieLeft = new GreenfootImage[6];
        
        for (int i = 0; i < imagesWalkRight.length; i++)
        {
            // Assuming the image files are tile0.png, tile1.png, etc.
            String imagePath = "images/Orc_Walk" + i + ".png";
            imagesWalkRight[i] = new GreenfootImage(imagePath);
            imagesWalkLeft[i] = new GreenfootImage(imagePath);
            imagesWalkLeft[i].scale(64, 92);
            imagesWalkRight[i].scale(64, 92);
            imagesWalkLeft[i].mirrorHorizontally();
        }
        for (int i = 0; i < imagesIdleRight.length; i++)
        {
            // Again, assuming the image files are tile0.png, tile1.png, etc.
            String imagePath = "images/Orc_Idle" + i + ".png";
            imagesIdleRight[i] = new GreenfootImage(imagePath);
            imagesIdleLeft[i] = new GreenfootImage(imagePath);
            imagesIdleLeft[i].scale(64, 92);
            imagesIdleRight[i].scale(64, 92);
            imagesIdleLeft[i].mirrorHorizontally();
        }
        for (int i = 0; i < imagesIdleRight.length; i++)
        {
            // Again, assuming the image files are tile0.png, tile1.png, etc.
            String imagePath = "images/Orc_Dying" + i + ".png";
            imagesDieRight[i] = new GreenfootImage(imagePath);
            imagesDieLeft[i] = new GreenfootImage(imagePath);
            imagesDieLeft[i].scale(64, 92);
            imagesDieRight[i].scale(64, 92);
            imagesDieLeft[i].mirrorHorizontally();
        }
    }
}
