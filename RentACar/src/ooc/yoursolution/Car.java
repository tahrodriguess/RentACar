package ooc.yoursolution;


import java.util.Map;
import ooc.enums.Make;
import ooc.enums.Month;
import java.util.HashMap; //import HashMap

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
    //variables 
    private int id;
    private Make make;
    private double rate;
    private Map<Month, Boolean[]> map;

    public Car(int id, Make make, double rate) {
        this.id = id;
        this.make = make;
        this.rate = rate;
        createAvailability();
    }

    @Override
    public Map createAvailability() {
        map = new HashMap<>(); /*decision based on the explanation in this
        website https://examples.javacodegeeks.com/java-map-example/  */

        map.put(Month.JANUARY, new Boolean[31]);
        map.put(Month.FEBRUARY, new Boolean[28]);
        map.put(Month.MARCH, new Boolean[31]);
        map.put(Month.APRIL, new Boolean[30]);
        map.put(Month.MAY, new Boolean[31]);
        map.put(Month.JUNE, new Boolean[30]);
        map.put(Month.JULY, new Boolean[31]);
        map.put(Month.AUGUST, new Boolean[31]);
        map.put(Month.SEPTEMBER, new Boolean[30]);
        map.put(Month.OCTOBER, new Boolean[31]);
        map.put(Month.NOVEMBER, new Boolean[30]);
        map.put(Month.DECEMBER, new Boolean[31]);

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
    public Map getAvailability() {
        return map;
    }

    @Override
    public void setAvailability(Map availability) {
        this.map = map;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean isAvailable(Month month, int day) {
        Boolean[] availability = map.get(month);//access a value in the enum 
        if (availability[day-1] == null) { 
            availability[day-1] = true; //if it's available return true
        }
        
        return availability[day-1];
    }

    @Override
    public boolean book(Month month, int day) {
        if (map.get(month)[day-1]) { 
            map.get(month)[day-1] = false; //if it's not booked return true
            return true;
        }

        return false;
    }
    
}
