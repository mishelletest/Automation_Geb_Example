package login

import geb.spock.GebSpec
import org.openqa.selenium.By
import pages.FaceBookLoginPage

class loginWithoutUserNamePasswordSpec extends GebSpec{

    def setup() {
        to FaceBookLoginPage
    }

    def "user login without entering an account info"() {

        given: "navigate to Facebook Login Page"
            at FaceBookLoginPage

        when: "click the login button"
            loginButton.click()

        then: "error message appear"
        // you can use jquery code here to assert the error message or you can make a function in FacebookLoginPage and call the function
        waitFor { $(By.xpath("//div[contains(text(), 'The email or phone number you’ve entered doesn’t match any account. ')]")).isDisplayed() }
    }
}
