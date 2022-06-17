import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoorTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DoorTwo extends Actor
{
    int counter = 0;
    
    GreenfootImage DoorClosed;
    
    public DoorTwo()
    {
        GreenfootImage image = getImage();
        image.scale(75, 100);
        setImage(image);
        
        DoorClosed = new GreenfootImage("DoorClosedDark.png");
        DoorClosed.scale(75, 100); 
    }
    
    /**
     * Act - do whatever the DoorTwo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (counter >= 75)
        {
             setImage(DoorClosed);   
            
        }
        
        counter++;
        
    }    
}
