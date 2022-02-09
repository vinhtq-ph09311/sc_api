package vn.vissoft.sc.exception;

import vn.vissoft.sc.dto.response.Response;

public class CommonException extends RuntimeException {

    private final Response response;
    private final String message;

    public CommonException(Response response, String message) {
        super(message);
        this.response = response;
        this.message = message == null ? response.getResponseMessage() : message;
    }

    public CommonException(Response response) {
        super(response.getResponseMessage());
        this.response = response;
        this.message = response.getResponseMessage();
    }

    public CommonException(String responseCode, String message) {
        super(message);
        this.response = Response.fromCode(responseCode);
        this.message = message == null ? response.getResponseMessage() : message;
    }

    public Response getResponse() {
        return response;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
