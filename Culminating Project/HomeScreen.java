    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    /**
 * Write a description of class HomeScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HomeScreen extends World
{ StartButton button;
  Levels levels;
  L1 l1;
  L2 l2;
    
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
         //l3 = new L3();
         //controls = new Controls();
         addObject(button,400,300);
    }
     public void act()
    {
        
        if(Greenfoot.mouseClicked(button))
        {
            removeObject(button);
            Greenfoot.delay(20);
            // addObject(controls,400,300);
            // Greenfoot.delay(150);
            // removeObject(controls);
            addObject(levels, 400,100);
            addObject(l1,100,200);
            addObject(l2,300,200);
            //addObject(l3,600,300);
        }
        if (Greenfoot.mouseClicked(l1))
        {
            //System.out.println(1);
            Greenfoot.setWorld(new MyWorld());
            
        }
        if (Greenfoot.mouseClicked(l2))
        {
            Greenfoot.setWorld(new LevelTwo());
        }
        // if (Greenfoot.mouseClicked(l3))
        // {
            // Greenfoot.setWorld(new Level3());
        // }
   }
 }

