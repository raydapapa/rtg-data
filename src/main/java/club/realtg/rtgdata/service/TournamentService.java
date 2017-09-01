package club.realtg.rtgdata.service;

import club.realtg.rtgdata.common.util.BaseSearch;
import club.realtg.rtgdata.common.util.PageableUtil;
import club.realtg.rtgdata.common.util.SearchDto;
import club.realtg.rtgdata.common.util.SortDto;
import club.realtg.rtgdata.entity.Tournament;
import club.realtg.rtgdata.repository.TournamentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Desc
 *
 * @author Papa Ray
 * Created on 2017-08-28
 */
@Service
public class TournamentService {
    private final
    TournamentRepository tournamentRepository;

    @Autowired
    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }

    public Page<Tournament> getTournamentsPage(int pageNo, int pageSize, String keyword, String sortKey, String direction) {
        Specifications newSpes;
        newSpes = Specifications.where(new BaseSearch<Tournament>(new SearchDto("name", SearchDto.LIKE, keyword)))
                .or(new BaseSearch<>(new SearchDto("location", "like", keyword)));
        return tournamentRepository.findAll(newSpes, PageableUtil.basicPage(pageNo, pageSize, new SortDto(direction, sortKey)));
    }

    public Tournament getTournamentById(int id) {
        return tournamentRepository.findOne(id);
    }

    public void saveTournament(Tournament tournament) throws Exception {
        //校验赛事名是否重复
        Tournament duplicateTournament = tournamentRepository.findByName(tournament.getName());
        if(duplicateTournament == null) {
            tournamentRepository.save(tournament);
        } else {
            throw new Exception("已经存在名为'"+tournament.getName()+"'的赛事！");
        }
    }

    public void updateTournament(Tournament tournament) throws Exception {
        saveTournament(tournament);
    }

    public void removeTournaments(String ids) {
        if (StringUtils.isEmpty(ids)) return;

        String[] idArry = ids.split(",");
        for (String strId : idArry) {
            tournamentRepository.delete(Integer.valueOf(strId.trim()));
        }
    }
}
