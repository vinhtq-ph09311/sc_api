package vn.vissoft.sc.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import vn.vissoft.sc.exception.CommonException;

@Getter
@Setter
@NoArgsConstructor
public class ResponseBody {

    @JsonProperty("response_code")
    private String responseCode;
    @JsonProperty("response_message")
    private String responseMessage;
    @JsonProperty("response_data")
    private Object responseData;

    public ResponseBody(Response response, Object data) {
        this.responseCode = response.getResponseCode();
        this.responseMessage = response.getResponseMessage();
        this.responseData = data;
    }

    public ResponseBody(CommonException e, Object data) {
        this.responseCode = e.getResponse().getResponseCode();
        this.responseMessage = e.getResponse().getResponseMessage();
        this.responseData = data;
    }

    public ResponseBody(Response response) {
        this.responseCode = response.getResponseCode();
        this.responseMessage = response.getResponseMessage();
    }

    public ResponseBody(Response response, String responseMessage, Object data) {
        this.responseCode = response.getResponseCode();
        this.responseMessage = responseMessage;
        this.responseData = data;
    }

    public ResponseBody(String responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public ResponseBody(String responseCode, String responseMessage, Object data) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.responseData = data;
    }

}
