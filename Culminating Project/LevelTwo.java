import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelTwo extends World
{
    PlayerOne player = new PlayerOne();
    int scrollDistance = 2;
    int vScrollDistance = 5;
    int numberOfBricks = 5;
    /**
     * Constructor for objects of class LevelTwo.
     * 
     */
    public LevelTwo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        setPaintOrder(PlayerOne.class, Orc.class, Platform.class, Spike.class , Platform2.class, Sword.class, Key.class, Door.class, Temp.class);
        prepare();
    }
    
    public void act()
    {
        checkScroll();
    }
    
    private void prepare()
    {
        addObject(player, 300, 200);
        Ground();
    }
    
    public void checkScroll()
    {
        if (player.getX() < 298.5)
        {
            scroll(- scrollDistance , 0);
        }
        
        if (player.getX() > 301.5)
        {
            scroll(+ scrollDistance , 0);
        }
        
        if (player.getY() > 300)
        {
            scroll(0 , + vScrollDistance);
        }
        
        if (player.getY() < 100)
        {
            scroll(0 , - vScrollDistance);
        }
    }
    
    public void scroll(int x , int y)
    {
        for (Actor actor : getObjects(Actor.class))
        {
            actor.setLocation(actor.getX() - x, actor.getY() - y);
        }
    }
    
    public void Ground()
    {//Floor
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 600;
         int y = 380;
         addObject(new Platform(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 400;
         int y = 380;
         addObject(new Platform(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 200;
         int y = 380;
         addObject(new Platform(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 0;
         int y = 380;
         addObject(new Platform(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + -200;
         int y = 380;
         addObject(new Platform(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + -400;
         int y = 380;
         addObject(new Platform(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + -600;
         int y = 380;
         addObject(new Platform(), x, y);
         
        }
    }
}

