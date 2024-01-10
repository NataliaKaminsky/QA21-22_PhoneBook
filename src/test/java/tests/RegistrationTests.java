package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        //if signout present--->logout
        if (TestBase.app.getHelperUser().isLogged()) {
            TestBase.app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccess() {
        Random random = new Random();
        int i = random.nextInt(1000);

        //int i=(int)(System.currentTimeMillis()/1000%3600);
        User user = new User().withEmail("don" + i + "@gmail.com").withPassword("Don123456$");
        TestBase.app.getHelperUser().openLoginRegistrationForm();
        TestBase.app.getHelperUser().fillLoginRegistrationForm(user);
        TestBase.app.getHelperUser().submitRegistration();
        Assert.assertTrue(TestBase.app.getHelperUser().isLogged());
        Assert.assertTrue(TestBase.app.getHelperUser().isNoContactHereDisplayed());
    }

    @Test//(description = "Bug report #12456", enabled = false" или fixed) - сделать тест невидимым)
    public void registrationWrongEmail() {
        User user = new User().withEmail("dongmail.com").withPassword("Don123456$");
        TestBase.app.getHelperUser().openLoginRegistrationForm();
        TestBase.app.getHelperUser().fillLoginRegistrationForm(user);
        TestBase.app.getHelperUser().submitRegistration();
        Assert.assertTrue(TestBase.app.getHelperUser().isAlertPresent("Wrong email or password format"));
    }

    @Test
    public void registrationWrongPassword() {
        Random random = new Random();
        int i = random.nextInt(1000);


        User user = new User().withEmail("don" + i + "@gmail.com").withPassword("Don123");
        TestBase.app.getHelperUser().openLoginRegistrationForm();
        TestBase.app.getHelperUser().fillLoginRegistrationForm(user);
        TestBase.app.getHelperUser().submitRegistration();
        Assert.assertTrue(TestBase.app.getHelperUser().isAlertPresent("Wrong email or password format"));
    }

    @Test
    public void registrationExistingUser() {

        User user = new User().withEmail("natalia.kaminsky142857@gmail.com").withPassword("Don123456$");
        TestBase.app.getHelperUser().openLoginRegistrationForm();
        TestBase.app.getHelperUser().fillLoginRegistrationForm(user);
        TestBase.app.getHelperUser().submitRegistration();
        Assert.assertTrue(TestBase.app.getHelperUser().isAlertPresent("User already exist"));
    }

}
