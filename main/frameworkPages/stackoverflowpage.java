package frameworkPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import stackoverflowProject.frameworkPackage.Base;

public class stackoverflowpage{

	protected static WebDriver driver;
	
	@FindBy(xpath="//button[contains(., 'Accept all cookies')]")
	WebElement accept_cookies;
	
	@FindBy(xpath="//*[contains(@class, 's-topbar--menu-btn')]")
	WebElement menu;
	
	@FindBy(xpath="//*[@id='nav-tags']")
	WebElement tags;
	
	@FindBy(xpath="//*[contains(text(), 'related tags')]")
	WebElement related_tags;
	
	@FindBy(xpath="//*[@id='tagfilter']")
	WebElement filter_search;
	
	@FindBy(xpath="//a[contains(@href,'questions/tagged/')]")
	WebElement result;
	
	@FindBy(xpath="//*[@data-nav-value='Bounties']//div")
	List<WebElement> bountied_question;
	
	public stackoverflowpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getAccept_cookies() {
		return accept_cookies;
	}

	public void setAccept_cookies(WebElement accept_cookies) {
		this.accept_cookies = accept_cookies;
	}

	public WebElement getMenu() {
		return menu;
	}

	public void setMenu(WebElement menu) {
		this.menu = menu;
	}

	public WebElement getTags() {
		return tags;
	}

	public void setTags(WebElement tags) {
		this.tags = tags;
	}

	public WebElement getFilter_search() {
		return filter_search;
	}

	public void setFilter_search(WebElement filter_search) {
		this.filter_search = filter_search;
	}

	public WebElement getResult() {
		return result;
	}

	public void setResult(WebElement result) {
		this.result = result;
	}

	public WebElement getRelated_tags() {
		return related_tags;
	}

	public void setRelated_tags(WebElement related_tags) {
		this.related_tags = related_tags;
	}

	public List<WebElement> getBountied_question() {
		return bountied_question;
	}

	public void setBountied_question(List<WebElement> bountied_question) {
		this.bountied_question = bountied_question;
	}
	
	
}
