package org;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<Level> levels;

    private ParkingLot(){levels= new ArrayList<>();}

    public static ParkingLot getInstance(){
        if (instance==null){
            synchronized (ParkingLot.class){
                if (instance==null){
                    instance= new ParkingLot();
                }
            }
        }
        return instance;
    }
    public void addLevel(Level level){
        levels.add(level);
    }
    public boolean parkVehicle(Vehicle vehicle){
        for (Level lev:levels){
            if (lev.parkVehicle(vehicle)){
                System.out.println("Vehicle Parked Successfully");
                return true;
            }
        }
        return false;
    }
    public boolean unparkVehicle(Vehicle vehicle){
        for (Level lev:levels){
            if (lev.unparkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }
    public void displayAvailability(){
        for (Level lev: levels){
            lev.displayAvailability();
        }
    }






}
