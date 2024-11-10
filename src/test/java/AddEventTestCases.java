


public class AddEventTestCases {


    public static void addEventTestCases(String startTime, String finishtime) throws InterruptedException {

        AddEventTestStep.openURL("https://examples.sencha.com/extjs/6.5.3/examples/calendar/");
        Thread.sleep(10000);

        AddEventTestStep.findFrime("examples-iframe");

        AddEventTestStep.clickButton("Create");

        String title = AddEventTestStep.titleName();
        AddEventTestStep.fillTitle(title);

        AddEventTestStep.clickForm();

        AddEventTestStep.getMounth();

        AddEventTestStep.SetDay(AddEventTestStep.getMounth(),AddEventTestStep.getDay(),"from");
        Thread.sleep(2000);
        AddEventTestStep.allDayClick();

        AddEventTestStep.timeClickFrom("from");
        Thread.sleep(2000);

        AddEventTestStep.scroolTimeFrom(startTime,"from");
        Thread.sleep(2000);

        AddEventTestStep.clickTo();
        Thread.sleep(2000);

        AddEventTestStep.SetDay(AddEventTestStep.getMounth(),AddEventTestStep.getDay(),"to");
        Thread.sleep(2000);

        AddEventTestStep.timeClickFrom("to");
        Thread.sleep(2000);

        AddEventTestStep.scroolTimeFrom(finishtime,"to");
        Thread.sleep(2000);
        AddEventTestStep.setDescription("TestDescription");
        Thread.sleep(2000);

        AddEventTestStep.clickButton("Save");
        Thread.sleep(2000);

        //String pageText = driver.getPageSource();

        //System.out.println(pageText);
        AddEventTestStep.findText(title);
    }

}

