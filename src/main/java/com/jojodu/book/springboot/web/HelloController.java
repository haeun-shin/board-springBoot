package com.jojodu.book.springboot.web;

import com.jojodu.book.springboot.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// @RestController: 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어줌.
// @ResponseBody를 각 메소드마다 선언했던 것을 한 번에 사용할 수 있게 해준다고 생각하면 됨.
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String holle() {
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name,
                                     @RequestParam("amount") int amount) {
        return new HelloResponseDto(name, amount);
    }
}
