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
public abstract class Group implements Displayable{
    protected Person[] members;
    protected int numMembers;
    private String groupName;
    public Group(String groupName, int maxNumMembers){
    
    this.groupName=groupName;
    this.members=new Person[maxNumMembers];
    this.numMembers=0;
    
    
    }
    public void addMember(Person member){
    members[numMembers]=member;
    numMembers++;
    
    
    
    }
    @Override
    public void display(){

System.out.println("groupNAME="+groupName);
for(int i=0;i<numMembers;i++){
members[i].display();


}



}
}
