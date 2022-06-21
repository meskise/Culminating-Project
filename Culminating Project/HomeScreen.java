import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    /**
 * Write a description of class HomeScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 public class HomeScreen extends World
  { 
   //Declares actors
   StartButton button;
   Levels levels;
   L1 l1;
   L2 l2;
   GuideScreen guide; 
   //Controls controls;
   /**
   * Constructor for objects of class HomeScreen.
   * 
   */
   public HomeScreen()
   {    
         // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
         super(800, 600, 1);
         button = new StartButton();
         levels = new Levels();
         l1 = new L1();
         l2 = new L2();
         guide = new GuideScreen();
         addObject(button,400,300);
   }
   public void act()
   {
        //Displays guide screen
        if (Greenfoot.mouseClicked(button))
        {
            removeObject(button);
            Greenfoot.delay(20);
            addObject(guide, 400 , 300);
        }
        //Displays Level select
        if(Greenfoot.isKeyDown("enter"))
        {
            removeObject(guide);
            Greenfoot.delay(20);
            addObject(levels, 400,100);
            addObject(l1,100,200);
            addObject(l2,300,200);
        }
        //Starts Level One
        if (Greenfoot.mouseClicked(l1))
        {
            Greenfoot.setWorld(new MyWorld());
        }
        //Starts Level Two
        if (Greenfoot.mouseClicked(l2))
        {
            Greenfoot.setWorld(new LevelTwo());
        }
        
   }
 }

