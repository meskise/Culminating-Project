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
    int counter = 0;
    
    //Movement Speed.
    double SPEED_X = 2.5;
    // jump height
    int JUMPHEIGHT = -14;
    // Check if facing right or is in air.
    boolean isFacingRight;
    boolean isInAir;
    
    // Movement variables.
    double deltaX = 0;
    double deltaY = 0;
    double swordDeltaX = 0;
    double swordDeltaY = 0;
    final double SWORDSPEED_X = 5;
    
    // Gravity
    double g = 0.8;
    
    // Arrays for animation images.
    GreenfootImage[] imagesWalkRight;
    GreenfootImage[] imagesWalkLeft;
    GreenfootImage[] imagesJumpRight;
    GreenfootImage[] imagesJumpLeft;
    GreenfootImage[] imagesIdleRight;
    GreenfootImage[] imagesIdleLeft;

    GreenfootImage[] imagesDieRight;
    GreenfootImage[] imagesDieLeft;
    
    private boolean touchedKey = false;

    
    // Variables for picking up object.
    private Actor sword;
    private Actor key;
    private Actor bow;
    private boolean pickUpMsg = false;

    
    private Actor spike;
    boolean isDead = false;

    private boolean pickUpMsgTwo = false;
    private boolean pickUpMsgThree = false;
    private boolean findKeyMsg = false;
    private boolean swordPickedUp = false;
    private boolean bowPickedUp = false;
    private boolean swordLocation;
    private boolean keyPickedUp = false;

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
        death();
        swordPickUp();
        bowPickUp();
        keyPickUp();
        swordCombat();
        bowCombat();
        doorLogic();
    }
    
    public void doorLogic()
    {
        if (getWorld().getObjects(KeyTwo.class).isEmpty())
        {
            keyPickedUp = true;
            
        }
        
        FindKey findKey = new FindKey();
         if (keyPickedUp == false && findKeyMsg == false && isTouching(Gate.class))
        {
            getWorld().addObject(findKey, getX() + 5, getY() - 25);
            findKeyMsg = true;
        }
    }
    
    public void swordCombat()
    {
        // If left clicked, and sword is picked up, sword location is false.
        if (Greenfoot.mousePressed(null) && swordPickedUp == true)
        {
            swordLocation = false;
        }
        // If 'f' is pressed, and sword has been picked up before, then sword location is true.
        if (Greenfoot.isKeyDown("f") && (swordPickedUp == true))
        {
            swordLocation = true;
        }
        
        // If sword location is true, then set location of sword to PlayerOne.
        if (swordLocation == true)
        {
            sword.setLocation(getX(), getY());
        }
        
        // If facing right, sword has been picked up and sword/player are touching eachother, set sword rotation to 240 to appear as if it is being carried.
        if (isFacingRight == true && swordPickedUp == true && isTouching(Sword.class))
        {
            sword.setRotation(240);
        }
        else if (isFacingRight == false && swordPickedUp == true && isTouching(Sword.class)) // If facing left, sword has been picked up and sword/player are touching eachother, set sword rotation to 120 to appear as if it is being carried.
        {
            sword.setRotation(120);
        }

    }
    
    public void swordPickUp()
    {
        PickUp pickup = new PickUp();
        // If sword is on the map, and is touching player, and F is pressed, pick up sword.
        if (sword == null && isTouching(Sword.class) && Greenfoot.isKeyDown("f"))
        {
            sword = getOneIntersectingObject(Sword.class);
        }
        
        // If there is no pick up msg displayed and is touching sword, display pickup msg.
        if (pickUpMsg == false && isTouching(Sword.class))
        {
            getWorld().addObject(pickup, getX() + 5, getY() - 25);
            pickUpMsg = true;
        }
        
        // If sword is picked up, attach to player
        if (sword != null && sword.getWorld() != null)
        {
            swordPickedUp = true;
        }
    }
    
    public void bowCombat()
    {
        // If facing right, bow has been picked up and bow/player are touching eachother, set bow rotation to 240 to appear as if it is being carried.
        if (isFacingRight == true && bowPickedUp == true && isTouching(Bow.class) && Greenfoot.isKeyDown("g") == false)
        {
            bow.setRotation(45);
        }
        else if (isFacingRight == false && bowPickedUp == true && isTouching(Bow.class) && Greenfoot.isKeyDown("g") == false) // If facing left, bow has been picked up and bow/player are touching eachother, set bow rotation to 120 to appear as if it is being carried.
        {
            bow.setRotation(115);
        }
        
    }
    
    public void bowPickUp()
    {
        PickUp pickup = new PickUp();
        // If bow is on the map, and is touching player, and F is pressed, pick up sword.
        if (bow == null && isTouching(Bow.class) && Greenfoot.isKeyDown("f"))
        {
            bow = getOneIntersectingObject(Bow.class);
        }
        
        // If there is no pick up msg displayed and is touching bow, display pickup msg.
        if (pickUpMsgThree == false && isTouching(Bow.class))
        {
            getWorld().addObject(pickup, getX() + 10, getY() - 35);
            pickUpMsgThree = true;
        }
        
        // If bow is picked up, attach to player
        if (bow != null && bow.getWorld() != null)
        {
            bowPickedUp = true;
        }
        // If bow is picked up and g isn't pressed, set location to player.
        if (bowPickedUp == true && Greenfoot.isKeyDown("g") == false)
        {
            bow.setLocation(getX(), getY() + 5);
        }
        // If bow is picked up, g is pressed, and facing right is true then set location to infront of player.
        if (bowPickedUp == true && Greenfoot.isKeyDown("g") && isFacingRight == true)
        {
            bow.setLocation(getX() + 10, getY() + 5);
            bow.setRotation(0);
        }
       
        if (bowPickedUp == true && Greenfoot.isKeyDown("g") && isFacingRight == false)
        {
            bow.setLocation(getX() - 10, getY() + 5);
            bow.setRotation(180);
        }
   
    }
    
    public void keyPickUp()
    {
        PickUp pickup = new PickUp();
        // If sword is on the map, and is touching player, and F is pressed, pick up sword.
        if (key == null && isTouching(Key.class) && Greenfoot.isKeyDown("f"))
        {
            key = getOneIntersectingObject(Key.class);
        }
        
        // If there is no pick up msg displayed and is touching sword, display pickup msg.
        if (pickUpMsgTwo == false && isTouching(Key.class))
        {
            getWorld().addObject(pickup, getX() + 5, getY() - 25);
            pickUpMsgTwo = true;
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
            if ((isInAir == false) && (isFacingRight == false) && (isDead == false))
            {
                animate(imagesWalkLeft);
            }
        }
        else if (Greenfoot.isKeyDown("d"))
        {
            deltaX = SPEED_X;
            isFacingRight = true;
            if ((isInAir == false) && (isFacingRight == true) && (isDead == false))
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
                deltaY = JUMPHEIGHT;
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
        if (isTouching(Orc.class))
        {
            if (isDead == false)
            {
                frameCounter = 0;
                isDead = true;
            }
            
        }
        if (isTouching(Bat.class))
        {
            if (isDead == false)
            {
                frameCounter = 0;
                isDead = true;
            }
        }
        
        if (isTouching(Lava.class))
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
            SPEED_X = 0;
            JUMPHEIGHT = 0;
            if (platform != null)
            {
                moveOnTopOfObject(platform);
            }
            counter++;
            if (counter == 50)
            {
                 Greenfoot.setWorld(new HomeScreen());
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
