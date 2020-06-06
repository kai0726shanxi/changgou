package utils;

import exceptionUtils.BaseErrorInfoInterface;

public class Result<T> {

    private int code;
    private String message;
    private T data;

    /**
     * 成功时调用
     * @param data
     * @param <T>
     * @return
     */
    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    /**
     * 失败时调用
     * @param codeMsg
     * @param <T>
     * @return
     */
    public static <T> Result error(CodeMsg codeMsg){
        return new Result<T>(codeMsg);
    }

    public static <T> Result error(int code, String message){

        return new Result<T>(code,message);
    }

    public static <T> Result error(String message){

        return new Result<T>(message);
    }

    /**
     * 失败
     */
    public static <T> Result error(BaseErrorInfoInterface errorInfo) {
        return new Result<T>(errorInfo);

    }



    /**
     * 构造方法私有化，不允许外部new utils.Result
     * @param data
     */
    private Result(T data){
        this.code = 0;
        this.message = "SUCCESS";
        this.data = data;
    }


    private Result(BaseErrorInfoInterface errorInfo){

        this.setCode(errorInfo.getResultCode());
        this.setMessage(errorInfo.getResultMsg());

    }

    /**
     * 构造方法私有化，不允许外部new utils.Result
     * @param codeMsg
     */
    private Result(CodeMsg codeMsg){
        if (null == codeMsg) {
            return;
        }
        this.code = codeMsg.getCode();
        this.message = codeMsg.getMessage();
    }


    private Result(int code,String message){

        this.code = code;
        this.message = message;
    }

    private Result(String message){

        this.code = -1;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}