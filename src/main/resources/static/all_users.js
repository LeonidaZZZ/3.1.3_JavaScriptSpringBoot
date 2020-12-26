$(document).ready(function (){

    fetch('http://localhost:8080/admin/userList')
        .then(response => response.json())
        .then(data => {
            console.log(data)
            var tr=[];
            var p=[];
            for (let i = 0; i < data.length; i++) {
                if (data[i].roles.length > 1){
                    var role = data[i].roles[0].name + ', ' + data[i].roles[1].name
                } else {
                    var role = data[i].roles[0].name
                }
                tr.push('<tr>');
                tr.push('<td>' + data[i].id + '</td>');
                tr.push('<td>' + data[i].firstName + '</td>');
                tr.push('<td>' + data[i].lastName + '</td>');
                tr.push('<td>' + data[i].age + '</td>');
                tr.push('<td>' + data[i].email + '</td>');
                tr.push('<td>' + role + '</td>');
                tr.push('<td><button id="edit_modal" type="button" class="btn btn-info" data-toggle="modal">' + 'Edit' + '</button></td>');
                tr.push('<td><button id="delete_modal" type="button" class="btn btn-danger" data-toggle="modal" >' + 'Delete' + '</button></td>');
                tr.push('</tr>');
            }

            $('#all_users_table').append($(tr.join('')))
        })
    fetch('http://localhost:8080/admin/auth')
        .then(response => response.json())
        .then(data => {
            console.log(data)
            let table = ""
                    if (data.roles.length > 1){
                        var role = data.roles[0].name + ', ' + data.roles[1].name
                    } else {
                        var role = data.roles[0].name
                    }

                    table += ('<tr id="list">')
                    table += ('<td>' + data.id + '</td>')
                    table += ('<td>' + data.firstName + '</td>')
                    table += ('<td>' + data.lastName + '</td>')
                    table += ('<td>' + data.age + '</td>')
                    table += ('<td>' + data.email + '</td>')
                    table += ('<td>' + role + '</td>')

                    table += ('</tr>')

                    console.log(table)
                    $('#auth_user').append(table)
                    $('#admin_header').html(data.firstName + ' with role: ' + role)
        })

    $('#add_button').on('click',function (){

        let $firstName = $('#firstName')
        let $lastname = $('#lastName')
        let $email = $('#email')
        let $age = $('#age')
        let $password = $('#password')

        let roles = $('#roleSelect').val()
        if (roles.length > 1){
            roles =[{id: 1}, {id: 2}]
        } else {
            roles =[{id: $('#roleSelect').val()[0]}]
        }
        const data = {
            firstName: $firstName.val(),
            lastName: $lastname.val(),
            email: $email.val(),
            age: $age.val(),
            password: $password.val(),
            roles : roles
        }

        fetch('http://localhost:8080/admin/save',{
            method: 'POST',
            body: JSON.stringify(data),
            headers:{"Content-type": "application/json; charset=UTF-8"}
        })
    })


})
