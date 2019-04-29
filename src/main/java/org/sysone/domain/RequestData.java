package org.sysone.domain;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RequestData {

    @Size(min = 1, max = 10485760)
    @Pattern(regexp="[a-zA-Z]+")
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
