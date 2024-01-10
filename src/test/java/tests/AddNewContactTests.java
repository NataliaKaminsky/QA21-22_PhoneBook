package tests;

import models.Contact;
import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.Random;

public class AddNewContactTests extends TestBase{

@BeforeClass
    public void precondition(){
    if(!app.getHelperUser().isLogged()){
        app.getHelperUser().login(new User().withEmail("natalia.kaminsky142857@gmail.com").withPassword("7Zhizney!"));
    }

}
@Test
public void addContactSuccessAllFields(){
    int i  = (int) (System.currentTimeMillis()/1000%3600);
    Contact contact = Contact.builder()
            .name("Tony")
            .lastName("Stark")
            .address("New York")
            .phone("356594"+i)
            .email("stark"+i+"@gmail.com")
            .description("The best")
            .build();
}


    @Test
    public void addContactSuccessRequiredFields(){
        int i  = (int) (System.currentTimeMillis()/1000%3600);
        Contact contact = Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .address("New York")
                .phone("356594"+i)
                .email("stark"+i+"@gmail.com")
                .build();
    }

  @Test
    public void addNewContactWrongName() {

    }

    @Test
    public void addNewContactWrongAddress() {

    }

    @Test
    public void addNewContactWrongLastName() {

    }
    @Test
    public void addNewContactWrongPhone() {

    } @Test
    public void addNewContactWrongWrongEmail() {

    }
}
