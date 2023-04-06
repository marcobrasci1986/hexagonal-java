package be.avidoo.hexagonal.framework.features.dossier.adaptor.output.persistence.jdbc;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DossierJdbcRepository {

    private final JdbcTemplate jdbcTemplate;


    public int updateDescription(String newDescription, String oldDescription) {
        String sql = "UPDATE dossier SET description = ? WHERE description = ?";

        return jdbcTemplate.update(sql, newDescription, oldDescription);
    }

}
