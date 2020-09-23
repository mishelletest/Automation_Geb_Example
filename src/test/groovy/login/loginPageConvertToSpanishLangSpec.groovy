package login

import geb.spock.GebSpec
import org.openqa.selenium.By
import pages.FaceBookLoginPage

class loginPageConvertToSpanishLangSpec extends GebSpec{
    def setup() {
        to FaceBookLoginPage
    }

    def "user login without entering an account info"() {

        def userNameField = $('[name="email"]')
        def passwordField = $('[type="password"]')

        when: "navigate to login page"
            at FaceBookLoginPage

        and: "click on Espanol language"
            espanolLanguage.click()

        then: "login to face is converted to spanish"
            assert spanishVersionOfLoginToFacebook()

        cleanup: "always change to english"
            report("before-cleanup")
            defaultToEnglish()

    }
}
