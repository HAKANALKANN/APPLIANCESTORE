document.addEventListener("DOMContentLoaded", function () {
    
    document.getElementById("categoryEkle").addEventListener("click", function () {
      
      var name = document.getElementById("name").value;
     r
      fetch("http://localhost:8080/api/categories", {
        method: "POST",
        headers: getDefaultHeaders(),
        body: JSON.stringify({ name: name }),
      })
        .then((response) => response.json())
        .then(() => {
       
          document.getElementById("name").value = "";
  
        })
        .catch((error) => {
          console.error("Error:", error);
        });
    });
  });
  document.addEventListener("DOMContentLoaded", function () {
  document.getElementById("categoriGüncelle").addEventListener("click", function () {
   
    var name = document.getElementById("name").value;
    var id = document.getElementById("id").value;
   
    fetch("http://localhost:8080/api/categories", {
      method: "PUT",
      headers: getDefaultHeaders(),
      body: JSON.stringify({ name: name }),
      body: JSON.stringify({ id: id }),
    })
      .then((response) => response.json())
      .then(() => {
      
        document.getElementById("name").value = "";
        document.getElementById("id").value = "";
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  });
});
document.addEventListener("DOMContentLoaded", function () {
  document.getElementById("kategoriSil").addEventListener("click", function () {
    
    var id = document.getElementById("id").value;
   
    fetch("http://localhost:8080/api/categories", {
      method: "DELETE",
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
  document.getElementById("ürünEkle").addEventListener("click", function () {
   
    var categoriesId = document.getElementById("categoriesId").value;
    var name = document.getElementById("name").value;
    var quantity = document.getElementById("quantity").value;
    var description = document.getElementById("description").value;
    var price = document.getElementById("price").value;

   
    fetch("http://localhost:8080/api/products", {
      method: "POST",
      headers: getDefaultHeaders(),
      body: JSON.stringify({ categoriesId: categoriesId }),
      body: JSON.stringify({ name: name }),
      body: JSON.stringify({ quantity: quantity }),
      body: JSON.stringify({ description: description }),
      body: JSON.stringify({ price: price }),
    })
      .then((response) => response.json())
      .then(() => {
       
        document.getElementById("categoriesId").value = "";
        document.getElementById("name").value = "";
        document.getElementById("quantity").value = "";
        document.getElementById("description").value = "";
        document.getElementById("price").value = "";
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  });
});
document.addEventListener("DOMContentLoaded", function () {
  document.getElementById("urunSil").addEventListener("click", function () {
   
    var id = document.getElementById("id").value;
    
    fetch("http://localhost:8080/api/products", {
      method: "DELETE",
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
  document.getElementById("urunGüncelle").addEventListener("click", function () {
    
    var categoriesId = document.getElementById("categoriesId").value;
    var id = document.getElementById("id").value;
    var name = document.getElementById("name").value;
    var quantity = document.getElementById("quantity").value;
    var description = document.getElementById("description").value;
    var price = document.getElementById("price").value;

    
    fetch("http://localhost:8080/api/products", {
      method: "PUT",
      headers: getDefaultHeaders(),
      body: JSON.stringify({ categoriesId: categoriesId }),
      body: JSON.stringify({ id: id }),
      body: JSON.stringify({ name: name }),
      body: JSON.stringify({ quantity: quantity }),
      body: JSON.stringify({ description: description }),
      body: JSON.stringify({ price: price }),
    })
      .then((response) => response.json())
      .then(() => {
        
        document.getElementById("categoriesId").value = "";
        document.getElementById("id").value = "";
        document.getElementById("name").value = "";
        document.getElementById("quantity").value = "";
        document.getElementById("description").value = "";
        document.getElementById("price").value = "";
      })
      .catch((error) => {
        console.error("Error:", error);
      });
  });
});
