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


## 🗓️ **Handling Calendars in Selenium 

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

