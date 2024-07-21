//compraDePasaje
function comprarPasaje(){

  let idNumeroVueloInput =document.getElementById("idVuelo").value;
  let nombrePasajeroInput = document.getElementById("idNombre").value;
  let apellidoPasajeroInput = document.getElementById("idApellido").value;
  let dniPasajeroInput = document.getElementById("dni").value;
  let cantPasajesAComprarInput = document.getElementById("cantPasaje").value;

  const requestData = {
    "vid": idNumeroVueloInput,
    "nombre": nombrePasajeroInput,
    "apellido": apellidoPasajeroInput,
    "dni": dniPasajeroInput,
    "cantPasajesComprado": cantPasajesAComprarInput,
  };
 axios
      .post("http://localhost:8080/compraPasaje/comprarVuelo", requestData)
      .then(function(mensaje){
        window.alert(mensaje.data.mensaje);
      })
      .catch(function (error) {
        console.error("Error:", error);
      });
    
};

