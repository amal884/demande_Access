package com.supportportal.services;


import com.supportportal.dtos.BadgeDto;
import com.supportportal.entities.Badge;

public interface BadgeService {



    Badge saveBadge(Long id);

    BadgeDto getBadge(Long id );

}
