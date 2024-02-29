package lt.eif.viko.m.danys.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;

public class WebTests {

    private WebDriver driver;

    @BeforeTest
    void setUp(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void login(){

        driver.get("https://opensource-demo.orangehrmlive.com");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='username']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("button")));

        WebElement usernameInput = driver.findElement(By.xpath("//input[@name='username']"));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@name='password']"));
        WebElement loginButton = driver.findElement(By.tagName("button"));
        usernameInput.sendKeys("admin");
        passwordInput.sendKeys("admin123");
        loginButton.click();

        assert driver.getCurrentUrl().equals("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
    }

    @Test(dependsOnMethods = "login")
    public void addEmployeeTest() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")));
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[1]/aside/nav/div[2]/ul/li[2]/a")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")));
        driver.findElement(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div[2]/div[1]/button")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='app']/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input")));
        WebElement firstName = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input"));
        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[1]/div/div/div[2]/div[3]/div[2]/input"));
        WebElement employeeId = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[1]/div[2]/div/div/div[2]/input"));
        WebElement photo = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[1]/div/div[2]/input"));


        firstName.sendKeys("Antanas");
        lastName.sendKeys("Antanaitis");
        employeeId.sendKeys("102395");

        // Pridėjimas paveikslėlio
        photo.sendKeys("images\\test-profile-img.jpg");

        // Pridėjimas prisijungimo duomenų
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[2]/div/label/span")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input")));
        WebElement usernameLogin = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[3]/div/div[1]/div/div[2]/input"));
        WebElement passwordLogin = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[1]/div/div[2]/input"));
        WebElement confirmPassword = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[1]/div[2]/div[4]/div/div[2]/div/div[2]/input"));

        usernameLogin.sendKeys("Andrifuchsaaasdfasdfasdfassd");
        passwordLogin.sendKeys("Antanis@43222");
        confirmPassword.sendKeys("Antanis@43222");

        //isaugomijas naujo darbuotojo
        WebElement saveBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]"));

        saveBtn.click();

        // Pridėjimas darbo informacijos
        //Job lango atidarymas
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[6]/a")));
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[1]/div[2]/div[6]/a")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/div/div/input")));
        WebElement joinedDate = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[1]/div/div[2]/div/div/input"));
        WebElement jobTitle = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[2]/div/div[2]"));
        WebElement employmentStatus = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div/div[7]/div/div[2]/div/div/div[1]"));

        joinedDate.sendKeys("2023-01-01");

        String jTitle = "IT Manager";
        String jEmp = "Freelance";

        jobTitle.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-select-wrapper']//div[@class='oxd-select-text-input' and text()='"+jTitle+"']")));

        employmentStatus.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='oxd-select-wrapper']//div[@class='oxd-select-text-input' and text()='"+jEmp+"']")));

        //Job issaugojimas
        WebElement saveJob = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/button"));
        saveJob.click();

    }

    @Test
    public void editEmployeeData() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewPersonalDetails/empNumber/12");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div[1]/div/div/div[2]/div[1]/div[2]/input")));

        // Name
        WebElement name = driver.findElement(By.className("orangehrm-firstname"));
        String value = name.getAttribute("value");

        if(value.isEmpty()) {
            name.sendKeys("Martin");
        }
        else{
            for (int i = 0; i <= value.length(); i++) {
                name.sendKeys(Keys.BACK_SPACE);
            }
            name.sendKeys("Martin");
        }

        // Mid Name
        WebElement midName = driver.findElement(By.className("orangehrm-middlename"));
        value = midName.getAttribute("value");

        for(int i = 0; i <= value.length(); i++){
            midName.sendKeys(Keys.BACK_SPACE);
        }
        midName.sendKeys("Lewander");


        //LastName
        WebElement lname = driver.findElement(By.className("orangehrm-lastname"));
        value = lname.getAttribute("value");

        for(int i = 0; i <= value.length(); i++){
            lname.sendKeys(Keys.BACK_SPACE);
        }
        lname.sendKeys("Jameson");


        //Nickname
        WebElement nickname = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[1]/div[2]/div/div/div[2]/input"));
        value = nickname.getAttribute("value");

        if(value.isEmpty()) {
            nickname.sendKeys("Martin1234");
        }
        else{
            for (int i = 0; i <= value.length(); i++) {
                nickname.sendKeys(Keys.BACK_SPACE);
            }
            nickname.sendKeys("Martin1234");
        }


        //Employee ID
        WebElement empId = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[1]/div/div[2]/input"));
        value = empId.getAttribute("value");

        if(value.isEmpty()) {
            empId.sendKeys("12364561");
        }
        else{
            for (int i = 0; i <= value.length(); i++) {
                empId.sendKeys(Keys.BACK_SPACE);
            }
            empId.sendKeys("12364561");
        }

        //Other ID
        WebElement otrId = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[1]/div[2]/div/div[2]/input"));
        value = otrId.getAttribute("value");

        if(value.isEmpty()) {
            otrId.sendKeys("098765");
        }
        else{
            for (int i = 0; i <= value.length(); i++) {
                otrId.sendKeys(Keys.BACK_SPACE);
            }
            otrId.sendKeys("098765");
        }

        //Driver license
        WebElement drvId = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[1]/div/div[2]/input"));
        value = drvId.getAttribute("value");

        if(value.isEmpty()) {
            drvId.sendKeys("198234123984");
        }
        else{
            for (int i = 0; i <= value.length(); i++) {
                drvId.sendKeys(Keys.BACK_SPACE);
            }
            drvId.sendKeys("198234123984");
        }

        //Expire date
        WebElement dateExp = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[2]/div[2]/div/div[2]/div/div/input"));
        value = dateExp.getAttribute("value");

        if(value.isEmpty()) {
            dateExp.sendKeys("2023-09-23");
        }
        else{
            for (int i = 0; i <= value.length(); i++) {
                dateExp.sendKeys(Keys.BACK_SPACE);
            }
            dateExp.sendKeys("2023-09-23");
        }

        //SSN Number
        WebElement ssnNum = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[3]/div[1]/div/div[2]/input"));
        value = ssnNum.getAttribute("value");

        if(value.isEmpty()) {
            ssnNum.sendKeys("1112223333");
        }
        else{
            for (int i = 0; i <= value.length(); i++) {
                ssnNum.sendKeys(Keys.BACK_SPACE);
            }
            ssnNum.sendKeys("1112223333");
        }

        //SIN Number
        WebElement sinNum = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[2]/div[3]/div[2]/div/div[2]/input"));
        value = sinNum.getAttribute("value");

        if(value.isEmpty()) {
            sinNum.sendKeys("1112223333444");
        }
        else{
            for (int i = 0; i <= value.length(); i++) {
                sinNum.sendKeys(Keys.BACK_SPACE);
            }
            sinNum.sendKeys("1112223333444");
        }

        //Nationality
        WebElement nation = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[1]/div/div[2]/div/div/div[1]"));
        nation.click();

        String result = "Australian";
        while(!result.equals(value)){

            nation.sendKeys(Keys.ARROW_DOWN);
            value = nation.getText();

        }

        //Marital Status
        WebElement marrage = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[1]/div[2]/div/div[2]/div/div/div[1]"));
        marrage.click();

        String mresult = "Married";
        while(!mresult.equals(value)){

            marrage.sendKeys(Keys.ARROW_DOWN);
            value = marrage.getText();

        }


        //DoB
        WebElement dateOfBirth = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[3]/div[2]/div[1]/div/div[2]/div/div/input"));
        value = dateOfBirth.getAttribute("value");

        if(value.isEmpty()) {
            dateOfBirth.sendKeys("1989-03-12");
        }
        else{
            for (int i = 0; i <= value.length(); i++) {
                dateOfBirth.sendKeys(Keys.BACK_SPACE);
            }
            dateOfBirth.sendKeys("1989-03-12");
        }

        // Military Service
        WebElement mill = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/div/div[1]/div/div[2]/input"));
        value = mill.getAttribute("value");

        if(value.isEmpty()) {
            mill.sendKeys("Test");
        }
        else{
            for (int i = 0; i <= value.length(); i++) {
                mill.sendKeys(Keys.BACK_SPACE);
            }
            mill.sendKeys("Test");
        }

        //Smoker
        WebElement smoker = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[4]/div/div[2]/div/div[2]/div/label/span/i"));
        smoker.click();

        WebElement savePersonDetails = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[1]/form/div[5]/button"));
        savePersonDetails.click();


        //Blood Type
        WebElement blood = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[1]/div/div/div/div[2]/div/div/div[1]"));
        blood.click();

        String bresult = "B+";
        while(!bresult.equals(value)){

            blood.sendKeys(Keys.ARROW_DOWN);
            value = blood.getText();

        }

        WebElement saveBloodGroup = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[2]/div/form/div[2]/button"));
        saveBloodGroup.click();

        //Add file button
        WebElement fileBtn = wait.until(ExpectedConditions.elementToBeClickable(By.className("oxd-button--text")));
        fileBtn.sendKeys(Keys.ENTER);

        //File add
        WebElement file = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[1]/div/div/div/div[2]/input"));
        file.sendKeys("testFIle1.txt");

        //Save file
        WebElement SaveFile = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div/form/div[3]/button[2]"));
        SaveFile.click();

        //Download File
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div[3]/div/div[2]/div[1]/div/div[8]/div/button[3]")));
        WebElement Download = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div[3]/div/div[2]/div[1]/div/div[8]/div/button[3]"));
        Download.click();

        //Delete File
        WebElement Delete = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/div/div[2]/div[3]/div[3]/div/div[2]/div/div/div[8]/div/button[2]"));
        Delete.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div")));
        WebElement deletePop = driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div/div/div/div[3]/button[2]"));
        deletePop.click();


    }

    @Test
    public void addCandidate() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/recruitment/addCandidate");

        //An variable for getting input values
        String value;

        //To pass input
        String result;

        //Get Form elements
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("orangehrm-firstname")));
        WebElement firstname = driver.findElement(By.className("orangehrm-firstname"));
        WebElement middlename = driver.findElement(By.className("orangehrm-middlename"));
        WebElement lastname = driver.findElement(By.className("orangehrm-lastname"));
        WebElement vacancy = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div/div/div[2]/div/div/div[1]"));
        WebElement email = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[1]/div/div[2]/input"));
        WebElement contactNumber = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/div/div[2]/div/div[2]/input"));
        WebElement insertFile = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[4]/div/div/div/div/div[2]/input"));
        WebElement keywords = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/div/div[1]/div/div[2]/input"));
        WebElement appDate = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[5]/div/div[2]/div/div[2]/div/div/input"));
        WebElement notes = driver.findElement(By.className("oxd-textarea"));
        WebElement checkbox = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[7]/div/div/div/div[2]/div/label/span/i"));
        WebElement saveBtn = driver.findElement(By.className("orangehrm-left-space"));

        firstname.sendKeys("Wilson");
        middlename.sendKeys("John");
        lastname.sendKeys("Witwicky");

        //Choose Vacancy
        result = "Software Engineer";
        value = vacancy.getText();

        while(!result.equals(value)){
            vacancy.sendKeys(Keys.ARROW_DOWN);
            value = vacancy.getText();
        }

        email.sendKeys("wilson@gmail.com");
        contactNumber.sendKeys("8643242312341");

        insertFile.sendKeys("testFile2.txt");

        keywords.sendKeys("Test");

        //Application Date
        value = appDate.getAttribute("value");

        for(int i = 0; i<= value.length(); i++){
            appDate.sendKeys(Keys.BACK_SPACE);
        }

        appDate.sendKeys("2023-12-03");

        notes.sendKeys("Amazing candidate !!!");
        checkbox.click();

        //Entering shortlist
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[2]/button[2]")));
        WebElement shortlistBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[2]/button[2]"));
        shortlistBtn.click();

        //Shortlist
        Thread.sleep(4000);
        WebElement shortNotes = driver.findElement(By.className("oxd-textarea"));
        shortNotes.sendKeys("Accepted");

        WebElement shortSave = driver.findElement(By.className("orangehrm-left-space"));
        shortSave.click();

        //Entering Schedule Interview Page
        Thread.sleep(8000);
        WebElement schInterviewBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div[1]/form/div[2]/div[2]/button[2]"));
        schInterviewBtn.click();

        //Schedule Interview Page
        Thread.sleep(4000);
        WebElement interviewTitle = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[1]/div/div[2]/input"));
        WebElement interviewer = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[2]/div/div/div[2]/div/div/input"));
        WebElement date = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[3]/div/div[2]/div/div/input"));
        WebElement time = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/div/div[4]/div/div[2]/div/div[1]/input"));
        WebElement scheduleNotes = driver.findElement(By.className("oxd-textarea"));
        WebElement saveScheduleBtn = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[3]/button[2]"));

        interviewTitle.sendKeys("Junior Java Developer");
        interviewer.sendKeys("Odis");
        Thread.sleep(3000);
        interviewer.sendKeys(Keys.ARROW_DOWN, Keys.ENTER);

        date.sendKeys("2023-12-12");

        //Set time for interview
        value = time.getAttribute("value");
        for (int i = 0; i <= value.length(); i++){
            time.sendKeys(Keys.BACK_SPACE);
        }
        time.sendKeys("02:30 PM");

        scheduleNotes.sendKeys("Good");
        saveScheduleBtn.click();

    }

    @Test(dependsOnMethods = "login")
    public void buzzFeedTest() throws InterruptedException{
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/buzz/viewBuzz");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        //Text Posting Action
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("oxd-buzz-post-input")));

        WebElement postInput = driver.findElement(By.className("oxd-buzz-post-input"));
        WebElement postBtn = driver.findElement(By.className("oxd-button--main"));

        postInput.click();
        postInput.sendKeys("How's Your Day ? Comment bellow !!");
        postBtn.click();

        Thread.sleep(4000);

        //Photo Posting Action
        WebElement sharePhoto = driver.findElement(By.className("oxd-glass-button-icon--cameraglass"));
        sharePhoto.click();

        // Wait for the popup to appear
        WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".orangehrm-dialog-modal")));
        WebElement messageInput = popup.findElement(By.cssSelector(".oxd-buzz-post-input"));
        Thread.sleep(4000);
        WebElement insertPhoto = driver.findElement(By.cssSelector(".oxd-file-input"));

        // Enable the "Share" button
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].removeAttribute('disabled')", popup.findElement(By.cssSelector(".oxd-button--main")));

        // Click the "Share" button
        WebElement shareButton = popup.findElement(By.cssSelector(".oxd-button--main"));
        messageInput.sendKeys("This is my test message");
        insertPhoto.sendKeys("images\\buzzfeed-test-photo.jpg");
        shareButton.click();

    }


    public void tearDown() {
        // Uždaryti naršyklę po testo pabaigos
        driver.quit();
    }

}
