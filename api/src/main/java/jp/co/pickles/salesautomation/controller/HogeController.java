package jp.co.pickles.salesautomation.controller;

import jp.co.pickles.salesautomation.application.HogeUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HogeController {

    @Autowired
    HogeUseCase useCase;

    public String get() {
//        return new HogeUseCase(new HogeRepository(new Mapper(new Connection("mysql://~~~~~")))).execute();
        return this.useCase.execute();
    }
}
