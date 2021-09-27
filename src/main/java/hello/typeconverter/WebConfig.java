package hello.typeconverter;

import hello.typeconverter.converter.IntegerToStringConverter;
import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
// WebMvcConfigurer를 implements해준다.
public class WebConfig implements WebMvcConfigurer {
    @Override
    // 스프링설정파일에 addFormatters를 사용해서 컨버터를 등록한다.
    // 스프링은 내부에서 ConversionService를 제공하기 때문에
    // registry.addConverter를 이용해 스프링 설정파일에서 똑같이 등록해주면 된다.
    public void addFormatters(FormatterRegistry registry) {
        // 주석처리 우선순위
//        registry.addConverter(new StringToIpPortConverter());  //포맷터 예제에서 컨버터 추가해준것들 다 삭제해서 블로깅하자.
//        registry.addConverter(new IpPortToStringConverter());
        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIntegerConverter());

        // 포맷터 추가
        registry.addFormatter(new MyNumberFormatter());
    }
}
