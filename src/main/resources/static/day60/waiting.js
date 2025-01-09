

function register(){console.log('register 시작');

    const number = document.querySelector(".numberInput").value;
    const count = document.querySelector(".countInput").value;
    
    const person = {number : number, count:count};
    
    const option = {method :"POST",
                    headers : {'Content-Type':'application/json'},
                    body : JSON.stringify(person)};
    
        fetch("/register.do",option)
        .then(r => r.json())
        .then(d=>{console.log(d);
                  if(d==true){alert('대기 등록에 성공하였습니다');
                              document.querySelector(".numberInput").value = "";
                              document.querySelector(".countInput").value = "";
                                }
                              else{alert('회원가입에 실패했습니다')}
                                })
        .then(e=>console.log(e))
    
    
    } //end register
    
    
    
    function total(){{console.log('total 시작');

        fetch("/total.do")
        .then(r=>r.json())
        .then(d=>{

            const  totalview = document.querySelector('.totalview');

            let HTML ='';
            
            
            d.forEach(

                item=>{
                    
                      HTML += `<hr/><div>
                      <h2><b> 대기번호 : ${item.no} 번 </b></h2>
                      <p> 전화번호 : ${item.number} <p>
                      <p> 대기 인원수 : ${item.count} 명<p>
                      </div>`;
                    console.log(item.no,item.number,item.count + "출력")
                    totalview.innerHTML= HTML;
                }
            
            )})  


        .then(e=>console.log(e))

        



    }
    }//end total