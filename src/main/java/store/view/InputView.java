package store.view;

import camp.nextstep.edu.missionutils.Console;
import store.vo.Date;

public class InputView {

    public String read() {
        return Console.readLine();
    }

    public Date readDate() {
        return Date.from(read());
    }

}
