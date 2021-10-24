import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ContactTest {
	//"T" refers to test and "LT" refers to long test
	protected String uniqueIdT,firstNameT, lastNameT, phoneNumT, addressT;
	protected String uniqueIdLT, firstNameLT, lastNameLT, phoneNumLT, addressLT;
	//This Before each section will set the variable belows
	//before each of the tests as a baseline.
	@BeforeEach
	void setUp() {
		uniqueIdT = "1684736284";
		firstNameT = "Francis";
		lastNameT = "Naughton";
		phoneNumT = "7743299640";
		addressT = "68 Stafford St";
		//long test values 
		uniqueIdLT = "16847362841684736284";
		firstNameLT = "FrancisFrancisFrancis";
		lastNameLT = "NaughtonNaughtonNaughton";
		phoneNumLT = "774329964077432996407743299640";
		addressLT = "68 Stafford St 68 Stafford St 68 Stafford St 68 Stafford St";
	}
	@Test
	void contactTest() {
		Contact contact = new Contact();
		assertAll("constructor",
				()->assertNotNull(contact.getUniqueId()),
				()->assertNotNull(contact.getFirstName()),
				()->assertNotNull(contact.getLastName()),
				()->assertNotNull(contact.getPhoneNum()),
				()->assertNotNull(contact.getAddress())
				);
	}
	@Test
	void uniqueIdConstructorTest() {
		Contact contact = new Contact(uniqueIdT);
		assertAll("constructor one: ",
				()->assertEquals(uniqueIdT, contact.getUniqueId()),
				()->assertNotNull(contact.getFirstName()),
				()->assertNotNull(contact.getLastName()),
				()->assertNotNull(contact.getPhoneNum()),
				()->assertNotNull(contact.getAddress())
				);
	}
	@Test
	void uniqueIdAndFirstNameTest() {
		Contact contact = new Contact(uniqueIdT, firstNameT);
		assertAll("constuctor two: ",
		()->assertEquals(firstNameT, contact.getFirstName()),
		()->assertNull(contact.getLastName()),
		()->assertEquals("0000000000",contact.getPhoneNum()),
		()->assertNull(contact.getAddress()));
	}
	@Test
	void uniqueIdAndFirstLastName() {
		Contact contact = new Contact(uniqueIdT, firstNameT, lastNameT);
		assertAll("constuctor three: ",
		()->assertEquals(firstNameT, contact.getFirstName()),
		()->assertEquals(lastNameT, contact.getLastName()),
		()->assertEquals("0000000000",contact.getPhoneNum()),
		()->assertNull(contact.getAddress()));
	}
	@Test
	void constructorPhone() {
		Contact contact = new Contact(uniqueIdT, firstNameT, lastNameT, phoneNumT);
		assertAll("constuctor three: ",
		()->assertEquals(firstNameT, contact.getFirstName()),
		()->assertEquals(lastNameT, contact.getLastName()),
		()->assertEquals(phoneNumT, contact.getPhoneNum()),
		()->assertNull(contact.getAddress()));
	}
	@Test
	void constructorPhoneAddy() {
		Contact contact = new Contact(uniqueIdT, firstNameT, lastNameT, phoneNumT, addressT);
		assertAll("constuctor three: ",
		()->assertEquals(firstNameT, contact.getFirstName()),
		()->assertEquals(lastNameT, contact.getLastName()),
		()->assertEquals(phoneNumT, contact.getPhoneNum()),
		()->assertEquals(addressT, contact.getAddress()));
	}
	@Test
	void updatePhoneNum() {
		Contact contact = new Contact();
		contact.updatePNumber(phoneNumT);
		assertAll("Phone Number Update:", 
				()->assertEquals(phoneNumT, contact.getPhoneNum()),
				()->assertThrows(IllegalArgumentException.class, 
				()->contact.updatePNumber(null)),
				()->assertThrows(IllegalArgumentException.class, ()-> contact.updatePNumber(phoneNumLT))
				);
	}
	@Test
	void updateAddress() {
		Contact contact = new Contact();
		contact.updateAddress(addressT);
		assertAll("Address Update:", 
				()->assertEquals(addressT, contact.getAddress()),
				()->assertThrows(IllegalArgumentException.class, 
				()->contact.updateAddress(null)),
				()->assertThrows(IllegalArgumentException.class, ()-> contact.updateAddress(addressLT))
				);
	}
}
