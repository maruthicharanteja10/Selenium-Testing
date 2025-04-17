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


## 🕒 `pageLoadTimeout` in Selenium WebDriver
### 🔹 **What is `pageLoadTimeout`?**
- It sets the **maximum time Selenium will wait** for a **web page to load**.
- If the page **doesn’t load within the specified time**, a **`TimeoutException`** is thrown.
### 📌 **Syntax**
```java
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
```
> 💡 `Duration` is used from Java 8+ (`java.time.Duration`)
### 🧠 **Why Use It?**
- Prevents your tests from **hanging forever** if a page fails to load.
- Helps catch slow or broken pages early in automation runs.
### ✅ **Key Points**
- It only applies to **full page loads**, like `driver.get(url)` or `navigate().to(url)`.
- If the page loads **after** the timeout, Selenium throws `TimeoutException`.
- Works in combination with **implicit/explicit waits** but controls the page loading behavior.
### 📌 **Example Usage**
```java
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
driver.get("https://example.com");
```
### ⚠️ **Exception Handling**
```java
try {
    driver.get("https://example.com");
} catch (TimeoutException e) {
    System.out.println("Page load timed out!");
}
```
### 🧪 **Common Use Cases**
- Testing websites with **slow network conditions**.
- Validating **error handling** for pages that fail to load.
- Ensuring **test stability** in CI/CD environments.

## **Implicit Wait Time in Selenium WebDriver**:

### 🔹 What is Implicit Wait?
- Implicit Wait is used to tell the WebDriver to wait for a certain amount of time **while trying to find an element** if it is not immediately available.

### 🔹 Syntax (Java):
```java
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
```

> In older versions:
```java
driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
```
### 🔹 Key Points:
- It is applied **globally**: once set, it is applicable for the **entire WebDriver session**.
- It waits for the **specified time** before throwing a `NoSuchElementException`.
- It **does not wait** for conditions like element to be clickable or visible — for those, use **Explicit Wait**.
### 🔹 When to Use:
- When you're unsure about the exact load time of elements.
- For pages where elements take some time to appear.
### 🔹 Default Value:
- The default implicit wait time is **0 seconds**.
### 🔹 Example:
```java
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
driver.get("https://example.com");
WebElement element = driver.findElement(By.id("username"));
```
### 🔹 Pros:
- Simple to use.
- Automatically applied to all elements.
### 🔹 Cons:
- Can **slow down test execution** if overused.
- May cause **unexpected wait times**.
- Not suitable for complex conditions.

## 🔶 **Explicit Wait in Selenium WebDriver**
### ✅ **What is Explicit Wait?**
Explicit Wait is used to **wait for a specific condition to occur** before proceeding with the next step in the code.

Unlike **Implicit Wait** (which waits for the presence of elements), **Explicit Wait** lets you wait for:
- An element to be clickable
- Visibility of an element
- Presence of an element in the DOM
- Invisibility of an element
- And other expected conditions

### ✅ **Why Use Explicit Wait?**
Web applications often load elements dynamically via JavaScript or AJAX. Some elements may not be immediately available. Using **Explicit Wait** makes your script **more stable and reliable** by waiting until conditions are met.

### ✅ **Syntax (Java Example using WebDriverWait and ExpectedConditions):**
```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
element.sendKeys("JohnDoe");
```
### ✅ **Common ExpectedConditions:**

| Method | Description |
|--------|-------------|
| `visibilityOfElementLocated(By locator)` | Waits until element is visible on the page |
| `elementToBeClickable(By locator)` | Waits until element is clickable |
| `presenceOfElementLocated(By locator)` | Waits until element is present in DOM |
| `titleContains(String title)` | Waits until page title contains given text |
| `urlContains(String fraction)` | Waits until URL contains a specific string |
| `invisibilityOfElementLocated(By locator)` | Waits until element disappears from the page |


### ✅ **Real-Time Example: Login Button after AJAX Loading**
Imagine you have a login form, and the **login button is enabled only after an AJAX call** finishes checking username availability.
```java
WebDriver driver = new ChromeDriver();
driver.get("https://example.com/login");

// Enter username
driver.findElement(By.id("username")).sendKeys("testuser");

// Explicit Wait for the login button to be clickable
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginButton")));

// Now click it
loginBtn.click();
```
### ✅ **When to Use Explicit Wait:**
- AJAX-heavy applications
- Elements loaded after a specific event (like button enabling after filling a field)
- To avoid **StaleElementReferenceException**
### ✅ **Difference Between Implicit and Explicit Wait:**

| Feature | Implicit Wait | Explicit Wait |
|--------|----------------|----------------|
| Scope | Global (applies to all elements) | Specific (applies to particular condition) |
| Flexibility | Less flexible | Very flexible |
| Condition-based | No | Yes |
| Reusability | Not reusable | Can be reused with helper methods |


### ✅ **Helper Method Example (Reusable):**

```java
public WebElement waitForVisibility(By locator, int timeoutInSeconds) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
}
```


## 🔁 **Difference Between Implicit and Explicit Wait in Selenium (with Real-Time Example)**

