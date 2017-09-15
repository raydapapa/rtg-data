package club.realtg.rtgdata.controller;

import club.realtg.rtgdata.entity.Team;
import club.realtg.rtgdata.service.TeamService;
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
 * Controller for Team
 *
 * @author Papa Ray
 * Created on 2017-08-30
 */
@Controller
public class TeamController extends BaseController {

    @Resource
    private TeamService teamService;

    @RequestMapping(value = "teamList")
    public String gotoTeamList(Model model) {
        String title = "球队列表";
        model.addAttribute("title",title);
        return "biz/teamList";
    }

    @RequestMapping(value = "queryTeam")
    public void query(HttpServletResponse response, int pageNo, int pageSize, String keyword, String sortKey, String direction) {
        try {
            Page<Team> teams = teamService.getTeamsPage(pageNo, pageSize, keyword, sortKey, direction);
            writeSuccess(response, teams);
        } catch (Exception e) {
            e.printStackTrace();
            writeError(response, e.getMessage());
        }
    }

    @RequestMapping(value = "saveTeam")
    public void saveAddTeam(@ModelAttribute @Valid Team team, Errors errors, HttpServletResponse response, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("errors", errors.getAllErrors());
            return;
        }
        try {
            teamService.saveTeam(team);
            writeSuccess(response, team);
        } catch (Exception e) {
            e.printStackTrace();
            writeError(response, e.getMessage());
        }
    }

    @RequestMapping(value = "updateTeam")
    public void saveUpdateTeam(@ModelAttribute @Valid Team team, Errors errors, HttpServletResponse response, Model model) {
        if(errors.hasErrors()) {
            model.addAttribute("errors", errors.getAllErrors());
            return;
        }
        try {
            teamService.updateTeam(team);
            writeSuccess(response, team);
        } catch (Exception e) {
            e.printStackTrace();
            writeError(response, e.getMessage());
        }
    }

    @RequestMapping(value = "removeTeams")
    public void removeTeams(HttpServletResponse response, String ids){
        try {
            teamService.removeTeams(ids);
            writeSuccess(response);
        } catch (Exception e) {
            e.printStackTrace();
            writeError(response, e.getMessage());
        }
    }

}
