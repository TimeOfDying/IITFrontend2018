package com.example.steps;

import com.example.pages.DataPage;

import static com.codeborne.selenide.Condition.*;

public class DataPageSteps extends BaseSteps<DataPage> {

    public DataPageSteps() {
        page = new DataPage();
    }

    public DataPageSteps openPage() {
        page.navigate().shouldBeOpened();
        return this;
    }



    public DataPageSteps checkElementsExists()
    {

        page.getDatasetNumber().shouldBe(visible);
        page.getDatasetCaption().shouldBe(visible);
        page.getDatasetDescIcon().shouldBe(visible);
        page.getDatasetIcon().shouldBe(visible);
        page.getExport().shouldBe(visible);
        page.getPassport().shouldBe(visible);
        return this;
    }

    public DataPageSteps clickOnDescIcon()
    {
        page.getDatasetDescIcon().click();
        return this;
    }

    public DataPageSteps checkDropDescStatus(String iconStatus)
    {
        if(iconStatus == "true")
        {
            page.getDatasetDescIcon().shouldHave(attribute("aria-expanded", iconStatus));
            page.getDropDesc().shouldBe(visible);
        }
        else
        {
            page.getDatasetDescIcon().shouldHave(attribute("aria-expanded",iconStatus));
            page.getDropDesc().shouldNotBe(visible);
        }
        return this;
    }

    public DataPageSteps clickOnExportButton()
    {
        page.getExport().click();
        return this;
    }

    public DataPageSteps clickOnJsonExportFormat()
    {
        page.getJsonExport().click();
        return this;
    }

    public DataPageSteps checkExportMenuVisibility(String expectedValue)
    {
        page.getExport().shouldHave(attribute("aria-expanded",expectedValue));
        return this;
    }
}
