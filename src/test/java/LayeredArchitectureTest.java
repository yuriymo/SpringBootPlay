import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.mmy.Application;

import static com.tngtech.archunit.library.Architectures.layeredArchitecture;

@AnalyzeClasses(packages = "org.mmy")
public class LayeredArchitectureTest {
    
    @ArchTest
    static final ArchRule layerDependenciesAreRespected = layeredArchitecture()

            .layer("Controllers").definedBy("org.mmy.controllers..")
            .layer("Services").definedBy("org.mmy.services..")
            .layer("Persistence").definedBy("org.mmy.persistence..")
            .layer("Entity").definedBy("org.mmy.models..")
            .layer("App").definedBy("org.mmy..")

            .whereLayer("Controllers").mayNotBeAccessedByAnyLayer()
            .whereLayer("Services").mayOnlyBeAccessedByLayers("Controllers", "App")
            .whereLayer("Persistence").mayOnlyBeAccessedByLayers("Services")
            .whereLayer("Entity").mayOnlyBeAccessedByLayers("Persistence", "Services", "Controllers");
}