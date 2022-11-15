package com.supportportal.mappers;

import com.supportportal.dtos.BadgeDto;
import com.supportportal.entities.Badge;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
public class BadgeMapper {

    public BadgeDto fromBadge(Badge badge){
        BadgeDto badgeDto = new BadgeDto();
        BeanUtils.copyProperties( badge, badgeDto);
        return badgeDto;
    }

    public Badge fromBadgeDto( BadgeDto badgeDto){
        Badge badge = new Badge();
        BeanUtils.copyProperties( badgeDto, badge);
        return badge;
    }


}
