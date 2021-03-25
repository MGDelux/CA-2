function getAllPersons(){
        fetch("/ca-2/api/person/all").then( res => res.json()).then(data =>{
        console.log("Persons: ",data);
        let persons = data;
        let table = document.getElementById('table-div');
        for(i = 0; i < persons.length; i++ ){
                var row = `<tr> 
                        <td>${persons[i].id}</td> 
                        <td>${persons[i].lastName}</td> 
                        <td>${persons[i].lastName}</td>
                        <td>${persons[i].Email}</td>
                        <td>${persons[i].PhoneNr}</td>
                        <td>${persons[i].Hobby}</td>
                        <td>${persons[i].zipCode}</td>
                        <td>${persons[i].city}</td>
                         </tr>`;
            table.innerHTML += row;
        };
    });
    }

 function filter_Hobby(){
    fetch("/ca-2/api/person/all").then( res => res.json()).then(data =>{
    let persons = data;
    let value = document.getElementById("hobby").value;
    let newPerson = persons.filter((element) => element.make.toLowerCase().match(value));
    for(i = 0; i < newPerson.length; i++ ){
        console.log(newPerson);
                var row = `<tr> 
                        <td>${newPerson[i].id}</td> 
                        <td>${newPerson[i].lastName}</td> 
                        <td>${newPerson[i].lastName}</td>
                        <td>${newPerson[i].Email}</td>
                        <td>${newPerson[i].PhoneNr}</td>
                        <td>${newPerson[i].Hobby}</td>
                        <td>${newPerson[i].zipCode}</td>
                        <td>${newPerson[i].city}</td>
                         </tr>`;
            table.innerHTML += row;
        };
    });
    } 
