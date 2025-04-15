# **Introduction to Selenium**
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
#### **Note**
- Selenium is a **powerful tool for web automation**.
- It is **widely used** for **functional testing, regression testing, and cross-browser testing**.
- Supports **multiple languages** (Java, Python, C#, etc.).
- Used by companies to **automate testing and save manual effort**.
  
## **Launching Chrome and Firefox Browsers Using Selenium WebDriver**
Selenium WebDriver allows us to automate web browsers like **Chrome and Firefox**. The key steps involved in setting up and running Selenium WebDriver are as follows:
### 1. Setting Up WebDriver for Chrome
To launch a Chrome browser using Selenium WebDriver, use the following Java code:
```java
WebDriver driver = new ChromeDriver();
driver.get("http://www.google.com");
```
#### **Steps to Set Up ChromeDriver**
1. **Download ChromeDriver**  
   - You can download the required WebDriver from **[chromedriver.chromium.org](https://chromedriver.chromium.org/)**.
   - This is necessary for normal Java projects.
2. **Dependency Handling**
   - If using **Selenium 4.6+**, there is **no need** to set the property for ChromeDriver manually.
   - WebDriver **Manager** will automatically handle the driver setup.
### **2. Finding Web Elements in a Web Page**
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

**Note**
- Selenium WebDriver is used to **automate Chrome and Firefox browsers**.
- We can **download ChromeDriver** and set up WebDriver for browser automation.
- Web elements can be found using different **locators** like ID, Name, XPath, and CSS Selectors.
- **Selenium 4.6+ has automatic WebDriver setup**, reducing manual effort.
### **Explanation of  WebElementsFinding stratagies code**
#### 1. Setting Up Selenium WebDriver
- We use **WebDriverManager** to automatically handle ChromeDriver setup.
- `WebDriver driver = new ChromeDriver();` launches the Chrome browser.
#### 2. Navigating to a Web Page
- `driver.get("https://www.google.com/");` opens Google.
- `driver.get("https://github.com/login");` navigates to GitHub’s login page.
#### 3. Locating Web Elements Using Different Locators
- **By ID** → `By.id("login_field")`
- **By Name** → `By.name("password")`
- **By Class Name** → `By.className("header-logo")`
- **By Link Text** → `By.linkText("Forgot password?")`
- **By Partial Link Text** → `By.partialLinkText("Create an")`
- **By Tag Name** → `By.tagName("h1")`
- **By XPath** → `By.xpath("//label[contains(text(),'Username or email address')]")`
- **By CSS Selector** → `By.cssSelector("input[name='commit']")`
#### 4. Highlighting Elements
- The `highlight()` method uses **JavaScript Executor** to apply a **red border and yellow background** to web elements.
#### 5. Closing the Browser
- `driver.quit();` closes the browser session.
This program demonstrates **finding elements using different strategies and highlighting them dynamically.** 🚀

## **Handling Textboxes in Selenium WebDriver**
Handling textboxes in Selenium WebDriver involves various operations such as locating, entering text, retrieving text, clearing text, and verifying properties. Below are the key concepts:

 **1. Locating a Textbox Element**
-- Before interacting with a textbox, it must be located on the webpage using **locators** like `id`, `name`, `className`, `XPath`, or `CSS Selector`.

 **Example: Locating Using Different Locators**
```java
WebElement textboxById = driver.findElement(By.id("username")); // Using id
WebElement textboxByName = driver.findElement(By.name("username")); // Using name
WebElement textboxByXPath = driver.findElement(By.xpath("//input[@id='username']")); // Using XPath
WebElement textboxByCss = driver.findElement(By.cssSelector("input#username")); // Using CSS Selector
```
 **2. Entering Text in a Textbox**
-- To enter text into a textbox, use the **`sendKeys()`** method.
```java
textboxById.sendKeys("CharanTeja");
```
This simulates typing the text into the input field.

 **3. Retrieving Text from a Textbox**
-- To get the entered text, use **`getAttribute("value")`**.
```java
String enteredText = textboxById.getAttribute("value");
System.out.println("Entered Text: " + enteredText);
```
**4. Clearing Text from a Textbox**
-- To remove any existing text, use the **`clear()`** method.
```java
textboxById.clear();
```

 **5. Checking If a Textbox is Displayed and Enabled**
Before interacting with a textbox, verify if it is visible and enabled.
```java
if (textboxById.isDisplayed() && textboxById.isEnabled()) {
    textboxById.sendKeys("CharanTeja");
} else {
    System.out.println("Textbox is either not visible or disabled");
}
```
- **`isDisplayed()`** → Checks if the textbox is visible on the UI.
- **`isEnabled()`** → Checks if the textbox is interactive (not disabled).
  
 **6. Handling Textbox Using Explicit Wait**
-- Instead of using `Thread.sleep()`, Selenium provides **Explicit Waits** to wait until a textbox is available.
```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement textbox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
textbox.sendKeys("CharanTeja");
```
This ensures the textbox is **visible** before sending input.

**7. Verifying Placeholder Text**
Some textboxes have placeholder text (default text). You can retrieve it using `getAttribute("placeholder")`.
```java
String placeholderText = textboxById.getAttribute("placeholder");
System.out.println("Placeholder: " + placeholderText);
```
**8. Handling Read-Only or Disabled Textboxes**
-- Some textboxes may be **read-only** or **disabled**, preventing input.
```java
if (!textboxById.isEnabled()) {
    System.out.println("Textbox is disabled");
}
if (textboxById.getAttribute("readonly") != null) {
    System.out.println("Textbox is read-only");
}
```
**9. Handling Hidden Textboxes**
-- Some textboxes might be hidden using CSS (`display: none;` or `visibility: hidden;`). Use JavaScript to interact with them.
```java
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].value='CharanTeja';", textboxById);
```
 10. Simulating Keyboard Actions in a Textbox
Use the **Actions class** to simulate keyboard events (e.g., pressing Enter or Backspace).
```java
Actions actions = new Actions(driver);
actions.sendKeys(textboxById, Keys.ENTER).perform();
```
### **Conclusion**
Handling textboxes in Selenium involves:
✔️ Locating elements using different locators  
✔️ Entering, retrieving, and clearing text  
✔️ Checking visibility, enablement, and read-only state  
✔️ Using Explicit Waits for synchronization  
✔️ Interacting with hidden or disabled textboxes using JavaScript  
## Handling Basic HTML Controls in Selenium Webdriver
Handling basic HTML controls in **Selenium WebDriver** involves interacting with elements such as text boxes, buttons, checkboxes, radio buttons, dropdowns, links, and alerts. Below are the key concepts and code snippets to handle these elements using **Java**:

### **1. Handling Text Boxes (Input Fields)**
Use the `sendKeys()` method to enter text into a text box.

```java
WebDriver driver = new ChromeDriver();
driver.get("https://example.com");

WebElement username = driver.findElement(By.id("username"));
username.sendKeys("testuser");
```

**Common methods:**
- `clear()` – Clears the text box.
- `sendKeys("text")` – Enters text into the text box.
- `getAttribute("value")` – Retrieves the text.

### **2. Handling Buttons**
Use `click()` to simulate a button click.

```java
WebElement loginButton = driver.findElement(By.id("login"));
loginButton.click();
```

**Common methods:**
- `click()` – Clicks the button.
- `isEnabled()` – Checks if the button is enabled.

### **3. Handling Checkboxes**
Use `click()` to check/uncheck a checkbox.

```java
WebElement checkbox = driver.findElement(By.id("acceptTerms"));
checkbox.click();
```

**Check if a checkbox is selected:**
```java
boolean isChecked = checkbox.isSelected();
```

### **4. Handling Radio Buttons**
Use `click()` to select a radio button.
```java
WebElement maleRadio = driver.findElement(By.id("male"));
maleRadio.click();
```

**Check if a radio button is selected:**
```java
boolean isSelected = maleRadio.isSelected();
```

### **5. Handling Dropdowns**
Use the `Select` class to work with dropdowns.
```java
import org.openqa.selenium.support.ui.Select;

WebElement dropdown = driver.findElement(By.id("country"));
Select select = new Select(dropdown);
select.selectByVisibleText("India");  // Select by text
select.selectByIndex(2);  // Select by index
select.selectByValue("IN");  // Select by value
```

### **6. Handling Links**
Use `click()` to interact with a link.

```java
WebElement link = driver.findElement(By.linkText("Sign Up"));
link.click();
```

**Alternative:**
```java
driver.findElement(By.partialLinkText("Sign")).click();
```

### **7. Handling Alerts & Pop-ups**
Use `Alert` class for JavaScript alerts.

```java
import org.openqa.selenium.Alert;

Alert alert = driver.switchTo().alert();
alert.accept();  // Click OK
alert.dismiss();  // Click Cancel
alert.sendKeys("Input text");  // Enter text in prompt
```

### **8. Handling Frames**
Switch to a frame using `switchTo()`.
```java
driver.switchTo().frame("frameName");  // By name
driver.switchTo().frame(0);  // By index
driver.switchTo().frame(driver.findElement(By.xpath("//iframe")));  // By WebElement
```

**Switch back to the default page:**
```java
driver.switchTo().defaultContent();
```

### **9. Handling Windows & Tabs**
Switch to a new window/tab using `getWindowHandles()`.
```java
String parentWindow = driver.getWindowHandle();
Set<String> windows = driver.getWindowHandles();

for (String window : windows) {
    if (!window.equals(parentWindow)) {
        driver.switchTo().window(window);
    }
}
```

### **10. Handling Mouse Hover (Actions Class)**
Use `Actions` class for mouse interactions.

```java
import org.openqa.selenium.interactions.Actions;

Actions actions = new Actions(driver);
WebElement element = driver.findElement(By.id("menu"));
actions.moveToElement(element).perform();  // Hover over the element
```
Here’s a concise **content guide** on **handling dropdowns in Selenium**, suitable for study notes, documentation, or interview prep:



## 🔽 Handling Dropdowns in Selenium

Dropdowns are commonly used in web applications for selecting an item from a list. Selenium provides multiple ways to handle them depending on how the dropdown is implemented in HTML.

### ✅ 1. Handling Standard HTML Dropdowns (`<select>` tag)
- Selenium supports `<select>` elements directly using the **`Select` class**.

### Features of `Select` class:
- **Select by Visible Text:** Choose the option displayed to the user.
- **Select by Value:** Choose using the `value` attribute of the option.
- **Select by Index:** Choose based on the order of the option (starting from 0).
- **Get All Options:** Retrieve and loop through all dropdown options.
- **Get Selected Option:** Check which option is currently selected.

### When to use:
- When the dropdown is created using a `<select>` HTML tag.
- When options are defined using `<option>` tags.


### ❗ 2. Handling Custom Dropdowns (Non-`<select>` elements)
- Some modern web apps use stylized or JavaScript-driven dropdowns using `<div>`, `<ul>`, `<li>`, or `<span>` elements.

#### How to handle:
- **Click to open** the dropdown.
- **Wait for the options** to appear if loaded dynamically.
- **Click the desired option** using XPath, CSS selector, or text.
- Use **`WebDriverWait`** if the options take time to load.

#### When to use:
- When the dropdown is not a traditional `<select>` element.
- In frameworks like React, Angular, or Vue, where custom dropdown components are used.

#### 🔁 Additional Tips

- Always **wait** for the dropdown and options to be visible and clickable.
- Use **XPath or CSS selectors** smartly to locate options.
- Use **loops** to validate or interact with multiple dropdown values.
- Use **scrolling actions** if options are not initially visible on the screen.
- Handle **multi-select dropdowns** by checking if multiple selections are allowed using `isMultiple()` method (for standard dropdowns).



## **Navigations Handle in Selenium using Webbdriver**
Navigation in Selenium refers to controlling the browser's history stack and current page — including moving to a different URL, going back, forward, or refreshing the page.
- get() opens the initial page.
- navigate().to() loads a new URL (similar to get() but more flexible).
- navigate().back() goes to the previous page.
- navigate().forward() goes to the next page (if back() was used).
- navigate().refresh() reloads the current page.
- quit() closes the browser session.
### 🧭 **Navigation vs Page Load**
- **`navigate().to()`** and **`get()`** both open a new page.
- The difference: `get()` waits for the full page to load, while `navigate().to()` is generally faster and used when moving between internal URLs or during redirection handling.
### 🌐 **Opening a URL**
- Used to load a new webpage.
- Essential when starting a test or switching to a different page in your application.
### 🔙 **Navigating Back**
- Simulates clicking the browser’s “Back” button.
- Useful after clicking a link that leads to another page, and you want to return to the original page.
### 🔜 **Navigating Forward**
- Simulates the browser’s “Forward” button.
- Only works if you previously navigated back.
### 🔁 **Refreshing the Page**
- Reloads the current webpage.
- Useful for testing how your app behaves when a user refreshes (e.g., checking for session persistence or reload bugs).
### ⏱️ **Waits and Timing**
- After navigation, elements may not be immediately available.
- Use **explicit waits** (like WebDriverWait) to wait until a page or element is fully loaded before interacting with it.
### 🔧 **Best Practices**
- Prefer `navigate().to()` when switching URLs during an active session.
- Combine navigation with waits to ensure reliable test execution.
- Use back/forward actions only when you have a clear navigation flow.

##  Handling Alerts in Selenium WebDriver
Web-based applications sometimes use JavaScript alerts to interact with users. Selenium can handle these alerts using the **`Alert` interface**.
### 📋 **Types of Alerts**
1. **Simple Alert**  
   - Contains only an OK button.  
   - Used for displaying information.
2. **Confirmation Alert**  
   - Contains OK and Cancel buttons.  
   - Used to confirm user decisions.
3. **Prompt Alert**  
   - Contains a text box with OK and Cancel buttons.  
   - Used to get user input.
### 📌 **Alert Handling Methods**
- `driver.switchTo().alert()` → Switches to the alert.
- `alert.accept()` → Clicks OK.
- `alert.dismiss()` → Clicks Cancel.
- `alert.getText()` → Gets the alert message.
- `alert.sendKeys("text")` → Enters text into a prompt.
### 💡 **Notes**
- Always **switch to the alert** before interacting with it.
- If an alert is not present, calling `driver.switchTo().alert()` will throw a `NoAlertPresentException`.
- Use **explicit waits** (like `WebDriverWait`) when alert appearance is delayed.
- For prompt alerts, use `sendKeys()` before `accept()` to enter text.


##  Handling Single, Multiple Tabs & Windows in Selenium
### 🔹 **1. What Are Windows and Tabs in Selenium?**

- **Window/Tab**: A browser instance (could be a new tab or a popup window).
- Every window or tab has a **unique handle (ID)**.

> You can switch between tabs/windows using their **window handle**.

### 🔹 **2. Key Methods**

| Method                            | Description                                       |
|----------------------------------|---------------------------------------------------|
| `getWindowHandle()`              | Gets the current (parent) window handle           |
| `getWindowHandles()`             | Returns a set of all open window handles          |
| `switchTo().window(handle)`      | Switches control to a specific window or tab      |
| `close()`                        | Closes the current tab/window                     |
| `quit()`                         | Closes all browser windows and ends the session   |

### 🔹 **3. Handling a Single Window/Tab**
- Selenium automatically starts in one tab.
- You interact with it normally using standard WebDriver commands.

### 🔹 **4. Handling Multiple Tabs/Windows**
#### ✅ Steps:
1. **Trigger the new tab/window** (click a link or button).
2. **Get all window handles** using `getWindowHandles()`.
3. **Switch to the new handle** using `switchTo().window(handle)`.
4. Perform actions in the new tab/window.
5. Optionally **switch back** to the parent window.

### 🧠 **Important Notes**
- **Window handles are unordered**, so use a loop or list to access them predictably.
- Always **store the parent window handle** before opening a new tab/window.
- You must **switch to a new tab** before performing actions in it.

### 🧪 Example Use Cases
- Switching to a payment popup window.
- Handling terms and conditions or help links that open in a new tab.
- Managing login windows that appear separately.


## 🖼️ Handling Frames in Selenium WebDriver 
### 🔹 **What is a Frame?**
- A **frame (or iframe)** is an HTML document embedded inside another HTML document.
- Web pages use frames to embed content like ads, forms, videos, or widgets.
- Selenium cannot access elements inside a frame directly—you must **switch into the frame first**.
### 🔑 **Why Handle Frames?**
- To interact with elements **inside** the frame (click, send keys, read text, etc.).
- Failing to switch into a frame before interacting causes **`NoSuchElementException`**.
### 🔧 **Switching into a Frame**
You can switch to a frame using:
1. **By Index** – Based on frame order in the page.
2. **By Name or ID** – If the frame has a `name` or `id` attribute.
3. **By WebElement** – Locate the frame as a web element, then switch.

```java
driver.switchTo().frame(0); // By index
driver.switchTo().frame("frameName"); // By name or ID
driver.switchTo().frame(driver.findElement(By.tagName("iframe"))); // By WebElement
```
### 🔁 **Switching Back to Main Page**
- To go back to the main (default) content after working inside a frame:
```java
driver.switchTo().defaultContent(); // Goes to main document
```

- To go **one level up**, use:
```java
driver.switchTo().parentFrame(); // Goes to parent frame
```
### ✅ **Best Practices**
- Always check if the page uses frames (`iframe` tags).
- Use explicit waits if the frame or its contents load dynamically.
- Prefer using frame **WebElement** if frames don't have clear names or IDs.
### 🧪 **Common Use Cases**
- Working with embedded forms (like Google Forms).
- Automating video players (YouTube iframes).
- Interacting with ad frames or payment gateways.


## 📸 Capturing Screenshots in Selenium WebDriver
### 🔹 **Why Take Screenshots?**
- To record **test results**, especially failures.
- For **debugging** UI issues.
- For maintaining **test evidence** in reports.
### 🔧 **How Screenshots Work in Selenium**
- Selenium provides a built-in interface called **`TakesScreenshot`**.
- It captures the **visible part of the web page**.
### 🧰 **Steps to Capture a Screenshot**
1. **Cast WebDriver to TakesScreenshot**
2. **Call `getScreenshotAs()` method**
3. **Save the image file to a location**
### 📂 **File Format**
- The screenshot is typically saved in **`.png`** format.
### 📝 **Key Method**
```java
File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
```
### ✅ **Best Practices**
- Store screenshots in a dedicated `screenshots/` folder.
- Use **timestamped filenames** to avoid overwriting.
- Integrate with **test frameworks** (JUnit/TestNG) for automatic capture on failure.
- Consider **full-page screenshot tools** for capturing the entire page (e.g., AShot).
### 🧪 **Use Cases**
- Capturing a screenshot on test failure.
- Taking snapshots of each step in a test.
- Comparing UI changes visually over time.


