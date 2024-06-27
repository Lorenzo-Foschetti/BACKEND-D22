package lorenzofoschetti.u5d9.payloads;

import java.time.LocalDateTime;

public record ErrorsPayload(String message, LocalDateTime errorTime) {
}
