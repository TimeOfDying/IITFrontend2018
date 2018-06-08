package com.example.steps;

import static com.codeborne.selenide.Condition.*;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.example.pages.DatasetPage;

import javax.xml.crypto.Data;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;

public class DatasetPageSteps extends BaseSteps<DatasetPage> {

    public DatasetPageSteps() {
        page = new DatasetPage();
    }

    public DatasetPageSteps openPage() {
        page.navigate().shouldBeOpened();
        return this;
    }


    public DatasetPageSteps checkButtonsExists()
    {
        page.getCopyButton().shouldBe(visible);
        page.getMapIcon().shouldBe(visible);
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
        page.getMapIcon().shouldHave(attribute("class", "map-card-link r1 selected"));
        return this;
    }

    public DatasetPageSteps checkSelectedAddressVisibility()
    {
        page.getSelectedAddress().shouldBe(visible);
        return this;
    }

    public DatasetPageSteps checkSortingOrder(String order)
    {
        page.getFirstColumn().shouldHave(attribute("class", "hide-for-mobile "+order));
        return this;
    }

    public DatasetPageSteps clickIdColumn()
    {
        page.getIdColumn().click();
        return this;
    }

    public DatasetPageSteps checkSortingIsValid(String sortOrder)
    {
        SelenideElement firstID = page.getFirstId();
        SelenideElement secondID = page.getSecondId();
        SelenideElement idColumn = page.getIdColumn();

        if(sortOrder.equals("ASC"))
        {
            idColumn.shouldHave(text("ASC"));
            assertThat(Integer.parseInt(firstID.getText()), lessThan(Integer.parseInt(secondID.getText())));
        }
        else {
            idColumn.shouldHave(text("DESC"));
            assertThat(Integer.parseInt(firstID.getText()), greaterThan(Integer.parseInt(secondID.getText())));
        }

        return this;
    }

    public DatasetPageSteps clickDropColumns()
    {
        page.getDropColumnsLink().click();
        return this;
    }

    public DatasetPageSteps clickOnDropColumnElement()
    {
        page.getElementInDropColumns().click();
        return this;
    }

    public DatasetPageSteps checkDropColumnsVisibility()
    {
        page.getDropColumns().shouldBe(visible);
        return this;
    }

    public DatasetPageSteps checkDropColumnElementStatus(String status)
    {
        page.getElementInDropColumns().shouldHave(attribute("class", status));
        return this;
    }

    public DatasetPageSteps checkColumnVisibility(Condition condition)
    {
        page.getColumn().shouldBe(condition);
        return this;
    }

    public DatasetPageSteps waitSorting(String expectedValue)
    {
        page.getFirstId().shouldHave(text(expectedValue));
        return this;
    }
}
