const start = document.querySelector('.start');
const map = document.getElementById('map');
const login_Btn = document.getElementById('login_Btn');

const bottomMenu = document.getElementsByClassName('bottomMenu');
// start.addEventListener('mouseover', function(e){
//     console.log("dnl");
// });

start.addEventListener('click', ddd);
login_Btn.addEventListener('click', qqq);


for(let i=0; i < bottomMenu.length; i++){

    bottomMenu[i].addEventListener('mouseover', ccc);
    bottomMenu[i].addEventListener('mouseout', bbb);
}

function ddd(e){

    if(map.style.display == ""){

        map.style.display = 'block';
    }else{
        map.style.display = "";
    }
}

function ccc(e) {
//	console.log(document.querySelector('.backgroundImg').style);
	document.querySelector('.backgroundImg').style.backgroundImage = `url(${getContextPath()}/resources/asset/back3.jpg)`;
    e.target.style.color = 'orangered';
}

function bbb(e) {
    e.target.style.color = 'blanchedalmond';
}

function qqq(e) {
    location.href = `${getContextPath()}/resources/naverLogin/naverLogin.html`;
}
