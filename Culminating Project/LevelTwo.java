
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LevelTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelTwo extends GameWorld 
{
    // Scrolling screen variables.

    int scrollDistance = 2;
    int vScrollDistance = 5;
    // For for loops.
    int numberOfBricks = 5;
    /**
     * Constructor for objects of class LevelTwo.
     * 
     */
    public LevelTwo()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1, false); 
        // Paint order for level 2.
        setPaintOrder(PickUp.class, FindKey.class, Lava.class, Gate.class, PlayerOne.class, Bow.class, KeyTwo.class, Orc.class, Arrow.class, DoorTwo.class, DoorThree.class, Platform.class, SolidGround.class, Spike.class , Platform2.class, Sword.class, Key.class, Door.class, Temp.class, TempWall.class);
        prepare();
    }
    
    /**
     * 
     * Act void for scrolling screen.
     */
    public void act()
    {
        //Scrolling screen
        checkScroll();
    }
    
    /**
     * Spawn objects when called
     */
    private void prepare()
    {
        // Spawn player.
        addObject(player, 300, 330);
        // Add all main objects to level.
        DoorTwo door = new DoorTwo();
        addObject(door, 320, 310);
        Gate gate = new Gate();
        addObject(gate, 1090, 322);
        KeyTwo key = new KeyTwo();
        addObject (key, 365, -650);
        TempWall temp = new TempWall();
        addObject(temp, 1090, 322);
        DoorThree door3 = new DoorThree();
        addObject(door3, 1620, -95);
        KeyThree key3 = new KeyThree();
        addObject(key3, 1142, -655);
        // Bat walls so bats travel left to right.
        BatWallLeft bwl = new BatWallLeft();
        addObject(bwl, 1120, -50);
        BatWallLeft bwl2= new BatWallLeft();
        addObject(bwl2, 1120, -475);
        
        bats();
        ground();
        leftBorder();
        rightBorder();
        roof();
        platforms();
        
        // Add bow.
        Bow bow = new Bow();
        addObject(bow, 1002, -10);
        
        // Add gate walls above the gate.
        RightCastleWall gatewall = new RightCastleWall();
        addObject(gatewall, 1062, 260);
        RightCastleWall gatewall2 = new RightCastleWall();
        addObject(gatewall2, 1062, 220);
        RightCastleWall gatewall3 = new RightCastleWall();
        addObject(gatewall3, 1062, 180);
        RightCastleWall gatewall4 = new RightCastleWall();
        addObject(gatewall4, 1062, 140);
        RightCastleWall gatewall5 = new RightCastleWall();
        addObject(gatewall5, 1062, 100);
        RightCastleWall gatewall6 = new RightCastleWall();
        addObject(gatewall6, 1062, 60);
        RightCastleWall gatewall7 = new RightCastleWall();
        addObject(gatewall7, 1062, 20);
        RightCastleWall gatewall8 = new RightCastleWall();
        addObject(gatewall8, 1062, -20);
        RightCastleWall gatewall9 = new RightCastleWall();
        addObject(gatewall9, 1062, -60);
        RightCastleWall gatewall10 = new RightCastleWall();
        addObject(gatewall10, 1062, -80);
        
        SolidCastleGround gatewall11 = new SolidCastleGround();
        addObject(gatewall11, 1102, 260);
        SolidCastleGround gatewall12 = new SolidCastleGround();
        addObject(gatewall12, 1102, 220);
        SolidCastleGround gatewall13 = new SolidCastleGround();
        addObject(gatewall13, 1102, 180);
        SolidCastleGround gatewall14 = new SolidCastleGround();
        addObject(gatewall14, 1102, 140);
        SolidCastleGround gatewall15 = new SolidCastleGround();
        addObject(gatewall15, 1102, 100);
        SolidCastleGround gatewall16 = new SolidCastleGround();
        addObject(gatewall16, 1102, 60);
        SolidCastleGround gatewall17 = new SolidCastleGround();
        addObject(gatewall17, 1102, 20);
        SolidCastleGround gatewall18 = new SolidCastleGround();
        addObject(gatewall18, 1102, -20);
        SolidCastleGround gatewall19 = new SolidCastleGround();
        addObject(gatewall19, 1102, -60);
        SolidCastleGround gatewall20 = new SolidCastleGround();
        addObject(gatewall20, 1102, -80);
        SolidCastleGround gatewall21 = new SolidCastleGround();
        addObject(gatewall21, 1102, -120);
        SolidCastleGround gatewall22 = new SolidCastleGround();
        addObject(gatewall22, 1102, -160);
        SolidCastleGround gatewall23 = new SolidCastleGround();
        addObject(gatewall23, 1102, -200);
        SolidCastleGround gatewall24 = new SolidCastleGround();
        addObject(gatewall24, 1102, -240);
        SolidCastleGround gatewall25 = new SolidCastleGround();
        addObject(gatewall25, 1102, -280);
        SolidCastleGround gatewall26 = new SolidCastleGround();
        addObject(gatewall26, 1102, -320);
        SolidCastleGround gatewall27 = new SolidCastleGround();
        addObject(gatewall27, 1102, -360);
        SolidCastleGround gatewall28 = new SolidCastleGround();
        addObject(gatewall28, 1102, -400);
        SolidCastleGround gatewall29 = new SolidCastleGround();
        addObject(gatewall29, 1102, -440);
        SolidCastleGround gatewall30 = new SolidCastleGround();
        addObject(gatewall30, 1102, -480);
        SolidCastleGround gatewall31 = new SolidCastleGround();
        addObject(gatewall31, 1102, -520);
        SolidCastleGround gatewall32 = new SolidCastleGround();
        addObject(gatewall32, 1102, -560);
        SolidCastleGround gatewall33 = new SolidCastleGround();
        addObject(gatewall33, 1102, -600);
        SolidCastleGround gatewall34 = new SolidCastleGround();
        addObject(gatewall34, 1102, -640);
        SolidCastleGround gatewall35 = new SolidCastleGround();
        addObject(gatewall35, 1102, -680);
        SolidCastleGround gatewall36 = new SolidCastleGround();
        addObject(gatewall36, 1102, -720);
        SolidCastleGround gatewall37 = new SolidCastleGround();
        addObject(gatewall37, 1102, -760);
        SolidCastleGround gatewall38 = new SolidCastleGround();
        addObject(gatewall38, 1102, -800);
        
        
        // Add spikes to left side.
        Spike2 spike = new Spike2();
        addObject(spike, 560, 360);
        Spike2 spike2 = new Spike2();
        addObject(spike2, 620, 360);
    }

    /**
     * Scrolling screen void.
     */
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
        
        if (player.getY() > 250)
        {
            scroll(0 , + vScrollDistance);
        }
        
        if (player.getY() < 150)
        {
            scroll(0 , - vScrollDistance);
        }
    }
    
    /**
     * Scrolling screen void.
     */
    public void scroll(int x , int y)
    {
        for (Actor actor : getObjects(Actor.class))
        {
            // Move actors along with player.
            actor.setLocation(actor.getX() - x, actor.getY() - y);
        }
    }
    
    /**
     * Void for most platforms.
     */
    public void platforms()
    {
        // Add platforms
        Platform2 platform = new Platform2();
        addObject(platform, 450, 290);
        Platform2 platform2 = new Platform2();
        addObject(platform2, 490, 290);
        
        Platform2 platform3 = new Platform2();
        addObject(platform3, 580, 225);
        Platform2 platform4 = new Platform2();
        addObject(platform4, 620, 225);
        
        Platform2 platform5 = new Platform2();
        addObject(platform5, 720, 225);
        
        Platform2 platform7 = new Platform2();
        addObject(platform7, 670, 140);
        
        Platform2 platform8 = new Platform2();
        addObject(platform8, 530, 100);
        Platform2 platform9 = new Platform2();
        addObject(platform9, 570, 100);
        
        Platform2 platform10 = new Platform2();
        addObject(platform10, 382, 115);
        Platform2 platform11 = new Platform2();
        addObject(platform11, 422, 115);
        
        SolidCastleGround platform12 = new SolidCastleGround();
        addObject(platform12, 302, -80);
        SolidCastleGround platform13 = new SolidCastleGround();
        addObject(platform13, 342, -80);
        SolidCastleGround platform14 = new SolidCastleGround();
        addObject(platform14, 462, -80);
        SolidCastleGround platform16 = new SolidCastleGround();
        addObject(platform16, 502, -80);
        SolidCastleGround platform17 = new SolidCastleGround();
        addObject(platform17, 542, -80);
        SolidCastleGround platform18 = new SolidCastleGround();
        addObject(platform18, 582, -80);
        SolidCastleGround platform19 = new SolidCastleGround();
        addObject(platform19, 622, -80);
        SolidCastleGround platform20 = new SolidCastleGround();
        addObject(platform20, 662, -80);
        SolidCastleGround platform21 = new SolidCastleGround();
        addObject(platform21, 702, -80);
        SolidCastleGround platform22 = new SolidCastleGround();
        addObject(platform22, 742, -80);
        SolidCastleGround platform23 = new SolidCastleGround();
        addObject(platform23, 782, -80);
        SolidCastleGround platform24 = new SolidCastleGround();
        addObject(platform24, 822, -80);
        SolidCastleGround platform25 = new SolidCastleGround();
        addObject(platform25, 862, -80);
        SolidCastleGround platform26 = new SolidCastleGround();
        addObject(platform26, 902, -80);
        SolidCastleGround platform27 = new SolidCastleGround();
        addObject(platform27, 942, -80);
        SolidCastleGround platform28 = new SolidCastleGround();
        addObject(platform28, 982, -80);
        SolidCastleGround platform29 = new SolidCastleGround();
        addObject(platform29, 1022, -80);
        SolidCastleGround platform30 = new SolidCastleGround();
        addObject(platform30, 1062, -80);
        SolidCastleGround platform31 = new SolidCastleGround();
        addObject(platform31, 1102, -80);
        
        Platform platform32 = new Platform();
        addObject(platform32, 302, -120);
        Platform platform33 = new Platform();
        addObject(platform33, 342, -120);
        Platform platform34 = new Platform();
        addObject(platform34, 462, -120);
        Platform platform36 = new Platform();
        addObject(platform36, 502, -120);
        Platform platform37 = new Platform();
        addObject(platform37, 542, -120);
        Platform platform38 = new Platform();
        addObject(platform38, 582, -120);
        Platform platform39 = new Platform();
        addObject(platform39, 622, -120);
        Platform platform40 = new Platform();
        addObject(platform40, 662, -120);
        Platform platform41 = new Platform();
        addObject(platform41, 702, -120);
        Platform platform42 = new Platform();
        addObject(platform42, 742, -120);
        Platform platform43 = new Platform();
        addObject(platform43, 782, -120);
        Platform platform44 = new Platform();
        addObject(platform44, 822, -120);
        Platform platform45 = new Platform();
        addObject(platform45, 862, -120);
        Platform platform46 = new Platform();
        addObject(platform46, 902, -120);
        
        // Add lava.
        Lava platform47 = new Lava();
        addObject(platform47, 942, -115);
        Lava platform48 = new Lava();
        addObject(platform48, 982, -115);
        Lava platform49 = new Lava();
        addObject(platform49, 1022, -115);
        Lava platform50 = new Lava();
        addObject(platform50, 1062, -115);
        
        Lava lava1 = new Lava();
        addObject(lava1, 1022, -150);
        Lava lava2 = new Lava();
        addObject(lava2, 1022, -185);
        Lava lava3 = new Lava();
        addObject(lava3, 1022, -220);
        Lava lava4 = new Lava();
        addObject(lava4, 1022, -255);
        Lava lava5 = new Lava();
        addObject(lava5, 1022, -290);
        Lava lava6 = new Lava();
        addObject(lava6, 1022, -325);
        Lava lava7 = new Lava();
        addObject(lava7, 1022, -360);
        LavaTriangle lava8 = new LavaTriangle();
        addObject(lava8, 1022, -395);
        Lava lava9 = new Lava();
        addObject(lava9, 1062, -395);
        
        Lava lava10 = new Lava();
        addObject(lava10, 1062, -430);
        Lava lava11 = new Lava();
        addObject(lava11, 1062, -465);
        Lava lava12 = new Lava();
        addObject(lava12, 1062, -500);
        Lava lava13 = new Lava();
        addObject(lava13, 1062, -535);
        Lava lava14 = new Lava();
        addObject(lava14, 1062, -570);
        Lava lava15 = new Lava();
        addObject(lava15, 1062, -605);
        Lava lava16 = new Lava();
        addObject(lava16, 1062, -640);
        Lava lava17 = new Lava();
        addObject(lava17, 1062, -675);
        Lava lava18 = new Lava();
        addObject(lava18, 1062, -710);
        LavaTriangle lava20 = new LavaTriangle();
        addObject(lava20, 1062, -745);
        
        // Add platforms beneath lava.
        Platform lavaplatform1 = new Platform();
        addObject(lavaplatform1, 1062, -360);
        SolidCastleGround lavaplatform2 = new SolidCastleGround();
        addObject(lavaplatform2, 1102, -360);
        Platform lavaplatform3 = new Platform();
        addObject(lavaplatform3, 1102, -400);
        Platform lavaplatform4 = new Platform();
        addObject(lavaplatform4, 1142, -400);
        Platform lavaplatform5 = new Platform();
        addObject(lavaplatform5, 1182, -400);
        SolidCastleGround lavaplatform6 = new SolidCastleGround();
        addObject(lavaplatform6, 1142, -360);
        
        // More platforms.
        Platform platform51 = new Platform();
        addObject(platform51, 1102, -120);
        
        Platform2 platform15 = new Platform2();
        addObject(platform15, 402, 15);
        
        Platform2 platform52 = new Platform2();
        addObject(platform52,840, 280);
        Platform2 platform53 = new Platform2();
        addObject(platform53,880, 280);
        
        Platform2 platform54 = new Platform2();
        addObject(platform54,982, 20);
        Platform2 platform55 = new Platform2();
        addObject(platform55,1022, 20);
        
        Platform2 platform56 = new Platform2();
        addObject(platform56,772, 75);
        Platform2 platform57 = new Platform2();
        addObject(platform57,812, 75);
        Platform2 platform58 = new Platform2();
        addObject(platform58,902, 75);
        Platform2 platform59 = new Platform2();
        addObject(platform59,942, 75);
        Platform2 platform60 = new Platform2();
        addObject(platform60,422, -90);
        
        Platform2 platforms1 = new Platform2();
        addObject(platforms1, 535, -225);
        Platform2 platforms2 = new Platform2();
        addObject(platforms2, 575, -225);
        
        Platform2 platforms3 = new Platform2();
        addObject(platforms3, 382, -275);
        Platform2 platforms4 = new Platform2();
        addObject(platforms4, 422, -275);
        Platform2 platforms5 = new Platform2();
        addObject(platforms5, 300, -350);
        Platform2 platforms6 = new Platform2();
        addObject(platforms6, 405, -425);
        Platform2 platforms7 = new Platform2();
        addObject(platforms7, 445, -425);
        Platform2 platforms8 = new Platform2();
        addObject(platforms8, 560, -425);
        Platform2 platforms9 = new Platform2();
        addObject(platforms9, 600, -425);
        Platform2 platforms10 = new Platform2();
        addObject(platforms10, 715, -425);
        Platform2 platforms11 = new Platform2();
        addObject(platforms11, 755, -425);
        Platform2 platforms12 = new Platform2();
        addObject(platforms12, 840, -475);
        Platform2 platforms13 = new Platform2();
        addObject(platforms13, 715, -550);
        Platform2 platforms14 = new Platform2();
        addObject(platforms14, 755, -550);
        Platform2 platforms15 = new Platform2();
        addObject(platforms15, 590, -625);
        Platform2 platforms16 = new Platform2();
        addObject(platforms16, 630, -625);
        Platform2 platforms17 = new Platform2();
        addObject(platforms17, 460, -625);
        Platform2 platforms18 = new Platform2();
        addObject(platforms18, 500, -625);
        Platform2 platforms19 = new Platform2();
        addObject(platforms19, 350, -625);
        Platform2 platforms20 = new Platform2();
        addObject(platforms20, 390, -625);
        Platform2 platforms21 = new Platform2();
        addObject(platforms21, 845, -635);
        
        // Platforms on right side of map.
        Platform2 platformss1 = new Platform2();
        addObject(platformss1, 1175, 250);
        Platform2 platformss2 = new Platform2();
        addObject(platformss2, 1215, 250);
        Platform2 platformss3 = new Platform2();
        addObject(platformss3, 1300, 175);
        Platform2 platformss4 = new Platform2();
        addObject(platformss4, 1340, 175);
        Platform2 platformss6 = new Platform2();
        addObject(platformss6, 1190, 80);
        Platform2 platformss7 = new Platform2();
        addObject(platformss7, 1230, 80);
        Platform2 platformss8 = new Platform2();
        addObject(platformss8, 1330, 0);
        Platform2 platformss9 = new Platform2();
        addObject(platformss9, 1440, 0);
        Platform2 platformss10 = new Platform2();
        addObject(platformss10, 1480, 0);
        Platform2 platformss11 = new Platform2();
        addObject(platformss11, 1620, -40);
        Platform2 platformss12 = new Platform2();
        addObject(platformss12, 1660, -40);
        Platform2 platformss13 = new Platform2();
        addObject(platformss13, 1580, -40);
        Platform2 platformss14 = new Platform2();
        addObject(platformss14, 1460, -120);
        Platform2 platformss15 = new Platform2();
        addObject(platformss15, 1340, -175);
        Platform2 platformss16 = new Platform2();
        addObject(platformss16, 1380, -175);
        Platform2 platformss17 = new Platform2();
        addObject(platformss17, 1200, -175);
        Platform2 platformss18 = new Platform2();
        addObject(platformss18, 1240, -175);
        Platform2 platformss19 = new Platform2();
        addObject(platformss19, 1290, -280);
        Platform2 platformss20 = new Platform2();
        addObject(platformss20, 1222, -350);
        Platform2 platformss21 = new Platform2();
        addObject(platformss21, 1182, -350);
        Platform2 platformss22 = new Platform2();
        addObject(platformss22, 1300, -450);
        Platform2 platformss23 = new Platform2();
        addObject(platformss23, 1340, -450);
        Platform2 platformss24 = new Platform2();
        addObject(platformss24, 1440, -450);
        Platform2 platformss25 = new Platform2();
        addObject(platformss25, 1480, -450);
        Platform2 platformss26 = new Platform2();
        addObject(platformss26, 1550, -515);
        Platform2 platformss27 = new Platform2();
        addObject(platformss27, 1620, -575);
        Platform2 platformss28 = new Platform2();
        addObject(platformss28, 1660, -575);
        Platform2 platformss29 = new Platform2();
        addObject(platformss29, 1480, -625);
        Platform2 platformss30 = new Platform2();
        addObject(platformss30, 1520, -625);
        Platform2 platformss31 = new Platform2();
        addObject(platformss31, 1360, -625);
        Platform2 platformss32 = new Platform2();
        addObject(platformss32, 1400, -625);
        Platform2 platformss33 = new Platform2();
        addObject(platformss33, 1230, -625);
        Platform2 platformss34 = new Platform2();
        addObject(platformss34, 1270, -625);
        Platform2 platformss35 = new Platform2();
        addObject(platformss35, 1142, -625);
        
        
        // More spikes.
        Spike2 spikes = new Spike2();
        addObject(spikes, 272, -140);
        Spike2 spikes2 = new Spike2();
        addObject(spikes2, 332, -140);
        Spike2 spikes7 = new Spike2();
        addObject(spikes7, 620, -140);        
        Spike2 spikes3 = new Spike2();
        addObject(spikes3, 680, -140);
        Spike2 spikes4 = new Spike2();
        addObject(spikes4, 740, -140);
        Spike2 spikes5 = new Spike2();
        addObject(spikes5, 800, -140);
        Spike2 spikes6 = new Spike2();
        addObject(spikes6, 860, -140);
        
        Spike2 spikes8 = new Spike2();
        addObject(spikes8, 1400, 360);
        Spike2 spikes9 = new Spike2();
        addObject(spikes9, 1460, 360);
        Spike2 spikes10 = new Spike2();
        addObject(spikes10, 1520, 360);
        Spike2 spikes11 = new Spike2();
        addObject(spikes11, 1162, -420);
        
        //Add orcs.
        Orc orc = new Orc();
        addObject(orc, 860, -180);
        Orc orc2 = new Orc();
        addObject(orc2, 1500, 300);
    }
    
    /**
     * Void for spawning bats.
     */
    public void bats()
    {
        for (int i = 0; i < 3;  i++)
        {
         int x = i * -200 + 900;
         int y = 180;
         addObject(new Bat(), x, y);
         
        }
        for (int i = 0; i < 3;  i++)
        {
         int x = i * -200 + 900;
         int y = -500;
         addObject(new Bat(), x, y);
         
        }
        for (int i = 0; i < 3;  i++)
        {
         int x = i * -150 + 900;
         int y = -670;
         addObject(new Bat(), x, y);
         
        }
        for (int i = 0; i < 2;  i++)
        {
         int x = i * -150 + 1500;
         int y = -50;
         addObject(new Bat(), x, y);
         
        }
        for (int i = 0; i < 2;  i++)
        {
         int x = i * -150 + 1500;
         int y = -475;
         addObject(new Bat(), x, y);
         
        }
    }
    
    /** 
     * Void for ground under player.
     */
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
        for (int i = 0; i < 35;  i++)
        {
         int x = i * -40 + 1660;
         int y = 500;
         addObject(new SolidCastleGround(), x, y);
         
        }
    }
    
    /**
     * Void for spawning all roof tiles.
     */
    public void roof()
    {
        // Roof
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 2060;
         int y = -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1860;
         int y = -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1660;
         int y = -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1460;
         int y = -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1260;
         int y = -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1060;
         int y = -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 860;
         int y = -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 660;
         int y = -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 460;
         int y = -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 260;
         int y = -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 60;
         int y = -800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 2060;
         int y = -840;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1860;
         int y = -840;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1660;
         int y = -840;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1460;
         int y = -840;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1260;
         int y = -840;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1060;
         int y = -840;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 860;
         int y = -840;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 660;
         int y = -840;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 460;
         int y = -840;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 260;
         int y = -840;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 60;
         int y = -840;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 2060;
         int y = -880;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1860;
         int y = -880;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1660;
         int y = -880;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1460;
         int y = -880;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1260;
         int y = -880;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1060;
         int y = -880;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 860;
         int y = -880;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 660;
         int y = -880;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 460;
         int y = -880;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 260;
         int y = -880;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 60;
         int y = -880;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 2060;
         int y = -920;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1860;
         int y = -920;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1660;
         int y = -920;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1460;
         int y = -920;
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
         int y = -920;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 860;
         int y = -920;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 660;
         int y = -920;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 460;
         int y = -920;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 260;
         int y = -920;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 60;
         int y = -920;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 2060;
         int y = -960;
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
         int y = -960;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1460;
         int y = -960;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1260;
         int y = -960;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 1060;
         int y = -960;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 860;
         int y = -960;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 660;
         int y = -960;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 460;
         int y = -960;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 260;
         int y = -960;
         addObject(new SolidCastleGround(), x, y);
         
        }
        for (int i = 0; i < numberOfBricks;  i++)
        {
         int x = i * -40 + 60;
         int y = -960;
         addObject(new SolidCastleGround(), x, y);
         
        }
    }
    
    /**
     * Void for all right border tiles.
     */
    public void rightBorder()
    {
        // Right border
        for (int i = 0; i < 50;  i++)
        {
         int x = 1700;
         int y = i * -40 + 800;
         addObject(new RightCastleWall(), x, y);
         
        }
        
        for (int i = 0; i < 50;  i++)
        {
         int x = 1740;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        
        for (int i = 0; i < 50;  i++)
        {
         int x = 1780;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        
        for (int i = 0; i < 50;  i++)
        {
         int x = 1820;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        
        for (int i = 0; i < 50;  i++)
        {
         int x = 1860;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        
        for (int i = 0; i < 50;  i++)
        {
         int x = 1900;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        
        for (int i = 0; i < 50;  i++)
        {
         int x = 1940;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        
        for (int i = 0; i < 50;  i++)
        {
         int x = 1980;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
    }
    
    /**
     * Void for all left border tiles.
     */
    public void leftBorder()
    {
        // Left Border
        for (int i = 0; i < 50;  i++)
        {
         int x = 260;
         int y = i * -40 + 800;
         addObject(new LeftCastleWall(), x, y);
         
        }
        
        
        for (int i = 0; i < 50;  i++)
        {
         int x = 220;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        
        for (int i = 0; i < 50;  i++)
        {
         int x = 180;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        
        for (int i = 0; i < 50;  i++)
        {
         int x = 140;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        
        for (int i = 0; i < 50;  i++)
        {
         int x = 100;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        

        for (int i = 0; i < 50;  i++)
        {
         int x = 60;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        
        for (int i = 0; i < 50;  i++)
        {
         int x = 20;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        
        
        for (int i = 0; i < 50;  i++)
        {
         int x = -20;
         int y = i * -40 + 800;
         addObject(new SolidCastleGround(), x, y);
         
        }
        

    }
}

