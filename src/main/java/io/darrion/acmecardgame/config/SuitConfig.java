package io.darrion.acmecardgame.config;

import io.darrion.acmecardgame.constant.Prefix;
import io.darrion.acmecardgame.model.Suit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Configuration
@ConfigurationProperties(prefix = Prefix.DECK)
public class SuitConfig {
    public List<Suit> suits;
}
