package com.tyh.code.exception;

import com.tyh.code.model.CodeMsg;
import com.tyh.code.model.Result;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

	/**
	 * 主要是@ExceptionHandler这个注解
	 * @param request
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value=Exception.class)
	public Object exceptionHandler(HttpServletRequest request, Exception e){
		e.printStackTrace();
		//如果是ajax请求异常
		if (isAjax(request)) {
			return Result.error(CodeMsg.AJAX_ERROR.fillArgs(e.getMessage()));
		}else if(e instanceof GlobalException) {
			GlobalException ex = (GlobalException)e;
			return Result.error(ex.getCm());
		}else if(e instanceof BindException) {
			BindException ex = (BindException)e;
			List<ObjectError> errors = ex.getAllErrors();
			ObjectError error = errors.get(0);
			String msg = error.getDefaultMessage();
			return Result.error(CodeMsg.BIND_ERROR.fillArgs(msg));
		}else {
			ModelAndView mav = new ModelAndView();
			mav.addObject("exception", e);
			mav.addObject("url", request.getRequestURL());
			mav.setViewName("error");
			return mav;
		}
	}

	/**
	 * @Description: 判断是否是ajax请求
	 */
	public static boolean isAjax(HttpServletRequest httpRequest){
		return  (httpRequest.getHeader("X-Requested-With") != null
				&& "XMLHttpRequest"
				.equals( httpRequest.getHeader("X-Requested-With").toString()) );
	}
}