### 🧪 **Scenario: Testing a Login Page with Dynamic Content**
You're testing a login page:
- Username field: appears instantly.
- Login button: gets **enabled only after** entering username & password (AJAX validation).
### ✅ 1. **Implicit Wait Example (Global wait)**
```java
// 1. Set up WebDriver and Implicit Wait
WebDriver driver = new ChromeDriver();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // global wait
driver.get("https://example.com/login");

// 2. These elements must appear within 10 seconds
driver.findElement(By.id("username")).sendKeys("john123");
driver.findElement(By.id("password")).sendKeys("password123");

// 3. Click login (Implicit wait won't wait for 'clickable', only presence)
driver.findElement(By.id("loginBtn")).click();
```
🔸 **Problem:** If the `loginBtn` is not yet **clickable** (only present but disabled), this will fail or throw an exception.
### ✅ 2. **Explicit Wait Example (Condition-based wait)**
```java
// 1. Set up WebDriver
WebDriver driver = new ChromeDriver();
driver.get("https://example.com/login");

// 2. Fill in fields (no wait needed)
driver.findElement(By.id("username")).sendKeys("john123");
driver.findElement(By.id("password")).sendKeys("password123");

// 3. Explicit Wait until login button is clickable
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("loginBtn")));

// 4. Now safely click
loginBtn.click();
```
🔸 **Advantage:** Waits **only for login button** to become clickable. This is ideal for dynamic UI behavior.
### 🔍 **Comparison Table:**
| Feature | Implicit Wait | Explicit Wait |
|--------|----------------|----------------|
| Wait Type | Global | Conditional |
| Applied On | All elements | Specific element |
| Usage | Set once | Set where needed |
| Condition Support | ❌ No | ✅ Yes (clickable, visible, etc.) |
| Best For | Static content | Dynamic / AJAX content |
| Performance | May slow down | Optimized for targeted waits |

### 🎯 **Real-World Tip:**
Use **implicit wait** for general stability, and use **explicit wait** when dealing with:
- AJAX popups
- Loading spinners
- Delayed buttons
- Visibility issues


## Application properties
### ✅ 1. `getTitle()`

### 🔹 Description:
- Retrieves the **title of the current web page**.
- The title is the text shown in the browser tab and is defined in the `<title>` tag of the HTML.

### 🔹 Syntax:
```java
String title = driver.getTitle();
```

### 🔹 Use Case:
Useful for verifying the correct page is loaded — often used in assertions during testing.

### 🔹 Example:
```java
System.out.println("Page Title: " + driver.getTitle());
```

### ✅ 2. `getCurrentUrl()`
### 🔹 Description:
- Returns the **current URL** loaded in the browser.

### 🔹 Syntax:
```java
String currentUrl = driver.getCurrentUrl();
```

### 🔹 Use Case:
Used to validate redirection, navigation, or that the expected URL is opened after clicking a link or submitting a form.

### 🔹 Example:
```java
System.out.println("Current URL: " + driver.getCurrentUrl());
```
### ✅ 3. `getPageSource()`
### 🔹 Description:
- Retrieves the **entire HTML source code** of the current page as a string.
### 🔹 Syntax:
```java
String pageSource = driver.getPageSource();
```
### 🔹 Use Case:
Can be used to:
- Debug content rendering issues.
- Check presence of specific content/tags.
- Perform source-level validations.
### 🔹 Example:
```java
System.out.println("Page Source Length: " + driver.getPageSource().length());
```
### ✅ Summary Table

| Method           | Returns                      | Use Case                               |
|------------------|-------------------------------|----------------------------------------|
| `getTitle()`     | Page title (String)           | Page validation                        |
| `getCurrentUrl()`| Current URL (String)          | URL navigation checks                  |
| `getPageSource()`| HTML source (String)          | Content validation/debugging           |



## 🧾  Get WebElement Properties using Selenium WebDriver 

### 📌 1. **Getting Started**
```java
WebDriver driver = new ChromeDriver();
driver.get("https://example.com");
WebElement element = driver.findElement(By.id("exampleId"));
```
### 📋 2. **WebElement Property Methods**

| **Property**           | **Method**                                | **Description**                                |
|------------------------|--------------------------------------------|------------------------------------------------|
| Text Content           | `element.getText()`                       | Gets visible text of the element               |
| Attribute Value        | `element.getAttribute("name")`            | Gets value of a specific attribute (e.g., `href`, `value`) |
| Tag Name               | `element.getTagName()`                    | Gets HTML tag (e.g., `input`, `button`)        |
| CSS Property           | `element.getCssValue("property")`         | Gets value of a CSS property (e.g., `color`)   |
| Location (X, Y)        | `element.getLocation()`                   | Gets element's position on the screen          |
| Size (Width, Height)   | `element.getSize()`                       | Gets element's dimensions                      |
| Is Displayed?          | `element.isDisplayed()`                   | Checks if element is visible                   |
| Is Enabled?            | `element.isEnabled()`                     | Checks if element is interactable              |
| Is Selected?           | `element.isSelected()`                    | Checks if radio/checkbox is selected           |

### 🧪 3. **Example**
```java
WebElement btn = driver.findElement(By.id("submit"));

System.out.println("Text: " + btn.getText());
System.out.println("Tag: " + btn.getTagName());
System.out.println("Color: " + btn.getCssValue("color"));
System.out.println("X: " + btn.getLocation().getX());
System.out.println("Width: " + btn.getSize().getWidth());
System.out.println("Is Enabled: " + btn.isEnabled());
System.out.println("Is Displayed: " + btn.isDisplayed());
```
### 🧼 4. **Close Driver**
```java
driver.quit();
```
