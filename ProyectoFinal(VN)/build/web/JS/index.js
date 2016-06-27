$(document).ready(function (){
    if(sessionStorage.getItem("usuario")){
        document.getElementById('login').style.display = 'none';
        document.getElementById('logout').style.display = 'block';
    }else{
         document.getElementById('logout').style.display = 'none';
         document.getElementById('login').style.display = 'block';
    }
});

function logout(){
    sessionStorage.removeItem("usuario");
    window.location.href = "index.html";
}