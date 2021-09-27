package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.assertThat;

public class ConversionServiceTest {
    @Test
    void conversionService(){
        // 먼저 컨버전서비스에 내가 사용할 컨버터를 등록해야 한다.
        // DefaultConversionService()를 이용한다.
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToIntegerConverter()); // addConverter를 이용해서 사용할 컨버터들을 넣어둔다.
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());

        // 등록이 완료됐다면 conversionService를 사용하면 된다.
        Integer result = conversionService.convert("10", Integer.class); // 문자 -> Integer.class
        assertThat(result).isEqualTo(10);
        // 결과 : INFO hello.typeconverter.converter.StringToIntegerConverter - convert source=10
        // 결과를 보면, 문자가 들어왔을 때 Integer.class로 변환해주어야하는걸 컨버전서비스가 혼자 판단해서
        // 아까 등록해놓은 컨버터중에 StringToIntegerConverter()를 사용하는걸 확인할 수 있다.

        assertThat(conversionService.convert(10, String.class)).isEqualTo("10"); // 숫자 -> 문자

        IpPort result2 = conversionService.convert("127.0.0.1:8080", IpPort.class); // 문자 -> 객체
        assertThat(result2).isEqualTo(new IpPort("127.0.0.1",8080));

        String ipPortString = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);// 객체 -> 문자
        assertThat(ipPortString).isEqualTo("127.0.0.1:8080");
    }
}
