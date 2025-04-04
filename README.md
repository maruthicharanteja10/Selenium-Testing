### **Introduction to Selenium**
Selenium is an **open-source tool** used for **automating web applications**. It allows testers and developers to control web browsers programmatically, making it an essential tool for web automation testing.
## **Selenium Suite**
Selenium consists of multiple components, each serving a different purpose:
1. **Selenium IDE (Integrated Development Environment)**  
   - A **record and playback** tool used for **quick automation**.
   - Suitable for beginners but **not for complex test automation**.
2. **Selenium RC (Remote Control) [Deprecated]**  
   - Used to write test scripts in different programming languages.  
   - **No longer supported** because **WebDriver replaced it**.
3. **Selenium WebDriver**  
   - **Most commonly used component** for automation.  
   - Interacts directly with web browsers.  
   - Supports **parallel execution** and different programming languages like **Java, Python, C#, etc.**.
4. **Selenium Grid**  
   - Helps in running tests **in parallel** on multiple machines/browsers.
   - Supports **distributed execution** of test cases.
   - Useful for **cross-browser testing**.
## **History of Selenium**
- **Founder**: **Jason Huggins** (Created Selenium in **2004-2005**).  
- **Selenium RC** was the first version released as an **open-source tool**.  
- **Paul Hammant, Simon Stewart, and Philippe Hanrigou** contributed to making Selenium **more advanced**.
- Selenium **WebDriver replaced Selenium RC** due to better performance.
## **Why is it Named Selenium?**
Selenium got its name **as a joke**!  
- Mercury (a competitor of Selenium) was another automation tool.  
- **Selenium is a chemical element used to neutralize mercury poisoning**.  
- The name **Selenium** was chosen to mock the competitors.
## **Requirements to Use Selenium**
To use Selenium effectively, you need:
### **1. Java Basics**
   - Java is **commonly used** with Selenium.
   - Need to understand **Java files, libraries, and object-oriented concepts**.
### **2. Java Eclipse Software (Recommended)**
   - Eclipse IDE is used for **writing and running Selenium scripts**.
### **3. Selenium Server (Standalone)**
   - Needed for running **Selenium Grid**.
### **4. Adding Dependencies**
   - If using a **normal Java project**, you need to **import Selenium JAR files** manually.
   - If using **Maven**, you can add the **Selenium dependency** in `pom.xml`.
## **Selenium WebDriver Usage**
- Can **launch web browsers** like **Chrome, Firefox, Edge, etc.**.
- Uses browser-specific **drivers** (e.g., ChromeDriver for Chrome).
- Automates web applications by performing actions like:
  - Clicking buttons
  - Filling forms
  - Scrolling pages
  - Extracting data
## **Note**
- Selenium is a **powerful tool for web automation**.
- It is **widely used** for **functional testing, regression testing, and cross-browser testing**.
- Supports **multiple languages** (Java, Python, C#, etc.).
- Used by companies to **automate testing and save manual effort**.
### **Launching Chrome and Firefox Browsers Using Selenium WebDriver**

Selenium WebDriver allows us to automate web browsers like **Chrome and Firefox**. The key steps involved in setting up and running Selenium WebDriver are as follows:
## **1. Setting Up WebDriver for Chrome**
To launch a Chrome browser using Selenium WebDriver, use the following Java code:
```java
WebDriver driver = new ChromeDriver();
driver.get("http://www.google.com");
```
### **Steps to Set Up ChromeDriver**
1. **Download ChromeDriver**  
   - You can download the required WebDriver from **[chromedriver.chromium.org](https://chromedriver.chromium.org/)**.
   - This is necessary for normal Java projects.
2. **Dependency Handling**
   - If using **Selenium 4.6+**, there is **no need** to set the property for ChromeDriver manually.
   - WebDriver **Manager** will automatically handle the driver setup.

## **2. Finding Web Elements in a Web Page**
To interact with a web page, Selenium WebDriver needs to **find elements** (buttons, text fields, links, etc.).
### **Different Locators in Selenium WebDriver**
There are **8 locators** that help identify elements:
1. **ID** – Finds elements using their unique `id` attribute.  
2. **Name** – Finds elements using their `name` attribute.  
3. **className** – Finds elements using their CSS class name.  
4. **LinkText** – Finds links using the complete visible text of the link.  
5. **Partial LinkText** – Finds links using a part of the visible text.  
6. **TagName** – Finds elements based on their HTML tag (e.g., `input`, `button`).  
7. **XPath** – Finds elements using XML path expressions.  
8. **CSS Selector** – Finds elements using CSS rules.
### **Example Usage in Java**
Using **`findElement(By...)`**, we can locate elements as follows:
```java
WebElement searchBox = driver.findElement(By.name("q"));
WebElement loginButton = driver.findElement(By.id("login"));
WebElement signupLink = driver.findElement(By.linkText("Sign Up"));
WebElement menu = driver.findElement(By.className("menu"));
WebElement submitButton = driver.findElement(By.cssSelector(".btn-primary"));
```
## **Note**
- Selenium WebDriver is used to **automate Chrome and Firefox browsers**.
- We can **download ChromeDriver** and set up WebDriver for browser automation.
- Web elements can be found using different **locators** like ID, Name, XPath, and CSS Selectors.
- **Selenium 4.6+ has automatic WebDriver setup**, reducing manual effort.
## Explanation of  WebElementsFinding stratagies code
#### **1. Setting Up Selenium WebDriver**
- We use **WebDriverManager** to automatically handle ChromeDriver setup.
- `WebDriver driver = new ChromeDriver();` launches the Chrome browser.
#### **2. Navigating to a Web Page**
- `driver.get("https://www.google.com/");` opens Google.
- `driver.get("https://github.com/login");` navigates to GitHub’s login page.
#### **3. Locating Web Elements Using Different Locators**
- **By ID** → `By.id("login_field")`
- **By Name** → `By.name("password")`
- **By Class Name** → `By.className("header-logo")`
- **By Link Text** → `By.linkText("Forgot password?")`
- **By Partial Link Text** → `By.partialLinkText("Create an")`
- **By Tag Name** → `By.tagName("h1")`
- **By XPath** → `By.xpath("//label[contains(text(),'Username or email address')]")`
- **By CSS Selector** → `By.cssSelector("input[name='commit']")`
#### **4. Highlighting Elements**
- The `highlight()` method uses **JavaScript Executor** to apply a **red border and yellow background** to web elements.
#### **5. Closing the Browser**
- `driver.quit();` closes the browser session.
This program demonstrates **finding elements using different strategies and highlighting them dynamically.** 🚀
