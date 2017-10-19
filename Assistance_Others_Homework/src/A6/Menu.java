package A6;

import java.util.HashMap;

public class Menu {
	HashMap<String,Contact> Contacts;
	Contact lastRecord;
	Contact firstRecord;
	public Menu() {
		this.Contacts=new HashMap<String,Contact>();
	}
	public HashMap<String, Contact> getContacts() {
		return Contacts;
	}
	public void setContacts(HashMap<String, Contact> contacts) {
		Contacts = contacts;
	}
	public Contact getLastRecord() {
		return lastRecord;
	}
	public void setLastRecord(Contact lastRecord) {
		this.lastRecord = lastRecord;
	}
	public void add(Contact ContactToAdded){
		Contacts.put(ContactToAdded.name, ContactToAdded);
		if(firstRecord==null){
			firstRecord=ContactToAdded;
		}
		if(lastRecord==null){
			lastRecord=ContactToAdded;
		}else{
		lastRecord.next=ContactToAdded;
		ContactToAdded.previous=lastRecord;
		}
	}
	public void delete(String name){
		Contact ContactToDeleted=Contacts.get(name);
		if(lastRecord==ContactToDeleted){
			lastRecord=lastRecord.previous;
		}
		if(firstRecord==ContactToDeleted){
			firstRecord=null;
		}
		Contacts.remove(ContactToDeleted.name);
	}
	public Contact Search(String name){
		return Contacts.get(name); 
	}
}
