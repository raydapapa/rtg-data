package club.realtg.rtgdata.controller;

import club.realtg.rtgdata.common.JsonResult;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.ObjectSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 基础controller类
 * @author Administrator
 *
 */
public class BaseController {

	private Logger logger = Logger.getLogger("BaseController");
	
	private static ObjectSerializer idSerializer = (serializer, object, fieldName, fieldType, features) -> {
        SerializeWriter out = serializer.getWriter();
        if ( object == null ) {
            if (out.isEnabled(SerializerFeature.WriteNullNumberAsZero) ) {
                out.write('0');
            } else {
                out.writeNull();
            }
            return;
        }
        out.writeString(object.toString());
    };
	
	private String toJSONString(Object object) {
        try (SerializeWriter out = new SerializeWriter()) {
            JSONSerializer serializer = new JSONSerializer(out);
            serializer.getMapping().put(Long.class, idSerializer);
            serializer.config(SerializerFeature.WriteDateUseDateFormat, true);
            serializer.config(SerializerFeature.WriteMapNullValue, true);

            serializer.write(object);

            return out.toString();
        }
	}

	/**
     * 渲染失败数据
     */
    protected void writeError(HttpServletResponse response) {
        try {
	    	JsonResult result = new JsonResult();
	        result.setSuccess(false);
	        result.setStatus("100");
	        response.setCharacterEncoding("utf-8");
	        response.getWriter().write(toJSONString(result));
        } catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
    }

    /**
     * 渲染失败数据（带消息）
     *
     * @param msg 需要返回的消息
     */
    void writeError(HttpServletResponse response, String msg) {
        try {
	    	JsonResult result = new JsonResult();
	        result.setSuccess(false);
	        result.setStatus("100");
	        result.setMsg(msg);
	        response.setCharacterEncoding("utf-8");
	        response.getWriter().write(toJSONString(result));
        } catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
    }

    /**
     * 渲染成功数据
     *
     * @return result
     */
    protected void writeSuccess(HttpServletResponse response) {
        try {
	        JsonResult result = new JsonResult();
	        result.setSuccess(true);
	        result.setStatus("0000");
	        response.setCharacterEncoding("utf-8");
	        response.getWriter().write(toJSONString(result));
        } catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
    }

    /**
     * 渲染成功数据（带信息）
     *
     * @param msg 需要返回的信息
     */
    protected void writeSuccess(HttpServletResponse response,String msg) {
        try {
	    	JsonResult result = new JsonResult();
	        result.setSuccess(true);
	        result.setStatus("0000");
	        result.setMsg(msg);
	        response.setCharacterEncoding("utf-8");
	        response.getWriter().write(toJSONString(result));
        } catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
    }

    /**
     * 渲染成功数据（带数据）
     *
     * @param obj 需要返回的对象
     * @return result
     */
    void writeSuccess(HttpServletResponse response, Object obj) {
        try {
	    	JsonResult result = new JsonResult();
	        result.setSuccess(true);
	        result.setStatus("0000");
	        result.setObj(obj);
	        response.setCharacterEncoding("utf-8");
	        String json = toJSONString(result);
	        response.getWriter().write(json);
        } catch (IOException e) {
			logger.log(Level.SEVERE, e.getMessage());
		}
    }
}
