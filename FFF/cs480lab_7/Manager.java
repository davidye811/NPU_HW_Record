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
public class Manager extends Programmer{
    private double annualBonus;

    public Manager(String name, String skill, double salary,double annualBonus) {
        super(name, skill, salary);
        this.annualBonus=annualBonus;
    }
    @Override
    public void doWork() {
        System.out.println("software management WORK");
    }

    @Override
    public double getAnnualIncome() {
        return super.getAnnualIncome()+annualBonus;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("skill=" + annualBonus);
       

    }
}
