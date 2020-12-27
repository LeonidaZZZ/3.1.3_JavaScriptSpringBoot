function roleCreator(selector){
    let roles = $(selector).val()
    let roleID
    if (roles[0] === 'ROLE_ADMIN'){
        roleID = 2
    } else {
        roleID = 1
    }

    if (roles.length > 1){
        roles =[{   id: 2,
            name: roles[0]},
            {   id:1,
                name: roles[1]},]
    } else {
        roles =[{   id: roleID,
            name: roles[0]}]
    }

    return roles
}