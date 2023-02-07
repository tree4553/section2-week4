package com.codestates.section2week4.singleton;

public class SingletonService {

    // static 영역에 객체를 생성
    private static final SingletonService instance = new SingletonService();

    // get 함수를 통해야만 객체에 접근할수 있도록 한다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 생성자를 private 으로 만들어서 외부에서 객체를 생성할 수 없게 한다.
    private SingletonService() {}
}
