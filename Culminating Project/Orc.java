import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Animations using arrays of images.
 */
public class Orc extends Actor
{
    GameWorld world;
    // Movement variables.
    boolean isInAir;
    boolean isFacingRight = true;
    boolean isTouchingPlayer;
    int deltaY;
    int deltaX;
    final int gravity = 1;
    int move = 2;
    
    
    // Animation variables.
    int animationInterval = 7;  // Number of frames between animation images.
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
    GreenfootImage[] imagesAttackRight;
    GreenfootImage[] imagesAttackLeft;

    
    /**
     * Public orc class.
     */
    public Orc()
    {
        loadImages();
    }
    protected void addedToWorld(World world)
    {
        this.world = (GameWorld) world;
    }
    
    public void act()
    {
        movement();
        runAnimations();
        checkCollision();
        applyGravity();
        healthSystem();
    }
    
    public void movement()
    {
        //Moves orc
        deltaX = move;
        if (isTouchingPlayer == false)
        {
            setLocation(getX() + deltaX , getY() + deltaY);
        }
    }
    
    public void healthSystem()
    {

        
        
        if (isTouching(Sword.class) && (world.player.swordPickedUp == true && (Greenfoot.isKeyDown("e"))))

        {
            health = health - 100;
            Greenfoot.delay(20);
            System.out.println(health);
            
        }
        if (isTouching(Arrow.class))
        {
            health = health - 75;
            //System.out.println(health);
        }
        //If out of healt remove orc
        if (health <= 0)
        {
            die();
            getWorld().removeObject(this);
        }
    }
    
    public void runAnimations()
    {
        //Runs the walk and attack animation
        if (isTouchingPlayer == true)
        {
            if (isFacingRight == true)
            {
                animate(imagesAttackRight);
            }
            else
            {
                animate(imagesAttackLeft);
            }
        }
        else if (deltaX == 2)
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
        //Gets height and width
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
        //If at the edge of platform move the other way
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
        //Checks if touching player
        if (isTouching(PlayerOne.class))
        {
            isTouchingPlayer = true;
        }
        else
        {
            isTouchingPlayer = false;
        }
        //Gets height and width of image
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
    
    /**
     * Stop right on object when called.
     */
    public void stopOnRightObject(Actor object)//Stops on right
    {
        int width = getImage().getWidth();
        int objectWidth = object.getImage().getWidth();
        
        setLocation(object.getX() + objectWidth /2 + width /2, getY());
    }
    
    /**
     * Stop left on object when called.
     */
    public void stopOnLeftObject(Actor object)//Stops on left
    {
        int width = getImage().getWidth();
        int objectWidth = object.getImage().getWidth();
        
        setLocation(object.getX() - objectWidth /2 - width /2, getY());
    }
    public void die()//Animate dieing
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
        imagesAttackRight = new GreenfootImage[7];
        imagesAttackLeft = new GreenfootImage[7];
        for (int i = 0; i < imagesWalkRight.length; i++)
        {
            // Assuming the image files are tile0.png, tile1.png, etc.
            String imagePath = "images/Orc_Walk" + i + ".png";
            imagesWalkRight[i] = new GreenfootImage(imagePath);
            imagesWalkLeft[i] = new GreenfootImage(imagePath);
            imagesWalkLeft[i].scale(64, 90);
            imagesWalkRight[i].scale(64, 90);
            imagesWalkLeft[i].mirrorHorizontally();
        }
        for (int i = 0; i < imagesIdleRight.length; i++)
        {
            // Again, assuming the image files are tile0.png, tile1.png, etc.
            String imagePath = "images/Orc_Idle" + i + ".png";
            imagesIdleRight[i] = new GreenfootImage(imagePath);
            imagesIdleLeft[i] = new GreenfootImage(imagePath);
            imagesIdleLeft[i].scale(64, 90);
            imagesIdleRight[i].scale(64, 90);
            imagesIdleLeft[i].mirrorHorizontally();
        }
        for (int i = 0; i < imagesIdleRight.length; i++)
        {
            // Again, assuming the image files are tile0.png, tile1.png, etc.
            String imagePath = "images/Orc_Dying" + i + ".png";
            imagesDieRight[i] = new GreenfootImage(imagePath);
            imagesDieLeft[i] = new GreenfootImage(imagePath);
            imagesDieLeft[i].scale(64, 90);
            imagesDieRight[i].scale(64, 90);
            imagesDieLeft[i].mirrorHorizontally();
        }
        for (int i = 0; i < imagesAttackRight.length; i++)
        {
            // Assuming the image files are tile0.png, tile1.png, etc.
            String imagePath = "images/Orc_Attack" + i + ".png";
            imagesAttackRight[i] = new GreenfootImage(imagePath);
            imagesAttackLeft[i] = new GreenfootImage(imagePath);
            imagesAttackLeft[i].scale(64, 90);
            imagesAttackRight[i].scale(64, 90);
            imagesAttackLeft[i].mirrorHorizontally();
        }
    }
}
