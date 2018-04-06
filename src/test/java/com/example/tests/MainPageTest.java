package com.example.tests;

import com.codeborne.selenide.testng.annotations.Report;
import com.example.BaseTest;
import com.example.steps.DataPageSteps;
import com.example.steps.DatasetPageSteps;
import com.example.steps.MainPageSteps;
import com.example.steps.SearchPageSteps;
import org.hamcrest.Matcher;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.startsWith;

@Test
@Report
public class MainPageTest extends BaseTest {

    @DataProvider(name = "search")
    public Object[][] createData1() {
        return new Object[][] {
                { "Имена", startsWith("им")},
                { "Дети", anyOf(startsWith("дет"), startsWith("реб"))},
        };
    }

    // iit-234
    /*@Test(groups = "regression", dataProvider = "search")
    public void search(String searchText, Matcher highlighted)  {
        *//*MainPageSteps mainPageSteps = new MainPageSteps();
        mainPageSteps.openMainPage()
                .checkSearchInputPlaceholder("Поиск по 929 наборам данных и материалам портала")
                .searchFor(searchText);*//*

        *//*SearchPageSteps searchSteps = new SearchPageSteps();
        searchSteps.getPage().shouldBeOpened();
        searchSteps.checkSearchInputValue(searchText)
                .checkOverallNumberExist()
                .checkSearchTypeExists("По объектам в наборах данных")
                .checkSearchTypeExists("Материалы портала")
                .checkSearchTypeExists("По наборам данных")
                .checkSearchTypeSelected("По наборам данных")
                .checkElementsHighlighted(highlighted);*//*

        DataPageSteps dataSteps = new DataPageSteps();
        dataSteps.openPage();
        dataSteps.getPage().shouldBeOpened();
        dataSteps.checkElementsExists();
    }
*/
    @Test(groups = "regression")
    public void checkDropDescription()
    {
        DataPageSteps dataSteps = new DataPageSteps();
        dataSteps.openPage();
        dataSteps.getPage().shouldBeOpened();
        dataSteps.checkElementsExists()
                .clickOnDescIcon()
                .checkDropDescStatus("true")
                .clickOnDescIcon()
                .checkDropDescStatus("false");
    }

    @Test(groups = "regression")
    public void checkJsonDownload()
    {
        DataPageSteps dataSteps = new DataPageSteps();
        dataSteps.openPage();
        dataSteps.getPage().shouldBeOpened();
        dataSteps.checkElementsExists()
                .clickOnExportButton()
                .checkExportMenuVisibility("true")
                .clickOnJsonExportFormat();
    }

    @Test(groups = "regression")
    public void check3()
    {
        DatasetPageSteps datasetSteps = new DatasetPageSteps();
        datasetSteps.openPage();
        datasetSteps.getPage().shouldBeOpened();
        datasetSteps.checkIdCellValue()
                .checkButtonsExists()
                .clickMapButton()
                .checkMapButtonBecomeBlue()
                .checkMapAppear();
    }



}
