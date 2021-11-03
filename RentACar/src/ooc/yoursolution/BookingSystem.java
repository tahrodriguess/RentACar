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
        List<Car> cars = new ArrayList<>();
        name = in.readLine();
        
        while ((su = in.readLine()) !=null){
            String s[] = su.split(":");
            
            Make make = Make.valueOf(s[0]);
            double rate = Double.parseDouble(s[1]);
            int carsNum = Integer.parseInt(s[2]);
            
            for(int i=0; i<carsNum; i++){
                Car car = new Car(i, make, rate);
                cars.add(car);
            }
        }
        RentACarInterface rentACarInterface = new RentACar(cars, name);
        return rentACarInterface;
    }
    
}
