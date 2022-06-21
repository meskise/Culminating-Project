import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SolidGround here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SolidGround extends Platform
{
    public SolidGround()
    {
        //Sets image scale
        GreenfootImage image = getImage();
        image.scale(42,41);
        setImage(image);
    }
    
    /**
     * Act - do whatever the SolidGround wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
    }    
}
