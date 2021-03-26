document.getElementById("GetPersons").onclick = function(){
        fetch("/ca2/api/person/").then( res => res.json()).then(data =>{
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
    fetch("/ca2/api/person/hobby/"+value).then( res => res.json()).then(data =>{
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
    fetch("/ca2/api/person/city/"+value).then( res => res.json()).then(data =>{
    let city = data;
    clearTable();
    for(i = 0; i < city.length; i++ ){
                var row = `<tr> 
                        <td>${city[i].id}</td> 
                        <td>${city[i].firstName}</td> 
                        <td>${city[i].lastName}</td>
                        <td>${city[i].email}</td>
                        <td>${city[i].phoneInfomation[0].number}</td>
                        <td>${city[i].hobbies[0].name}</td>
                        <td>${city[i].adress.cityinfo.zipCode}</td>
                        <td>${city[i].adress.cityinfo.city}</td>
                         </tr>`;
            table.innerHTML += row;
        };
    });
    }


document.getElementById("phoneb").onclick = function(){
     let value = document.getElementById("phone").value;
    fetch("/ca2/api/person/phone/"+value).then( res => res.json()).then(data =>{
    let phone = data;
    clearTable();
    for(i = 0; i < phone.length; i++ ){
                var row = `<tr> 
                        <td>${phone[i].id}</td> 
                        <td>${phone[i].firstName}</td> 
                        <td>${phone[i].lastName}</td>
                        <td>${phone[i].email}</td>
                        <td>${phone[i].phoneInfomation[0].number}</td>
                        <td>${phone[i].hobbies[0].name}</td>
                        <td>${phone[i].adress.cityinfo.zipCode}</td>
                        <td>${phone[i].adress.cityinfo.city}</td>
                         </tr>`;
            table.innerHTML += row;
        };
    });
    }

document.getElementById("zipcodeb").onclick = function(){
        fetch("/ca2/api/cityinfo").then( res => res.json()).then(data =>{
        let zipcodes = data;
        let table = document.getElementById('table-zip');
        clearTable();
        for(i = 0; i < zipcodes.length; i++ ){
                var row = `
                        <tr> 
                        <td>${zipcodes[i].zipCode}</td>
                        <td>${zipcodes[i].city}</td>
                         </tr>
                       
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


document.getElementById("hobbies").onclick = function(){
        fetch("/ca2/api/person/").then( res => res.json()).then(data =>{
        let hobby = data;
        let table = document.getElementById('dropdown');
        
        for(i = 0; i < hobby.length; i++ ){
                var row = `
                        <option value="${hobby[i].hobbies[0].name}">${hobby[i].hobbies[0].name}</option>
                        `;
            table.innerHTML += row;
        };
    });
    }