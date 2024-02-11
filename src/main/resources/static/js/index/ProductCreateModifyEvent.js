document.addEventListener("DOMContentLoaded", function () {

    const fileInput = document.getElementById('hiddenFileInput');
    const modifyButtons = document.querySelectorAll('.productModify-Btn');
    const UPDataButtons = document.querySelectorAll('.productModify-Btn-UPData');
    let CangeButton = null;

    document.querySelectorAll('.product-img-change-btn').forEach(button => {
        button.addEventListener('click', function() {
            const productRow = this.closest('tr');
            fileInput.onchange = function() {
                const file = fileInput.files[0];
                if (file) {
                    const reader = new FileReader();
                    CangeButton = button;
                    button.style.background = "red";

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


    modifyButtons.forEach(button => {
        button.addEventListener("click", function () {
            const productRow = this.closest('tr');
            const ProductObjcet = PackJsonObject(productRow);

            // alert(ProductObjcet.proid);
            if (CangeButton){
                CangeButton.style.background = "";
            }


            ModifyProductEvent_Ajax(ProductObjcet);

            alert(ProductObjcet.proid + " 更新成功");
        });
    });

// 修改資料事件
    UPDataButtons.forEach(button => {
        button.addEventListener("click", UPDataButtonsEvent);
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

// 修改資料事件
function UPDataButtonsEvent() {
    const productRow = this.closest('tr');
    const tds = productRow.querySelectorAll('td');
    tds.forEach((td, index) => {

        if (index < tds.length - 2) {
            const text = td.innerText;
            td.innerText = '';
            const input = document.createElement('input');
            input.className = "modify-input";
            input.value = text;
            td.appendChild(input);
        }
    });
}