## 🖱️ **Mouse Actions in Selenium WebDriver**

Selenium WebDriver provides the **`Actions`** class to handle mouse interactions like hover, right-click, drag and drop, click and hold, etc.

#### 🔧 Import Required Packages

```java
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
```

### 💡 **Common Mouse Actions**

#### ✅ 1. **Mouse Hover (Move to Element)**

```java
Actions actions = new Actions(driver);
actions.moveToElement(element).perform();
```

#### ✅ 2. **Click**

```java
actions.click(element).perform();
```

#### ✅ 3. **Right Click (Context Click)**

```java
actions.contextClick(element).perform();
```

#### ✅ 4. **Double Click**

```java
actions.doubleClick(element).perform();
```

#### ✅ 5. **Click and Hold**

```java
actions.clickAndHold(element).perform();
```

#### ✅ 6. **Release Mouse (after click and hold)**

```java
actions.release().perform();
```

#### ✅ 7. **Drag and Drop**

```java
actions.dragAndDrop(sourceElement, targetElement).perform();
```

#### ✅ 8. **Drag and Drop by Offset**

```java
actions.dragAndDropBy(sourceElement, xOffset, yOffset).perform();
```
### 🧠 **Notes**

- Always call `.perform()` to execute the action.
- `Actions` class uses **method chaining**: You can chain multiple actions like:
  ```java
  actions.moveToElement(element).click().build().perform();
  ```
### 🧪 Example

```java
WebElement menu = driver.findElement(By.id("menu"));
WebElement submenu = driver.findElement(By.id("submenu"));

Actions actions = new Actions(driver);
actions.moveToElement(menu).moveToElement(submenu).click().build().perform();
```


## 🗓️ Handling Calendars in Selenium 

#### 1. **Types of Calendars**
- **Static calendars**: All dates are present in the DOM and just shown/hidden using CSS/JS.
- **Dynamic calendars**: Dates are dynamically loaded based on navigation (month/year change).
- **Custom JS libraries**: e.g., jQuery UI Datepicker, Bootstrap Datepicker, React Datepicker, etc.

### ✅ **Basic Steps to Handle Calendar**

#### a. **Click to open calendar**
```java
driver.findElement(By.id("datePickerInput")).click();
```

#### b. **Select date directly (if visible)**
```java
driver.findElement(By.xpath("//td[text()='15']")).click();  // for 15th of current month
```
### 🔁 **If calendar requires navigating month/year**

1. **Click to open**
2. **Loop until desired month/year is found**
```java
while (!driver.findElement(By.className("ui-datepicker-title")).getText().contains("April 2025")) {
    driver.findElement(By.className("ui-datepicker-next")).click();
}
```
3. **Select date**
```java
driver.findElement(By.xpath("//a[text()='18']")).click();  // Select 18th
```

### 🔍 **Handling attributes / locating dates**
- Check calendar structure in browser's **Inspect Element** tool.
- Use XPath/CSS based on:
  - Tag: `<td>`, `<a>`, `<div>`, etc.
  - Class names like `day`, `ui-datepicker-day`, etc.
  - Text values using `text()='value'`.

### 🧠 **Pro Tips**
- Some calendars allow entering the date directly into the input field:  
  ```java
  driver.findElement(By.id("dateInput")).sendKeys("04/18/2025");
  ```
- Use `JavascriptExecutor` if clicking doesn’t work.
- Watch out for:
  - Disabled dates
  - Dynamic loading delays (use `WebDriverWait`)

### 🧪 **Wait Example (Explicit Wait)**
```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("calendarId")));
```

## JavaScript Executor
In Selenium WebDriver, a **JavaScriptExecutor** is an interface that allows you to execute JavaScript code directly within the context of the browser that Selenium is controlling. It's very useful when Selenium's built-in methods are not sufficient to interact with certain elements or behaviors on a web page.

### ✅ Interface:
```java
JavascriptExecutor js = (JavascriptExecutor) driver;
```

You can then use methods like:

### 🧠 Common Methods:
1. **`executeScript(String script, Object... args)`**  
   Executes JavaScript in the context of the currently selected frame or window.
   
2. **`executeAsyncScript(String script, Object... args)`**  
   Executes asynchronous JavaScript.

### 📌 Example Use Cases:

#### 1. Scroll the page:
```java
js.executeScript("window.scrollBy(0,500)");
```

#### 2. Click on a hidden element:
```java
js.executeScript("arguments[0].click();", element);
```

#### 3. Get page title using JS:
```java
String title = (String) js.executeScript("return document.title;");
```

#### 4. Set value in a text box:
```java
js.executeScript("arguments[0].value='test';", element);
```

