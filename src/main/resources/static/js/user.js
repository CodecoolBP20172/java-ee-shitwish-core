window.onload = function(){
    $('.register_errors').hide();
    $('.login_error').hide();

    const errorlist = {
        "allFieldsRequired": "All fields are required!",
        "passwordMismatch": "Passwords do not match!",
        "invalidName": "Your name contains invalid characters!",
        "emailExists": "Your email already exists!",
        "emailInvalid": "That does not look like a valid email!"
    };


    $('.register-button').click(function(event){
        event.preventDefault();
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

        $.ajax({
            type: 'POST',
            contentType: 'application/JSON',
            url: '/api/register',
            data: JSON.stringify(data),
            success: function (response) {
                console.log(response);
            },
            error: function(response) {
                console.log(response);
            }
        });
    });

    $('.login-button').click(function(event){
        event.preventDefault();
        let data = {
            'username': $('#login_username').val(),
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
            error: function(response) {
                console.log(response);
            }
        });
    });
};