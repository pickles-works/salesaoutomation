package jp.co.pickles.salesautomation.application;

import jp.co.pickles.salesautomation.infrastructure.HogeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HogeUseCase {

    @Autowired
    private HogeRepository repository;

    public HogeUseCase(HogeRepository repository) {
        this.repository = repository;
    }

    public String execute() {
        return null;
    }
}
