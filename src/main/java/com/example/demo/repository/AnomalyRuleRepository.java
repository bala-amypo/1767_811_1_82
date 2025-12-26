import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.AnomalyRule;

public interface AnomalyRuleRepository extends JpaRepository<AnomalyRule, Long> {
    Optional<AnomalyRule> findByRuleCode(String ruleCode);
    List<AnomalyRule> findByActiveTrue(); // For getActiveRules()
}
