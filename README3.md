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
