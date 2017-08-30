package club.realtg.rtgdata.common.util;

/**
 * Created by 钟述林 393156105@qq.com on 2016/10/21 17:12.
 */
public class SearchDto {

    public static final String GRATE_EQUAL = "ge"; //大于等于
    public static final String GRATE_THEN = "gt"; //大于
    public static final String LESS_EQUAL = "le"; //小于等于
    public static final String LESS_THEN = "lt"; //小于
    public static final String LIKE_BEGIN = "likeb"; // like '%?'
    public static final String LIKE_END = "likee"; //like '?%'
    public static final String LIKE = "like"; //like '%?%'
    public static final String LIKE_BEGIN_END = "likebe"; //like '%?%'
    public static final String NOT_LIKE_BEGIN = "nlikeb"; //not like '%?'
    public static final String NOT_LIKE_END = "nlikee"; //not like '?%'
    public static final String NOT_LIKE = "nlike"; //not like '%?%'
    public static final String NOT_LIKE_BEGIN_END = "nlikebe"; // not like '%?%'
    public static final String EQUAL = "eq"; //equal =
    public static final String NOT_EQUAL = "neq"; // not equal   !=
    public static final String IS_NULL = "isnull"; //is null

    /** 拼接类型，and或者or */
    private String type;
    private String key;
    private String operation;
    private Object value;

    public SearchDto(String key, String operation, Object value) {
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    public SearchDto(String type, String key, String operation, Object value) {
        this.type = type;
        this.key = key;
        this.operation = operation;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public String getKey() {
        return key;
    }

    public String getOperation() {
        return operation;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
