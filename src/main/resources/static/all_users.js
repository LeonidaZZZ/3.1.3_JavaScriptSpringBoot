$(document).ready(function (){
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/admin/userList',
        dataType: 'JSON',
        contentType: 'application/json',
        success: function (data){

            console.log(data[0].roles[0].name)

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
                tr.push('<td><button type="button" class="btn btn-info" data-toggle="modal">' + 'Edit' + '</button></td>');
                tr.push('<td><button type="button" class="btn btn-danger" data-toggle="modal" >' + 'Delete' + '</button></td>');
                tr.push('</tr>');
            }

            $('#all_users_table').append($(tr.join('')))
        }
    })
    $.ajax({
        type: 'GET',
        url: 'http://localhost:8080/admin/auth',
        dataType: 'JSON',
        contentType: 'application/json',
        success: function (data){
            console.log(data);
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
        }
    })

})
