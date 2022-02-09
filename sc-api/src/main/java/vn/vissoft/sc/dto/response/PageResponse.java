package vn.vissoft.sc.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import java.util.List;

@Data
public class PageResponse<T> {

    @JsonProperty("total_element")
    private long totalElement;
    private List<T> data;

    public PageResponse(PageImpl<T> page) {
        this.totalElement = page.getTotalElements();
        this.data = page.getContent();
    }

    public PageResponse(Page<T> page) {
        this.totalElement = page.getTotalElements();
        this.data = page.getContent();
    }

}
