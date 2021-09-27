package hello.typeconverter.controller;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;

@Controller
public class FormatterController {
    @GetMapping("/formatter/edit")
    public String formatterForm(Model model){
        Form form = new Form();
        form.setNumber(10000);
        form.setLocalDateTime(LocalDateTime.now());
        model.addAttribute("form",form);
        return "formatter-form";
    }

    @PostMapping("/formatter/edit")
    public String formatterEdit(@ModelAttribute Form form, Model model){
        model.addAttribute("form",form);
        return "formatter-view";
    }

    @Data
    static class Form{

        // 해당 포멧의 페턴을 지정해준다.
        // 지정해준 패턴대로 출력되게 된다.
        // 여기선 number가 10000이 들어가게 되면, 10,000 이렇게 출력
        @NumberFormat(pattern = "###,###")
        private Integer number;

        // 년월일 그리고 시간 분 초 가 등록된 패턴에맞게끔 출력
        @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
        private LocalDateTime localDateTime;
    }
}
