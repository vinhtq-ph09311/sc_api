package vn.vissoft.sc.dto.response;

import lombok.Getter;
import java.util.HashMap;
import java.util.Map;

@Getter
public enum Response {

    SUCCESS("0000", "Success"),
    MISSING_PARAM("0001", "Missing param required"),
    PARAM_NOT_ACCEPT("0002", "Param type not match or constraint violation"),
    PARAM_NOT_VALID("0003", "Method argument not valid"),
    OBJECT_NOT_FOUND("0004", "Object not found"),
    OBJECT_IS_EXISTS("0005", "Object is exists"),
    NOT_SUPPORT_REQUEST_METHOD("0006", "This method is not support"),
    NOT_SUPPORT_MEDIA_TYPE("0008", "This media type not support"),
    SYSTEM_ERROR("9999", "System error");

    private final String responseCode;
    private final String responseMessage;
    private static final Map<String, Response> ERR_CODE_MAP = new HashMap<>();

    static {
        for (Response response: Response.values()) {
            ERR_CODE_MAP.put(response.getResponseCode(), response);
        }
    }

    Response(String responseCode, String responseMessage) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
    }

    public static Response fromCode(String code) {
        Response response = ERR_CODE_MAP.get(code);
        if (response == null) return Response.SYSTEM_ERROR;
        return response;
    }

}
