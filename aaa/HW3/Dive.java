/*
 * student info: name=YITING PENG  ,ID=19503
 * cs480_hw_nightmare
 */
package HW3;

/**
 *
 * @author asus-ad
 */
public class Dive {
    private String name;
    private float[]difficult=new float[3];
    private float grade[][];
    public Dive(String name,float[] difficult,float[][] grade){
    this.name=name;
    this.difficult=difficult;//difficult
    this.grade=grade;//grade
    
    
    }

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

    /**
     * @return the difficult
     */
    public float[] getDifficult() {
        return difficult;
    }

    /**
     * @param difficult the difficult to set
     */
    public void setDifficult(float[] difficult) {
        this.difficult = difficult;
    }

    /**
     * @return the grade
     */
    public float[][] getGrade() {
        return grade;
    }

    /**
     * @param grade the grade to set
     */
    public void setGrade(float[][] grade) {
        this.grade = grade;
    }

    
 }
