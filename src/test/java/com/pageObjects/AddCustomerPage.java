package com.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class AddCustomerPage {
	
	WebDriver driver;

	public AddCustomerPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement linkAddNewCustomer;
	
	@FindBy(how = How.NAME, using = "name")
	@CacheLookup
	WebElement textCustomerName;
	
	@FindBy(how = How.NAME, using = "rad1")
	@CacheLookup
	WebElement rdGender;
	
	@FindBy(how = How.ID_OR_NAME, using = "dob")
	@CacheLookup
	WebElement textdob;
	
	@FindBy(how = How.NAME, using = "addr")
	@CacheLookup
	WebElement textAddress;
	
	@FindBy(how = How.NAME, using = "city")
	@CacheLookup
	WebElement textCity;
	
	@FindBy(how = How.NAME, using = "state")
	@CacheLookup
	WebElement textState;
	
	@FindBy(how = How.NAME, using = "pinno")
	@CacheLookup
	WebElement textPinno;
	
	@FindBy(how = How.NAME, using = "telephoneno")
	@CacheLookup
	WebElement textTelephoneno;
	
	@FindBy(how = How.NAME, using = "emailid")
	@CacheLookup
	WebElement textEmailid;
	
	@FindBy(how = How.NAME, using = "password")
	@CacheLookup
	WebElement textPassword;
	
	@FindBy(how = How.NAME, using = "sub")
	@CacheLookup
	WebElement btnSubmit;
	
	public void clickAddNewCustomer() {
		linkAddNewCustomer.click();
	}
	
	public void clickSubmit() {
		btnSubmit.click();
	}
	
	public void custName(String cname) {
		textCustomerName.sendKeys(cname);
	}
	
	public void custGender(String cgender) {
		rdGender.sendKeys(cgender);
	}
	
	public void custDob(String mm, String dd, String yy) {
		textdob.sendKeys(mm);
		textdob.sendKeys(dd);
		textdob.sendKeys(yy);
	}
	
	public void custAddress(String caddress) {
		textAddress.sendKeys(caddress);
	}
	
	public void custCity(String ccity) {
		textCity.sendKeys(ccity);
	}
	public void custState(String cstate) {
		textState.sendKeys(cstate);
	}
	public void custPinno(String cpinno) {
		textPinno.sendKeys(String.valueOf(cpinno));
	}
	public void custTelephone(String ctelephone) {
		textTelephoneno.sendKeys(ctelephone);
	}
	public void custEmailid(String cemailid) {
		textEmailid.sendKeys(cemailid);
	}
	public void custPassword(String cpassword) {
		textPassword.sendKeys(cpassword);
	}
	
	public void custSubmit() {
		btnSubmit.click();
	}

}
