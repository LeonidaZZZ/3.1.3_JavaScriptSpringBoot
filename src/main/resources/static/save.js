$('#add_button').on('click',function (){

    let $firstName = $('#firstName')
    let $lastname = $('#lastName')
    let $email = $('#email')
    let $age = $('#age')
    let $password = $('#password')

    const data = {

        firstName: $firstName.val(),
        lastName: $lastname.val(),
        email: $email.val(),
        age: $age.val(),
        password: $password.val(),
        roles : [{
                id: $('#roleSelect').val()[0]
            },
            {
                id: $('#roleSelect').val()[1]
            }
        ],
    }

    $.ajax({
        type: 'POST',
        url: 'http://localhost:8080/admin/save',
        dataType: 'json',
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (data){
            console.log(data)

        }
    })
})

