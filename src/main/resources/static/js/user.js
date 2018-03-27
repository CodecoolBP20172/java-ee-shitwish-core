window.onload = function() {
    $('.register_errors').hide();
    $('.login_error').hide();

    const errorlist = {
        "allFieldsRequired": "All fields are required!",
        "passwordMismatch": "Passwords do not match!",
        "invalidName": "Your name contains invalid characters!",
        "emailExists": "Your email already exists!",
        "emailInvalid": "That does not look like a valid email!"
    };

    $('.register-button').click(function (event) {
        event.preventDefault();
        let counter = 0;
        let data = {
            'email': $('#email').val(),
            'firstName': $('#firstName').val(),
            'lastName': $('#lastName').val(),
            'userName': $('#userName').val(),
            'city': $('#city').val(),
            'password': $('#password').val(),
            'passwordAgain': $('#passwordAgain').val()
        };
        console.log(data);

        $('.regInput').each(function () {
            let element = this;
            if (fieldValidation(element)) {
                counter++;
            }
        });

        if (counter === 7) {
            console.log("we got in");
            $.ajax({
                type: 'POST',
                contentType: 'application/JSON',
                url: '/api/register',
                data: JSON.stringify(data),
                success: function (response) {
                    console.log(response);
                },
                error: function (response) {
                    console.log(response);
                }
            });
        }
    });

    $('.login-button').click(function (event) {
        event.preventDefault();
        let data = {
            'userName': $('#login_username').val(),
            'password': $('#login_password').val(),
        };

        console.log(data);

        $.ajax({
            type: 'POST',
            url: '/api/login',
            contentType: 'application/JSON',
            data: JSON.stringify(data),
            success: function (response) {
                console.log(response);
            },
            error: function (response) {
                console.log(response);
            }
        });
    });

    $('.regInput').each(function () {
        let element = this;
        $(element).keyup(function (event) {
            let field = event.target;
            if (fieldValidation(field)) {
                $(field).css("background-color", "white");
            } else {
                $(field).css("background-color", "coral");
            }
        });
    });
};

function fieldValidation(field) {
    let isEmpty = field.value.length === 0;
    let whiteSpaceOnly = isWhiteSpaceOnly(field.value);
    let startUpperCase = isStartUpperCase(field.value);
    let lettersOnly = isLettersOnly(field.value);
    let email = isEmail(field.value);
    if(field.id === "password" || field.id === "userName") {
        return true;
    } else if (field.id === "passwordAgain") {
        let psw = $("#password").val();
        return field.value === psw;
    } else if (field.id === "email") {
        return email;
    } else {
        return isEmpty || !whiteSpaceOnly && startUpperCase && lettersOnly;
    }
}

function isWhiteSpaceOnly(value) {
    let string = value.replace(/\s/g, "");
    return string.length === 0;
}

function isStartUpperCase(value) {
    return /^[A-Z]/.test(value);
}

function isLettersOnly(value) {
    return /^[^0-9]+$/.test(value);
}

function isEmail(value) {
    return /[a-z0-9._%+-]+[@][a-z0-9.-]+[.][a-z]{2,3}/.test(value);
}
