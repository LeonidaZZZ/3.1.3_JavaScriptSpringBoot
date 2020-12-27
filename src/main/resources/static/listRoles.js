function listRoles(data) {

    if (data.roles.length > 1){
        var role = data.roles[0].name + ', ' + data.roles[1].name
    } else {
        var role = data.roles[0].name
    }

    return role;
}