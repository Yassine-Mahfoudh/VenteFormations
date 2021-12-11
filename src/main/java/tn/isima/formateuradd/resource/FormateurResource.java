package tn.isima.formateuradd.resource;

        import org.springframework.http.HttpStatus;
        import org.springframework.http.ResponseEntity;
        import org.springframework.web.bind.annotation.*;

        import tn.isima.formateuradd.model.Formateur;
        import tn.isima.formateuradd.service.FormateurService;

        import java.util.List;

@RestController
@RequestMapping("/formateur")
@CrossOrigin(origins = "*")
public class FormateurResource {
    private final FormateurService formateurService;



    public FormateurResource(FormateurService formateurService) {
        this.formateurService = formateurService;
    }



    @PostMapping("/add")
    public ResponseEntity<Formateur> addFormateur(@RequestBody Formateur formateur) {
        Formateur newFormateur = formateurService.addFormateur(formateur);
        return new ResponseEntity<>(newFormateur, HttpStatus.CREATED);
    }


}

