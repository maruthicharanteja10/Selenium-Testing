##  **Introduction to XPath in Selenium WebDriver**

### 📌 What is XPath?
**XPath (XML Path Language)** is a syntax used to navigate through elements and attributes in an XML document. In Selenium, XPath is used to **locate elements** on a web page.

### ✅ Why Use XPath in Selenium?
- Can **locate complex/nested elements**.
- Works when elements **don’t have ID, name, or class**.
- Allows use of **conditions, functions, and axes**.

### 🧭 Types of XPath

| Type              | Syntax Example                              | Description                          |
|------------------|---------------------------------------------|--------------------------------------|
| **Absolute XPath** | `/html/body/div[1]/form/input`              | Starts from root node (fragile)      |
| **Relative XPath** | `//input[@id='username']`                   | Starts from anywhere (preferred)     |

### 🔨 Basic XPath Syntax
```xpath
//tagname[@attribute='value']
```

#### 📘 Examples:
```xpath
//input[@id='email']           --> input element with id='email'
//button[text()='Login']       --> button with exact text 'Login'
//a[contains(text(),'Click')]  --> anchor with partial text 'Click'
//div[@class='box'][2]         --> second matching div with class 'box'
```
### ⚙️ Useful XPath Functions

| Function          | Example                                    | Purpose                                |
|------------------|--------------------------------------------|----------------------------------------|
| `text()`         | `//h1[text()='Welcome']`                   | Match element text                     |
| `contains()`     | `//input[contains(@name,'user')]`          | Match partial attribute/text           |
| `starts-with()`  | `//div[starts-with(@class,'alert')]`       | Match starting substring               |
| `last()`         | `(//div[@class='item'])[last()]`           | Selects last matching element          |
| `position()`     | `(//tr)[position()<3]`                     | Select first 2 rows                    |

### 🔄 XPath Axes (for navigating relations)

| Axis              | Example                                    | Description                            |
|------------------|--------------------------------------------|----------------------------------------|
| `parent::`       | `//span[@class='label']/parent::div`       | Gets parent element                    |
| `child::`        | `//div[@id='menu']/child::ul`              | Gets direct child elements             |
| `following-sibling::` | `//label/following-sibling::input`     | Gets the next sibling                  |
| `preceding-sibling::` | `//input[@id='pwd']/preceding-sibling::label` | Gets previous sibling          |

### 🧪 Example in Java with Selenium
```java
WebElement emailInput = driver.findElement(By.xpath("//input[@id='email']"));
emailInput.sendKeys("test@example.com");
```

