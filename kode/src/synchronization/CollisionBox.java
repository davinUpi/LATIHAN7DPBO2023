/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package synchronization;

import static java.lang.Math.abs;

/**
 *
 * @author User
 */



public final class CollisionBox {
    
    private Min min;
    private Max max;
    
    public class Min{
        public int x;
        public int y;
        
        public Min(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public void transpose(int x, int y){
            this.x += x;
            this.y += y;
        }

    }
    
    public class Max{
        public int x;
        public int y;
        
        public Max(int x, int y){
            this.x = x;
            this.y = y;
        }
        
        public void transpose(int x, int y){
            this.x += x;
            this.y += y;
        }
    }
    
    public enum CollisionType{
        NONE,
        TRIGGER,
        BLOCK,
        CONTAIN;
    }
    
    public CollisionBox(){
        
    }
    
    public CollisionBox(int x, int y, int width, int height){
        min = new Min(0,0);
        max = new Max(width, height);
        transpose(x, y);
    }
    
    public void setMin(int x, int y){
        min.x = x;
        min.y = y;
    }
    
    public void setMax(int x, int y){
        max.x=x;
        max.y = y;
    }
    
    public Min getMin(){
        return min;
    }
    
    public Max getMax(){
        return max;
    }
    
    public int getWidth(){
        return abs(max.x - min.x);
    }
    
    public int getHeight(){
        return abs(max.y - min.y);
    }
    
    public void transpose(int x, int y){
        min.transpose(x, y);
        max.transpose(x, y);
    }
    
    public class CollisionHandler{
        public static boolean isCollision(CollisionBox box_a, CollisionBox box_b){
        return !(box_a.max.x < box_b.min.x || box_a.min.x > box_b.max.x ||
                box_a.max.y < box_b.min.y || box_a.min.y > box_b.max.y
                );
    }
    }
    
}
