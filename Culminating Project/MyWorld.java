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
    int scrollDistance = 2;
    int vScrollDistance = 5;
    int numberOfBricks = 5;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1 , false); 
        prepare();
        setPaintOrder(PickUp.class, PlayerOne.class, Orc.class, Platform.class, SolidGround.class, CastlePlatform.class , Spike.class , Platform2.class, CastlePlatform2.class , Sword.class, Key.class, Door.class, Temp.class);
    }
    
    public void act()
    {
        checkScroll();
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
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        addObject(player,-760,330);

        Key key = new Key();
        addObject(key,70,50);
        Door door = new Door();
        addObject(door,550, 315);

        Sword sword = new Sword();
        addObject(sword, 353,147);
        boarder();
        platforms();
        ground();
        walls();
        

        Orc orc = new Orc();
        addObject(orc,500,320);

        Spike spike1 = new Spike();
        addObject(spike1, -210 , 360);
        Spike spike2 = new Spike();
        addObject(spike2, -150 , 360);
        Spike spike3 = new Spike();
        addObject(spike3, -290 , 360);
        Spike spike4 = new Spike();
        addObject(spike4, -350 , 360);
        Spike spike5 = new Spike();
        addObject(spike5, -410 , 360);
        Spike spike6 = new Spike();
        addObject(spike6, -470 , 360);
    }
    
    public void ground()
    {
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 600;
         int y = 420;
         addObject(new SolidGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 400;
         int y = 420;
         addObject(new SolidGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 200;
         int y = 420;
         addObject(new SolidGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 0;
         int y = 420;
         addObject(new SolidGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + -200;
         int y = 420;
         addObject(new SolidGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + -400;
         int y = 420;
         addObject(new SolidGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + -600;
         int y = 420;
         addObject(new SolidGround(), x, y);
         
        }
        
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 600;
         int y = 460;
         addObject(new SolidGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 400;
         int y = 460;
         addObject(new SolidGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 200;
         int y = 460;
         addObject(new SolidGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 0;
         int y = 460;
         addObject(new SolidGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + -200;
         int y = 460;
         addObject(new SolidGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + -400;
         int y = 460;
         addObject(new SolidGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + -600;
         int y = 460;
         addObject(new SolidGround(), x, y);
         
        }
    }
    
    public void boarder()
    {
        //Floor
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 600;
         int y = 380;
         addObject(new CastlePlatform(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 400;
         int y = 380;
         addObject(new CastlePlatform(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 200;
         int y = 380;
         addObject(new CastlePlatform(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 0;
         int y = 380;
         addObject(new CastlePlatform(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + -200;
         int y = 380;
         addObject(new CastlePlatform(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + -400;
         int y = 380;
         addObject(new CastlePlatform(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + -600;
         int y = 380;
         addObject(new CastlePlatform(), x, y);
         
        }
        //Roof
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 600;
         int y = -1200;
         addObject(new Roof(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 400;
         int y = -1200;
         addObject(new Roof(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 200;
         int y = -1200;
         addObject(new Roof(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 0;
         int y = -1200;
         addObject(new Roof(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + -200;
         int y = -1200;
         addObject(new Roof(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + -400;
         int y = -1200;
         addObject(new Roof(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + -600;
         int y = -1200;
         addObject(new Roof(), x, y);
         
        }

        // Right boarder
        for (int i = 0; i < 10;  i++)
        {
         int x = 640;
         int y = i * -40 + 400;
         addObject(new RightWall(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 640;
         int y = i * -40 + 0;
         addObject(new RightWall(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 640;
         int y = i * -40 + -400;
         addObject(new RightWall(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = 640;
         int y = i * -40 + -800;
         addObject(new RightWall(), x, y);
         
        }
        // Left Boarder
        for (int i = 0; i < 10;  i++)
        {
         int x = -800;
         int y = i * -40 + 400;
         addObject(new LeftWall(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = -800;
         int y = i * -40 + 0;
         addObject(new LeftWall(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = -800;
         int y = i * -40 + -400;
         addObject(new LeftWall(), x, y);
         
        }
        for (int i = 0; i < 10;  i++)
        {
         int x = -800;
         int y = i * -40 + -800;
         addObject(new LeftWall(), x, y);
         
        }
    }
    public void platforms()
    {
        CastlePlatform2 castleplatform22 = new CastlePlatform2();
        addObject(castleplatform22,-670,280);
        CastlePlatform2 castleplatform23 = new CastlePlatform2();
        addObject(castleplatform23,-630,280);
        CastlePlatform2 castleplatform24 = new CastlePlatform2();
        addObject(castleplatform24,-520,280);
        CastlePlatform2 castleplatform25 = new CastlePlatform2();
        addObject(castleplatform25,-480,280);
        CastlePlatform2 castleplatform26 = new CastlePlatform2();
        addObject(castleplatform26,-380,280);
        CastlePlatform2 castleplatform27 = new CastlePlatform2();
        addObject(castleplatform27,-340,280);
        CastlePlatform2 castleplatform28 = new CastlePlatform2();
        addObject(castleplatform28,-340,180);
        CastlePlatform2 castleplatform29 = new CastlePlatform2();
        addObject(castleplatform29,-420,90);
        CastlePlatform2 castleplatform210 = new CastlePlatform2();
        addObject(castleplatform210,-460,90);
        CastlePlatform2 castleplatform211 = new CastlePlatform2();
        addObject(castleplatform211,-560,90);
        CastlePlatform2 castleplatform212 = new CastlePlatform2();
        addObject(castleplatform212,-600,90);
        CastlePlatform2 castleplatform213 = new CastlePlatform2();
        addObject(castleplatform213,-700,90);
        CastlePlatform2 castleplatform214 = new CastlePlatform2();
        addObject(castleplatform214,-758,0);
        CastlePlatform2 castleplatform215 = new CastlePlatform2();
        addObject(castleplatform215,-680,-100);
        CastlePlatform2 castleplatform216 = new CastlePlatform2();
        addObject(castleplatform216,-640,-100);
        CastlePlatform2 castleplatform217 = new CastlePlatform2();
        addObject(castleplatform217,-500,-100);
        CastlePlatform2 castleplatform218 = new CastlePlatform2();
        addObject(castleplatform218,-540,-100);
        
        CastlePlatform2 castleplatform219 = new CastlePlatform2();
        addObject(castleplatform219,-340,-90);
        CastlePlatform2 castleplatform220 = new CastlePlatform2();
        addObject(castleplatform220,-380,-90);
        CastlePlatform2 castleplatform221 = new CastlePlatform2();
        addObject(castleplatform221,-220,-90);
        
    }
    public void walls()
    {
        for (int i = 0; i < 10;i++)
        {
         int x = -300;
         int y = i * 40;
         addObject(new CastlePlatform(), x, y);
         
        }
        for (int i = 0; i < 10;i++)
        {
         int x = -260;
         int y = i * 40;
         addObject(new CastlePlatform(), x, y);
         
        }
        CastlePlatform castleplatform = new CastlePlatform();
        addObject(castleplatform,-300,-40);
        CastlePlatform castleplatform1 = new CastlePlatform();
        addObject(castleplatform1,-300,-80);
        CastlePlatform castleplatform2 = new CastlePlatform();
        addObject(castleplatform2,-260,-40);
        CastlePlatform castleplatform3 = new CastlePlatform();
        addObject(castleplatform3,-260,-80);
        for (int i = 0; i < 10;i++)
        {
         int x = -300;
         int y = i * -40 - 180;
         addObject(new CastlePlatform(), x, y);
         
        }
        for (int i = 0; i < 10;i++)
        {
         int x = -260;
         int y = i * -40 - 180;
         addObject(new CastlePlatform(), x, y);
         
        }
        
    }
    
}
