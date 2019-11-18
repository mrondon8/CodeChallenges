package com.codefights.challenges;
import java.util.ArrayList;
import java.util.List;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/

class Box implements Comparable<Object>{
    float weight;
    float volume;
    int index;
    int truck;
    
    Box(float weight, float volume, int index){
        this.weight = weight;
        this.volume = volume;
        this.index = index;
        this.truck = -1;
    }
    
    public float getWeight(){
        return this.weight;
    }
    
    public float getVolume(){
    	return this.volume;
    }
    
    public int getIndex(){
    	return this.index;
    }
    
    public int getTruck(){
        return this.truck;
    }
    
    public void setTruck(int truck){
        this.truck = truck;
    }
    
    public String toString(){
        return "Volume: " + this.getVolume() + ", Index: " + this.getIndex() + ", Truck: " + this.getTruck();
    }

	public int compareTo(Object that) {
		if(this.getVolume() < ((Box) that).getVolume())
			return -1;
		else if(this.getVolume() > ((Box) that).getVolume())
			return 1;
		return 0;
	}
    
}

public class Player {

    public static void main(String args[]) {
        
        
        //int boxCount = in.nextInt();
        int boxCount = 5;
        
        List<Box> boxList = new ArrayList<Box>(boxCount);
        
//        for (int i = 0; i < boxCount; i++) {
//            float weight = in.nextFloat();
//            float volume = in.nextFloat();
//            averageVolume += volume;
//            boxList.add(new Box(weight, volume, i));
//        }

        boxList.add(new Box(1, 92, 0));
        boxList.add(new Box(2, 90, 1));
        boxList.add(new Box(3, 3, 2));
        boxList.add(new Box(4, 3, 3));
        boxList.add(new Box(5, 2, 4));
        boxList.add(new Box(6, 8, 5));
        boxList.add(new Box(6, 10, 6));
        boxList.add(new Box(6, 7, 7));
        boxList.add(new Box(6, 3, 8));
        
        boxList.sort(null);
        
        
        //System.out.println(averageVolume);
        int t = 3;
        float[] trucks = new float[t];

        for(Box b : boxList){
            for(int i = 0; i < t; i++){
            	System.out.println("Truck i:" + i + " has " + trucks[i] + " volume.");
                if(trucks[i] + b.getVolume() <= 100){
                    trucks[i] += b.getVolume();
                    b.setTruck(i);
                    break;
                }
            }
        }
        System.out.println(boxList);
        boxList.sort( (Box b1, Box b2) -> b1.getIndex() - b2.getIndex());
        
        String out = "";
        for(Box b : boxList)
            out += b.getTruck() + " ";

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(out);
    }
}