import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    PlayerOne player = new PlayerOne();
    int scrollDistance = 200;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
        setPaintOrder(PlayerOne.class, Orc.class, Platform.class, Platform2.class, Key.class, Door.class, Temp.class);
    }
    
    public void act()
    {
        checkScroll();
    }
    
    public void checkScroll()
    {
        if (player.getX() < 100)
        {
            scroll(- scrollDistance , 0);
        }
        
        if (player.getX() > 500)
        {
            scroll(+ scrollDistance , 0);
        }
    }
    
    public void scroll(int x , int y)
    {
        for (Actor actor : getObjects(Actor.class))
        {
            actor.setLocation(actor.getX() - x, actor.getY() - y);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        
        addObject(player,20,330);
        
        Key key = new Key();
        addObject(key,70,50);
        Door door = new Door();
        addObject(door,550, 315);
        
        Sword sword = new Sword();
        addObject(sword, 240, 250);

        Platform platform = new Platform();
        addObject(platform,20,380);
        Platform platform2 = new Platform();
        addObject(platform2,60,380);
        Platform platform3 = new Platform();
        addObject(platform3,100,380);
        Platform platform4 = new Platform();
        addObject(platform4,140,380);
        Platform platform5 = new Platform();
        addObject(platform5,180,380);
        Platform platform6 = new Platform();
        addObject(platform6,300,380);
        Platform platform7 = new Platform();
        addObject(platform7,340,380);
        Platform platform8 = new Platform();
        addObject(platform8,380,380);
        Platform platform9 = new Platform();
        addObject(platform9,420,380);
        Platform platform10 = new Platform();
        addObject(platform10,460,380);
        Platform platform11 = new Platform();
        addObject(platform11,500,380);
        Platform platform12 = new Platform();
        addObject(platform12,540,380);
        Platform platform13 = new Platform();
        addObject(platform13,580,380);

        Platform2 platform22 = new Platform2();
        addObject(platform22,222,280);
        Platform2 platform23 = new Platform2();
        addObject(platform23,262,280);
        Platform2 platform24 = new Platform2();
        addObject(platform24,338,183);
        Platform2 platform25 = new Platform2();
        addObject(platform25,378,183);
        Platform2 platform26 = new Platform2();
        addObject(platform26,222,122);
        Platform2 platform27 = new Platform2();
        addObject(platform27,262,122);
        Platform2 platform28 = new Platform2();
        addObject(platform28,73,77);
        Platform2 platform29 = new Platform2();
        addObject(platform29,113,77);
        Platform2 platform210 = new Platform2();
        addObject(platform210,487,220);
        Platform2 platform211 = new Platform2();
        addObject(platform211,568,110);
        
        Orc orc = new Orc();
        addObject(orc,500,320);
    }
}
