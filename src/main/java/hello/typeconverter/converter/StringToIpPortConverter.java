package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class StringToIpPortConverter implements Converter<String, IpPort> {
    @Override
    public IpPort convert(String source) {
      log.info("converter source={}",source);
      // 127.0.0.1:8080 이라는 문자가 들어옴
        String[] split = source.split(":");
        String ip = split[0]; // :을 기준으로 앞이 ip주소, 뒤가 포트번호
        int port = Integer.parseInt(split[1]);
        return new IpPort(ip,port); // ip주소는 String으로, port번호는 숫자로
    }
}