### 🛠 Why Use JavaScriptExecutor?
- When normal Selenium actions like `.click()` or `.sendKeys()` don’t work due to overlays, hidden elements, or JS-based interactions.
- To manipulate the DOM directly.
- To retrieve browser-specific or page-level properties not accessible via WebDriver.

---
### 📒 **JavaScriptExecutor in Selenium**

**Purpose:**  
Allows execution of JavaScript code in the browser controlled by Selenium WebDriver.

**Initialization:**
```java
JavascriptExecutor js = (JavascriptExecutor) driver;
```

### 🔍 **Finding Elements using JavaScriptExecutor**

You can use JavaScript DOM methods inside `executeScript()` to locate elements.

### ✅ **Examples**

#### 1. **By ID**
```java
WebElement element = (WebElement) js.executeScript("return document.getElementById('elementId');");
```

#### 2. **By Class Name**
```java
WebElement element = (WebElement) js.executeScript("return document.getElementsByClassName('className')[0];");
```

#### 3. **By Name**
```java
WebElement element = (WebElement) js.executeScript("return document.getElementsByName('name')[0];");
```

#### 4. **By Tag Name**
```java
WebElement element = (WebElement) js.executeScript("return document.getElementsByTagName('input')[0];");
```

#### 5. **By CSS Selector**
```java
WebElement element = (WebElement) js.executeScript("return document.querySelector('.className');");
```

#### 6. **By XPath**
```java
WebElement element = (WebElement) js.executeScript(
  "return document.evaluate(\"//tag[@attr='value']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;"
);
```
### 🛠️ **Performing Actions After Finding**

```java
// Click
js.executeScript("arguments[0].click();", element);

// Set value
js.executeScript("arguments[0].value='text';", element);
```
---
### 📒 **Entering Text Using JavaScriptExecutor**

**Purpose:**  
Used when `sendKeys()` fails due to hidden elements, overlays, or JS-heavy frontends.

**JavaScriptExecutor Setup:**
```java
JavascriptExecutor js = (JavascriptExecutor) driver;
```

### ✅ **Method 1: Using WebElement**
```java
WebElement inputBox = driver.findElement(By.id("username"));
js.executeScript("arguments[0].value='SeleniumUser';", inputBox);
```
### ✅ **Method 2: Direct JavaScript Access**
```java
js.executeScript("document.getElementById('username').value='SeleniumUser';");
```
### ⚡ **Triggering Input Event (for React/Angular apps)**
```java
js.executeScript(
  "let el = document.getElementById('username');" +
  "el.value='SeleniumUser';" +
  "el.dispatchEvent(new Event('input'));"
);
```

> Use this when the page relies on input events to detect text changes.

---
### 📒 **Clicking with JavaScriptExecutor**

**Why use it?**  
When Selenium's `.click()` fails due to:
- Hidden elements
- Overlays
- JavaScript-heavy frontends
- Intercepted clicks

### ✅ **Syntax Using WebElement**
```java
JavascriptExecutor js = (JavascriptExecutor) driver;
WebElement element = driver.findElement(By.id("submitBtn"));

js.executeScript("arguments[0].click();", element);
```

### ✅ **Syntax Using Direct JavaScript**
```java
js.executeScript("document.getElementById('submitBtn').click();");
```

### 🧪 **Full Example**
```java
WebDriver driver = new ChromeDriver();
driver.get("https://example.com");

WebElement button = driver.findElement(By.id("submitBtn"));

JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].click();", button);
```
### ⚠️ **Note:**  
JS click **bypasses WebDriver checks**, so use it when:
- `.click()` throws `ElementClickInterceptedException`
- The element is visible in the DOM but not interactable in the traditional way
---

### 📒 **Highlighting Web Elements with JavaScriptExecutor**

**Purpose:**  
Used for debugging or visual testing — highlights the element by changing its **style (border, background, etc.)**.

### ✅ **Basic Syntax:**
```java
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].style.border='3px solid red'", element);
```

### 🧪 **Full Example:**
```java
WebDriver driver = new ChromeDriver();
driver.get("https://example.com");

WebElement element = driver.findElement(By.id("username"));

JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("arguments[0].style.border='3px solid red'", element);
```
### 🎨 **Custom Highlighting (with background color):**
```java
js.executeScript("arguments[0].setAttribute('style', 'border: 2px solid blue; background: yellow;')", element);
```

### 🔁 **Flashing Effect (for better visibility):**
```java
for (int i = 0; i < 5; i++) {
    js.executeScript("arguments[0].style.border='3px solid red'", element);
    Thread.sleep(200);
    js.executeScript("arguments[0].style.border=''", element);
    Thread.sleep(200);
}
```
### ⚠️ **Note:**
- This change is **only visual** and **temporary**.
- Helpful in demos, debugging, and creating visual logs.

---

### 📒 **Scrolling with JavaScriptExecutor**

**Why?**  
To bring elements into view, reach bottom/top of the page, or scroll by specific pixels — especially when Selenium actions don’t auto-scroll.

**Setup:**
```java
JavascriptExecutor js = (JavascriptExecutor) driver;
```

### ✅ **1. Scroll by Pixel (X, Y)**
```java
js.executeScript("window.scrollBy(0, 500);");  // Scroll down by 500px
js.executeScript("window.scrollBy(0, -500);"); // Scroll up by 500px
```

### ✅ **2. Scroll to the Bottom of the Page**
```java
js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
```

### ✅ **3. Scroll to the Top of the Page**
```java
js.executeScript("window.scrollTo(0, 0);");
```

### ✅ **4. Scroll an Element into View**
```java
WebElement element = driver.findElement(By.id("footer"));
js.executeScript("arguments[0].scrollIntoView(true);", element);
```

- `true` aligns to the top of the element
- `false` aligns to the bottom of the element

### ✅ **5. Smooth Scroll (Optional Visual Appeal)**
```java
js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", element);
```
### ⚠️ **Note:**
- Use scrolls when elements are outside the viewport and Selenium throws errors like `ElementNotInteractableException`.
- Always prefer `scrollIntoView()` for targeting elements.
### 📒 **Selenium Manager in Selenium WebDriver** (from Selenium 4.6+)

## 🧠 **Selenium Manager**

**Selenium Manager** is a built-in utility introduced in **Selenium 4.6** that automatically manages browser driver executables like `chromedriver`, `geckodriver`, `msedgedriver`, etc.

### ✅ **Before Selenium Manager (Manual Setup):**
You had to manually:

- Download the correct driver (e.g., `chromedriver.exe`)
- Match it with your browser version
- Set the path using `System.setProperty`

```java
System.setProperty("webdriver.chrome.driver", "path/to/chromedriver.exe");
WebDriver driver = new ChromeDriver();
```

### ✅ **With Selenium Manager (Automatic Setup):**
You **don’t need to set up drivers manually** anymore!

```java
WebDriver driver = new ChromeDriver(); // No need to set property
```

Selenium Manager will:
- Detect your browser version
- Download the compatible driver
- Set the path automatically

### 🌍 **How It Works Internally:**
- Selenium Manager runs as a **native executable**.
- It’s downloaded the first time you run Selenium 4.6+.
- It finds your browser version and resolves the correct driver version.

### 🔒 **Security:**
It connects to the internet only to download drivers **once** and stores them in a cache (`.cache/selenium`).

### 🔧 **Supported Browsers:**
| Browser  | Supported? |
|----------|------------|
| Chrome   | ✅ Yes     |
| Firefox  | ✅ Yes     |
| Edge     | ✅ Yes     |
| Safari   | 🚫 No (uses built-in WebDriver)

### ⚠️ **Important Notes:**
- Selenium Manager **requires internet** for the initial download.
- It may not support **proxy-based environments** out of the box.

### 🎯 **Advantages:**
- No need for WebDriverManager (third-party library)
- Fewer setup steps
- Built-in and maintained by Selenium team

### ✅ Example (Full Code with Selenium Manager):

```java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumManagerExample {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver(); // Selenium Manager handles driver setup
        driver.get("https://example.com");
        System.out.println("Title: " + driver.getTitle());
        driver.quit();
    }
}
```
### Important Notes
Here are concise answers to the questions about **Selenium Manager**:

1. **What is Selenium Manager?**  
   Selenium Manager is a feature introduced in Selenium 4.6+ that automatically manages browser driver binaries (like chromedriver, geckodriver).  
   It eliminates the need to manually download and set paths for WebDriver executables.

2. **Why do we need the Selenium Manager?**  
   It simplifies test setup by handling the browser driver management internally.  
   This reduces compatibility issues and setup overhead for test automation engineers.

3. **How does Selenium Manager work or help?**  
   At runtime, it detects the required driver for the browser and OS, downloads it if necessary, and sets the correct path automatically.  
   It ensures that the appropriate version of the driver is always used.

4. **Do we need an additional library in order to use the Selenium Manager?**  
   No, Selenium Manager is built into Selenium 4.6+ itself.  
   No external library like WebDriverManager is required.

5. **Where does the driver executables stored?**  
   Driver executables are cached locally, typically in the user’s home directory (e.g., `~/.cache/selenium`).  
   This prevents repeated downloads and speeds up execution.

6. **Does Selenium always try to download the executable files?**  
   No, it checks the cache first.  
   It downloads the driver only if it's not already available or outdated.

7. **Do we still need WebDriverManager library?**  
   Not necessarily with Selenium Manager.  
   However, WebDriverManager may still be useful in advanced use cases or legacy projects.
