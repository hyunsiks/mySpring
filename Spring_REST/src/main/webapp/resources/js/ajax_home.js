/**
 * 
 */
const to_print = document.querySelector('#test > h4');

function loadStr(){
	
	//1. 비동기 요청 인스턴스를 생성한다.
	const xhttp = new XMLHttpRequest();
	
	//2. 비동기 요청에 대한 설정을 한다.
//	xhttp.addEventListener('readystatechange', () => {
//		to_print.innerHTML = this.responseText;
//	});
	
	xhttp.onreadystatechange = (e) => {
		
		const target = e.target;
		const readyState = e.target.readyState;
		const httpStatus = e.target.status;
		console.log(target);
		console.log(readyState);
		
		if(httpStatus == 200){
			if(readyState == 1){
				to_print.innerHTML = "서버와 연결됨";
				
			}else if(readyState == 2){
				to_print.innerHTML = "서버가 나의 요청받았습니다";
				
			}else if(readyState == 3){
				to_print.innerHTML = "서버가 요청을 처리중입니다";
				
			}else if(readyState == 4){
				to_print.innerHTML = "서버 요청 처리가 끝난 후 응답이 준비되었습니다";
						
			}else{
				to_print.innerHTML = "뭔가가 잘못되었습니다";
				
			}
		}
	};
	
	xhttp.open('GET', '/rest/sample/getstr', true);
	
	//3. 요청을 보낸다.
	xhttp.send();
}

const sampleAsyncBtn = document.getElementById('sampleAsyncBtn');

const testList = document.getElementById('testList');

sampleAsyncBtn.addEventListener('click', () =>{
	
	const xhttp = new XMLHttpRequest();
	
	//비동기 요청에 대한 상태가 변화할때마다 발생하는 이벤트
	xhttp.addEventListener('readystatechange', (e) =>{
		const target = e.target;
		const status = target.status;
		const readyState = target.readyState;
		
		if(status == 200 && readyState == 4){
			//자바스크립트에서는 아주 쉽게 JSON형식의 문자열을 Object로 변환할 수 있다
			myobj = JSON.parse(target.responseText);
			console.log(myobj);
			
			
			Object.keys(myobj).forEach((key) =>{
				const new_node = document.createElement("li");
				new_node.innerHTML = myobj[key];
				testList.appendChild(new_node);
			});
		}
	});
	
	//비동기 요청의 주소를 설정하는 METHOD와 URI를 설정하는 것
	xhttp.open('GET', '/rest/sample/getSample', true);
	
	xhttp.send();
});



const asyncJsonBtn = document.getElementById('asyncJsonBtn');

asyncJsonBtn.addEventListener('click', ()=>{
	
	console.log("들옴");
	
	const xhttp = new XMLHttpRequest();
	
	xhttp.addEventListener('readystatechange', (e)=>{
		const target = e.target;
		const status = target.status;
		const readyState = target.readyState;
	
		if(status == 200 && readyState ==4){
			to_print.innerHTML = target.responseText;
		}
	
	});
	
	const myFruit = {
		'name': '파인애플',
		'price': 4500,
		'calorie': 800
	};
	
	//GET방식으로 데이터를 보낼 때는 open() 메서드의 URI뒤에 데이터를 붙여서 전송한다.
	//POST방식으로 데이터를 보낼 때는 send() 메서드의 매개변수로 데이터를 전송한다.
	xhttp.open('POST', '/rest/sample/fruit', true);
	
	xhttp.setRequestHeader('content-type', 'application/json;charset=utf-8')
	
	//자바스크립트 오브젝트는 아주 손쉽게 JSON형식 문자열로 변환될 수 있다.
	xhttp.send(JSON.stringify(myFruit));
});















