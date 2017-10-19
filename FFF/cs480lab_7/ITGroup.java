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
public class ITGroup extends Group {

    protected int numProjects;
    private Project[] projects;

    public ITGroup(String groupName, int maxNumMembers, int maxNumProjects) {
        super(groupName, maxNumMembers);

        this.projects = new Project[maxNumProjects];
        this.numProjects = 0;
    }

    public void Poject(Project project) {

        projects[numProjects] = project;
        numProjects++;

    }

    public void addProject(Project project) {
        projects[numProjects] = project;
        numProjects++;

    }

    public Project findlargestProjects() {
        double maxbudget = 0.0;
        Project max = projects[0];
        for (int i = 0; i < numProjects; i++) {
            if (projects[i].getBudget() > max.getBudget()) {
                max = projects[i];
                maxbudget = projects[i].getBudget();
            }

        }

        return max;

    }

    public Person[] findAllMembersMoreTHAN(double income) {

        Person[] vip = new Person[members.length];
        int j = 0;
        for (int i = 0; i < super.numMembers; i++) {
            if (super.members[i].getAnnualIncome() > income) {

                vip[j] = members[i];
                j++;

            }

        }
        
        return vip;

    }

    public void askAllManagerDoWork() {
        for (int i = 0; i < members.length; i++) {
            System.out.print(members[i].getClass().getName());
            if(members[i]!=null){
            if (members[i].getClass().getName().equals("cs480lab_7.Manager")) {
                this.members[i].doWork();
            }}
        }

    }

    @Override
    public void display() {
        super.display();
        for (int i = 0; i < numProjects; i++) {

            projects[i].display();

        }

    }

    public static void main(String[] args) {

        ITGroup itg = new ITGroup("NPU", 10, 20);
        itg.addMember(new Programmer("Jimmy", "PHP", 5000));
        itg.addMember(new Programmer("Jim", "c2", 5000));
        itg.addMember(new Programmer("Tom", "as", 5000));
        itg.addProject(new Project("Libarary", 200));
        itg.addProject(new Project("school", 23000));
        itg.addProject(new Project("church", 203300));
        itg.addProject(new Project("subway", 20002));
        itg.addProject(new Project("classroom", 20345200));
        /*findlargest*/
        itg.display();
        Project temp=itg.findlargestProjects();
        System.out.println(temp.getProjectName());
        /*more than*/
        Person[]vip=itg.findAllMembersMoreTHAN(3000.0);
        for(Person s2:vip){
            if(s2!=null){
        System.out.println(s2.getName());
            }
        
        }
        /*dowork*/
        itg.askAllManagerDoWork();
    }

    /**
     * @return the projects
     */
}
