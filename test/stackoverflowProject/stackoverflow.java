package stackoverflowProject;

import java.awt.Robot;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkPages.stackoverflowpage;
import stackoverflowProject.frameworkPackage.Base;

public class stackoverflow extends Base{
	//Base b = new Base();

	public static void main(String[] args) throws InterruptedException {  
		//public static void setup() throws InterruptedException {
		String keyword;
		getDriver();
		stackoverflowpage sp = new stackoverflowpage(driver);
		driver.manage().window().maximize();
		driver.get("https://stackoverflow.com/");
		keyword = "javas";
		//getDriver().manage().window().maximize();
		//getDriver().get("https://stackoverflow.com/");
		Thread.sleep(8000);
		sp.getAccept_cookies().click();
		sp.getMenu().click();
		sp.getTags().click();
		if (sp.getAccept_cookies().isDisplayed()) {
			sp.getAccept_cookies().click();
		}
		Thread.sleep(2000);
		sp.getFilter_search().sendKeys(keyword);
		Thread.sleep(5000);
		if(sp.getResult().isDisplayed())
		{
			String resulttag = sp.getResult().getText();
			Thread.sleep(2000);
			if(resulttag.equals(keyword))
			{
				sp.getResult().click();
				Thread.sleep(2000);
				for(int i=0; i<sp.getBountied_question().size(); i++)
				{
					System.out.println("bountied question:"+sp.getBountied_question().get(i).getText());
				}

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,800)", "");
				Thread.sleep(2000);
				if (sp.getRelated_tags().isDisplayed()) 
				{
					sp.getRelated_tags().click();
				}

				Thread.sleep(2000);
				List<WebElement> myList=driver.findElements(By.xpath("//a[contains(@href,'/questions/tagged/"+keyword+""+'+'+"')]"));
				List<String> all_elements_text=new ArrayList<>();
				List<WebElement> myListCount=driver.findElements(By.xpath("//*[@class='module js-gps-related-tags']//div//span[@class='item-multiplier-count']"));
				for(int i=0; i<myList.size(); i++){
					//loading text of each element in to array all_elements_text
					all_elements_text.add(myList.get(i).getText());
					//to print directly
					System.out.println("elem:"+myList.get(i).getText() +":"+myListCount.get(i).getText());

				}

			}
			else if(resulttag.contains(keyword))
			{
				keyword = sp.getResult().getText();
				sp.getResult().click();
				Thread.sleep(2000);
				for(int i=0; i<sp.getBountied_question().size(); i++)
				{
					System.out.println("bountied question count:"+sp.getBountied_question().get(i).getText());
				}

				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,800)", "");
				Thread.sleep(2000);
				if (sp.getRelated_tags().isDisplayed()) 
				{
					sp.getRelated_tags().click();
				}

				Thread.sleep(2000);
				List<WebElement> myList=driver.findElements(By.xpath("//a[contains(@href,'/questions/tagged/"+keyword+""+'+'+"')]"));
				List<String> all_elements_text=new ArrayList<>();
				List<WebElement> myListCount=driver.findElements(By.xpath("//*[@class='module js-gps-related-tags']//div//span[@class='item-multiplier-count']"));
				for(int i=0; i<myList.size(); i++){
					//loading text of each element in to array all_elements_text
					all_elements_text.add(myList.get(i).getText());
					//to print directly
					System.out.println("related tag:"+myList.get(i).getText() +"and its count:"+myListCount.get(i).getText());

				}
			}
		}

	}
}
