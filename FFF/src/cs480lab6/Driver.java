package cs480lab6;

/**
 *
 * @author Administrator
 */
public class Driver {
    private int driversn;
    private String drivertype;
    private double vottage;
    
    public Driver(int driversn,String drivertype,double vottage){
    
    this.driversn=driversn;
    this.drivertype=drivertype;
    this.vottage=vottage;
    
    }
public Driver(double vottage){

this.driversn=0;
this.drivertype=null;
this.vottage=vottage;
}
    /**
     * @return the driversn
     */
    public int getDriversn() {
        return driversn;
    }

    /**
     * @param driversn the driversn to set
     */
    public void setDriversn(int driversn) {
        this.driversn = driversn;
    }

    /**
     * @return the drivertype
     */
    public String getDrivertype() {
        return drivertype;
    }

    /**
     * @param drivertype the drivertype to set
     */
    public void setDrivertype(String drivertype) {
        this.drivertype = drivertype;
    }

    /**
     * @return the vottage
     */
    public double getVottage() {
        return vottage;
    }

    /**
     * @param vottage the vottage to set
     */
    public void setVottage(double vottage) {
        this.vottage = vottage;
    }
    
    
}
