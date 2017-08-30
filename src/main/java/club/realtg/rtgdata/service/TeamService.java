package club.realtg.rtgdata.service;

import club.realtg.rtgdata.common.util.BaseSearch;
import club.realtg.rtgdata.common.util.PageableUtil;
import club.realtg.rtgdata.common.util.SearchDto;
import club.realtg.rtgdata.common.util.SortDto;
import club.realtg.rtgdata.entity.Team;
import club.realtg.rtgdata.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Desc
 *
 * @author Papa Ray
 * Created on 2017-08-30
 */
@Service
public class TeamService {
    private final
    TeamRepository teamRepository;

    @Autowired
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Page<Team> getTeamsPage(int pageNo, int pageSize, String keyword, String sortKey, String direction) {
        Specifications newSpes;
        newSpes = Specifications.where(new BaseSearch<Team>(new SearchDto("name", SearchDto.LIKE, keyword)))
                .or(new BaseSearch<>(new SearchDto("desc", "like", keyword)));
        return teamRepository.findAll(newSpes, PageableUtil.basicPage(pageNo, pageSize, new SortDto(direction, sortKey)));
    }

    public Team getTeamById(int id) {
        return teamRepository.findOne(id);
    }

    public void saveTeam(Team team) throws Exception {
        //校验球队名是否重复
        Team duplicateTeam = teamRepository.findByName(team.getName());
        if(duplicateTeam == null) {
            teamRepository.save(team);
        } else {
            throw new Exception("已经存在名为'"+team.getName()+"'的球队！");
        }

    }

    public void updateTeam(Team team) throws Exception {
        saveTeam(team);
    }

    public void removeTeams(String ids) {
        if (StringUtils.isEmpty(ids)) return;

        String[] idArry = ids.split(",");
        for (String strId : idArry) {
            teamRepository.delete(Integer.valueOf(strId.trim()));
        }
    }
}
