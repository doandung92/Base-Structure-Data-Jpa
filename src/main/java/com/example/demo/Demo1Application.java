package com.example.demo;

import com.example.demo.dto.AddressDto;
import com.example.demo.dto.MemberDto;
import com.example.demo.service.interfaces.AddressService;
import com.example.demo.service.interfaces.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class Demo1Application implements CommandLineRunner {
    private final MemberService memberService;
    private final AddressService addressService;

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }

    @Override
    public void run(String... args) {
        AddressDto namDinh = new AddressDto(1, "Nam Dinh");
        AddressDto haNoi = new AddressDto(2, "Ha Noi");

        addressService.saveAll(List.of(namDinh, haNoi));

        memberService.save(new MemberDto(1, "ABC", namDinh));
        memberService.saveAll(List.of(new MemberDto(2, "CDF", haNoi), new MemberDto(3, "HSD", haNoi)));

        System.out.println(memberService.findByAddress("Ha Noi"));
    }
}
