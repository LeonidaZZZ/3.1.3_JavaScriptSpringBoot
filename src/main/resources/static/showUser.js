fetch('http://localhost:8080/users/u')
    .then(response => response.json())
    .then(data => {
        console.log(data)
        let table = ""
        let role1 = data.roles[0].name
        let role2 = data.roles[1].name

        table += ('<tr id="list">')
        table += ('<td>' + data.id + '</td>')
        table += ('<td>' + data.firstName + '</td>')
        table += ('<td>' + data.lastName + '</td>')
        table += ('<td>' + data.age + '</td>')
        table += ('<td>' + data.email + '</td>')
        table += ('<td>' + role1 + ", " + role2 + '</td>')

        table += ('</tr>')

        console.log(table)
        $('#user_table').append(table)
    })
