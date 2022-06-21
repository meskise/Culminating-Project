import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoorThree here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoorThree extends Actor
{
    //Load images
    GreenfootImage DoorOpen;
    
    public DoorThree()
    {
        //Sets scale of image
        GreenfootImage image = getImage();
        image.scale(75, 100);
        setImage(image);
        //Sets scale of image
        DoorOpen = new GreenfootImage("DoorOpenRed.png");
        DoorOpen.scale(75, 100); 
    }
    
    /**
     * Act - do whatever the DoorThree wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Temp temp = new Temp();
        // If temp object is touching door, open the door.
        if(isTouching(Temp.class))
        {
            setImage(DoorOpen);
        }
        // If door is touching player, and key isn't in world, you win.
        if (isTouching(PlayerOne.class) && getWorld().getObjects(KeyThree.class).isEmpty())
        {
            Greenfoot.setWorld(new YouWin());
        }
        
        if (getWorld().getObjects(KeyThree.class).isEmpty())
        {
            // Spawn temporary object on doors coordinates.
            getWorld().addObject(temp, getX(), getY());
        }
    }    
}
