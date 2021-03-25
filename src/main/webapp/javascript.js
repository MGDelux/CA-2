function getAllPersons(){
        fetch("/jpareststarter/api/person/").then( res => res.json()).then(data =>{
        let persons = data;
        let table = document.getElementById('table');
        clearTable();
        for(i = 0; i < persons.length; i++ ){
                var row = `<tr> 
                        <td>${persons[i].id}</td> 
                        <td>${persons[i].firstName}</td> 
                        <td>${persons[i].lastName}</td>
                        <td>${persons[i].email}</td>
                        <td>${persons[i].phoneInfomation[0].number}</td>
                        <td>${persons[i].hobbies[0].name}</td>
                        <td>${persons[i].adress.cityinfo.zipCode}</td>
                        <td>${persons[i].adress.cityinfo.city}</td>
                         </tr>`;
            table.innerHTML += row;
        };
    });
    }

 function filter_Hobby(){
     let value = document.getElementById("hobby").value;
    fetch("/jpareststarter/api/person/"+value).then( res => res.json()).then(data =>{
    let persons = data;
    clearTable();
    for(i = 0; i < persons.length; i++ ){
                var row = `<tr> 
                        <td>${persons[i].id}</td> 
                        <td>${persons[i].firstName}</td> 
                        <td>${persons[i].lastName}</td>
                        <td>${persons[i].email}</td>
                        <td>${persons[i].phoneInfomation[0].number}</td>
                        <td>${persons[i].hobbies[0].name}</td>
                        <td>${persons[i].adress.cityinfo.zipCode}</td>
                        <td>${persons[i].adress.cityinfo.city}</td>
                         </tr>`;
            table.innerHTML += row;
        };
    });
    } 
    
     function filter_city(){
     let value = document.getElementById("city").value;
    fetch("/jpareststarter/api/person/"+value).then( res => res.json()).then(data =>{
    let persons = data;
    clearTable();
    for(i = 0; i < persons.length; i++ ){
                var row = `<tr> 
                        <td>${persons[i].id}</td> 
                        <td>${persons[i].firstName}</td> 
                        <td>${persons[i].lastName}</td>
                        <td>${persons[i].email}</td>
                        <td>${persons[i].phoneInfomation[0].number}</td>
                        <td>${persons[i].hobbies[0].name}</td>
                        <td>${persons[i].adress.cityinfo.zipCode}</td>
                        <td>${persons[i].adress.cityinfo.city}</td>
                         </tr>`;
            table.innerHTML += row;
        };
    });
    }


function clearTable() { 
            var rowCount = table.rows.length;
        for (var i = rowCount - 1; i > 0; i--) {
            table.deleteRow(i);
        }
    }
