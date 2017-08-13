package club.realtg.rtgdata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Desc
 *
 * @author Papa Ray
 * Created on 2017-08-13
 */
@Controller
public class PlayerController {

    @RequestMapping(value = "")
    @ResponseBody
    public String index() {
        return "Hello World!";
    }


}
