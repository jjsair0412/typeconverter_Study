package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class IpPortToStringConverter implements Converter<IpPort,String > {
    @Override
    public String convert(IpPort source) {
        log.info("converter source = {}",source);
        // IpPort 객체를 127.0.0.1:8080 이라는 객체로 변환시켜주어야 한다.
        return source.getIp() + ":" + source.getPort();
    }
}
