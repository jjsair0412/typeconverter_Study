package hello.typeconverter.controller;

import hello.typeconverter.type.IpPort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HelloController {

    // 숫자타입으로 변경하는 예
    @GetMapping("/hello-v1")
    public String helloV1(HttpServletRequest request){
        String data = request.getParameter("data"); // 문자타입 조회
        Integer intValue = Integer.valueOf(data); // 숫자타입으로 변경
        System.out.println("intValue = " + intValue);
        return "ok";
    }

    // 그래서 스프링에서는 RequestParam을 통해 요청파라미터를 받아준다.
    @GetMapping("/hello-v2")
    public String helloV2(@RequestParam Integer data){
        System.out.println("data = " + data);
        return "ok";
    }

    @GetMapping("/ip-port")
    public String ipPort(@RequestParam IpPort ipPort){
        System.out.println("ipPort Ip= " + ipPort.getIp());
        System.out.println("ipPort Port = " + ipPort.getPort());
        // uri : ip-port?ipPort=127.0.0.1:8080
        // 결과 : StringToIpPortConverter 컨버터가 작동한다.
        // converter source=127.0.0.1:8080
        // ipPort Ip= 127.0.0.1
        // ipPort Port = 8080
        return "ok";
    }


}
