package med.voll.api.medico;

import io.micrometer.observation.ObservationFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

// na tipagem (dentro dos <>) passo primeiro o tipo da entidade que vamos trabalhar
// e depois passamos o tipo do atributo da chave primária
public interface MedicoRepository  extends JpaRepository<Medico, Long> {

    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}
