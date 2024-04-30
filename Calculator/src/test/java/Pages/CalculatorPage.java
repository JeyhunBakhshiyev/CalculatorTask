package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utilities.Driver;

public class CalculatorPage {
	
	 WebDriver driver;
	    public CalculatorPage() {
	        driver= Driver.getInstance().getDriver();
	        PageFactory.initElements(driver, this);
	    }

	    @FindBy(id = "display")
	    public WebElement display;

	    
	    @FindBy(xpath = "//input[@value = 'C']")
	    public WebElement clearButton;  
	    
	    @FindBy(xpath = "//input[@value = '0']")
	    public WebElement zeroBtn;  
	    @FindBy(xpath = "//input[@value = '1']")
	    public WebElement oneBtn;  
	    
	    @FindBy(xpath = "//input[@value = '2']")
	    public WebElement twoBtn;  
	    
	    @FindBy(xpath = "//input[@value = '3']")
	    public WebElement threeBtn;  
	    
	    @FindBy(xpath = "//input[@value = '4']")
	    public WebElement fourBtn;  
	    
	    @FindBy(xpath = "//input[@value = '5']")
	    public WebElement fiveBtn;  
	    
	    @FindBy(xpath = "//input[@value = '6']")
	    public WebElement sixBtn;  
	    
	    @FindBy(xpath = "//input[@value = '7']")
	    public WebElement sevenBtn;  
	    
	    @FindBy(xpath = "//input[@value = '8']")
	    public WebElement eightBtn;  
	    
	    @FindBy(xpath = "//input[@value = '9']")
	    public WebElement nineBtn;  
	    
	    @FindBy(xpath = "//input[@value = '.']")
	    public WebElement dotBtn; 
	    
	    
	    @FindBy(xpath = "//input[@value = '=']")
	    public WebElement equalsBtn; 
	    
	    
	    @FindBy(id = "add")
	    public WebElement addBtn;
	    
	    @FindBy(id = "subtract")
	    public WebElement subtractBtn;

	    
	    @FindBy(id = "multiply")
	    public WebElement multiplyBtn;

	    
	    @FindBy(id = "divide")
	    public WebElement divideBtn;


	    
	    
	    public void clearDisplay() {
	    	  this.clickOn("C");
	    }
	    
	    
	    public void enterValueOnDisplay(String value) {
	    	for(char each: value.toCharArray()) {
	    		clickOn(each+"");
	    	}
	    }
	    
	    
	    
	    
	    
	    public void clickOn(String button) {
	    	   switch(button) {
		    	case "+":  
		    		this.addBtn.click();
		    		break;
		    		
		    	case "-":  
		    		this.subtractBtn.click();
		    		break;
		    	case "*":  
		    		this.multiplyBtn.click();
		    		break;
		    	case "/":  
		    		this.divideBtn.click();
		    		break;
		    	case ".":  
		    		this.dotBtn.click();
		    		break;
		    	case "0":  
		    		this.zeroBtn.click();
		    		break;
		    	case "1":  
		    		this.oneBtn.click();
		    		break;
		    	case "2":  
		    		this.twoBtn.click();
		    		break;
		    	case "3":  
		    		this.threeBtn.click();
		    		break;
		    	case "4":  
		    		this.fourBtn.click();
		    		break;
		    	case "5":  
		    		this.fiveBtn.click();
		    		break;
		    	case "6":  
		    		this.sixBtn.click();
		    		break;
		    	case "7":  
		    		this.sevenBtn.click();
		    		break;
		    	case "8":  
		    		this.eightBtn.click();
		    		break;
		    	case "9":  
		    		this.nineBtn.click();
		    		break;
		    	case "C":  
		    	case "c":	
		    		this.clearButton.click();
		    		break;
		    	case "=":  
		    		this.equalsBtn.click();
		    		break;
		    		
		    	default:
		    		throw new IllegalArgumentException("Invalid button: "+button);
		    	
		    }
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
}
