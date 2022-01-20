package com.fortna.tests;

import com.fortna.pages.FortnaHomePage;
import com.fortna.utility.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.*;

public class FortnaContactTest extends TestBase {

    @Test
    public void testFortnaContact() {
    FortnaHomePage homePage = new FortnaHomePage();
        homePage.goTo();

    assertTrue( homePage.isAt()  );

    driver.findElement(By.xpath("//a[@class='contact-btn button']")).click();

    assertTrue( driver.getTitle().startsWith("Contact") ) ;


}

}
