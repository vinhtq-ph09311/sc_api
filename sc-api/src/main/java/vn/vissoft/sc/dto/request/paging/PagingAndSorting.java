package vn.vissoft.sc.dto.request.paging;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import lombok.Data;
import vn.vissoft.sc.config.StringConstant;

@Data
public class PagingAndSorting {
    private int pageIndex;
    private int pageSize;
    private String sortField;
    private String sortOrder;
    private String keyword;

    public PagingAndSorting(int pageIndex, int pageSize, String sortField, String sortOrder, String keyword) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.sortField = sortField;
        this.sortOrder = sortOrder;
        this.keyword = keyword;
    }

    public Pageable createPageable() {
        if(sortField != null && sortOrder != null && !sortField.equals("null") && !sortOrder.equals("null")) {
            Sort sort = Sort.by(sortField);
            sort = StringConstant.SORT_ASC.equalsIgnoreCase(sortOrder) ? sort.ascending() : sort.descending();
            return PageRequest.of(pageIndex - 1, pageSize, sort);
        } else {
            return PageRequest.of(pageIndex - 1, pageSize);
        }
    }

}
