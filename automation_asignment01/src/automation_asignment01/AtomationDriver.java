package automation_asignment01;

import java.util.Iterator;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


public class AtomationDriver {
	
	//create an exerciseOne public void method with arguments of driver object
	public void exerciseOne(WebDriver driver) {
		// access the radio button & perform click operation
		// verification whether it got selected or not using assert

		driver.findElement(By.xpath("//input[@value='radio1']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='radio1']")).isSelected());
		System.out.println(driver.findElement(By.xpath("//input[@value='radio1']")).isSelected());

		driver.findElement(By.xpath("//input[@value='radio2']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='radio2']")).isSelected());
		System.out.println(driver.findElement(By.xpath("//input[@value='radio2']")).isSelected());

		driver.findElement(By.xpath("//input[@value='radio3']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//input[@value='radio3']")).isSelected());
		System.out.println(driver.findElement(By.xpath("//input[@value='radio3']")).isSelected());

	}
	
	//create an public method to work on autosuggestion search box
	
	public void exerciseTwo(WebDriver driver) throws InterruptedException {

		driver.findElement(By.id("autocomplete")).sendKeys("United States");

		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		List<WebElement> optionsmany = driver.findElements(By.cssSelector("li[class='ui-menu-item'] div"));

		for (WebElement option : optionsmany)

		{

			if (option.getText().equalsIgnoreCase("United States Minor Outlying Islands"))

			{

				option.click();

				break;

			}

		}

	}

	// create an static method of exerciseThree
	static void exerciseThree(WebDriver driver) {

		// create a webelement with dropdown code to access with indexing method
		WebElement Dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select dropdown = new Select(Dropdown);
		dropdown.selectByIndex(1);
		dropdown.selectByIndex(2);
		dropdown.selectByIndex(3);

	}

	// select checkbox
	public void exerciseFour(WebDriver driver) {
		// selecting the checkbox option1 and verifying it

		WebElement checkbox1 = driver.findElement(By.id("checkBoxOption1"));
		checkbox1.click();
		if (checkbox1.isSelected()) {
			System.out.println(checkbox1.isSelected());

		} else {
			System.out.println("null");
		}

		// deselect the checkbox option1 and verify it
		checkbox1.click();
		if (!checkbox1.isSelected()) {
			System.out.println(checkbox1.isSelected());
		}

		// selecting the checkbox option2 and verifying it

		WebElement checkbox2 = driver.findElement(By.id("checkBoxOption2"));
		checkbox2.click();
		if (checkbox2.isSelected()) {
			System.out.println(checkbox2.isSelected());

		} else {
			System.out.println("null");
		}

		// deselect the checkbox option2 and verify it
		checkbox2.click();
		if (!checkbox2.isSelected()) {
			System.out.println(checkbox2.isSelected());

		}
		// selecting the checkbox option3 and verifying it

		WebElement checkbox3 = driver.findElement(By.id("checkBoxOption3"));
		checkbox3.click();
		if (checkbox3.isSelected()) {
			System.out.println(checkbox3.isSelected());

		}

		// deselect the checkbox option3 and verify it
		checkbox3.click();
		if (!checkbox3.isSelected()) {
			System.out.println(checkbox3.isSelected());

		}
	}

	// select all checkbox possible options
	static void exerciseFourPointOne(WebDriver driver) {
		// initialize with webelement to access in logic
		// deselect the first option & verify
		driver.findElement(By.id("checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
		// select the second option & verify
		driver.findElement(By.id("checkBoxOption2")).click();
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption2")).isSelected());
		// select the third option & verify
		driver.findElement(By.id("checkBoxOption3")).click();
		Assert.assertTrue(driver.findElement(By.id("checkBoxOption3")).isSelected());

	}
	// deselect all possible checkboxes

	static void exerciseFourPointTwo(WebDriver driver) {
		// initialize with webelement to access in logic
		WebElement uncheckbox1 = driver.findElement(By.id("checkBoxOption1"));
		// deselect the first option & verify
		uncheckbox1.click();
		if (!uncheckbox1.isSelected()) {
			System.out.println(uncheckbox1.isSelected());
		}
		WebElement uncheckbox2 = driver.findElement(By.id("checkBoxOption2"));
		// deselect the second option & verify
		uncheckbox2.click();
		if (!uncheckbox2.isSelected()) {
			System.out.println(uncheckbox2.isSelected());
		}
		WebElement uncheckbox3 = driver.findElement(By.id("checkBoxOption3"));
		// deselect the third option & verify
		uncheckbox3.click();
		if (!uncheckbox3.isSelected()) {
			System.out.println(uncheckbox3.isSelected());

		}
	}

	public void exericseFive(WebDriver driver) {
		// click on the parent window
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[text()='Open Window']")).click();
		Set<String> windows = driver.getWindowHandles();

		Iterator<String> window = windows.iterator();
		String actualId = window.next();
		String newId = window.next();
//opens child window
		driver.switchTo().window(newId);
		// close the newly opened window & confims
		driver.close();
		Assert.assertTrue(true);

		// again switches to actual window
		driver.switchTo().window(actualId);
		Assert.assertTrue(true);

	}

	public void exerciseSix(WebDriver driver) {
		// click on the parent window
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//a[@id='opentab']")).click();
		Set<String> windows = driver.getWindowHandles();

		Iterator<String> window = windows.iterator();
		String actualId = window.next();
		String newId = window.next();

		// opens child window
		driver.switchTo().window(newId);
		// to close the child window
		driver.close();
		Assert.assertTrue(true);
		// System.out.println("child windows name"+driver.getTitle());

		// again switches to actual window
		driver.switchTo().window(actualId);
		Assert.assertTrue(true);

		// System.out.println("actual windows name"+driver.getTitle());

	}

	public void exericseSeven(WebDriver driver) {

		// enter the name in alert text box
		driver.findElement(By.id("name")).sendKeys("Jhon");
           //click the alert button
		driver.findElement(By.cssSelector("[id='alertbtn']")).click();
           //get the text content
		System.out.println(driver.switchTo().alert().getText());
		// accepts the alert message & confirms

		driver.switchTo().alert().accept();

		driver.findElement(By.id("confirmbtn")).click();

		System.out.println(driver.switchTo().alert().getText());

		driver.switchTo().alert().dismiss();
	}

	public void exerciseEight(WebDriver driver) {

		// javascript js srcoll down
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// scrolls down the wen page
		js.executeScript("window.scrollBy(0,600)");

//create an array list for rows

		List<WebElement> row = driver.findElements(By.xpath(
				"//legend[contains(text(),'Web Table Example')]/following-sibling::table[@id='product']/tbody/tr"));
//prints out the row size
		System.out.println(row.size());
		// create an array list for column
		List<WebElement> col = driver.findElements(By.xpath(
				"//legend[contains(text(),'Web Table Example')]/following-sibling::table[@id='product']/tbody/tr/th"));
		// prints out the column size
		System.out.println(col.size());

		System.out.println(driver.findElement(By.xpath(
				"//legend[contains(text(),'Web Table Example')]/following-sibling::table[@id='product']/tbody/tr[3]"))
				.getText());

	}

	public void exerciseNine(WebDriver driver) {
		// scroll down window
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		// perform action
		Actions a = new Actions(driver);
		WebElement move = driver.findElement(By.xpath("//div[@class='mouse-hover']/button[@id='mousehover']"));
		// move to the hover
		a.moveToElement(move).build().perform();
		// move to the top option & click on it
		WebElement move1 = driver.findElement(By.xpath("//div[@class='mouse-hover-content']/a[@href='#top']"));
		a.moveToElement(move1).click().build().perform();

	}

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("WebDriver.chrome.driver", "C:\\Users\\bhuvaneshwari\\Desktop.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://www.qaclickacademy.com/practice.php ");

		// calling the method of exerciseOne
		AtomationDriver a = new AtomationDriver();
		a.exerciseOne(driver);

		// call method of exerciseTwo
		a.exerciseTwo(driver);

		// calling the method of exerciseThree
		exerciseThree(driver);

		// call method of exerciseFour
		a.exerciseFour(driver);
		
		//call method Checkbox Example: Select All 
		exerciseFourPointOne(driver);
		
		//call Checkbox Example: Deselect All 
		exerciseFourPointTwo(driver);
		
		//call Switch Window Example 
		a.exericseFive(driver);
		
		//call Switch Tab Example 
		a.exerciseSix(driver);
		
		//call method alert example
		a.exericseSeven(driver);
		
		//call method Table Example 
		a.exerciseEight(driver);
		
		//call method   Mouse Hover Example 
		a.exerciseNine(driver);

	}
}
