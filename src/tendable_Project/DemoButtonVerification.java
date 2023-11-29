package tendable_Project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DemoButtonVerification {

    public static void main(String[] args) {
        // Set the path to the ChromeDriver executable
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\hp\\\\Downloads\\\\Automation\\\\selenium\\\\chromedriver_win32\\\\chromedriver.exe");

        // Initialize the WebDriver
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tendable.com/");
        driver.manage().window().maximize();

        // Define the top-level menu page URLs
        String[] menuPages = {
                "https://www.tendable.com/home",
                "https://www.tendable.com/our-story",
                "https://www.tendable.com/our-solution",
                "https://www.tendable.com/why-tendable"
        };

        try {
            // Loop through each top-level menu page
            for (String menuPage : menuPages) {
                // Navigate to the menu page
                driver.get(menuPage);

                // Verify the presence and activity of the "Request a Demo" button
                verifyDemoButton(driver, menuPage);
            }
        } finally {
            // Close the browser window
            driver.quit();
        }
    }

    private static void verifyDemoButton(WebDriver driver, String pageUrl) {
        try {
            // Locate the "Request a Demo" button
            WebElement demoButton = driver.findElement(By.xpath("//button[contains(text(),'Request a Demo')]"));

            // Check if the button is present
            if (demoButton.isDisplayed()) {
                // Check if the button is active (enabled)
                if (demoButton.isEnabled()) {
                    System.out.println("PASS: 'Request a Demo' button is present and active on " + pageUrl);
                } else {
                    System.out.println("FAIL: 'Request a Demo' button is present but not active on " + pageUrl);
                }
            } else {
                System.out.println("FAIL: 'Request a Demo' button is not present on " + pageUrl);
            }
        } catch (Exception e) {
            // Handle exceptions, e.g., element not found
            System.out.println("ERROR: Exception occurred while verifying 'Request a Demo' button on " + pageUrl);
            e.printStackTrace();
        }
    }
        
        private static void verifyErrorMessage(WebDriver driver) {
            try {
                // Locate the error message element
                WebElement errorMessage = driver.findElement(By.xpath("//div[@class='error-message']"));

                // Check if the error message is present
                if (errorMessage.isDisplayed()) {
                    System.out.println("PASS: Error message is displayed on form submission.");
                } else {
                    System.out.println("FAIL: Error message is not displayed on form submission.");
                }
            } catch (Exception e) {
                // Handle exceptions, e.g., element not found
                System.out.println("ERROR: Exception occurred while verifying error message on form submission.");
                e.printStackTrace();
            }
    }
}