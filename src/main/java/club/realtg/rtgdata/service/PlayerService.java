package club.realtg.rtgdata.service;

import club.realtg.rtgdata.common.util.BaseSearch;
import club.realtg.rtgdata.common.util.PageableUtil;
import club.realtg.rtgdata.common.util.SearchDto;
import club.realtg.rtgdata.common.util.SortDto;
import club.realtg.rtgdata.entity.Player;
import club.realtg.rtgdata.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Desc
 *
 * @author Papa Ray
 * Created on 2017-08-26
 */
@Service
public class PlayerService {
    private final
    PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Page<Player> getPlayersPage(int pageNo, int pageSize, String keyword, String sortKey, String direction) {
        if ("birthDate".equals(sortKey)) {
            if (SortDto.ASC.equals(direction)) {
                direction = SortDto.DESC;
            } else {
                direction = SortDto.ASC;
            }
        }
        Specifications newSpes;
        newSpes = Specifications.where(new BaseSearch<Player>(new SearchDto("realName", SearchDto.LIKE, keyword)))
                .or(new BaseSearch<>(new SearchDto("nickName", SearchDto.LIKE, keyword)));
        return playerRepository.findAll(newSpes, PageableUtil.basicPage(pageNo, pageSize, new SortDto(direction, sortKey)));
    }

    public Player getPlayerById(int id) {
        return playerRepository.findOne(id);
    }

    public void savePlayer(Player player) throws Exception {
        //验证身份证是否重复
        Player duplicatePlayer = playerRepository.findByIdCardNo(player.getIdCardNo());
        if(duplicatePlayer == null) {
            playerRepository.save(player);
        } else {
            throw new Exception("已经存在身份证号为'"+player.getIdCardNo()+"'的球员！");
        }
    }

    public void updatePlayer(Player player) throws Exception {
        Player oldPlayer = playerRepository.findOne(player.getId());
        boolean idCardNoChanged = !oldPlayer.getIdCardNo().equals(player.getIdCardNo());
        if(idCardNoChanged) { //如果有修改身份证号，则需要校验改后的身份证号是否已经存在
            savePlayer(player);
        } else {
            playerRepository.save(player);
        }
    }

    public void removePlayers(String ids) {
        if (StringUtils.isEmpty(ids)) return;

        String[] idArry = ids.split(",");
        for (String strId : idArry) {
            playerRepository.delete(Integer.valueOf(strId.trim()));
        }
    }
}
