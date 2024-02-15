<!--  修改按鈕事件  -->
function modifyEvent(button) {
    // const productRow = button.closest('tr');
    const CurrentObject = button.closest('tr');
    const Object = PackJsonObject(CurrentObject);
    alert(JSON.stringify(Object));
    Modify_Member_Ajax(Object);
}

function Modify_Member_Ajax(CurrentObject) {
    $.ajax({
        url: '/members/insert/' + CurrentObject.memberid,
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(CurrentObject),
        dataType: 'json',
        success: function (response) {
            console.log('Product updated with ID:', response);
        },
        error: function (xhr, status, error) {
            console.error('Error updating product:', xhr.statusText);
        }
    });
}
function PackJsonObject(Object) {
    // const ID = productRow.querySelector(".productId").innerText;
    // const name = productRow.querySelector(".product-img").src.replace(/^data:image\/jpeg;base64,/, "");

    const ID = Object.querySelector("#ID").innerText;
    const account = Object.querySelector("#account").innerText;
    const password = Object.querySelector("#password").innerText;
    const name = Object.querySelector("#name").innerText;
    const email = Object.querySelector("#email").innerText;
    const birthday = Object.querySelector("#birthday").innerText;
    const phonenumber = Object.querySelector("#phonenumber").innerText;
    const otherphonenumber = Object.querySelector("#otherphonenumber").innerText;
    const homenumber = Object.querySelector("#homenumber").innerText;
    const gender = Object.querySelector("#gender").innerText;
    const avatar = Object.querySelector("#avatar").src.replace(/^data:image\/jpeg;base64,/, "");
    const createtime = Object.querySelector("#createtime").innerText;
    const updatedtime = Object.querySelector("#updatedtime").innerText;
    const lastonlinetime = Object.querySelector("#lastonlinetime").innerText;

    return {
        memberid: ID,
        account: account,
        password: password,
        name: name,
        email: email,
        birthday: birthday,
        phonenumber: phonenumber,
        otherphonenumber: otherphonenumber,
        homenumber: homenumber,
        gender: gender,
        avatar : avatar,
        createtime: createtime,
        updatedtime: updatedtime,
        lastonlinetime: lastonlinetime
    };
}


