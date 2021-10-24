import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
public class ContactService {
	private String uniqueID;
	private List<Contact> contactList = new ArrayList<>();
	{
		uniqueID = UUID.randomUUID().toString().substring(0,Math.min(toString().length(), 10));
	}
	
 
	
	public void newContact() {
		Contact contact = new Contact(newId());
		contactList.add(contact);
	}
	public void newContact(String firstName) {
		Contact contact = new Contact(newId(), firstName);
		contactList.add(contact);
	}
	public void newContact(String firstName, String lastName) {
		Contact contact = new Contact(newId(), firstName, lastName);
		contactList.add(contact);
	}
	public void newContact(String firstName, String lastName, String phoneNum) {
		Contact contact = new Contact(newId(), firstName, lastName, phoneNum);
		contactList.add(contact);
	}
	public void newContact(String firstName, String lastName, String phoneNum, String address) {
		Contact contact = new Contact(newId(), firstName, lastName, phoneNum, address);
		contactList.add(contact);
	}
	
	public void updateFName(String id, String firstName) throws Exception {
		idSearch(id).updateFName(firstName);
	}
	public void updateLName(String id, String lastName) throws Exception {
		idSearch(id).updateLName(lastName);
	}
	public void updatePNumber(String id, String phoneNum) throws Exception {
		idSearch(id).updatePNumber(phoneNum);
	}
	public List<Contact> getContactList() {
		return contactList;
	}
	
	private String newId() {
		return uniqueID = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
	}
	
	private Contact idSearch(String id) throws Exception{
		for(int i = 0; i > contactList.size(); i++) {
			if(id.equals(contactList.get(i).getUniqueId())) {
				return contactList.get(i);
			}
		}
		throw new Exception("That contact doesn't exist!");
	}
	
	
	public void deleteContact(String id) throws Exception{
		contactList.remove(idSearch(id));
	}
}
