/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;

import java.util.List;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author TahR
 */
public class RentACar implements RentACarInterface {

    private List<Car> cars; 
    private String name; 
    
    public RentACar(List<Car>cars, String name){
        this.cars = cars; // gives value to cars.
        this.name = name; // gives value to the String
    }
    
    @Override
    public List getCars() {
        return cars;
    }

    @Override
    public void setCars(List cars) {
        this.cars = cars;
    }

    @Override
    public String getName() {
       return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent) { // this method checks availability and do the loop prosses.
        int currentDay, flag; // creates the ints
        
        for(Car car : cars){                //This loop takes the Car&cars through each elements in the array.
            if(car.getMake().equals(make)){ //this if statment stresses the maker value, given a condition
                flag = 0;
                currentDay = day; 
                for (int i=0; i<lengthOfRent; i++){ //starts the loop at 0 and gos through the lenght od Rent.
                    if(!car.isAvailable(month, currentDay++)){ //Reverse the result, returns false if the result is true.
                        flag = 1; 
                        break;
                    }
                } 
                if (flag == 0){  //if the flag is equals to 0 returns true.
                    return true; // Returns true if the loop statment is false ( equals to 0).
                }
            } 
        }
        return false;
    }

    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {  // this method gets availability and do the loop prosses.
        int currentDay, flag;
        
        
        for(Car car : cars){ //This loop takes the Car&cars through each elements in the array.(same)
            if(car.getMake().equals(make)) {
                flag = 0;
                currentDay = day; // is the same for all the loops proccess they will go through the Array elements and return true or false acording to what is in the folder.
                for (int i=0; i<lengthOfRent; i++){
                    if(!car.isAvailable(month, currentDay++)) {
                     flag = 1;
                     break;
                    }  // in this case will return -1 if there is no car available.
                }
                if(flag == 0) {
                    return car.getId();
                }
            }
        }
        return -1;
    }

    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
       
        if(!checkAvailability(month, day, make, lengthOfRent)){
            return false;
        }
        int carId = getCarAvailable(month, day, make, lengthOfRent);
        
        for (Car car : cars)  {  //This loop takes the Car&cars through each elements in the array.(same)
            if (car.getId() == carId && car.getMake() == make) { // gets the car id and checks for equality with the carId and does the same for the getMake and make.
                int currentDay = day;  
                for (int i=0; i<lengthOfRent; i++){
                    car.book(month, currentDay++); //after initializing the couter it will try to book acording to the method on the maid asks for.
                }
            }  
        }
        return true;
    }

    @Override
    public int getNumberOfCars() {
        return cars.size(); 
    }
    
}
