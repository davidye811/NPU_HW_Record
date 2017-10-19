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
public class Project implements Displayable{
    private String projectName;
    private double budget;
    public Project(String projectName,double budget){
    
    
    this.projectName=projectName;
    this.budget=budget;
    
    
    }

    /**
     * @return the projectName
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * @param projectName the projectName to set
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    /**
     * @return the budget
     */
    public double getBudget() {
        return budget;
    }

    /**
     * @param budget the budget to set
     */
    public void setBudget(double budget) {
        this.budget = budget;
    }
    
     @Override
    public void display(){

System.out.println("groupNAME="+getProjectName());



}
    
}
