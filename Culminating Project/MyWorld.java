import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        PlayerOne player = new PlayerOne();
        addObject(player,20,330);
        
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
    }
}
