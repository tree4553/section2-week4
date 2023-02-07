package com.codestates.section2week4.coffee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// AutoDependencyConfig에서 @ComponentScan을 통해 CoffeeService 클래스를 Bean으로 등록하기 위해 @Component 입력
@Component
public class CoffeeService {

    // DI 미적용
    //private static CoffeeRepository coffeeRepository = new CoffeeRepository();

    private final CoffeeRepository coffeeRepository;

    // CoffeeRepository를 의존하는 CoffeeService 생성자의 Bean 등록과 의존 관계 자동 주입을 위해 @Autowired 입력
    @Autowired
    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public void createCoffee(Coffee coffee) {
        coffeeRepository.postCoffee(coffee);
    }

    public Coffee editCoffee(Long coffeeId, String korName, int price) {
        return coffeeRepository.patchCoffee(coffeeId, korName, price);
    }

    public Coffee getCoffee(Long coffeeId) {
        return coffeeRepository.getCoffee(coffeeId);
    }

    public void deleteCoffee(Long coffeeId) {
        coffeeRepository.deleteCoffee(coffeeId);
    }
}
