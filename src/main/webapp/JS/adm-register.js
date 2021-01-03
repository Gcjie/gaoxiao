function admRegister() {
    var oUname = document.getElementById("name")
    var oError = document.getElementById("error_box")
    var opassword = document.getElementById("password")
    var opassword2 = document.getElementById("password2")
    oError.innerHTML = "<br>"
    if(oUname.value.length<6||oUname.value.length>12){
        oError.innerHTML="用户名需为6-12位";
        return;
    }

    else if ((oUname.value.charCodeAt(0)>=48) && oUname.value.charCodeAt(0)<=57){
        oError.innerHTML="首字母不能是数字";
        return;

    }
    else for(var i=0;i<oUname.value.length;i++){
            if((oUname.value.charCodeAt(i)<48||oUname.value.charCodeAt(i)>57) && (oUname.value.charCodeAt(i)<97)||oUname.value.charCodeAt(i)>122){
                oError.innerHTML="只能包含字母和数字";
                return;
            }
        }
    if(opassword.value.length<6||opassword.value.length>12){
        oError.innerHTML="密码需为6-12位";
        return;
    }
    if(opassword2.value!=opassword.value){
        oError.innerHTML="密码不一致";
        return;
    }
    window.alert("注册成功！")
}