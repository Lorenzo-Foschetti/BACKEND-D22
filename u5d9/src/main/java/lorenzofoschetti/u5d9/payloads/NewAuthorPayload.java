package lorenzofoschetti.u5d9.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

import java.time.LocalDateTime;

public record NewAuthorPayload(
        @NotEmpty(message = "Il nome è obbligatorio!")
        String name,
        @NotEmpty(message = "Il cognome è obbligatorio!")
        String surname,
        @NotEmpty(message = "L'email è obbligatoria")
        @Email(message = "L'email inserita non è valida!")
        String email,
        @NotEmpty(message = "La tua data di nascita è obbligatoria!")
        LocalDateTime dataDiNascita
) {
}
