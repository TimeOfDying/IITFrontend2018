package com.example.tests;

import com.codeborne.selenide.Condition;
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
import static com.codeborne.selenide.Condition.*;

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
   /* @Test(groups = "regression", dataProvider = "search")
    public void search(String searchText, Matcher highlighted)  {
        MainPageSteps mainPageSteps = new MainPageSteps();
        mainPageSteps.openMainPage()
                .checkSearchInputPlaceholder("Поиск по 929 наборам данных и материалам портала")
                .searchFor(searchText);

        SearchPageSteps searchSteps = new SearchPageSteps();
        searchSteps.getPage().shouldBeOpened();
        searchSteps.checkSearchInputValue(searchText)
                .checkOverallNumberExist()
                .checkSearchTypeExists("По объектам в наборах данных")
                .checkSearchTypeExists("Материалы портала")
                .checkSearchTypeExists("По наборам данных")
                .checkSearchTypeSelected("По наборам данных")
                .checkElementsHighlighted(highlighted);

        DataPageSteps dataSteps = new DataPageSteps();
        dataSteps.openPage();
        dataSteps.getPage().shouldBeOpened();
        dataSteps.checkElementsExists();
    }*/

    //iit-159
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

    //iit-160
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

    //iit-161
    @Test(groups = "regression")
    public void checkSorting()
    {
        DatasetPageSteps datasetSteps = new DatasetPageSteps();
        datasetSteps.openPage();
        datasetSteps.getPage().shouldBeOpened();
        datasetSteps.checkSortingOrder("ASC")
                .clickIdColumn()
                .waitSorting("1")
                .checkSortingIsValid("ASC")
                .clickIdColumn()
                .waitSorting("9000004")
                .checkSortingIsValid("DESC");
    }

    //iit-162
    @Test(groups = "regression")
    public void checkShowOnMapFunction()
    {
        DatasetPageSteps datasetSteps = new DatasetPageSteps();
        datasetSteps.openPage();
        datasetSteps.getPage().shouldBeOpened();
        datasetSteps.checkButtonsExists()
                .clickMapButton()
                .checkMapButtonBecomeBlue()
                .checkMapAppear()
                .checkSelectedAddressVisibility();
    }

    //iit-163
    @Test(groups = "regression")
    public void checkDisplaySpecificColumn()
    {
        DatasetPageSteps datasetSteps = new DatasetPageSteps();
        datasetSteps.openPage();
        datasetSteps.getPage().shouldBeOpened();
        datasetSteps.clickDropColumns()
                .checkDropColumnsVisibility()
                .checkDropColumnElementStatus("inactive")
                .clickOnDropColumnElement()
                .checkDropColumnElementStatus("")
                .checkColumnVisibility(visible)
                .clickOnDropColumnElement()
                .checkDropColumnElementStatus("inactive")
                .checkColumnVisibility(hidden);
    }




}
