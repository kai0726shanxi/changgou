package exceptionUtils;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import utils.Result;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * 处理自定义的业务异常
	 * @param req
	 * @param e
	 * @return
	 */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
	public Result bizExceptionHandler(HttpServletRequest req, BizException e){
    	return Result.error(e.getErrorCode(),e.getErrorMsg());
    }


	//处理Get请求中 使用@Valid 验证路径中请求实体校验失败后抛出的异常，详情继续往下看代码
	@ExceptionHandler(BindException.class)
	@ResponseBody
	public Result BindExceptionHandler(BindException e) {
		String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
		return Result.error(400,message);
	}

	//处理请求参数格式错误 @RequestParam上validate失败后抛出的异常是javax.validation.ConstraintViolationException
	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	public Result ConstraintViolationExceptionHandler(ConstraintViolationException e) {
		String message = e.getConstraintViolations().stream().map(ConstraintViolation::getMessage).collect(Collectors.joining());
		return Result.error(400,message);
	}

	//处理请求参数格式错误 @RequestBody上validate失败后抛出的异常是MethodArgumentNotValidException异常。
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	public Result MethodArgumentNotValidExceptionHandler(MethodArgumentNotValidException e) {
		String message = e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.joining());
		return Result.error(400,message);
	}
	@ExceptionHandler(MissingServletRequestParameterException.class)
	@ResponseBody
	public Result missingServletRequestParameterException(MissingServletRequestParameterException e){
    	return Result.error(CommonEnum.NOT_FOUND);
}
	/**
	 * 处理空指针的异常
	 * @param req
	 * @param e
	 * @return
	 */
	@ExceptionHandler(value =NullPointerException.class)
	@ResponseBody
	public Result exceptionHandler(HttpServletRequest req, NullPointerException e){
		return Result.error(CommonEnum.BODY_NOT_MATCH);
	}


    /**
        * 处理其他异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(value =Exception.class)
	@ResponseBody
	public Result exceptionHandler(HttpServletRequest req, Exception e){

       	return Result.error(CommonEnum.INTERNAL_SERVER_ERROR);
    }





}