package login

import geb.spock.GebSpec
import pages.FaceBookLoginPage

class loginUsingWrongUserNameAndPwSpec extends GebSpec{
    def setup() {
        to FaceBookLoginPage
    }

    def "user login without entering an account info"() {

        def invalidUserName = "username@gmail.com"
        def invalidPw = "password"

        given: "navigated to facebook login page"
            at FaceBookLoginPage

        when: "user enter random user name and PW"
            logIn(invalidUserName,invalidPw)

        and: "click on the login button"
            loginButton.click()

        then: "buttons and info are displayed"
            waitFor {
                errorUponLogin.isDisplayed()
            }
    }
}
