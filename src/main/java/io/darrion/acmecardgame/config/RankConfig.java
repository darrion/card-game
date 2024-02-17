package io.darrion.acmecardgame.config;

import io.darrion.acmecardgame.constant.Prefix;
import io.darrion.acmecardgame.model.Rank;
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
