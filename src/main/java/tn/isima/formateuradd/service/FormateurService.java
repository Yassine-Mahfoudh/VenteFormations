package tn.isima.formateuradd.service;

        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import tn.isima.formateuradd.model.Formateur;
        import tn.isima.formateuradd.repo.FormateurRepo;

        import javax.transaction.Transactional;
        import java.util.UUID;

@Service
@Transactional
public class FormateurService {
    private final FormateurRepo formateurRepo;

    @Autowired
    public FormateurService(FormateurRepo formateurRepo) {
        this.formateurRepo = formateurRepo;
    }

    public Formateur addFormateur(Formateur formateur) {
        formateur.setFormateurCode(UUID.randomUUID().toString());
        return formateurRepo.save(formateur);
    }


}
