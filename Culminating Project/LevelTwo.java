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
        setPaintOrder(PickUp.class, Lava.class, PlayerOne.class, Bow.class, Orc.class, Arrow.class, DoorTwo.class, Platform.class, SolidGround.class, Spike.class , Platform2.class, Sword.class, Key.class, Door.class, Temp.class);
        prepare();
    }
    
    public void act()
    {
        checkScroll();
    }
    
    private void prepare()
    {
        addObject(player, 300, 330);
        
        DoorTwo door = new DoorTwo();
        addObject(door, 320, 310);
        
        ground();
        leftBorder();
        rightBorder();
        roof();
        
        Bow bow = new Bow();
        addObject(bow, 500, 340);
        
        SolidCastleGround gatewall = new SolidCastleGround();
        addObject(gatewall, 1050, 260);
        SolidCastleGround gatewall2 = new SolidCastleGround();
        addObject(gatewall2, 1050, 220);
        SolidCastleGround gatewall3 = new SolidCastleGround();
        addObject(gatewall3, 1050, 180);
        SolidCastleGround gatewall4 = new SolidCastleGround();
        addObject(gatewall4, 1050, 140);
        SolidCastleGround gatewall5 = new SolidCastleGround();
        addObject(gatewall5, 1050, 100);
        
        Spike2 spike = new Spike2();
        addObject(spike, 560, 360);
        Spike2 spike2 = new Spike2();
        addObject(spike2, 620, 360);
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
    
    public void ground()
    {
        //Floor
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1660;
         int y = 380;
         addObject(new Platform(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1460;
         int y = 380;
         addObject(new Platform(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1260;
         int y = 380;
         addObject(new Platform(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1060;
         int y = 380;
         addObject(new Platform(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 860;
         int y = 385;
         addObject(new Lava(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 660;
         int y = 380;
         addObject(new Platform(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 460;
         int y = 380;
         addObject(new Platform(), x, y);
         
        }
        // Solid ground
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1660;
         int y = 420;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1460;
         int y = 420;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1260;
         int y = 420;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1060;
         int y = 420;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 860;
         int y = 420;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 660;
         int y = 420;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 460;
         int y = 420;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1660;
         int y = 460;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1460;
         int y = 460;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1260;
         int y = 460;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1060;
         int y = 460;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 860;
         int y = 460;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 660;
         int y = 460;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 460;
         int y = 460;
         addObject(new SolidCastleGround(), x, y);
         
        }
    }
    
    public void roof()
    {
        // Roof
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 2060;
         int y = -1200;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1860;
         int y = -1200;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1660;
         int y = -1200;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1460;
         int y = -1200;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1260;
         int y = -1200;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1060;
         int y = -1200;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 860;
         int y = -1200;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 660;
         int y = -1200;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 460;
         int y = -1200;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 260;
         int y = -1200;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 60;
         int y = -1200;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 2060;
         int y = -1240;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1860;
         int y = -1240;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1660;
         int y = -1240;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1460;
         int y = -1240;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1260;
         int y = -1240;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1060;
         int y = -1240;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 860;
         int y = -1240;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 660;
         int y = -1240;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 460;
         int y = -1240;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 260;
         int y = -1240;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 60;
         int y = -1240;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 2060;
         int y = -1280;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1860;
         int y = -1240;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1660;
         int y = -1280;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1460;
         int y = -1280;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1260;
         int y = -1280;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1060;
         int y = -1280;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 860;
         int y = -1280;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 660;
         int y = -1280;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 460;
         int y = -1280;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 260;
         int y = -1280;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 60;
         int y = -1280;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 2060;
         int y = -1320;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1860;
         int y = -1320;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1660;
         int y = -1320;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1460;
         int y = -1320;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1260;
         int y = -1320;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1060;
         int y = -1320;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 860;
         int y = -1320;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 660;
         int y = -1320;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 460;
         int y = -1320;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 260;
         int y = -1320;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 60;
         int y = -1320;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 2060;
         int y = -1360;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1860;
         int y = -1360;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1660;
         int y = -1360;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1460;
         int y = -1360;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1260;
         int y = -1360;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1060;
         int y = -1360;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 860;
         int y = -1360;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 660;
         int y = -1360;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 460;
         int y = -1360;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 260;
         int y = -1360;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 60;
         int y = -1360;
         addObject(new SolidCastleGround(), x, y);
         
        }
    }
    
    public void rightBorder()
    {
        // Right border
        for (int i = 0; i < 10;  i++)
        {
         int x = 1700;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1700;
         int y = i * -40 + 400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1700;
         int y = i * -40 + 0;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1700;
         int y = i * -40 + -400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1700;
         int y = i * -40 + -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1740;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1740;
         int y = i * -40 + 400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1740;
         int y = i * -40 + 0;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1740;
         int y = i * -40 + -400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1740;
         int y = i * -40 + -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        for (int i = 0; i < 10;  i++)
        {
         int x = 1780;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1780;
         int y = i * -40 + 400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1780;
         int y = i * -40 + 0;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1780;
         int y = i * -40 + -400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1780;
         int y = i * -40 + -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        for (int i = 0; i < 10;  i++)
        {
         int x = 1820;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1820;
         int y = i * -40 + 400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1820;
         int y = i * -40 + 0;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1820;
         int y = i * -40 + -400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1820;
         int y = i * -40 + -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        for (int i = 0; i < 10;  i++)
        {
         int x = 1860;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1860;
         int y = i * -40 + 400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1860;
         int y = i * -40 + 0;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1860;
         int y = i * -40 + -400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1860;
         int y = i * -40 + -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        for (int i = 0; i < 10;  i++)
        {
         int x = 1900;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1900;
         int y = i * -40 + 400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1900;
         int y = i * -40 + 0;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1900;
         int y = i * -40 + -400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1900;
         int y = i * -40 + -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        for (int i = 0; i < 10;  i++)
        {
         int x = 1940;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1940;
         int y = i * -40 + 400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1940;
         int y = i * -40 + 0;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1940;
         int y = i * -40 + -400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1940;
         int y = i * -40 + -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        for (int i = 0; i < 10;  i++)
        {
         int x = 1980;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1980;
         int y = i * -40 + 400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1980;
         int y = i * -40 + 0;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1980;
         int y = i * -40 + -400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 1980;
         int y = i * -40 + -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
    }
    
    public void leftBorder()
    {
        
        // Left Border
        for (int i = 0; i < 10;  i++)
        {
         int x = 260;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 260;
         int y = i * -40 + 400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 260;
         int y = i * -40 + 0;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 260;
         int y = i * -40 + -400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 260;
         int y = i * -40 + -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        for (int i = 0; i < 10;  i++)
        {
         int x = 220;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 220;
         int y = i * -40 + 400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 220;
         int y = i * -40 + 0;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 220;
         int y = i * -40 + -400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 220;
         int y = i * -40 + -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        for (int i = 0; i < 10;  i++)
        {
         int x = 180;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 180;
         int y = i * -40 + 400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 180;
         int y = i * -40 + 0;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 180;
         int y = i * -40 + -400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 180;
         int y = i * -40 + -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        for (int i = 0; i < 10;  i++)
        {
         int x = 140;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 140;
         int y = i * -40 + 400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 140;
         int y = i * -40 + 0;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 140;
         int y = i * -40 + -400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 140;
         int y = i * -40 + -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        for (int i = 0; i < 10;  i++)
        {
         int x = 100;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 100;
         int y = i * -40 + 400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 100;
         int y = i * -40 + 0;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 100;
         int y = i * -40 + -400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 100;
         int y = i * -40 + -800;
         addObject(new SolidCastleGround(), x, y);
         
        }

        for (int i = 0; i < 10;  i++)
        {
         int x = 60;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 60;
         int y = i * -40 + 400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 60;
         int y = i * -40 + 0;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 60;
         int y = i * -40 + -400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 60;
         int y = i * -40 + -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        for (int i = 0; i < 10;  i++)
        {
         int x = 20;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 20;
         int y = i * -40 + 400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 20;
         int y = i * -40 + 0;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 20;
         int y = i * -40 + -400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 20;
         int y = i * -40 + -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        for (int i = 0; i < 10;  i++)
        {
         int x = -20;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = -20;
         int y = i * -40 + 400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = -20;
         int y = i * -40 + 0;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = -20;
         int y = i * -40 + -400;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = -20;
         int y = i * -40 + -800;
         addObject(new SolidCastleGround(), x, y);
         
        }

    }
}

