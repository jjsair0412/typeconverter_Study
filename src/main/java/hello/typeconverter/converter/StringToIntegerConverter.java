package hello.typeconverter.converter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

// 가장 단순한 String을 Integer로 바꾸는 예제
@Slf4j
public class StringToIntegerConverter implements Converter<String, Integer> { //String을 Integer로
    @Override
    public Integer convert(String source) { // 문자를 받아서 숫자로바꾸는 컨버터 생성완료
        log.info("convert source={}", source);
        Integer integer = Integer.valueOf(source);
        return integer; // String source를 Integer로 변경
    }
}
