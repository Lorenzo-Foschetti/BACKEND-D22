package lorenzofoschetti.u5d9.payloads;

import jakarta.validation.constraints.NotEmpty;

public record NewBlogpostPayload(
        @NotEmpty
        String title, @NotEmpty
        String category,
        @NotEmpty
        String content,
        @NotEmpty
        int lectureTime) {

}
