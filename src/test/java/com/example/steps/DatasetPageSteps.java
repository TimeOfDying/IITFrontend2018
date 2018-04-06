package com.example.steps;

import static com.codeborne.selenide.Condition.*;
import com.example.pages.DatasetPage;

import javax.xml.crypto.Data;

public class DatasetPageSteps extends BaseSteps<DatasetPage> {

    public DatasetPageSteps() {
        page = new DatasetPage();
    }

    public DatasetPageSteps openPage() {
        page.navigate().shouldBeOpened();
        return this;
    }

    public DatasetPageSteps checkIdCellValue()
    {
        page.getIdCell().shouldHave(attribute("data-tooltip-info","3802928"));
        return this;
    }

    public DatasetPageSteps checkButtonsExists()
    {
        page.getCopyButton().shouldHave(attribute("data-tooltip","Скопировать ссылку"));
        page.getMapIcon().shouldBe(attribute("title","Показать на карте"));
        return this;
    }

    public DatasetPageSteps clickMapButton()
    {
        page.getMapIcon().click();
        return this;
    }

    public DatasetPageSteps checkMapAppear()
    {
        page.getMap().shouldBe(visible);
        return this;
    }

    public DatasetPageSteps checkMapButtonBecomeBlue()
    {
        page.getSelectedMapIcon().shouldBe(visible);
        return this;
    }

}
