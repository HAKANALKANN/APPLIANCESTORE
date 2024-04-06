function submitForm() {
  const email = document.getElementById("email").value;
  const password = document.getElementById("password").value;

  
  if (!validateEmail(email)) {
    alert("Geçerli bir e-posta adresi giriniz.");
    return;
  }

  fetch("http://localhost:8080/api/auth/login", {
    method: "POST",
    body: JSON.stringify({
      email: email,
      password: password,
    }),
    headers: {
      "Content-type": "application/json; charset=UTF-8",
    },
  })
  .then((response) => {
    if (!response.ok) {
      throw new Error("Giriş isteği başarısız. Durum kodu:" + response.status);
    }
    
    return response.json();
  })
  .then((data) => {
    localStorage.setItem("jwtToken", data.token);
    const role = parseJwt(data.token);
    redirectToPageByRole(role);
  })
  .catch((error) => {
    console.error("Hata:", error);
    alert("Giriş yapılırken bir hata oluştu. Lütfen tekrar deneyiniz."+error);
  });
}

function parseJwt(token) {
  try {
    const base64Url = token.split('.')[1];
    const base64 = base64Url.replace(/-/g, '+').replace(/_/g, '/');
    const jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
        return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
    }).join(''));
    const decodedData = JSON.parse(jsonPayload); 
    return decodedData.authorities[0].authority; 
  } catch (error) {
    console.error("JWT ayrıştırılırken bir hata oluştu:", error);
    return null;
  }
}

function redirectToPageByRole(role) {
  if (role === "ROLE_USER") {
    window.location.href = "../index.html";
  } else if (role === "ROLE_ADMIN") {
    window.location.href = "admin_kategori_ürün.html";
  } else {
    window.location.href = "../index.html"; 
  }
}

function validateEmail(email) {
 
  const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
  return regex.test(email);
}