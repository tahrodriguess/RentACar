/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ooc.enums.Make;

/**
 *
 * @author layhenececilio
 */
public class BookingSystem implements BookingSystemInterface{

    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {
        
        String su, name;
        List<Car> cars = new ArrayList<>(); // Array list for the Car class.
        name = in.readLine();// gets the String name and gives it the function of reading the lines.
        
        while ((su = in.readLine()) !=null){ //read the next line until is null
            String s[] = su.split(":"); // splits the ":" in the file.
            
            Make make = Make.valueOf(s[0]); //
            double rate = Double.parseDouble(s[1]); // creates a double for reading the values.
            int carsNum = Integer.parseInt(s[2]); //creates a int.
            
            for(int i=0; i<carsNum; i++){ //This loop initiates the couter in 0 if the couter is bigger than the lenght of carsNum it does the rest of the loop.
                Car car = new Car(i, make, rate);
                cars.add(car); // add a car.
            }
        }
        RentACarInterface rentACarInterface = new RentACar(cars, name);
        return rentACarInterface; //Will return the methods from Almicar class (rentACarInterface.
    }
    
}
// We don't think it was necessary add to much coment because the code is pretty clear, well nomineted classes and methods explicate's itself