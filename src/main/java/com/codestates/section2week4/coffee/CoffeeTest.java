package com.codestates.section2week4.coffee;

import com.codestates.section2week4.DependencyConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class CoffeeTest {
    public static void main(String[] args) {
        // 직접 DependencyConfig 객체를 생성해서 의존성을 주입하여 객체를 생성 방식
//        DependencyConfig dependencyConfig = new DependencyConfig();
//        CoffeeService coffeeService = dependencyConfig.coffeeService();

        // 스프링 컨테이너에 등록된 Bean을 가져와서 객체를 생성하는 방식
        ApplicationContext ac = new AnnotationConfigApplicationContext(DependencyConfig.class);
        CoffeeService coffeeService = ac.getBean("coffeeService", CoffeeService.class);

        Coffee coffee = new Coffee(0L, "아이스 아메리카노", "Ice Americano", 4000);
        coffeeService.createCoffee(coffee);

        if(coffeeService.getCoffee(0L).getKorName().equals(coffee.getKorName())) {
            System.out.println("아이스 아메리카노가 등록되었습니다.");
        }

        coffeeService.editCoffee(0L, "아이스 아메리카노", 4500);

        if(coffeeService.getCoffee(0L).getPrice() == 4500) {
            System.out.println("아이스 아메리카노의 금액이 정상적으로 변경되었습니다.");
        }

        coffeeService.deleteCoffee(0L);

        if(coffeeService.getCoffee(0L) == null) {
            System.out.println("아이스 아메리카노가 정상적으로 삭제되었습니다.");
        }
    }
}
