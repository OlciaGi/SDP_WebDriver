package NP.GL;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class SkyScannerTest {
	
	public static void main(String args[]) throws InterruptedException {

		// variables
		int implicitlyWaitingTime = 5;
		String baseURL = "https://www.skyscanner.pl/";

		// Preparing web driver
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--disable-extensions");
		chromeOptions.setHeadless(false);
		WebDriver driver = new ChromeDriver(chromeOptions);

		/* Wait implicit time until browser is not opened */
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(implicitlyWaitingTime, TimeUnit.SECONDS);

		/* Initialize web portal page */
		driver.get(baseURL);
		
		
		WebElement whence=driver.findElement(By.xpath(".//*[@id='fsc-origin-search']"));
		whence.click(); //click on Z Element
		Thread.sleep(2000);
		whence.sendKeys("Gdańsk");
		
		
		WebElement where=driver.findElement(By.xpath("//div[@class='SingleDestControls_destination-wrapper__FcyJu SingleDestControls_destination-wrapper-oneline__3brcO']//div[@class='bpk-autosuggest__container']/child::input"));
		where.click();
		where.sendKeys("Paryż");
		Thread.sleep(2000);
		WebElement depart=driver.findElement(By.xpath("//div[@class='DateRangeSelector_DateRangeSelector__1H106']/child::div[1]/child::button"));
		depart.click();
		Thread.sleep(2000);
		WebElement dateDepart=driver.findElement(By.xpath("//tr[2]//td[3]//button[1]"));
		dateDepart.click();
		Thread.sleep(2000);
		WebElement return1=driver.findElement(By.xpath("//button[@id='return-fsc-datepicker-button']"));
		return1.click();
		Thread.sleep(2000);
		WebElement dateReturn=driver.findElement(By.xpath("//tr[3]//td[6]//button[1]"));
		dateReturn.click();
		WebElement clickPerson=driver.findElement(By.xpath("//button[@id='CabinClassTravellersSelector_fsc-class-travellers-trigger__18yAY']"));
		clickPerson.click();
		WebElement addPerson=driver.findElement(By.xpath("//body//div[@class='BpkPopover_bpk-popover__body--padded__3N5AG']//div//div[1]//div[1]//button[2]"));
		addPerson.click();
		WebElement ready=driver.findElement(By.xpath("//button[@class='BpkLink_bpk-link__2e_PE']"));
		ready.click();
		
		/*-------checkbox--------------*/
		WebElement checkbox1=driver.findElement(By.xpath("//input[@name='originFlexible']"));
		checkbox1.click();
		Thread.sleep(2000);
		WebElement checkbox2=driver.findElement(By.xpath("//input[@name='destinationFlexible']"));
		checkbox2.click();
		Thread.sleep(2000);
		WebElement directFlightsCheckbox=driver.findElement(By.xpath("//input[@name='directOnly']"));
		directFlightsCheckbox.click();
		Thread.sleep(2000);
		
		WebElement search=driver.findElement(By.xpath("//button[@class='BpkButton_bpk-button__12Eue BpkButton_bpk-button--large__2SwK9 App_SubmitButton__1EUd0']"));
		search.click();
		Thread.sleep(8000);

		driver.close();
		driver.quit();

	}
}

