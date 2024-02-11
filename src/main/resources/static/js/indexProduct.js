document.addEventListener("DOMContentLoaded", function () {

    const fileInput = document.getElementById('hiddenFileInput');
    document.querySelectorAll('.product-img-change-btn').forEach(button => {
        button.addEventListener('click', function() {
            const productRow = this.closest('tr');
            fileInput.onchange = function() {
                const file = fileInput.files[0];
                if (file) {
                    const reader = new FileReader();
                    reader.onload = function(e) {
                        const base64Image = e.target.result;
                        productRow.querySelector('.product-img').src = base64Image;
                    };
                    reader.readAsDataURL(file);
                }
            };
            fileInput.click();
        });
    });

    const modifyButtons = document.querySelectorAll('.productModify-Btn');
    modifyButtons.forEach(button => {
        button.addEventListener("click", function () {
            const productRow = this.closest('tr');
            const ProductObjcet = PackJsonObject(productRow);
            alert(ProductObjcet.proid);
            ModifyProductEvent_Ajax(ProductObjcet);
        });
    });
});

function PackJsonObject(productRow){

    const ID = productRow.querySelector(".productId").innerText;
    const Name = productRow.querySelector(".productName").innerText;
    const Category = productRow.querySelector(".productCategory").innerText;

    let proImageElement = productRow.querySelector(".product-img");
    let proImage = proImageElement ? proImageElement.src.replace(/^data:image\/jpeg;base64,/, "") : "";

    const productPrice = productRow.querySelector(".productPrice").innerText;
    const productStock = productRow.querySelector(".productStock").innerText;
    const productDescription = productRow.querySelector(".productDescription").innerText;

    const ProductObjcet = {
        proid : ID,
        proname : Name,
        procategory : Category,
        proimage: proImage,
        proprice : parseFloat(productPrice),
        prostock : parseInt(productStock, 10),
        prodescription : productDescription
    }

    return ProductObjcet;
}

function ModifyProductEvent_Ajax(ProductObjcet) {
    $.ajax({
        url: '/Products/insert/' + ProductObjcet.proid,
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(ProductObjcet),
        dataType: 'json',
        success: function(response) {
            console.log('Product updated with ID:', response);
        },
        error: function(xhr, status, error) {
            console.error('Error updating product:', xhr.statusText);
        }
    });
}