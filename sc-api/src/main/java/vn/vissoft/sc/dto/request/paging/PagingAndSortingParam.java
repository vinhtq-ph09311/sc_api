package vn.vissoft.sc.dto.request.paging;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * * @author : VinhTQ
 * use this annotation to get paging and sorting parameter
 */

@Retention(RUNTIME)
@Target(PARAMETER)
public @interface PagingAndSortingParam {

}
