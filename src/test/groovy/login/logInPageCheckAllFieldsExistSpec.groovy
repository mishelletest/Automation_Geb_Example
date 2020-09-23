package login
import geb.spock.GebSpec
import pages.FaceBookLoginPage

class logInPageCheckAllFieldsExistSpec extends GebSpec{
    def setup() {
        to FaceBookLoginPage
    }

    def "user login without entering an account info"() {

        def userNameField = $('[placeholder="Email or Phone Number"]')
        def passwordField = $('[type="password"]')

        when: "navigate to facebook login page"
            at FaceBookLoginPage

        then: "buttons and info are displayed"
            waitFor { loginButton.isDisplayed() } //this is to wait for the page to totally load before assertion. Function is located in page.FacebookLoginPage
            createNewAccountButton.isDisplayed()  //this is a sample of checking the button if displayed, the function is located in page.FaceBookLoginPage
            $('h2').text() == "Connect with friends and the world around you on Facebook." //this is an example of assertion using without a function created and checking for the specific text
            assert userNameField.isDisplayed() && passwordField.isDisplayed() //example of asserting two variables created on this class
    }
}
