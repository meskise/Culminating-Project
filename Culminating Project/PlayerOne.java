import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayerOne here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayerOne extends Actor
{
    // Number of acts/frames between animation images.
    final int ANIMATION_INTERVAL = 7;
    int frameCounter = 0;// Frame counter. For animations.
    
    //Movement Speed.
    final double SPEED_X = 3.5;
    // Check if facing right or is in air.
    boolean isFacingRight;
    boolean isInAir;
    
    // Movement variables.
    double deltaX = 0;
    double deltaY = 0;
    
    // Gravity
    double g = 0.8;
    /**
     * Arrays for animation images.
     */
    GreenfootImage[] imagesWalkRight;
    GreenfootImage[] imagesWalkLeft;
    GreenfootImage[] imagesJumpRight;
    GreenfootImage[] imagesJumpLeft;
    GreenfootImage[] imagesIdleRight;
    GreenfootImage[] imagesIdleLeft;
    GreenfootImage[] imagesDieRight;
    GreenfootImage[] imagesDieLeft;
    
    private boolean touchedKey = false;
    
    private Actor sword;
    private boolean pickUpMsg = false;
    
    private Actor spike;
    boolean isDead = false;
    /** 
     * Scale and load all images.
     */
    public PlayerOne()
    {
        GreenfootImage image = getImage();
        image.scale(35,45);
        setImage(image);
        loadImages();
    }
    
    /**
     * Act for all voids.
     */
    public void act() 
    {
        movementKeys();
        applyGravity();
        collisonCheck();
        Sword();
        death();
        
    }
    
    public void Sword()
    {
        PickUp pickup = new PickUp();
        if (sword == null && isTouching(Sword.class) && Greenfoot.isKeyDown("f"))
        {
            sword = getOneIntersectingObject(Sword.class);
        }
        
        if (pickUpMsg == false && isTouching(Sword.class))
        {
            getWorld().addObject(pickup, getX() + 5, getY() - 25);
            pickUpMsg = true;
        }
        
        if (sword != null && sword.getWorld() != null)
        {
            sword.setLocation(getX(), getY());
        }
    }
      
    
    /**
     * Basic movement.
     */
    public void movementKeys()
    {
        // Movement keys.
        if (Greenfoot.isKeyDown("a"))
        {
            deltaX = - SPEED_X;
            isFacingRight = false;
            if ((isInAir == false) && (isFacingRight == false))
            {
                animate(imagesWalkLeft);
            }
        }
        else if (Greenfoot.isKeyDown("d"))
        {
            deltaX = SPEED_X;
            isFacingRight = true;
            if ((isInAir == false) && (isFacingRight == true))
            {
                animate(imagesWalkRight);
            }
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
        if ((isInAir == true) && (isFacingRight == true))
        {
            animate(imagesJumpRight);
        }
        if ((isInAir == true) && (isFacingRight == false))
        {
            animate(imagesJumpLeft);
        }
        if (deltaY == 0 && deltaX == 0  && isDead == false)// if not jumping/falling and not runing.
         {
             if (isFacingRight == true)
             {
                 animate(imagesIdleRight);
             }
             else
             {
                 animate(imagesIdleLeft);
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
    
    public void death()
    {
        if (isTouching(Spike.class))
        {
            if (isDead == false)
            {
                frameCounter = 0;
                isDead = true;
            }
            
        }
        int height = getImage().getHeight();
        if (isDead == true)
        {
            Actor platform = getOneObjectAtOffset(0, height / 2, Platform.class);
            deathAnimation();
            if (platform != null)
            {
                moveOnTopOfObject(platform);
            }
        }
    }
    
    public void deathAnimation()
    {
        if (isFacingRight == true)
            {
                animateNoLoop(imagesDieRight);
                
            }
            else
            {
                animateNoLoop(imagesDieLeft);
            }
    }
    
    void animateNoLoop(GreenfootImage[] images)
    {
        if (frameCounter >= images.length * ANIMATION_INTERVAL)  // Greater or equal (>=) takes care of animations with different number of images.
        {
            return;
        }
        
        if (frameCounter % ANIMATION_INTERVAL == 0)  // If it's time to switch to next animation image.
        {
            setImage(images[frameCounter/ANIMATION_INTERVAL]);
        }
        
        frameCounter++;
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
        imagesWalkRight = new GreenfootImage[6];
        imagesWalkLeft = new GreenfootImage[6];
        imagesJumpRight = new GreenfootImage[6];
        imagesJumpLeft = new GreenfootImage[6];
        imagesIdleRight = new GreenfootImage[4];
        imagesIdleLeft = new GreenfootImage[4];
        imagesDieRight = new GreenfootImage[6];
        imagesDieLeft = new GreenfootImage[6];
        for (int i = 0; i < imagesWalkRight.length; i++)
        {
            // Assuming the image files are tile0.png, tile1.png, etc.
            String imagePath = "Run/tile" + i + ".png";
            imagesWalkRight[i] = new GreenfootImage(imagePath);
            imagesWalkLeft[i] = new GreenfootImage(imagePath);
            
            imagesWalkLeft[i].mirrorHorizontally();
        }
        for (int i = 0; i < imagesJumpRight.length; i++)
        {
            // Assuming the image files are tile0.png, tile1.png, etc.
            String imagePath = "Jump/tile" + i + ".png";
            imagesJumpRight[i] = new GreenfootImage(imagePath);
            imagesJumpLeft[i] = new GreenfootImage(imagePath);
            
            imagesJumpLeft[i].mirrorHorizontally();
        }
        for (int i = 0; i < imagesIdleRight.length; i++)
        {
            // Assuming the image files are tile0.png, tile1.png, etc.
            String imagePath = "Idle/tile" + i + ".png";
            imagesIdleRight[i] = new GreenfootImage(imagePath);
            imagesIdleLeft[i] = new GreenfootImage(imagePath);
            
            imagesIdleLeft[i].mirrorHorizontally();
        }
        for (int i = 0; i < imagesDieRight.length; i++)
        {
            // Assuming the image files are tile0.png, tile1.png, etc.
            String imagePath = "SteamMan_death" + i + ".png";
            imagesDieRight[i] = new GreenfootImage(imagePath);
            imagesDieLeft[i] = new GreenfootImage(imagePath);
            
            imagesDieLeft[i].mirrorHorizontally();
        }
    }
}
