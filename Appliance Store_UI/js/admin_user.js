document.addEventListener("DOMContentLoaded", function () {
    
    document.getElementById("kullanıcıEkle").addEventListener("click", function () {
      
      var firstName = document.getElementById("firstName").value;
      var lastName = document.getElementById("lastName").value;
      var email = document.getElementById("email").value;
      var password = document.getElementById("password").value;
      var street = document.getElementById("street").value;
      var buildingName = document.getElementById("buildingName").value;
      var city = document.getElementById("city").value;
      var state = document.getElementById("state").value;
      var country = document.getElementById("country").value;
      var pincode = document.getElementById("pincode").value;

      
      fetch("http://localhost:8080/api/auth/register", {
        method: "POST",
        headers: getDefaultHeaders(),
        body: JSON.stringify({ name: firstName }),
        body: JSON.stringify({ name: lastName }),
        body: JSON.stringify({ name: email }),
        body: JSON.stringify({ name: password }),
        body: JSON.stringify({ name: street }),
        body: JSON.stringify({ name: buildingName }),
        body: JSON.stringify({ name: city }),
        body: JSON.stringify({ name: state }),
        body: JSON.stringify({ name: country }),
        body: JSON.stringify({ name: pincode }),

      })
        .then((response) => response.json())
        .then(() => {
          
          document.getElementById("firstName").value = "";
          document.getElementById("lastName").value = "";
          document.getElementById("email").value = "";
          document.getElementById("password").value = "";
          document.getElementById("street").value = "";
          document.getElementById("buildingName").value = "";
          document.getElementById("city").value = "";
          document.getElementById("state").value = "";
          document.getElementById("country").value = "";
          document.getElementById("pincode").value = "";
  
        })
        .catch((error) => {
          console.error("Error:", error);
        });
    });
  });
  document.addEventListener("DOMContentLoaded", function () {
  document.getElementById("kullanıcıSil").addEventListener("click", function () {
    

    var id = document.getElementById("id").value;
    
    fetch("http://localhost:8080/user/categories", {
      method: "PUT",
      headers: getDefaultHeaders(),
    
      body: JSON.stringify({ id: id }),
    })
      .then((response) => response.json())
      .then(() => {
        
        
        document.getElementById("id").value = "";
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  });
});
document.addEventListener("DOMContentLoaded", function () {
    
    document.getElementById("kullanıcıGüncelle").addEventListener("click", function () {
      
      var userId = document.getElementById("userId").value;
      var firstName = document.getElementById("firstName").value;
      var lastName = document.getElementById("lastName").value;
      var email = document.getElementById("email").value;
      var password = document.getElementById("password").value;
      var street = document.getElementById("street").value;
      var buildingName = document.getElementById("buildingName").value;
      var city = document.getElementById("city").value;
      var state = document.getElementById("state").value;
      var country = document.getElementById("country").value;
      var pincode = document.getElementById("pincode").value;

      
      fetch("http://localhost:8080/api/users", {
        method: "PUT",
        headers: getDefaultHeaders(),
        body: JSON.stringify({ name: userId }),
        body: JSON.stringify({ name: firstName }),
        body: JSON.stringify({ name: lastName }),
        body: JSON.stringify({ name: email }),
        body: JSON.stringify({ name: password }),
        body: JSON.stringify({ name: street }),
        body: JSON.stringify({ name: buildingName }),
        body: JSON.stringify({ name: city }),
        body: JSON.stringify({ name: state }),
        body: JSON.stringify({ name: country }),
        body: JSON.stringify({ name: pincode }),

      })
        .then((response) => response.json())
        .then(() => {
          
          document.getElementById("userId").value = "";
          document.getElementById("firstName").value = "";
          document.getElementById("lastName").value = "";
          document.getElementById("email").value = "";
          document.getElementById("password").value = "";
          document.getElementById("street").value = "";
          document.getElementById("buildingName").value = "";
          document.getElementById("city").value = "";
          document.getElementById("state").value = "";
          document.getElementById("country").value = "";
          document.getElementById("pincode").value = "";
  
        })
        .catch((error) => {
          console.error("Error:", error);
        });
    });
  });
