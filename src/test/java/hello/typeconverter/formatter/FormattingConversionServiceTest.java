package hello.typeconverter.formatter;

import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.format.support.DefaultFormattingConversionService;

import static org.assertj.core.api.Assertions.assertThat;

public class FormattingConversionServiceTest {

    @Test
    void formattingConversionService() {
        DefaultFormattingConversionService conversionService = new DefaultFormattingConversionService();
        // 컨버터 등록
        conversionService.addConverter(new StringToIpPortConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        // 포멧터 등록
        // addFormatter를 사용해서 포멧터도 등록시켜줄 수 있다.
        // 그니까 컨버터기능에 포멧터기능을 추가시킨거라고 보면 된다.
        conversionService.addFormatter(new MyNumberFormatter());

        // 컨버터 사용
        IpPort ipPort = conversionService.convert("127.0.0.1:8080", IpPort.class);
        assertThat(ipPort).isEqualTo(new IpPort("127.0.0.1", 8080));

        // 포멧터 사용
        // 사용할때는 컨버터와 포멧터를 구분할 필요가 없다. 등록할때만 구분시켜준다.
        assertThat(conversionService.convert(1000,String.class)).isEqualTo("1,000");
        assertThat(conversionService.convert("1,000",Long.class)).isEqualTo(1000L);

    }

}
