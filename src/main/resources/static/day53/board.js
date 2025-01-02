//(1) 글쓰기 함수
function write(){

    //[1] input 마크업의 입력받은 값 가져오기document.querySelector
        //1. document.querySelector() 함수를 이용하여 (DOM)마크업 객체 가져온다.
    let titleInput = document.querySelector('.titleInput');
    let contentInput = document.querySelector('.contentInput');
    let pwdInput = document.querySelector(`.pwdInput`);
        //2. 가져온 DOM객체의 value 속성 가져온다
    let title = titleInput.value;
    let content = contentInput.value;
    let pwd = pwdInput.value;


    //[2] 입력받은 값들을 객체화
    let board = {title:title,content:content,pwd:pwd};


    //[3] fetch 함수를 이용한 자바에게 입력받은 값 전달하고 응답받기
    const option = {
        method : `POST`,
        Headers : {'Content-Type' : 'application.json'},
        body : JSON.stringify(board)}
        //전송할 객체
        //INPUT 으로 부터 입력받은 값들을JSON 형식의 문자열타입으로 자바에게 전송
    
    fetch(`자바컨트롤러URL`,option)
        .then(response => response.json())
        .then(data => {
            if(data==true){alert(`write success`);}
            else{alert('wirte Fail');}}) // 응답 결과 코드
        .catch(error => console.log(error)); // 오류 결과 코드

    //[4] 응답 결과에 따른 결과 출력

        }//end f




//(2) 글출력 함수
function findAll(){

}//end f