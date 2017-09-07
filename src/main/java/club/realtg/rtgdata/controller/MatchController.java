package club.realtg.rtgdata.controller;

import club.realtg.rtgdata.entity.Match;
import club.realtg.rtgdata.service.MatchService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * Controller for Match
 *
 * @author Papa Ray
 * Created on 2017-08-28
 */
@Controller
public class MatchController extends BaseController {

    @Resource
    private MatchService matchService;

    @RequestMapping(value = "matchList")
    public String gotoMatchList(Model model) {
        String title = "比赛记录";
        model.addAttribute("title",title);
        return "biz/matchList";
    }

    @RequestMapping(value = "queryMatch")
    public void query(HttpServletResponse response, int pageNo, int pageSize, String keyword, String sortKey, String direction) {
        try {
            Page<Match> matchs = matchService.getMatchsPage(pageNo, pageSize, keyword, sortKey, direction);
            writeSuccess(response, matchs);
        } catch (Exception e) {
            e.printStackTrace();
            writeError(response, e.getMessage());
        }
    }

    @RequestMapping(value = "saveMatch")
    public void saveAddMatch(@ModelAttribute @Valid Match match, Errors errors, HttpServletResponse response, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("errors", errors.getAllErrors());
            return;
        }
        try {
            matchService.saveMatch(match);
            writeSuccess(response, match);
        } catch (Exception e) {
            e.printStackTrace();
            writeError(response, e.getMessage());
        }
    }

    @RequestMapping(value = "updateMatch")
    public void saveUpdateMatch(@ModelAttribute @Valid Match match, Errors errors, HttpServletResponse response, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("errors", errors.getAllErrors());
            return;
        }
        try {
            matchService.updateMatch(match);
            writeSuccess(response, match);
        } catch (Exception e) {
            e.printStackTrace();
            writeError(response, e.getMessage());
        }
    }

    @RequestMapping(value = "removeMatchs")
    public void removeMatches(HttpServletResponse response, String ids){
        try {
            matchService.removeMatches(ids);
            writeSuccess(response);
        } catch (Exception e) {
            e.printStackTrace();
            writeError(response, e.getMessage());
        }
    }
}
