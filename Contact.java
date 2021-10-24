import java.util.List;

/*
 * Francis Naughton
 * 
 */
public class Contact {
	private String uniqueID;
	private String firstName;
	private String lastName; 
	private String phoneNumber;
	private String address;
	
	Contact(){
		this.uniqueID = null;
		this.firstName = null;
		this.lastName = null;
		this.phoneNumber = "0000000000";
		this.address = null;
	}
	Contact(String uniqueID){
		this.firstName = null;
		this.lastName = null;
		this.phoneNumber = "0000000000";
		this.address = null;
	}
	Contact(String uniqueID, String firstName){
		updateFName(firstName);
		this.lastName = null;
		this.phoneNumber = "0000000000";
		this.address = null;
	}
	Contact(String uniqueID, String firstName, String lastName){
		updateFName(firstName);
		updateLName(lastName);
		this.phoneNumber = "0000000000";
		this.address = null;
	}
	Contact(String uniqueID, String firstName, String lastName, String phoneNumber){
		updateFName(firstName);
		updateLName(lastName);
		updatePNumber(phoneNumber);
		this.address = null;
	}
	Contact(String uniqueID, String firstName, String lastName, String phoneNumber, String address){
		
		updateFName(firstName);
		updateLName(lastName);
		updatePNumber(phoneNumber);
		updateAddress(address);
	}
// These  are the getter methods for the class Contact. 
	protected final String getUniqueId() {
		return uniqueID;
	}
	
	protected final String getFirstName() {
		return firstName;
	}
	protected final String getLastName() {
		return lastName;
	}
	protected final String getPhoneNum() {
		return phoneNumber;
	}
	protected final String getAddress() {
		return address;
	}
	//Updates the address if the string input is 
	//neither empty nor more than 30 characters
	protected void updateAddress(String address) {
		if(address == null) {
			throw new IllegalArgumentException("Address must be filled");			
		}else if(address.length() > 30) {
			throw new IllegalArgumentException("Address exceeds "+ 30 +"characters!");
		}else {
			this.address = address;
		}
		
	}
	//Updates the phone number if the string input is
	//neither empty nor more than 10 characters
	protected void updatePNumber(String phoneNumber) {
		if(phoneNumber == null) {
			throw new IllegalArgumentException("Phone number cannot remain empty!");			
		}else if(phoneNumber.length() != 10) {
			throw new IllegalArgumentException("Phone number must be 10 characters!");
		}else {
			this.phoneNumber = phoneNumber;
		}
		
	}
	//Updates the first name if the string input is
	//neither empty nor more than 10 characters
	protected void updateFName(String firstName) {
		if(firstName == null) {
			throw new IllegalArgumentException("Name cannot remain empty!");			
		}else if(firstName.length() > 10) {
			throw new IllegalArgumentException("First name exceeds "+ 10 +"characters!");
		}else {
			this.firstName = firstName;
		}
		
	}
	// Updates the last name the string input is
	//neither empty nor more than 10 characters
	protected void updateLName(String lastName) {
		if(lastName == null) {
			throw new IllegalArgumentException("Last name cannot remain empty!");			
		}else if(lastName.length() > 10) {
			throw new IllegalArgumentException("Last name exceeds "+ 10 +"characters!");
		}else {
			this.lastName = lastName;
		}	
	}
}
