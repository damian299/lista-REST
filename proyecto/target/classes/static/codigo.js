
const aplication = document.querySelector(".container");




fetch('http://localhost:8080/products')
  .then(response => response.json())
  .then(json => console.log(json))