package hello.typeconverter.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Slf4j
// import org.springframework.format.Formatter를 implements한다.
public class MyNumberFormatter implements Formatter<Number> {
    @Override
    // parse는 문자를 객체로 변경한다.
    // 여기선 1,000 요런 문자가 들어오면 Integer 객체로 변경하는 예제이다.
    public Number parse(String text, Locale locale) throws ParseException {
        log.info("text={}, locale={}",text,locale);
        // "1,000"이 들어왓을 때 1000으로 바꾸고싶은경우
        // 중간에 쉼표를 적용하고싶다면 NumberFormat을 이용한다.
        NumberFormat format = NumberFormat.getInstance(locale);
        return format.parse(text);  // 들어온게 숫자로 바뀐다.
    }

    @Override
    // print는 객체를 문자로 변경한다.
    public String print(Number object, Locale locale) {
        log.info("object={}, locale={}",object,locale);
        NumberFormat instance = NumberFormat.getInstance(locale);
        String format = instance.format(object);
        return format;
    }
}
