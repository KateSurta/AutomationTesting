package tests;

import Pages.AdminPages;
import org.testng.Assert;
import org.testng.annotations.Test;



public class AdminPageTests extends LoginPageTests {
    public String AdminPageTitle = "Event Central 3.0";

    /*@Test(dependsOnMethods = {"verifyAuthUser"})
    public void adminItemIsDisplayed() {
        boolean n = new AdminPages(driver).isNavbarTextisDisplayed();
        boolean h1 = new AdminPages(driver).ishomeFirstTitleisDisplayed();
        boolean h2 = new AdminPages(driver).ishomeSecondTitleisDisplayed();
        Assert.assertEquals(n, true);
        Assert.assertEquals(h1, true);
        Assert.assertEquals(h2, true);
        String titleAdminPage = new AdminPages(driver).getHomePagesText();
        Assert.assertEquals(AdminPageTitle, titleAdminPage);
        String firstTextAdminPage = new AdminPages(driver).gethomeFirstText();
        Assert.assertEquals("Administration", firstTextAdminPage);
        String secondTextAdminPage = new AdminPages(driver).gethomeFirstText();
        Assert.assertEquals("Administration", secondTextAdminPage);
    }

*/

}
