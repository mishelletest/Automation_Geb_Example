package pages

import geb.Page
import org.openqa.selenium.By


class FaceBookLoginPage extends Page {

    static at = { title == "Facebook - Log In or Sign Up" }

    static content = {
        loginButton {$('[name="login"]')}
        createNewAccountButton {$(By.xpath('//a[@data-testid="open-registration-form-button"]'))}
        userNameField { $('[placeholder="Email or Phone Number"]') }
        passwordField { $('[type="password"]') }
        errorUponLogin { $(By.xpath("//div[contains(text(), 'The email or phone number you’ve entered doesn’t match any account. ')]")) }
        espanolLanguage {$('a[title="Spanish"]')}


    }

    void logIn(String userName, String password){
        userNameField = userName
        passwordField = password
    }

    boolean spanishVersionOfLoginToFacebook() {
        $(By.xpath("//div[contains(text(), 'Iniciar sesión en Facebook')]")).isDisplayed()
        return true
    }

    void defaultToEnglish() {
        if ( loginButton.text() != 'Log in' ) {
            $(By.xpath('//a[@title="English (US)"]')).click()
        }
    }

}
