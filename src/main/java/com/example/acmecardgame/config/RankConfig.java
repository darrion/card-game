package com.example.acmecardgame.config;

import com.example.acmecardgame.constant.Prefix;
import com.example.acmecardgame.model.Rank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@ConfigurationProperties(prefix = Prefix.DECK)
public class RankConfig {
    @Getter @Setter
    private List<Rank> ranks;
}
