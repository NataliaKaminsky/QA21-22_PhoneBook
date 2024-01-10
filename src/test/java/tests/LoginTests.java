package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        //if sign out present --->log out
        if (TestBase.app.getHelperUser().isLogged()) {
            TestBase.app.getHelperUser().logout();
        }
    }

    @Test
    public void loginSuccess() {
        TestBase.app.getHelperUser().openLoginRegistrationForm();
        TestBase.app.getHelperUser().fillLoginRegistrationForm("natalia.kaminsky142857@gmail.com", "7Zhizney!");
        TestBase.app.getHelperUser().submitLogin();

        Assert.assertTrue(TestBase.app.getHelperUser().isLogged());

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

    }

    @Test
    public void loginSuccess1() {
        User user = new User().withEmail("natalia.kaminsky142857@gmail.com").withPassword("7Zhizney!");

        TestBase.app.getHelperUser().openLoginRegistrationForm();
        TestBase.app.getHelperUser().fillLoginRegistrationForm(user);
        TestBase.app.getHelperUser().submitLogin();

        Assert.assertTrue(TestBase.app.getHelperUser().isLogged());


    }

    @Test
    public void loginSuccessModel() {
        TestBase.app.getHelperUser().openLoginRegistrationForm();
        TestBase.app.getHelperUser().fillLoginRegistrationForm("natalia.kaminsky142857@gmail.com", "7Zhizney!");
        TestBase.app.getHelperUser().submitLogin();

        Assert.assertTrue(TestBase.app.getHelperUser().isLogged());

//        Assert.assertEquals();
//        Assert.assertNotEquals();
//        Assert.assertTrue();
//        Assert.assertFalse();

    }

    @Test
    public void loginWrongEmail() {
        TestBase.app.getHelperUser().openLoginRegistrationForm();
        TestBase.app.getHelperUser().fillLoginRegistrationForm("natalia.kaminsky142857gmail.com", "7Zhizney!");
        TestBase.app.getHelperUser().submitLogin();
        Assert.assertTrue(TestBase.app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

    @Test
    public void loginWrongPassword() {
        TestBase.app.getHelperUser().openLoginRegistrationForm();
        TestBase.app.getHelperUser().fillLoginRegistrationForm("natalia.kaminsky142857@gmail.com", "7Zhizney");
        TestBase.app.getHelperUser().submitLogin();
        Assert.assertTrue(TestBase.app.getHelperUser().isAlertPresent("Wrong email or password"));
    }


    @Test
    public void loginUnregisteredUser() {
        TestBase.app.getHelperUser().openLoginRegistrationForm();
        TestBase.app.getHelperUser().fillLoginRegistrationForm("nataliakaminsky142857@gmail.com", "7Zhizney!");
        TestBase.app.getHelperUser().submitLogin();
        Assert.assertTrue(TestBase.app.getHelperUser().isAlertPresent("Wrong email or password"));
    }

}



