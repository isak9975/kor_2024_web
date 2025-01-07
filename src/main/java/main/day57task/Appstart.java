package main.day57task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // *MVC 관련 컴포넌트(클래스)들을 스캔해서 등록처리한다.
                            // 그래서 항상 앞에 있어야 한다 (상위폴더)
                                // Component 를 제외한

public class Appstart {
    public static void main(String[] args) {
        SpringApplication.run(Appstart.class);
    }//end main
}//end class
