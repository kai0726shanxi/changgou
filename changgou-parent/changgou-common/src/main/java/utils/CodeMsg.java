package utils;

public class CodeMsg {

     private int code;
     private String message;

    /**
     * //通用模块异常 5001XX
     */
    public static CodeMsg SUCCESS = new CodeMsg(0,"SUCCESS");
     public static CodeMsg SERVER_ERROR = new CodeMsg(500100,"服务端异常");

     //登陆模块异常 5002XX
    //商品模块异常 5003XX
    //订单模块异常 5004XX
    //秒杀模块异常 5005XX


    private CodeMsg(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}