package RegistrationFormTest;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestAutomationChuloSolutions {

    WebDriver driver;

    @BeforeClass // annotation used for pre-processing before test begins
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://chulo-solutions.github.io/qa-internship/");
    }

    @AfterClass // annotation used for post operations after the test ends
    public void tearDown() {
        driver.quit(); // quits every window opened in the web browser during testing
        // driver.close(); closes a particular url for which we're testing on
    }

    // Helper method to handle JavaScript alert
    public String handleAlert() {
        Alert alert = driver.switchTo().alert();
        String alertMessage = alert.getText(); // Get the alert text
        alert.accept(); // Click "OK" on the alert
        return alertMessage;
    }

    // to execute every test case one by one we need to clear the previous data and fill new data
    public void clearAndFillInput(WebElement element, String data) {
        element.clear();
        element.sendKeys(data);
    }

    // verifying registration with valid input data
    @Test(priority = 1)
    public void validInputDataRegistration() throws InterruptedException {
        Thread.sleep(1000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement creditCardNumber = driver.findElement(By.id("creditCard"));
        WebElement telephoneNumber = driver.findElement(By.id("telephone"));

        clearAndFillInput(username, "abc123");
        Thread.sleep(500);
        clearAndFillInput(password, "AaBb@1230");
        Thread.sleep(500);
        clearAndFillInput(creditCardNumber, "4111666622227777");
        Thread.sleep(500);
        clearAndFillInput(telephoneNumber, "(981) 234-5678");
        Thread.sleep(500);
        driver.findElement(By.tagName("button")).click();

        String actualResult = handleAlert();
        System.out.println(actualResult);
        String expectedResult = "Form submitted successfully!";

        Assert.assertEquals(expectedResult, actualResult);

    }

    /*
    verifying registration with invalid username
    - less than 5 characters - status : pass
    - more than 15 characters - status : pass
    - username includes special characters - status : pass
    - username with numbers only - status : fail because we accept alphanumeric character not numbers only
    - username with alphabets only - status : fail because we accept alphanumeric character not alphabets only
     */

    @Test(priority = 2)
    public void invalidUsernameWithFiveCharacters() throws InterruptedException {
        Thread.sleep(1000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement creditCardNumber = driver.findElement(By.id("creditCard"));
        WebElement telephoneNumber = driver.findElement(By.id("telephone"));

        clearAndFillInput(username, "abc1");
        Thread.sleep(500);
        clearAndFillInput(password, "AaBb@1230");
        Thread.sleep(500);
        clearAndFillInput(creditCardNumber, "4111666622227777");
        Thread.sleep(500);
        clearAndFillInput(telephoneNumber, "(981) 234-5678");
        Thread.sleep(500);
        driver.findElement(By.tagName("button")).click();

        String actualResult = handleAlert();
        System.out.println(actualResult);
        String expectedResult = "Username must be alphanumeric and between 5 to 15 characters.";

        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test(priority = 3)
    public void invalidUsernameWithMoreThanFifteenCharacters() throws InterruptedException {
        Thread.sleep(1000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement creditCardNumber = driver.findElement(By.id("creditCard"));
        WebElement telephoneNumber = driver.findElement(By.id("telephone"));

        clearAndFillInput(username, "abcdef1234567890");
        Thread.sleep(500);
        clearAndFillInput(password, "AaBb@1230");
        Thread.sleep(500);
        clearAndFillInput(creditCardNumber, "4111666622227777");
        Thread.sleep(500);
        clearAndFillInput(telephoneNumber, "(981) 234-5678");
        Thread.sleep(500);
        driver.findElement(By.tagName("button")).click();

        String actualResult = handleAlert();
        System.out.println(actualResult);
        String expectedResult = "Username must be alphanumeric and between 5 to 15 characters.";

        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test(priority = 4)
    public void invalidUsernameWithSpecialCharacters() throws InterruptedException {
        Thread.sleep(100);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement creditCardNumber = driver.findElement(By.id("creditCard"));
        WebElement telephoneNumber = driver.findElement(By.id("telephone"));

        clearAndFillInput(username, "abc@123");
        Thread.sleep(500);
        clearAndFillInput(password, "AaBb@1230");
        Thread.sleep(500);
        clearAndFillInput(creditCardNumber, "4111666622227777");
        Thread.sleep(500);
        clearAndFillInput(telephoneNumber, "(981) 234-5678");
        Thread.sleep(500);
        driver.findElement(By.tagName("button")).click();

        String actualResult = handleAlert();
        System.out.println(actualResult);
        String expectedResult = "Username must be alphanumeric and between 5 to 15 characters.";

        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test(priority = 5)
    public void invalidUsernameWithNumericCharactersOnly() throws InterruptedException {
        Thread.sleep(1000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement creditCardNumber = driver.findElement(By.id("creditCard"));
        WebElement telephoneNumber = driver.findElement(By.id("telephone"));

        clearAndFillInput(username, "123456");
        Thread.sleep(500);
        clearAndFillInput(password, "AaBb@1230");
        Thread.sleep(500);
        clearAndFillInput(creditCardNumber, "4111666622227777");
        Thread.sleep(500);
        clearAndFillInput(telephoneNumber, "(981) 234-5678");
        Thread.sleep(500);
        driver.findElement(By.tagName("button")).click();

        String actualResult = handleAlert();
        System.out.println(actualResult);
        String expectedResult = "Username must be alphanumeric and between 5 to 15 characters.";

        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test(priority = 6)
    public void invalidUsernameWithAlphabetCharactersOnly() throws InterruptedException {
        Thread.sleep(2000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement creditCardNumber = driver.findElement(By.id("creditCard"));
        WebElement telephoneNumber = driver.findElement(By.id("telephone"));

        clearAndFillInput(username, "abcdef");
        Thread.sleep(1000);
        clearAndFillInput(password, "AaBb@1230");
        Thread.sleep(1000);
        clearAndFillInput(creditCardNumber, "4111666622227777");
        Thread.sleep(1000);
        clearAndFillInput(telephoneNumber, "(981) 234-5678");
        Thread.sleep(1000);
        driver.findElement(By.tagName("button")).click();

        String actualResult = handleAlert();
        System.out.println(actualResult);
        String expectedResult = "Username must be alphanumeric and between 5 to 15 characters.";

        Assert.assertEquals(expectedResult, actualResult);

    }

    /*
    verifying registration with invalid password
    - less than 8 characters
    - No uppercase
    - No lowercase
    - No number
    - No special character
     */

    @Test(priority = 7)
    public void invalidPasswordWithLessThanEightCharacters() throws InterruptedException {
        Thread.sleep(1000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement creditCardNumber = driver.findElement(By.id("creditCard"));
        WebElement telephoneNumber = driver.findElement(By.id("telephone"));

        clearAndFillInput(username, "abc123");
        Thread.sleep(500);
        clearAndFillInput(password, "Ab@123");
        Thread.sleep(500);
        clearAndFillInput(creditCardNumber, "4111666622227777");
        Thread.sleep(500);
        clearAndFillInput(telephoneNumber, "(981) 234-5678");
        Thread.sleep(500);
        driver.findElement(By.tagName("button")).click();

        String actualResult = handleAlert();
        System.out.println(actualResult);
        String expectedResult = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one number, and one special character.";

        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test(priority = 8)
    public void invalidPasswordWithNoUppercase() throws InterruptedException {
        Thread.sleep(1000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement creditCardNumber = driver.findElement(By.id("creditCard"));
        WebElement telephoneNumber = driver.findElement(By.id("telephone"));

        clearAndFillInput(username, "abc123");
        Thread.sleep(500);
        clearAndFillInput(password, "abcd@1230");
        Thread.sleep(500);
        clearAndFillInput(creditCardNumber, "4111666622227777");
        Thread.sleep(500);
        clearAndFillInput(telephoneNumber, "(981) 234-5678");
        Thread.sleep(500);
        driver.findElement(By.tagName("button")).click();

        String actualResult = handleAlert();
        System.out.println(actualResult);
        String expectedResult = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one number, and one special character.";

        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test(priority = 9)
    public void invalidPasswordWithNoLowercase() throws InterruptedException {
        Thread.sleep(1000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement creditCardNumber = driver.findElement(By.id("creditCard"));
        WebElement telephoneNumber = driver.findElement(By.id("telephone"));

        clearAndFillInput(username, "abc123");
        Thread.sleep(500);
        clearAndFillInput(password, "ABCD@1230");
        Thread.sleep(500);
        clearAndFillInput(creditCardNumber, "4111666622227777");
        Thread.sleep(500);
        clearAndFillInput(telephoneNumber, "(981) 234-5678");
        Thread.sleep(500);
        driver.findElement(By.tagName("button")).click();

        String actualResult = handleAlert();
        System.out.println(actualResult);
        String expectedResult = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one number, and one special character.";

        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test(priority = 10)
    public void invalidPasswordWithNoNumber() throws InterruptedException {
        Thread.sleep(1000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement creditCardNumber = driver.findElement(By.id("creditCard"));
        WebElement telephoneNumber = driver.findElement(By.id("telephone"));

        clearAndFillInput(username, "abc123");
        Thread.sleep(500);
        clearAndFillInput(password, "ABCD@abcd");
        Thread.sleep(500);
        clearAndFillInput(creditCardNumber, "4111666622227777");
        Thread.sleep(500);
        clearAndFillInput(telephoneNumber, "(981) 234-5678");
        Thread.sleep(500);
        driver.findElement(By.tagName("button")).click();

        String actualResult = handleAlert();
        System.out.println(actualResult);
        String expectedResult = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one number, and one special character.";

        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test(priority = 11)
    public void invalidPasswordWithNoSpecialCharacters() throws InterruptedException {
        Thread.sleep(1000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement creditCardNumber = driver.findElement(By.id("creditCard"));
        WebElement telephoneNumber = driver.findElement(By.id("telephone"));

        clearAndFillInput(username, "abc123");
        Thread.sleep(500);
        clearAndFillInput(password, "Abcd1230");
        Thread.sleep(500);
        clearAndFillInput(creditCardNumber, "4111666622227777");
        Thread.sleep(500);
        clearAndFillInput(telephoneNumber, "(981) 234-5678");
        Thread.sleep(500);
        driver.findElement(By.tagName("button")).click();

        String actualResult = handleAlert();
        System.out.println(actualResult);
        String expectedResult = "Password must be at least 8 characters long and contain at least one uppercase letter, one lowercase letter, one number, and one special character.";

        Assert.assertEquals(expectedResult, actualResult);

    }

    /*
    verifying registration with invalid credit card number
    - credit card numbers starting with 0,1,2,3,50,56,57,58,59,6,7,8,9 are invalid
     */
    @Test(priority = 12)
    public void testInvalidCreditCardNumber() throws InterruptedException {
        String[] invalidPrefixes = {"0", "1", "2", "3", "6", "7", "8", "9"};

        for(String prefix : invalidPrefixes) {
            String invalidCardNumber = prefix + "111666622227777";


            Thread.sleep(1000);

            WebElement username = driver.findElement(By.id("username"));
            WebElement password = driver.findElement(By.id("password"));
            WebElement creditCardNumber = driver.findElement(By.id("creditCard"));
            WebElement telephoneNumber = driver.findElement(By.id("telephone"));

            clearAndFillInput(username, "abc123");
            Thread.sleep(500);
            clearAndFillInput(password, "Abcd@1230");
            Thread.sleep(500);
            clearAndFillInput(creditCardNumber, invalidCardNumber);
            Thread.sleep(500);
            clearAndFillInput(telephoneNumber, "(981) 234-5678");
            Thread.sleep(500);
            driver.findElement(By.tagName("button")).click();

            String actualResult = handleAlert();
            System.out.println(actualResult);
            String expectedResult = "Enter a valid credit card number.";

            Assert.assertEquals(expectedResult, actualResult);
        }

    }

    @Test(priority = 13)
    public void testInvalidCreditCardNumberFive() throws InterruptedException {
        String[] invalid5Prefixes = {"50", "56", "57", "58", "59"};

        for(String prefix : invalid5Prefixes) {
            String invalidCardNumber = prefix + "11666622227777";


            Thread.sleep(1000);

            WebElement username = driver.findElement(By.id("username"));
            WebElement password = driver.findElement(By.id("password"));
            WebElement creditCardNumber = driver.findElement(By.id("creditCard"));
            WebElement telephoneNumber = driver.findElement(By.id("telephone"));

            clearAndFillInput(username, "abc123");
            Thread.sleep(500);
            clearAndFillInput(password, "Abcd@1230");
            Thread.sleep(500);
            clearAndFillInput(creditCardNumber, invalidCardNumber);
            Thread.sleep(500);
            clearAndFillInput(telephoneNumber, "(981) 234-5678");
            Thread.sleep(500);
            driver.findElement(By.tagName("button")).click();

            String actualResult = handleAlert();
            System.out.println(actualResult);
            String expectedResult = "Enter a valid credit card number.";

            Assert.assertEquals(expectedResult, actualResult);
        }

    }

    /*
    Verifying registration with invalid telephone number
    - telephone number is less than 10 digits
    - telephone number is more than 10 digits
    - telephone number contains alphabets
    - telephone number contains special characters
    - telephone number is in invalid format
     */

    @Test(priority = 14)
    public void invalidTelephoneNumberWithLessThanTenNumbers() throws InterruptedException {
        Thread.sleep(1000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement creditCardNumber = driver.findElement(By.id("creditCard"));
        WebElement telephoneNumber = driver.findElement(By.id("telephone"));

        clearAndFillInput(username, "abc123");
        Thread.sleep(500);
        clearAndFillInput(password, "Abcd@1230");
        Thread.sleep(500);
        clearAndFillInput(creditCardNumber, "4111666622227777");
        Thread.sleep(500);
        clearAndFillInput(telephoneNumber, "(981) 234-567");
        Thread.sleep(500);
        driver.findElement(By.tagName("button")).click();

        String actualResult = handleAlert();
        System.out.println(actualResult);
        String expectedResult = "Telephone number must follow the format (XXX) XXX-XXXX.";

        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test(priority = 15)
    public void invalidTelephoneNumberWithMoreThanTenNumbers() throws InterruptedException {
        Thread.sleep(1000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement creditCardNumber = driver.findElement(By.id("creditCard"));
        WebElement telephoneNumber = driver.findElement(By.id("telephone"));

        clearAndFillInput(username, "abc123");
        Thread.sleep(500);
        clearAndFillInput(password, "Abcd@1230");
        Thread.sleep(500);
        clearAndFillInput(creditCardNumber, "4111666622227777");
        Thread.sleep(500);
        clearAndFillInput(telephoneNumber, "(981) 234-56789");
        Thread.sleep(500);
        driver.findElement(By.tagName("button")).click();

        String actualResult = handleAlert();
        System.out.println(actualResult);
        String expectedResult = "Telephone number must follow the format (XXX) XXX-XXXX.";

        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test(priority = 16)
    public void invalidTelephoneNumberWithAlphabets() throws InterruptedException {
        Thread.sleep(1000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement creditCardNumber = driver.findElement(By.id("creditCard"));
        WebElement telephoneNumber = driver.findElement(By.id("telephone"));

        clearAndFillInput(username, "abc123");
        Thread.sleep(500);
        clearAndFillInput(password, "Abcd@1230");
        Thread.sleep(500);
        clearAndFillInput(creditCardNumber, "4111666622227777");
        Thread.sleep(500);
        clearAndFillInput(telephoneNumber, "(981) abcdefgh");
        Thread.sleep(500);
        driver.findElement(By.tagName("button")).click();

        String actualResult = handleAlert();
        System.out.println(actualResult);
        String expectedResult = "Telephone number must follow the format (XXX) XXX-XXXX.";

        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test(priority = 17)
    public void invalidTelephoneNumberWithSpecialCharacters() throws InterruptedException {
        Thread.sleep(1000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement creditCardNumber = driver.findElement(By.id("creditCard"));
        WebElement telephoneNumber = driver.findElement(By.id("telephone"));

        clearAndFillInput(username, "abc123");
        Thread.sleep(500);
        clearAndFillInput(password, "Abcd@1230");
        Thread.sleep(500);
        clearAndFillInput(creditCardNumber, "4111666622227777");
        Thread.sleep(500);
        clearAndFillInput(telephoneNumber, "(981) 234-567@");
        Thread.sleep(500);
        driver.findElement(By.tagName("button")).click();

        String actualResult = handleAlert();
        System.out.println(actualResult);
        String expectedResult = "Telephone number must follow the format (XXX) XXX-XXXX.";

        Assert.assertEquals(expectedResult, actualResult);

    }

    @Test(priority = 18)
    public void invalidTelephoneNumberWithInvalidFormat() throws InterruptedException {
        Thread.sleep(1000);

        WebElement username = driver.findElement(By.id("username"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement creditCardNumber = driver.findElement(By.id("creditCard"));
        WebElement telephoneNumber = driver.findElement(By.id("telephone"));

        clearAndFillInput(username, "abc123");
        Thread.sleep(500);
        clearAndFillInput(password, "Abcd@1230");
        Thread.sleep(500);
        clearAndFillInput(creditCardNumber, "4111666622227777");
        Thread.sleep(500);
        clearAndFillInput(telephoneNumber, "9812345678");
        Thread.sleep(500);
        driver.findElement(By.tagName("button")).click();

        String actualResult = handleAlert();
        System.out.println(actualResult);
        String expectedResult = "Telephone number must follow the format (XXX) XXX-XXXX.";

        Assert.assertEquals(expectedResult, actualResult);

    }
}
