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
