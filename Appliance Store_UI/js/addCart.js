document.addEventListener('DOMContentLoaded', function() {
   
    const addToCartBtns = document.querySelectorAll('.addToCartBtn');

   
    addToCartBtns.forEach(function(btn) {
        btn.addEventListener('click', function(event) {
            event.preventDefault(); 

           
            const productName = btn.parentElement.querySelector('h3').textContent;
            const productPrice = parseFloat(btn.parentElement.querySelector('p').textContent.replace('$', ''));

           
            const product = {
                name: productName,
                price: productPrice
               
            };

           n
            addToCart(product);
        });
    });
    
       
function addToCart(product) {
    

   
    fetch('http://localhost:8080/api/carts', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(product)
    })
    .then(response => {
        if (!response.ok) {
            throw new Error('Ürün sepete eklenemedi.');
        }
        return response.json();
    })
    .then(data => {
        console.log('Ürün sepete başarıyla eklendi:', data);
        niz
        alert('Ürün sepete başarıyla eklendi!');
    })
    .catch(error => {
        console.error('Ürün sepete eklenirken bir hata oluştu:', error);
      
        alert('Ürün sepete eklenirken bir hata oluştu. Lütfen daha sonra tekrar deneyin.');
    });
}
        console.log('Ürün sepete eklendi:', product);
    
});