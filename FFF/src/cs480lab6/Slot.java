package cs480lab6;

public class Slot {
    private String slotName;
    private int slotNo;
    private Driver driver;
    
    public Slot(String slotName,int slotNo,Driver driver){
    
    this.slotName=slotName;
    this.slotNo=slotNo;
    this.driver=driver;
    
    }

    /**
     * @return the slotName
     */
    public String getSlotName() {
        return slotName;
    }

    /**
     * @param slotName the slotName to set
     */
    public void setSlotName(String slotName) {
        this.slotName = slotName;
    }

    /**
     * @return the slotNo
     */
    public int getSlotNo() {
        return slotNo;
    }

    /**
     * @return the driver
     */
    public Driver getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */