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
