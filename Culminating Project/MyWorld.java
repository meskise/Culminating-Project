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
        setPaintOrder(PickUp.class, PlayerOne.class, Orc.class, SolidGround.class , Platform.class, CastlePlatform.class , LeftWall.class , Spike.class , Platform2.class, CastlePlatform2.class , Sword.class, Key.class, Door.class, Temp.class);
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
        addObject(door,750, 315);

        Sword sword = new Sword();

        addObject(sword, 740, -10);
        boarder();
        platforms();
        spawningBats();
        Bat bat = new Bat();
        
        
        

        
        ground();

        walls();
        


       


        Orc orc = new Orc();
        addObject(orc,500,320);

        
        for (int i = 0; i < 10; i++)
        {
         int x = -660 + i * 60;
         int y = 360;
         addObject(new Spike(), x, y);
         
        }
        for (int i = 0; i < 4; i++)
        {
         int x = -40 + i * 60;
         int y = 180;
         addObject(new Spike(), x, y);
         
        }
        for (int i = 0; i < 8; i++)
        {
         int x = 360 + i * 60;
         int y = 180;
         addObject(new Spike(), x, y);
         
        }
        
    }
    
    public void ground()
    {
        //Ground
        for (int i = 0; i < 50;  i++)
        {
         int x = -1120 + i * 40;
         int y = 420;
         addObject(new SolidGround(), x, y);
         
        }
        //Roof
        for (int i = 0; i < 50;  i++)
        {
         int x = -1120 + i * 40;
         int y = -340;
         addObject(new SolidGround(), x, y);
         
        }
        //Left wall
        for (int i = 0; i < 20;  i++)
        {
         int x = -840;
         int y = 400 - i * 40;
         addObject(new SolidGround(), x, y);
         
        }
        for (int i = 0; i < 20;  i++)
        {
         int x = -880;
         int y = 400 - i * 40;
         addObject(new SolidGround(), x, y);
         
        }
        for (int i = 0; i < 20;  i++)
        {
         int x = -920;
         int y = 400 - i * 40;
         addObject(new SolidGround(), x, y);
         
        }
        for (int i = 0; i < 20;  i++)
        {
         int x = -960;
         int y = 400 - i * 40;
         addObject(new SolidGround(), x, y);
         
        }
        for (int i = 0; i < 20;  i++)
        {
         int x = -1000;
         int y = 400 - i * 40;
         addObject(new SolidGround(), x, y);
         
        }
        for (int i = 0; i < 20;  i++)
        {
         int x = -1040;
         int y = 400 - i * 40;
         addObject(new SolidGround(), x, y);
         
        }
        for (int i = 0; i < 20;  i++)
        {
         int x = -1080;
         int y = 400 - i * 40;
         addObject(new SolidGround(), x, y);
         
        }
    }

    public void spawningBats()
    {
        // for (int i = 0; i < 7;  i++)
        // {
         // int x = i * -200 + 350;
         // int y = 140;
         // addObject(new Bat(), x, y);
         
        // }
        // // for (int i = 0; i < 7;  i++)
        // // {
         // // int x = i * -200 + 250;
         // // int y = -160;
         // // addObject(new Bat(), x, y);
         
        // // }
        // for (int i = 0; i < 7;  i++)
        // {
         // int x = i * -200 + 450;
         // int y = -360;
         // addObject(new Bat(), x, y);
         
        // }
        // for (int i = 0; i < 7;  i++)
        // {
         // int x = i * -200 + 150;
         // int y = -560;
         // addObject(new Bat(), x, y);
         
        // }
        // for (int i = 0; i < 7;  i++)
        // {
         // int x = i * -200 + 400;
         // int y = -760;
         // addObject(new Bat(), x, y);
         
        // }
        // for (int i = 0; i < 7;  i++)
        // {
         // int x = i * -200 + 0;
         // int y = -960;
         // addObject(new Bat(), x, y);
         
        // }
        // for (int i = 0; i < 7;  i++)
        // {
         // int x = i * -200 + -150;
         // int y = -1160;
         // addObject(new Bat(), x, y);
         
        // }
    }
    
    public void boarder()
    {
        //Floor
        for (int i = 0; i < 41;  i++)
        {
         int x = -800 + i * 40;
         int y = 380;
         addObject(new CastlePlatform(), x, y);
         
        }
        //Roof
        for (int i = 0; i < 41;  i++)
        {
         int x = -800 + i * 40;
         int y = -300;
         addObject(new Roof(), x, y);
         
        }
        // Right boarder
        for (int i = 0; i < 30;  i++)
        {
         int x = 840;
         int y = 380 - i * 40;
         addObject(new RightWall(), x, y);
         
        }
        // Left Boarder
        for (int i = 0; i < 30;  i++)
        {
         int x = -800;
         int y = 380 - i * 40;
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
        
        CastlePlatform2 castleplatform222 = new CastlePlatform2();
        addObject(castleplatform222,60,80);
        CastlePlatform2 castleplatform223 = new CastlePlatform2();
        addObject(castleplatform223,160,0);
        CastlePlatform2 castleplatform224 = new CastlePlatform2();
        addObject(castleplatform224,400,20);
        CastlePlatform2 castleplatform225 = new CastlePlatform2();
        addObject(castleplatform225,440,20);
        CastlePlatform2 castleplatform226 = new CastlePlatform2();
        addObject(castleplatform226,550,20);
        CastlePlatform2 castleplatform227 = new CastlePlatform2();
        addObject(castleplatform227,590,20);
        CastlePlatform2 castleplatform228 = new CastlePlatform2();
        addObject(castleplatform228,700,20);
        CastlePlatform2 castleplatform229 = new CastlePlatform2();
        addObject(castleplatform229,740,20);
    }
    public void walls()
    {
        for (int i = 0; i < 10; i++)
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
        
        for (int i = 0; i < 12; i++)
        {
         int x = -100;
         int y = -80 + i * 40;
         addObject(new CastlePlatform(), x, y);
         
        }
        for (int i = 0; i < 12;i++)
        {
         int x = -60;
         int y = -80 + i * 40;
         addObject(new CastlePlatform(), x, y);
         
        }
        
        for (int i = 0; i < 7;i++)
        {
         int x = -40 + i * 40;
         int y = 200;
         addObject(new CastlePlatform(), x, y);
         
        }
        
        for (int i = 0; i < 12;i++)
        {
         int x = 200;
         int y = -80 + i * 40;
         addObject(new CastlePlatform(), x, y);
         
        }
        
        for (int i = 0; i < 9;i++)
        {
         int x = 310;
         int y = -80 + i * 40;
         addObject(new CastlePlatform(), x, y);
         
        }
        
        for (int i = 0; i < 13;i++)
        {
         int x = 350 + i * 40;
         int y = 200;
         addObject(new CastlePlatform(), x, y);
         
        }
    }
    
}
