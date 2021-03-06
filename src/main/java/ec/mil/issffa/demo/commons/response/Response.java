package ec.mil.issffa.demo.commons.response;


import java.util.ArrayList;
import java.util.List;

public class Response<T> {
    private T result;
    private List<String> errors;

    public Response() {

    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public List<String> getErrors() {
        if (this.errors == null) {
            this.errors = new ArrayList<String>();
        }
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
