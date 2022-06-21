import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{   
    PlayerOne player = new PlayerOne();

    /**
     * Constructor for objects of class GameWorld.
     * 
     */
    public GameWorld(int width,int hight,int cellSize, boolean isBounded)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(width, hight, cellSize, isBounded); 
    }
}
