package com.rogercw.zuul.server.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.apache.http.protocol.RequestContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author rogercw
 * @date 2020-03-24
 */
@Component
public class LoginZuulFilter extends ZuulFilter {

    private static final Logger logger = LoggerFactory.getLogger(LoginZuulFilter.class);

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String userId = request.getParameter("userId");
        logger.info(String.format("%s >>>> %s", request.getMethod(), request.getRequestURL().toString()));
        if (StringUtils.isBlank(userId)) {
            logger.info("userId is empty");
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(401);
            try {
                requestContext.getResponse().getWriter().write("userId is empty");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        logger.info("OK");
        return null;
    }
}
