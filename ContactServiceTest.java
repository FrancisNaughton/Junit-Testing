import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class ContactServiceTest {
	//"T" refers to test and "LT" refers to long test
	protected String contactIdT,firstNameT, lastNameT, phoneNumT, addressT;
	protected String contactIdLT, firstNameLT, lastNameLT, phoneNumLT, addressLT;
	@BeforeEach
	void setUp() {
		contactIdT = "1684736284";
		firstNameT = "Francis";
		lastNameT = "Naughton";
		phoneNumT = "7743299640";
		addressT = "68 Stafford St";
		//long test values 
		contactIdLT = "16847362841684736284";
		firstNameLT = "FrancisFrancisFrancis";
		lastNameLT = "NaughtonNaughtonNaughton";
		phoneNumLT = "774329964077432996407743299640";
		addressLT = "68 Stafford St 68 Stafford St 68 Stafford St 68 Stafford St";
	}
	
	@Test
	void newContactTest() {
		ContactService service = new ContactService();
		service.newContact();
		assertAll("Service: ",
				()->assertNotNull(service.getContactList().get(0).getUniqueId()),
				()->assertEquals(null, service.getContactList().get(0).getFirstName()),
				()->assertEquals(null, service.getContactList().get(0).getLastName()),
				()->assertEquals("0000000000", service.getContactList().get(0).getPhoneNum()),
				()->assertEquals(null, service.getContactList().get(0).getAddress())
				);	
	}
	@Test
	void newContactTestOne() {
		ContactService service = new ContactService();
		service.newContact(firstNameT);
		assertAll("Constructor Test Two",
				()-> assertNotNull(service.getContactList().get(0).getUniqueId()),
				()-> assertEquals(firstNameT,service.getContactList().get(0).getFirstName()),
				()->assertEquals(null, service.getContactList().get(0).getLastName()),
				()->assertEquals("0000000000", service.getContactList().get(0).getPhoneNum()),
				()->assertEquals(null, service.getContactList().get(0).getAddress())
				);
	}
	@Test
	void newContactTestTwo() {
		ContactService service = new ContactService();
		service.newContact(firstNameT, lastNameT);
		assertAll("Constructor Test Three",
				()-> assertNotNull(service.getContactList().get(0).getUniqueId()),
				()-> assertEquals(firstNameT,service.getContactList().get(0).getFirstName()),
				()->assertEquals(lastNameT, service.getContactList().get(0).getLastName()),
				()->assertEquals("0000000000", service.getContactList().get(0).getPhoneNum()),
				()->assertEquals(null, service.getContactList().get(0).getAddress())
				);
	}
	@Test
	void newContactTestThree() {
		ContactService service = new ContactService();
		service.newContact(firstNameT, lastNameT, phoneNumT);
		assertAll("Constructor Test Two",
				()-> assertNotNull(service.getContactList().get(0).getUniqueId()),
				()-> assertEquals(firstNameT,service.getContactList().get(0).getFirstName()),
				()->assertEquals(lastNameT, service.getContactList().get(0).getLastName()),
				()->assertEquals(phoneNumT, service.getContactList().get(0).getPhoneNum()),
				()->assertEquals(null, service.getContactList().get(0).getAddress())
				);
	}
	@Test
	void newContactTestFour() {
		ContactService service = new ContactService();
		service.newContact(firstNameT, lastNameT, phoneNumT, addressT);
		assertAll("Constructor Test Two",
				()-> assertNotNull(service.getContactList().get(0).getUniqueId()),
				()-> assertEquals(firstNameT,service.getContactList().get(0).getFirstName()),
				()->assertEquals(lastNameT, service.getContactList().get(0).getLastName()),
				()->assertEquals(phoneNumT, service.getContactList().get(0).getPhoneNum()),
				()->assertEquals(addressT, service.getContactList().get(0).getAddress())
				);
	}
	@Test
	void updateFirstName() {
		ContactService service = new ContactService();
		service.newContact();
		service.getContactList().get(0).updateFName(firstNameT);
		assertEquals(firstNameT, service.getContactList().get(0).getFirstName());
	}
	@Test
	void updateLastName() {
		ContactService service = new ContactService();
		service.newContact();
		service.getContactList().get(0).updateLName(lastNameT);
		assertEquals(lastNameT, service.getContactList().get(0).getLastName());
	}
	@Test
	void updatePhoneNum() {
		ContactService service = new ContactService();
		service.newContact();
		service.getContactList().get(0).updatePNumber(phoneNumT);
		assertAll("",
			()->assertEquals(phoneNumT, service.getContactList().get(0).getPhoneNum()),
			()->assertThrows(Exception.class, ()->service.getContactList().get(0).updatePNumber(""))
		);
	}
	
}
	