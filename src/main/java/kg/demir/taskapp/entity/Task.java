package kg.demir.taskapp.entity;

import io.swagger.annotations.ApiModel;
import kg.demir.taskapp.enums.Status;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "task")
@ApiModel("Task basic information")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotBlank(message = "The field must not be empty")
    @Size(min = 3, message = "The length of the title must be longer than 3 characters")
    private String title;

    @NotBlank(message = "The field must not be empty")
    @Size(max = 50, message = "The field must not exceed 50 characters in length")
    private String explanation;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "The date must not be empty")
    @Future(message = "Choose the future time")
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private Status status;

}
