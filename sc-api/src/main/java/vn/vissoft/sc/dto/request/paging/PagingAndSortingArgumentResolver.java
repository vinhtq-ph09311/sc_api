package vn.vissoft.sc.dto.request.paging;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class PagingAndSortingArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter param) {
        return param.getParameterAnnotation(PagingAndSortingParam.class) != null;
    }

    @Override
    public Object resolveArgument(MethodParameter param, ModelAndViewContainer model,
                                  NativeWebRequest request, WebDataBinderFactory binderFactory) {
        Integer pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
        Integer pageSize = Integer.parseInt(request.getParameter("pageSize"));
        String sortField = request.getParameter("sortField");
        String sortOrder = request.getParameter("sortOrder");
        String keyword = request.getParameter("keyword");

        return new PagingAndSorting(pageIndex, pageSize, sortField, sortOrder, keyword);
    }
}
