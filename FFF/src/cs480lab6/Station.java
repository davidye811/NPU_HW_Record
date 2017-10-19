package cs480lab6;
public class Station {
    private String stationName;
    private String modelType;
    private double price;
    private Slot[] slots;
    private int numSlots;
    private int slotindex;
    
    public Station(String stationName,String modelType,double price,int maxSlots ){
    
    this.stationName=stationName;
    this.modelType=modelType;
    this.price=price;
    this.slots=new Slot[maxSlots];
    this.numSlots=0;
    
    }

    /**
     * @return the stationName
     */
    public String getStationName() {
        return stationName;
    }

    /**
     * @param stationName the stationName to set
     */
      public void addSlot(Slot slot){
slots[numSlots]=slot;
numSlots++;

}
    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    /**
     * @return the modelType
     */
    public String getModelType() {
        return modelType;
    }

    /**
     * @return the price
     */
    public double getPrice() {
        return price;
    }
     
    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }
    public Slot getslot(int slotindex){


return slots[slotindex];

}
    public int getNumSlotsnoDRIVER(){
    int count=0;
    for(int i=0;i<numSlots;i++){
    if(slots[i].getDriver()==null){
    
      count++;
    
    }
   
    
    }
   return count; 
    
    
    }
    public Slot[] getSlotNoDriver(){
    
    int count =getNumSlotsnoDRIVER();
    Slot[] noDriverSlots=new Slot[count];
    int num=0;
    for(int i=0;i<numSlots;i++){
    
    if(slots[i].getDriver()==null){
    noDriverSlots[num]=slots[i];
    num++;
     }
    }
    return noDriverSlots;
    }
   public int getNumSlotWithHighVolt(){
  int count=0;
  System.out.println(slots.length);
     for(int i=0;i<numSlots;i++){
      System.out.println(slots[i].getDriver().getVottage());
    if(slots[i].getDriver().getVottage()>=10){
    
      count++;
    
    }
   
    
    }
   return count; 
    }
    public Slot[] getSlotWithHighVolt(){
    
    int count =getNumSlotWithHighVolt();
    Slot[] HighVolt=new Slot[count];
    int num=0;
    for(int i=0;i<numSlots;i++){
    
    if(slots[i].getDriver().getVottage()>=10){
    HighVolt[num]=slots[i];
    num++;
     }
    }
    return HighVolt;
    }
    
    public Driver getDriverwithHighestVolt(){
    
  
    Driver max =new Driver(0,null,slots[0].getDriver().getVottage());
    
    
    for(int i=0;i<numSlots;i++){
    if(slots[i].getDriver().getVottage()>max.getVottage()){
      max=slots[i].getDriver();
    
    }
    
    else {
        return max;
    }
    }
    return max;
    
    
    
    }
    
    
    
    public Slot getslot(String slotName){
        Slot target=null;
        for(int i=0;i<slots.length;i++){
            if(this.slots[i].getSlotName().equals(slotName)==true){
            
            target=slots[i];
            break;
            }
          
            }
        
         return target;
        }
  ;
   public static void main(String[] args){
   Driver driver = new Driver(10000,"sdfasfsd",12);
   Slot slot =new Slot("sdfasf",1,driver);
   Station station=new Station("Station A","SUPER",1000,10);
   station.addSlot(slot);
   
   
  
   station.addSlot(new Slot("A",2,null));
   station.addSlot(new Slot("B",2,null));
   station.addSlot(new Slot("c",2,driver));
   /*q4*/
   System.out.println(+station.getNumSlotsnoDRIVER());
   Slot[] noDriver=station.getSlotNoDriver();
   for(Slot s:noDriver){
   System.out.println(s.getSlotName());
   
   }
   /*q5*/
   System.out.println(+station.getNumSlotWithHighVolt());
   Slot[] highvoltSlots=station.getSlotWithHighVolt();
   for(Slot s:noDriver){
   System.out.println(s.getSlotName());
   
   }
   
   
   }
        
    }

