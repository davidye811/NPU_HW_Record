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
public class Programmer extends Person {

    private String skill;
    private double salary;

    public Programmer(String name, String skill, double salary) {

        super(name);
        this.salary = salary;
        this.skill = skill;
    }

    @Override
    public void doWork() {
        System.out.println("software Programming WORK");
    }

    @Override
    public double getAnnualIncome() {
        return salary * 12;
    }

    @Override
    public void display() {
        super.display();
        System.out.println("skill=" + skill);
        System.out.println("salary=" + salary);

    }
}
