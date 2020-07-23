package kg.demir.taskapp.entity;

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
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NotEmpty(message = "Заголовок не должен быть пустым!")
    @Min(value = 3, message = "Заголок не должен быть длинее 20 символов")
    private String title;

    @Max(value = 90, message = "Описание не должно быть длинее 90 символов")
    private String explanation;

    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate startDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull(message = "Дата окончания не должна быть пустым")
    @Future(message = "Дата должна быть указана в будщем времени")
    private LocalDate dueDate;

    @Enumerated(EnumType.STRING)
    private Status status;

}
