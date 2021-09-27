package hello.typeconverter.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

@Slf4j
public class IntegerToStringConverter implements Converter<Integer, String> {// Integer를 String으로
    @Override
    public String convert(Integer source) {
        log.info("source={}",source);
        return String.valueOf(source); // 숫자를 문자로바꿔서 반환
    }
}
