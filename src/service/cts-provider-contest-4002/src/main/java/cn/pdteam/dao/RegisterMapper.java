package cn.pdteam.dao;

import cn.pdteam.pojo.contest.entity.RegisterInfo;
import cn.pdteam.pojo.contest.request.CancelSignUpContest2UserRequest;
import cn.pdteam.pojo.contest.request.SignUpContestRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RegisterMapper {
    Integer signUp(SignUpContestRequest request);

    Integer cancelSignUpByContestIdAndUser(CancelSignUpContest2UserRequest request);

    Integer cancelSignUpByRegId(Integer regId);

    Boolean checkSignUp(String contestId, String user);

    RegisterInfo queryRegisterInfoById(Integer id);

    List<RegisterInfo> queryRegisterUserList(Integer page, Integer limit, String search, String contestId);

    Integer queryRegisterCount(String search, String contestId);
}
