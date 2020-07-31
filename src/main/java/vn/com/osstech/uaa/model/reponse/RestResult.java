package vn.com.osstech.uaa.model.reponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Truong Duong on 27/02/2020
 */

@Getter
@Setter
public class RestResult<T> {

    public enum TypeResult {

        SUCCESS, ERROR

    }

    private TypeResult status;

    private List<String> messages;

    private T data;

    private Map<String, String> metadata;

    public void ok() {
        this.status = TypeResult.SUCCESS;
        this.data = data;
        this.messages = new ArrayList<>();
        this.metadata = new HashMap<>();
    }

    public void ok(T data) {
        this.status = TypeResult.SUCCESS;
        this.data = data;
        this.messages = new ArrayList<>();
        this.metadata = new HashMap<>();
    }

    public void fail() {
        this.status = TypeResult.ERROR;
    }

}
