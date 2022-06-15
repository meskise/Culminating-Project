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
    public Bat()
    {
        deltaY = 0;
        deltaX = -3;
    }
    /**
     * Act - do whatever the Bat wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //if Bat gets too close to Left edge, change y direction to go Right.
       if(isTouching(LeftWall.class))
       {
           deltaX=3;
           //getImage().mirrorVertically();
       }
       //if Bat gets too close to Right edge, change y direction to go Left.
       if(isTouching(RightWall.class))
       {
           deltaX=-3;
           //getImage().mirrorVertically();
       }
       setLocation(getX() + deltaX, getY() + deltaY);
    }    
}
