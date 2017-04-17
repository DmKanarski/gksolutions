"use strict";

function parseNewUser() {
    const
        fistName = $("#r_first_name").val(),
        middleName = $("#r_middle_name"),
        lastName = $("#r_last_name").val(),
        email = $("#r_email").val(),
        password = $("#r_password").val(),
        skype = $("#r_skype").val(),
        mobilePhone = $("#r_mobile_phone").val(),
        user = {
            firstName: fistName,
            middleName: middleName,
            lastName: lastName,
            email: email,
            password: password,
            skype: skype,
            mobilePhone: mobilePhone
        };
    return user;
}
