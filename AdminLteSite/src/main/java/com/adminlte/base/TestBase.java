package com.adminlte.base;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.adminlte.utility.TestUtil;

public class TestBase {

	public static WebDriver driver;
	public static Properties prop;

	public static void initialization() {

		prop = new Properties();

		FileInputStream fip;
		try {
			fip = new FileInputStream(
					"D:\\JavaProgramming\\AdminLteSite\\src\\main\\java\\com\\adminlte\\config\\properties\\config.properties");
			prop.load(fip);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		String browserName = prop.getProperty("browser");

		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\JavaProgramming\\AdminLteSite\\src\\main\\java\\com\\adminlte\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else {
			System.setProperty("webdriver.gecko.driver", "");
			driver = new FirefoxDriver();
		}

		System.out.println("Actual Window Size >> " + driver.manage().window().getSize());  //(1024,780)
		
		Dimension d = new Dimension(600, 600);
		
		driver.manage().window().setSize(d);
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.page_load_timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_wait, TimeUnit.SECONDS);

		driver.get(prop.getProperty("url"));
	}

}
