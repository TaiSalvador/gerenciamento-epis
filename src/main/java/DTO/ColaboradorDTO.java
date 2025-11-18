package DTO;

<<<<<<< Updated upstream

=======
>>>>>>> Stashed changes
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

<<<<<<< Updated upstream
=======
import javax.print.DocFlavor;

>>>>>>> Stashed changes
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
<<<<<<< Updated upstream
public class ColaboradorDTO {

    private int idColaborador;

    @NotBlank(message = "Nome do colaborador não pode ser vazio")
    @Size(max = 50, message = "Colaborador não pode ultrapassar 50 caracteres")
    private String nmColaborador;
=======

public class ColaboradorDTO {

    private int idDepartamento;

    @NotBlank(message= "" )
    @Size(max= 50, messagem = "")
    private

>>>>>>> Stashed changes
}
