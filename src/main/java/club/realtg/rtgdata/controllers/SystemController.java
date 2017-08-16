package club.realtg.rtgdata.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Controller for System
 *
 * @author Papa Ray
 * Created on 2017-08-16
 */
@Controller
public class SystemController {

    @RequestMapping(value = "")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/dashboard")
    public String toDashboard() {
        return "dashboard";
    }

}
