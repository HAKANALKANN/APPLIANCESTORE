function register() {
    const formData = {
        email: document.getElementById('email').value,
        firstName: document.getElementById('firstName').value,
        lastName: document.getElementById('lastName').value,
        password: document.getElementById('password').value,
        street: document.getElementById('street').value,
        buildingName: document.getElementById('buildingName').value,
        city: document.getElementById('city').value,
        state: document.getElementById('state').value,
        country: document.getElementById('country').value,
        pincode: document.getElementById('pincode').value
    };

    console.log('Form verileri alındı: ', formData);

    fetch('http://localhost:8080/api/auth/register', {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(formData)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Kayıt işlemi başarısız. Durum kodu: ' + response.status);
        }
        return response.json();
    })
    .then(data => {
        console.log('Kayıt işlemi başarılı. Sunucu tarafından dönen veri: ', data);
        
        window.location.href = '../index.html';
    })
    .catch(error => {
        console.error('Hata:', error);
        
        alert('Kayıt işlemi sırasında bir hata oluştu. Lütfen tekrar deneyin.' + error.message);
    });
}