document.getElementById("GetPersons").onclick = function(){
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

 document.getElementById("hobbyb").onclick = function(){
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
    
     document.getElementById("cityb").onclick = function(){
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


document.getElementById("phoneb").onclick = function(){
     let value = document.getElementById("phone").value;
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

function GetAllZipCodes(){
        fetch("/jpareststarter/api/person/zipcodes").then( res => res.json()).then(data =>{
        let zipcodes = data;
        let table = document.getElementById('table');
        clearTable();
        for(i = 0; i < zipcodes.length; i++ ){
                var row = `<table class="table" id="table2">
                <thead class="thead-dark">
                    <th scope="col">Zipcode</th>
                    <th scope="col">City</th>
                </thead>
                <tbody>
                        <tr> 
                        <td>${zipcodes[i].adress.cityinfo.zipCode}</td>
                        <td>${zipcodes[i].adress.cityinfo.city}</td>
                         </tr>
                </tbody>        
            `;
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
    



document.getElementById("CreateUser").onclick = function() {
  var x = document.getElementById('myDIV');
  if (x.style.visibility === 'hidden') {
    x.style.visibility = 'visible';
  } else {
    x.style.visibility = 'hidden';
  }
}


document.getElementById("populate").onclick = function(){
        fetch("/jpareststarter/api/person/").then( res => res.json()).then(data =>{
        let hobby = data;
        let table = document.getElementById('dropdown');
        
        for(i = 0; i < hobby.length; i++ ){
                var row = `
                        <button class="dropdown-item" type="button">${hobby[i].hobbies[0].name}</button>
                        `;
            table.innerHTML += row;
        };
    });
    }