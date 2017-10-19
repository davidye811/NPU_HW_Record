/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs480lab_7;

/**
 *
 * @author Administrator
 */
public abstract class Person implements Workable, Displayable{

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    private String name;
    public Person(String name){
    this.name=name;
    
    
    }
    @Override
    public void display(){
    System.out.println("name="+getName());
    
    
    }
}
