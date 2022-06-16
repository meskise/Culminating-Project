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
        setPaintOrder(PlayerOne.class, Orc.class, Platform.class, Spike.class , Platform2.class, Sword.class, Key.class, Door.class, Temp.class);
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
        addObject(sword, 290, 250);
        boarder();
        platforms();
        spawningBats();
        Bat bat = new Bat();
        
        
        
        Orc orc = new Orc();
        addObject(orc,500,320);
        
        Spike spike = new Spike();
        addObject(spike, -100 , 360);
        Spike spike2 = new Spike();
        addObject(spike2, -160, 360);
    }
    public void spawningBats()
    {
        for (int i = 0; i < 7;  i++)
        {
         int x = i * -200 + 350;
         int y = 140;
         addObject(new Bat(), x, y);
         
        }
        for (int i = 0; i < 7;  i++)
        {
         int x = i * -200 + 250;
         int y = -160;
         addObject(new Bat(), x, y);
         
        }
        for (int i = 0; i < 7;  i++)
        {
         int x = i * -200 + 450;
         int y = -360;
         addObject(new Bat(), x, y);
         
        }
        for (int i = 0; i < 7;  i++)
        {
         int x = i * -200 + 150;
         int y = -560;
         addObject(new Bat(), x, y);
         
        }
        for (int i = 0; i < 7;  i++)
        {
         int x = i * -200 + 400;
         int y = -760;
         addObject(new Bat(), x, y);
         
        }
        for (int i = 0; i < 7;  i++)
        {
         int x = i * -200 + 0;
         int y = -960;
         addObject(new Bat(), x, y);
         
        }
        for (int i = 0; i < 7;  i++)
        {
         int x = i * -200 + -150;
         int y = -1160;
         addObject(new Bat(), x, y);
         
        }
    }
    public void boarder()
    {
        //Floor
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
        // First level of platforms.
        for (int i = 0; i < 7; i++)
        {
            int y = 280;
            for (int a = 0; a < 2;  a++)
            {
                int x = i * -200 + a * -40 + 300;
                
                addObject(new Platform2(), x, y);
         
            }
        }
        // Second level of platforms.
        for (int i = 0; i < 7; i++)
        {
            int y = 183;
            for (int a = 0; a < 2;  a++)
            {
                int x = i * -200 + a * -40 + 400;
                
                addObject(new Platform2(), x, y);
         
            }
        }
        //Third level of platforms.
        for (int i = 0; i < 8; i++)
        {
            int y = 77;
            for (int a = 0; a < 2;  a++)
            {
                int x = i * -200 + a * -40 + 500;
                
                addObject(new Platform2(), x, y);
         
            }
        }
        // Forth
        for (int i = 0; i < 7; i++)
        {
            int y = -29;
            for (int a = 0; a < 2;  a++)
            {
                int x = i * -200 + a * -40 + 400;
                
                addObject(new Platform2(), x, y);
         
            }
        }
        //Fifth
        for (int i = 0; i < 8; i++)
        {
            int y = -135;
            for (int a = 0; a < 2;  a++)
            {
                int x = i * -200 + a * -40 + 500;
                
                addObject(new Platform2(), x, y);
         
            }
        }
        //Sixth
        for (int i = 0; i < 8; i++)
        {
            int y = -241;
            for (int a = 0; a < 2;  a++)
            {
                int x = i * -200 + a * -40 + 400;
                
                addObject(new Platform2(), x, y);
         
            }
        }
        //Seventh
        for (int i = 0; i < 8; i++)
        {
            int y = -347;
            for (int a = 0; a < 2;  a++)
            {
                int x = i * -200 + a * -40 + 500;
                
                addObject(new Platform2(), x, y);
         
            }
        }
        //Eightth
        for (int i = 0; i < 7; i++)
        {
            int y = -453;
            for (int a = 0; a < 2;  a++)
            {
                int x = i * -200 + a * -40 + 400;
                
                addObject(new Platform2(), x, y);
         
            }
        }
        //Nineth
        for (int i = 0; i < 8; i++)
        {
            int y = -559;
            for (int a = 0; a < 2;  a++)
            {
                int x = i * -200 + a * -40 + 500;
                
                addObject(new Platform2(), x, y);
         
            }
        }
        //Tenth
        for (int i = 0; i < 7; i++)
        {
            int y = -665;
            for (int a = 0; a < 2;  a++)
            {
                int x = i * -200 + a * -40 + 400;
                
                addObject(new Platform2(), x, y);
         
            }
        }
        //Eleventh
        for (int i = 0; i < 8; i++)
        {
            int y = -771;
            for (int a = 0; a < 2;  a++)
            {
                int x = i * -200 + a * -40 + 500;
                
                addObject(new Platform2(), x, y);
         
            }
        }
        //Twelveth
        for (int i = 0; i < 7; i++)
        {
            int y = -877;
            for (int a = 0; a < 2;  a++)
            {
                int x = i * -200 + a * -40 + 400;
                
                addObject(new Platform2(), x, y);
         
            }
        }
        //Thirteenth
        for (int i = 0; i < 8; i++)
        {
            int y = -983;
            for (int a = 0; a < 2;  a++)
            {
                int x = i * -200 + a * -40 + 500;
                
                addObject(new Platform2(), x, y);
         
            }
        }
        //Fourteenth
        for (int i = 0; i < 7; i++)
        {
            int y = -1089;
            for (int a = 0; a < 2;  a++)
            {
                int x = i * -200 + a * -40 + 400;
                
                addObject(new Platform2(), x, y);
         
            }
        }
        
    }
}
