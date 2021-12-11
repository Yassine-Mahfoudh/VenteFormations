package tn.isima.formateuradd.repo;

        import org.springframework.data.jpa.repository.JpaRepository;

        import tn.isima.formateuradd.model.Formateur;

        import java.util.Optional;

public interface FormateurRepo extends JpaRepository<Formateur, Long> {


    Optional<Formateur> findFormateurById(Long id);
}
