package ooc.yoursolution;


import java.util.Map;
import ooc.enums.Make;
import ooc.enums.Month;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TahR
 */
public class Car implements CarInterface {
    
        private int id;
        private Make make;
        private double rate;
        private  Map<Month, boolean[]> map;
        
        
        public Car (int id, Make make, double rate){
            
            this.id = id;
            this.make = make;
            this.rate = rate;
            createAvailability();
        }
        
    @Override
    public Map<Month, boolean[]> createAvailability()  {
             
        
        map.put(Month.JANUARY, new boolean [31]);
        map.put(Month.FEBRUARY, new boolean [28]);
        map.put(Month.MARCH, new boolean [31]);
        map.put(Month.APRIL, new boolean [30]);
        map.put(Month.MAY, new boolean [31]);
        map.put(Month.JUNE, new boolean [30]);
        map.put(Month.JULY, new boolean [31]);
        map.put(Month.AUGUST, new boolean [31]);
        map.put(Month.SEPTEMBER, new boolean [30]);
        map.put(Month.OCTOBER, new boolean [31]);
        map.put(Month.NOVEMBER, new boolean [30]);
        map.put(Month.DECEMBER, new boolean [31]);
        
        return map; 
    }

    @Override
    public Make getMake() {
        
        return make;
    }

    @Override
    public void setMake(Make make) {
        
        this.make = make;
         }

    @Override
    public double getRate() {
        
        return rate;
        
    }

    @Override
    public void setRate(double rate) {
        
        this.rate = rate;
    }

    @Override
    public Map<Month, boolean[]> getAvailability() {        
            
        return map;
           
    }

    @Override
    public void setAvailability(Map<Month, boolean[]> availability) {
        
        this.map = map;
        
    }

    @Override
    public int getId() {
        
        return id;
    
    }

    @Override
    public boolean isAvailable(Month month, int day) {
            
            //Boolean[] availability = map.get(month);
                
                if (map.get(month)[day-1] == null) { //HEEEEEELP
                    map.get(month)[day-1] = true;
                }// I don't know what to do I'm thinking of another way to write it because boolean is a primitive type and can not read null.
                
        return map.containsKey(day);
        
        
      }  
    
    @Override
    public boolean book(Month month, int day) {
        if (map.get(month)[day-1]){
            map.get(month)[day-1] = false;
            return true;
            
        }
                        
        return false;
        
    }
      
    
    
}
