package org.stag.serenitysteplib;

import net.serenitybdd.core.Serenity;
import org.stag.pageobjects.ProfilePage;

import static org.assertj.core.api.Assertions.assertThat;

public class UpdateAccountSerenitySteps {

    ProfilePage profilePage;

    public void updateAddress(String s){
        profilePage.address1Field.type(s);
        profilePage.confirmPasswordField.typeAndEnter(Serenity.getCurrentSession().get("password").toString());
    }

    public void validateUpdateMessage(){
        profilePage.updateSuccessMsg.waitUntilVisible();
        assertThat(profilePage.updateSuccessMsg.waitUntilVisible().isVisible()).isTrue();
    }


}
