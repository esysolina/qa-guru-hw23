package io.qameta.allure.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

public class FormTest extends TestBase {

    @Feature("Registration")
    @Story("Registration")
    @DisplayName("RegistrationForm")
    @Severity(SeverityLevel.BLOCKER)
    @Test
    void FormTest() {

        step("Open", () -> {
            open("/automation-practice-form");
        });

        step("Input name", () -> {
            $("#firstName").setValue("Eva");
        });

        step("Input lastname", () -> {
            $("#lastName").setValue("Sy");
        });

        step("Input email", () -> {
            $("#userEmail").setValue("eva.sy@test.com");
        });

        step("Input phone", () -> {
            $(".custom-control-label").click();
            $("#userNumber").setValue("1234567891");
        });

        step("Select date", () -> {
            $("#dateOfBirthInput").click();
            $(".react-datepicker__month-select").click();
            $(".react-datepicker__month-select").selectOption("April");
            $(".react-datepicker__year-select").selectOption("1990");
            $x("//div[contains(text(),'18')]").click();
        });

        step("Input hobby", () -> {
            $("#subjectsInput").setValue("Eng").pressEnter();
            $x("//label[contains(text(),'Reading')]").click();
        });

        step("Input address", () -> {
            $("#currentAddress").setValue("Flau, Rainy Street, 77");
        });

        step("Select state", () -> {
            $("#react-select-3-input").setValue("NCR").pressEnter();
        });

        step("Select town", () -> {
            $("#react-select-4-input").setValue("Delhi").pressEnter();
        });

        step("Submit", () -> {
            $("#submit").click();
        });

        step("Check visible", () -> {
            $("#example-modal-sizes-title-lg").shouldBe(visible);
        });

        step("Check table", () -> {
            $(".table-responsive").shouldHave(text("Eva"));
            $(".table-responsive").shouldHave(text("Sy"));
            $(".table-responsive").shouldHave(text("eva.sy@test.com"));
            $(".table-responsive").shouldHave(text("Female"));
            $(".table-responsive").shouldHave(text("1234567891"));
            $(".table-responsive").shouldHave(text("18 April,1990"));
            $(".table-responsive").shouldHave(text("English"));
            $(".table-responsive").shouldHave(text("Reading"));
            $(".table-responsive").shouldHave(text("Flau, Rainy Street, 77"));
            $(".table-responsive").shouldHave(text("NCR Delhi"));
        });
    }

    @Test
    @AllureId("")
    @DisplayName("GoogleTest")
    @Owner("allure8")
    void SearchTest() {
        step("Open", () -> {
            open("https://google.com");
        });
        step("Submit", () -> {
            $("#submit").click();
        });
    }

}
