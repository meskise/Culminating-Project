import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Gate here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Gate extends Actor
{
    //Sets booleans to false
    boolean isOpen = false;
    boolean keyPickedUp = false;
    //Loads images
    GreenfootImage GateOpen;
    
    public Gate()
    {
        //Sets scale of image
        GreenfootImage image = getImage();
        image.scale(75, 85);
        setImage(image);
        //Sets scale of image
        GateOpen = new GreenfootImage("DoorGateOpen.png");
        GateOpen.scale(100, 85); 
    }
    
    /**
     * Act - do whatever the Gate wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        Temp temp = new Temp();
        // If temp object is touching door, open the door.
        if(isTouching(Temp.class))
        {
            setImage(GateOpen);
        }

        if (getWorld().getObjects(KeyTwo.class).isEmpty())
        {
            // Spawn temporary object on doors coordinates.
            getWorld().addObject(temp, getX() +20, getY());
        }

    }
}
