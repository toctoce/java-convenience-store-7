package store.controller;


import store.dto.Dto;
import store.service.Service;
import store.view.InputView;
import store.view.OutputView;
import store.vo.Date;

public class Controller {

    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    Service service = new Service();

    public Controller(InputView inputView, OutputView outputView, Service service) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.service = service;
    }

    public void run() {
        Date date = createDate();

        Dto dto = service.createSchedule(date);
//        outputView.write(dto.content());
    }

    private Date createDate() {
        return null;
    }
}
