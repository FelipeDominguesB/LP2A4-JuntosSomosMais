
let queryObject = {
    size: 5,
    index: 0,
    type: "NONE",
    region: "NONE",
}
let path = 'http://localhost:9090/api/insumos/'
let query = '';



document.querySelectorAll('input').forEach(input =>{
    input.addEventListener('change', () =>{
        queryObject[input.name] = input.value;
        queryObject.index = 0;
        search();
    })
});

document.querySelector('select').addEventListener('change', (event) =>{
    queryObject.size = Number(event.target.value);
    search();
});

document.getElementById('prev').addEventListener('click', () =>{
    queryObject.index -= 1;
    search();
});

document.getElementById('next').addEventListener('click', () =>{
    queryObject.index += 1;
    search();
});

function buildQueryString()
{
    query = '?';
    query += ('size=' + queryObject.size); 
    query += ('&index=' + queryObject.index);
    query += (queryObject.type === "NONE" ? '' : ('&type='+ queryObject.type));
    query += (queryObject.region === "NONE" ? '' : ('&region='+ queryObject.region));
}

search();


function search()
{
    buildQueryString();
    fetch(path + query)
    .then((response) => response.json())
    .then((data) => {
        document.querySelector('.content').innerHTML = '';
        document.querySelector('#pageInfo').innerHTML = (data.pageNumber+1) + ' de ' + (data.totalPages);

        document.getElementById('prev').disabled = (data.pageNumber == 0);
        document.getElementById('next').disabled = (data.pageNumber+1 == data.totalPages);

        data.results.forEach(person => createCard(person));
    });
}


function createCard(person)
{
    let cardDiv = document.createElement('div');
    cardDiv.className = 'content-card';

    let img = document.createElement('img');
    img.src = person.pictureInfo.large;

    let cardText = document.createElement('div');
    cardText.className = 'card-text';

    let lblName = document.createElement('label');
    lblName.innerHTML = person.name.first + ' ' + person.name.last;
    
    let lblAddress = document.createElement('label');
    lblAddress.innerHTML = person.location.street;
    
    let lblCity = document.createElement('label');
    lblCity.innerHTML = person.location.city;
    
    let lblStateAndZipCode = document.createElement('label');
    lblStateAndZipCode.innerHTML = person.location.state + ' - ' + person.location.postcode;

    cardText.appendChild(lblName);
    cardText.appendChild(lblAddress);
    cardText.appendChild(lblCity);
    cardText.appendChild(lblStateAndZipCode);

    cardDiv.appendChild(img);
    cardDiv.appendChild(cardText);

    
    
    document.querySelector('.content').appendChild(cardDiv);
}