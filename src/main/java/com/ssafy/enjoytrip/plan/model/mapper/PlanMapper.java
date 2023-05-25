package com.ssafy.enjoytrip.plan.model.mapper;

import com.ssafy.enjoytrip.plan.model.dto.PlanBoardDto;
import com.ssafy.enjoytrip.plan.model.dto.PlanDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.Date;
import java.util.List;

@Mapper
public interface PlanMapper {
   int insertPlanBoard(PlanBoardDto planBoardDto);
   int insertPlanDtoList(List<PlanDto> planDtoList);

   List<PlanBoardDto> selectPlanBoardByUserId(String userId);
   List<PlanDto> selectPlanByPlanBoardId(int planBoardId);
   PlanBoardDto selectPlanBoardByPlanBoardId(int planBoardId);

   int deletePlanList(int planBoardId, Date date);
}
