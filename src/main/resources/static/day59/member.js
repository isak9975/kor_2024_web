console.log("member.js 실행");

//1. signup 메소드 실행
function signup(){console.log("signup 실행");


    //(1) html 의 dom 객체 가져오기
    const midInput = document.querySelector('.midInput')
    const mpwdInput = document.querySelector('.mpwdInput')
    const mnameIntput = document.querySelector('.mnameInput')
    const mphoneIntput = document.querySelector('.mphoneInput')
    
    //(2) 입력값 반환
    const mid = midInput.value;
    const mpwd = mpwdInput.value;
    const mname = mnameIntput.value;
    const mphone = mphoneIntput.value;

    const info = {
        mid : mid, mpwd: mpwd, mname:mname,mphone:mphone}
    

    //(3)fetch
    const option ={
        method : 'POST',
        headers : {'Content-Type' :'application/json'},
        body : JSON.stringify(info)
    }

    fetch('/signup.do',option)
        .then(r => r.json())
        .then(data => {console.log(data);
            if(data==true){   alert('회원가입 성공 했습니다');
                                //회원가입 성공시 로그인 페이지로 이동
                                 location.href="/login"}
                        else{alert('회원가입에 실패했습니다');}})
    
        .then(e=>{console.log(e)})


    //(4) 결과에 따른 화면 구성성



}
//2. login 메소드 실행
function login(){console.log("login 실행");

const mid = document.querySelector('.midInput').value;
const mpwd = document.querySelector('.mpwdInput').value;

fetch(`/login.do?mid=${mid}&mpwd=${mpwd}`)
    .then(r => r.json())
    .then(d=>{console.log(d);
        if(d==true){    
        alert('로그인 성공');
            location.href='/index'
    }else{alert('로그인 실패')}}
)
    .then(r=>console.log(e))


}//end login