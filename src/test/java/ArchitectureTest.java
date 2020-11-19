import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

public class ArchitectureTest {
    @Test
    public void architectureRule() {
        JavaClasses importedClasses = new ClassFileImporter().importPackages("com.myapp");

        ArchRule rule = classes().that().areAnnotatedWith(Service.class)
                .or().haveNameMatching(".*Service")
                .should().resideInAPackage("..service..")
                .orShould().beAnnotatedWith(Service.class);

        rule.check(importedClasses);
    }
}